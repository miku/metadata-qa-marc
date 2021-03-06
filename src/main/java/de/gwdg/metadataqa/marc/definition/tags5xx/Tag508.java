package de.gwdg.metadataqa.marc.definition.tags5xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Creation/Production Credits Note
 * http://www.loc.gov/marc/bibliographic/bd508.html
 */
public class Tag508 extends DataFieldDefinition {

	private static Tag508 uniqueInstance;

	private Tag508(){
		initialize();
	}

	public static Tag508 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag508();
		return uniqueInstance;
	}

	private void initialize() {

		tag = "508";
		label = "Creation/Production Credits Note";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("");
		ind2 = new Indicator("");
		setSubfieldsWithCardinality(
				"a", "Creation/production credits note", "NR",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
	}
}
