package de.gwdg.metadataqa.marc.definition.tags3xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Sound Characteristics
 * http://www.loc.gov/marc/bibliographic/bd344.html
 */
public class Tag344 extends DataFieldDefinition {
	private static Tag344 uniqueInstance;

	private Tag344(){
		initialize();
	}

	public static Tag344 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag344();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "344";
		label = "Sound Characteristics";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("");
		ind2 = new Indicator("");
		setSubfieldsWithCardinality(
				"a", "Type of recording", "R",
				"b", "Recording medium", "R",
				"c", "Playing speed", "R",
				"d", "Groove characteristic", "R",
				"e", "Track configuration", "R",
				"f", "Tape configuration", "R",
				"g", "Configuration of playback channels", "R",
				"h", "Special playback characteristics", "R",
				"0", "Authority record control number or standard number", "R",
				"2", "Source", "NR",
				"3", "Materials specified", "NR",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
	}
}
