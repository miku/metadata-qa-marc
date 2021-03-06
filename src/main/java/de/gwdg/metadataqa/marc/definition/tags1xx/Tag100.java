package de.gwdg.metadataqa.marc.definition.tags1xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;
import de.gwdg.metadataqa.marc.definition.general.codelist.RelatorCodes;

/**
 * Main Entry - Personal Name
 * https://www.loc.gov/marc/bibliographic/bd100.html
 */
public class Tag100 extends DataFieldDefinition {

	private static Tag100 uniqueInstance;

	private Tag100(){
		initialize();
	}

	public static Tag100 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag100();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "100";
		label = "Main Entry - Personal Name";
		cardinality = Cardinality.Nonrepeatable;
		ind1 = new Indicator("Type of personal name entry element").setCodes(
				"0", "Forename",
				"1", "Surname",
				"3", "Family name"
		);
		ind2 = new Indicator("").setCodes(" ", "Undefined");
		setSubfieldsWithCardinality(
				"a", "Personal name", "NR",
				"b", "Numeration", "NR",
				"c", "Titles and words associated with a name", "R",
				"d", "Dates associated with a name", "NR",
				"e", "Relator term", "R",
				"f", "Date of a work", "NR",
				"g", "Miscellaneous information", "R",
				"j", "Attribution qualifier", "R",
				"k", "Form subheading", "R",
				"l", "Language of a work", "NR",
				"n", "Number of part/section of a work", "R",
				"p", "Name of part/section of a work", "R",
				"q", "Fuller form of name", "NR",
				"t", "Title of a work", "NR",
				"u", "Affiliation", "NR",
				"0", "Authority record control number or standard number", "R",
				"4", "Relator code", "R",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
		getSubfield("4").setCodeList(RelatorCodes.getInstance());
	}
}
