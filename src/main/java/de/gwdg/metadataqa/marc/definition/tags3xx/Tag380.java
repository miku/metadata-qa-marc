package de.gwdg.metadataqa.marc.definition.tags3xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;
import de.gwdg.metadataqa.marc.definition.general.codelist.SubjectHeadingAndTermSourceCodes;

/**
 * Form of Work
 * http://www.loc.gov/marc/bibliographic/bd380.html
 */
public class Tag380 extends DataFieldDefinition {
	private static Tag380 uniqueInstance;

	private Tag380(){
		initialize();
	}

	public static Tag380 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag380();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "380";
		label = "Form of Work";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("");
		ind2 = new Indicator("");
		setSubfieldsWithCardinality(
				"a", "Form of work", "R",
				"0", "Record control number", "R",
				"2", "Source of term", "NR",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
		getSubfield("2").setCodeList(SubjectHeadingAndTermSourceCodes.getInstance());
	}
}
