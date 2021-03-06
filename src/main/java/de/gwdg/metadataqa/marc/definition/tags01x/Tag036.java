package de.gwdg.metadataqa.marc.definition.tags01x;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Original Study Number for Computer Data Files
 * http://www.loc.gov/marc/bibliographic/bd036.html
 */
public class Tag036 extends DataFieldDefinition {

	private static Tag036 uniqueInstance;

	private Tag036() {
		initialize();
	}

	public static Tag036 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag036();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "036";
		label = "Original Study Number for Computer Data Files";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("").setCodes();
		ind2 = new Indicator("").setCodes();
		setSubfieldsWithCardinality(
				"a", "Original study number", "NR",
				"b", "Source agency assigning number", "NR",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
	}
}
