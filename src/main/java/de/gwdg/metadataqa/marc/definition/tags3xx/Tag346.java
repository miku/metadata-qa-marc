package de.gwdg.metadataqa.marc.definition.tags3xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Video Characteristics
 * http://www.loc.gov/marc/bibliographic/bd346.html
 */
public class Tag346 extends DataFieldDefinition {
	private static Tag346 uniqueInstance;

	private Tag346(){
		initialize();
	}

	public static Tag346 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag346();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "346";
		label = "Video Characteristics";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("");
		ind2 = new Indicator("");
		setSubfieldsWithCardinality(
				"a", "Video format", "R",
				"b", "Broadcast standard", "R",
				"0", "Authority record control number or standard number", "R",
				"2", "Source", "NR",
				"3", "Materials specified", "NR",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
	}
}
