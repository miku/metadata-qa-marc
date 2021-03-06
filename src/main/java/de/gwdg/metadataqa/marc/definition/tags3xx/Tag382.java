package de.gwdg.metadataqa.marc.definition.tags3xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;
import de.gwdg.metadataqa.marc.definition.general.codelist.MusicalInstrumentationAndVoiceSourceCodes;

/**
 * Medium of Performance
 * http://www.loc.gov/marc/bibliographic/bd382.html
 */
public class Tag382 extends DataFieldDefinition {
	private static Tag382 uniqueInstance;

	private Tag382(){
		initialize();
	}

	public static Tag382 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag382();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "382";
		label = "Medium of Performance";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("Display constant controller").setCodes(
				" ", "No information provided",
				"0", "Medium of performance",
				"1", "Partial medium of performance"
		);
		ind2 = new Indicator("Access control").setCodes(
				" ", "No information provided",
				"0", "Not intended for access",
				"1", "Intended for access"
		);
		setSubfieldsWithCardinality(
				"a", "Medium of performance", "R",
				"b", "Soloist", "R",
				"d", "Doubling instrument", "R",
				"e", "Number of ensembles of the same type", "R",
				"n", "Number of performers of the same medium", "R",
				"p", "Alternative medium of performance", "R",
				"r", "Total number of individuals performing alongside ensembles", "NR",
				"s", "Total number of performers", "NR",
				"t", "Total number of ensembles", "NR",
				"v", "Note", "R",
				"0", "Authority record control number or standard number", "R",
				"2", "Source of term", "NR",
				"3", "Materials specified", "NR",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
		getSubfield("2").setCodeList(MusicalInstrumentationAndVoiceSourceCodes.getInstance());
	}
}
