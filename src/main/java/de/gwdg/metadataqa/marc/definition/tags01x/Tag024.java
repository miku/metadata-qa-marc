package de.gwdg.metadataqa.marc.definition.tags01x;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;
import de.gwdg.metadataqa.marc.definition.general.codelist.StandardIdentifierSourceCodes;

public class Tag024 extends DataFieldDefinition {

	private static Tag024 uniqueInstance;

	private Tag024() {
		initialize();
	}

	public static Tag024 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag024();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "024";
		label = "Other Standard Identifier";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("Type of standard number or code").setCodes(
				"0", "International Standard Recording Code",
				"1", "Universal Product Code",
				"2", "International Standard Music Number",
				"3", "International Article Number",
				"4", "Serial Item and Contribution Identifier",
				"7", "Source specified in subfield $2",
				"8", "Unspecified type of standard number or code"
		);
		ind2 = new Indicator("Difference indicator").setCodes(
				" ", "No information provided",
				"0", "No difference",
				"1", "Difference"
		);
		setSubfieldsWithCardinality(
				"a", "Standard number or code", "NR",
				"c", "Terms of availability", "NR",
				"d", "Additional codes following the standard number or code", "NR",
				"q", "Qualifying information", "R",
				"z", "Canceled/invalid standard number or code", "R",
				"2", "Source of number or code", "NR",
				"6", "Linkage", "NR",
				"8", "Field link and sequence number", "R"
		);
		getSubfield("2").setCodeList(StandardIdentifierSourceCodes.getInstance());
	}
}
