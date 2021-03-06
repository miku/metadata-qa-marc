package de.gwdg.metadataqa.marc.definition.tags20x;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;
import de.gwdg.metadataqa.marc.definition.general.codelist.AbbreviatedTitleSourceCodes;

/**
 * Abbreviated Title
 * http://www.loc.gov/marc/bibliographic/bd210.html
 */
public class Tag210 extends DataFieldDefinition {
	private static Tag210 uniqueInstance;

	private Tag210(){
		initialize();
	}

	public static Tag210 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag210();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "210";
		label = "Abbreviated Title";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("Title added entry").setCodes(
				"0", "No added entry",
				"1", "Added entry"
		);
		ind2 = new Indicator("Type").setCodes(
				" ", "Abbreviated key title",
				"0", "Other abbreviated title"
		);
		setSubfieldsWithCardinality(
				"a", "Abbreviated title", "NR",
				"b", "Qualifying information", "NR",
				"2", "Source", "R",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
		getSubfield("2").setCodeList(AbbreviatedTitleSourceCodes.getInstance());
	}
}
