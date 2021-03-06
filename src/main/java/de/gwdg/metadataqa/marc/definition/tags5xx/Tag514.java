package de.gwdg.metadataqa.marc.definition.tags5xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Data Quality Note
 * http://www.loc.gov/marc/bibliographic/bd514.html
 */
public class Tag514 extends DataFieldDefinition {

	private static Tag514 uniqueInstance;

	private Tag514(){
		initialize();
	}

	public static Tag514 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag514();
		return uniqueInstance;
	}

	private void initialize() {

		tag = "514";
		label = "Data Quality Note";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("");
		ind2 = new Indicator("");
		setSubfieldsWithCardinality(
				"a", "Attribute accuracy report", "NR",
				"b", "Attribute accuracy value", "R",
				"c", "Attribute accuracy explanation", "R",
				"d", "Logical consistency report", "NR",
				"e", "Completeness report", "NR",
				"f", "Horizontal position accuracy report", "NR",
				"g", "Horizontal position accuracy value", "R",
				"h", "Horizontal position accuracy explanation", "R",
				"i", "Vertical positional accuracy report", "NR",
				"j", "Vertical positional accuracy value", "R",
				"k", "Vertical positional accuracy explanation", "R",
				"m", "Cloud cover", "NR",
				"u", "Uniform Resource Identifier", "R",
				"z", "Display note", "R",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
	}
}
