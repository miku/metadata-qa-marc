package de.gwdg.metadataqa.marc.definition.tags3xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;
import de.gwdg.metadataqa.marc.definition.general.codelist.SubjectHeadingAndTermSourceCodes;

/**
 * Other Distinguishing Characteristics of Work or Expression
 * http://www.loc.gov/marc/bibliographic/bd381.html
 */
public class Tag381 extends DataFieldDefinition {
	private static Tag381 uniqueInstance;

	private Tag381(){
		initialize();
	}

	public static Tag381 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag381();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "381";
		label = "Other Distinguishing Characteristics of Work or Expression";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("");
		ind2 = new Indicator("");
		setSubfieldsWithCardinality(
				"a", "Other distinguishing characteristic", "R",
				"u", "Uniform Resource Identifier", "R",
				"v", "Source of information", "R",
				"0", "Record control number", "R",
				"2", "Source of term", "NR",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
		getSubfield("2").setCodeList(SubjectHeadingAndTermSourceCodes.getInstance());
	}
}
