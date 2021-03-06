package de.gwdg.metadataqa.marc.cli;

import de.gwdg.metadataqa.api.model.JsonPathCache;
import de.gwdg.metadataqa.api.model.XmlFieldInstance;
import de.gwdg.metadataqa.api.schema.MarcJsonSchema;
import de.gwdg.metadataqa.marc.MarcFieldExtractor;
import de.gwdg.metadataqa.marc.datastore.MarcElasticsearchClient;
import de.gwdg.metadataqa.marc.datastore.MarcSolrClient;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * usage:
 * java -cp target/metadata-qa-marc-0.1-SNAPSHOT-jar-with-dependencies.jar de.gwdg.metadataqa.marc.cli.SolrKeyGenerator http://localhost:8983/solr/tardit 0001.0000000.formatted.json
 * @author Péter Király <peter.kiraly at gwdg.de>
 */
public class SolrKeyGenerator {

	private static final Logger logger = Logger.getLogger(SolrKeyGenerator.class.getCanonicalName());

	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Please provide a Solr URL and file name!");
			System.exit(0);
		}

		String url = args[0];

		String relativeFileName = args[1];
		Path path = Paths.get(relativeFileName);
		String fileName = path.getFileName().toString();

		logger.info(String.format("Solr URL: %s, file: %s", url, fileName));

		MarcSolrClient client = new MarcSolrClient(url);
		JsonPathCache<? extends XmlFieldInstance> cache;
		List<String> records;
		try {
			records = Files.readAllLines(path, Charset.defaultCharset());
			MarcFieldExtractor extractor = new MarcFieldExtractor(new MarcJsonSchema());
			Map<String, Object> duplumKey;
			int i = 0;
			for (String record : records) {
				i++;
				cache = new JsonPathCache(record);
				extractor.measure(cache);
				duplumKey = extractor.getDuplumKeyMap();
				client.indexDuplumKey((String)duplumKey.get(MarcFieldExtractor.FIELD_NAME), duplumKey);
				if (i % 1000 == 0) {
					client.commit();
					logger.info(String.format("%s/%d) %s", fileName, i, duplumKey.get(MarcFieldExtractor.FIELD_NAME)));
				}
			}
			client.commit();
			// logger.info("optimize");
			// client.optimize();
			logger.info("end of cycle");
		} catch (IOException | SolrServerException ex) {
			logger.severe(ex.toString());
			System.exit(0);
		}
		logger.info("Bye!");

		System.exit(0);
	}
}
