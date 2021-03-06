package de.gwdg.metadataqa.marc.definition.tags3xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Format of Notated Music
 * http://www.loc.gov/marc/bibliographic/bd348.html
 */
public class Tag348 extends DataFieldDefinition {
	private static Tag348 uniqueInstance;

	private Tag348(){
		initialize();
	}

	public static Tag348 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag348();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "348";
		label = "Format of Notated Music";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("");
		ind2 = new Indicator("");
		setSubfieldsWithCardinality(
				"a", "Format of notated music term", "R",
				"b", "Format of notated music code", "R",
				"0", "Authority record control number or standard number", "R",
				"2", "Source", "NR",
				"3", "Materials specified", "NR",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
	}
}
