package de.gwdg.metadataqa.marc.definition.tags20x;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;
import de.gwdg.metadataqa.marc.definition.general.codelist.LanguageCodes;

/**
 * Translation of Title by Cataloging Agency
 * http://www.loc.gov/marc/bibliographic/bd242.html
 */
public class Tag242 extends DataFieldDefinition {
	private static Tag242 uniqueInstance;

	private Tag242(){
		initialize();
	}

	public static Tag242 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag242();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "242";
		label = "Translation of Title by Cataloging Agency";
		cardinality = Cardinality.Nonrepeatable;
		ind1 = new Indicator("Title added entry").setCodes(
				"0", "No added entry",
				"1", "Added entry"
		);
		ind2 = new Indicator("Nonfiling characters").setCodes(
				"0", "No nonfiling characters",
				"1-9", "Number of nonfiling characters"
		);
		ind2.getCode("1-9").setRange(true);
		setSubfieldsWithCardinality(
				"a", "Title", "NR",
				"b", "Remainder of title", "NR",
				"c", "Statement of responsibility, etc.", "NR",
				"h", "Medium", "NR",
				"n", "Number of part/section of a work", "R",
				"p", "Name of part/section of a work", "R",
				"y", "Language code of translated title", "NR",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
		getSubfield("y").setCodeList(LanguageCodes.getInstance());
	}
}
