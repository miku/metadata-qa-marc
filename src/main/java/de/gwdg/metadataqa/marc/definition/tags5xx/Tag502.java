package de.gwdg.metadataqa.marc.definition.tags5xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Dissertation Note
 * http://www.loc.gov/marc/bibliographic/bd502.html
 */
public class Tag502 extends DataFieldDefinition {

	private static Tag502 uniqueInstance;

	private Tag502(){
		initialize();
	}

	public static Tag502 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag502();
		return uniqueInstance;
	}

	private void initialize() {

		tag = "502";
		label = "Dissertation Note";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("");
		ind2 = new Indicator("");
		setSubfieldsWithCardinality(
				"a", "Dissertation note", "NR",
				"b", "Degree type", "NR",
				"c", "Name of granting institution", "NR",
				"d", "Year degree granted", "NR",
				"g", "Miscellaneous information", "R",
				"o", "Dissertation identifier", "R",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
	}
}
