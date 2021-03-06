package de.gwdg.metadataqa.marc.definition.tags5xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;
import de.gwdg.metadataqa.marc.definition.general.codelist.AccessRestrictionTermSourceCodes;

/**
 * Restrictions on Access Note
 * http://www.loc.gov/marc/bibliographic/bd506.html
 */
public class Tag506 extends DataFieldDefinition {

	private static Tag506 uniqueInstance;

	private Tag506(){
		initialize();
	}

	public static Tag506 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag506();
		return uniqueInstance;
	}

	private void initialize() {

		tag = "506";
		label = "Restrictions on Access Note";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("Restriction").setCodes(
				" ", "No information provided",
				"0", "No restrictions",
				"1", "Restrictions apply"
		);
		ind2 = new Indicator("");
		setSubfieldsWithCardinality(
				"a", "Terms governing access", "NR",
				"b", "Jurisdiction", "R",
				"c", "Physical access provisions", "R",
				"d", "Authorized users", "R",
				"e", "Authorization", "R",
				"f", "Standardized terminology for access restriction", "R",
				"u", "Uniform Resource Identifier", "R",
				"2", "Source of term", "NR",
				"3", "Materials specified", "NR",
				"5", "Institution to which field applies", "NR",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
		getSubfield("2").setCodeList(AccessRestrictionTermSourceCodes.getInstance());
	}
}
