package de.gwdg.metadataqa.marc.definition.tags5xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Bibliography, etc. Note
 * http://www.loc.gov/marc/bibliographic/bd504.html
 */
public class Tag504 extends DataFieldDefinition {

	private static Tag504 uniqueInstance;

	private Tag504(){
		initialize();
	}

	public static Tag504 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag504();
		return uniqueInstance;
	}

	private void initialize() {

		tag = "504";
		label = "Bibliography, etc. Note";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("");
		ind2 = new Indicator("");
		setSubfieldsWithCardinality(
				"a", "Bibliography, etc. note", "NR",
				"b", "Number of references", "NR",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
	}
}
