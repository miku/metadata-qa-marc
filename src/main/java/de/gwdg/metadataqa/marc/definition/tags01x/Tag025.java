package de.gwdg.metadataqa.marc.definition.tags01x;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

public class Tag025 extends DataFieldDefinition {

	private static Tag025 uniqueInstance;

	private Tag025() {
		initialize();
	}

	public static Tag025 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag025();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "025";
		label = "Overseas Acquisition Number";
		cardinality = Cardinality.Repeatable;
		ind1 = new Indicator("").setCodes(" ", "Undefined");
		// TODO: set label
		ind2 = new Indicator("").setCodes(" ", "Undefined");
		setSubfieldsWithCardinality(
				"a", "Overseas acquisition number", "R",
				"8", "Field link and sequence number", "R"
		);
	}
}
