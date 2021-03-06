package de.gwdg.metadataqa.marc.definition.tags5xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Target Audience Note
 * http://www.loc.gov/marc/bibliographic/bd521.html
 */
public class Tag521 extends DataFieldDefinition {

	private static Tag521 uniqueInstance;

	private Tag521(){
		initialize();
	}

	public static Tag521 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag521();
		return uniqueInstance;
	}

	private void initialize() {

		tag = "521";
		label = "Target Audience Note";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("Display constant controller").setCodes(
				" ", "Audience",
				"0", "Reading grade level",
				"1", "Interest age level",
				"2", "Interest grade level",
				"3", "Special audience characteristics",
				"4", "Motivation/interest level",
				"8", "No display constant generated"
		);
		ind2 = new Indicator("");
		setSubfieldsWithCardinality(
				"a", "Target audience note", "R",
				"b", "Source", "NR",
				"3", "Materials specified", "NR",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
	}
}
