package de.gwdg.metadataqa.marc.definition.tags5xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * System Details Note
 * http://www.loc.gov/marc/bibliographic/bd538.html
 */
public class Tag538 extends DataFieldDefinition {

	private static Tag538 uniqueInstance;

	private Tag538() {
		initialize();
	}

	public static Tag538 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag538();
		return uniqueInstance;
	}

	private void initialize() {

		tag = "538";
		label = "System Details Note";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("");
		ind2 = new Indicator("");
		setSubfieldsWithCardinality(
				"a", "System details note", "NR",
				"i", "Display text", "NR",
				"u", "Uniform Resource Identifier", "R",
				"3", "Materials specified", "NR",
				"5", "Institution to which field applies", "R",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
	}
}
