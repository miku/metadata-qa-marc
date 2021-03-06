package de.gwdg.metadataqa.marc.definition.tags01x;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;
import de.gwdg.metadataqa.marc.definition.general.codelist.DateSourceCodes;
import de.gwdg.metadataqa.marc.definition.general.codelist.MusicalCompositionSourceCodes;

/**
 * Form of Musical Composition Code
 * http://www.loc.gov/marc/bibliographic/bd047.html
 */
public class Tag047 extends DataFieldDefinition {

	private static Tag047 uniqueInstance;

	private Tag047(){
		initialize();
	}

	public static Tag047 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag047();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "047";
		label = "Form of Musical Composition Code";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("");
		ind2 = new Indicator("Source of code").setCodes(
				" ", "MARC musical composition code",
				"7", "Source specified in subfield $2"
		);
		setSubfieldsWithCardinality(
				"a", "Form of musical composition code", "R",
				"2", "Source of code", "NR",
				"8", "Field link and sequence number", "R"
		);
		getSubfield("2").setCodeList(MusicalCompositionSourceCodes.getInstance());
	}
}
