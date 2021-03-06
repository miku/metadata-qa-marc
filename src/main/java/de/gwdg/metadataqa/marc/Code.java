package de.gwdg.metadataqa.marc;

/**
 *
 * @author Péter Király <peter.kiraly at gwdg.de>
 */
public class Code {
	private String code;
	private String label;
	private boolean isRange = false;
	private boolean isRegex = false;

	public Code(String code, String label) {
		this.code = code;
		this.label = label;
	}

	public String getCode() {
		return code;
	}

	public String getLabel() {
		return label;
	}

	public boolean isRange() {
		return isRange;
	}

	public void setRange(boolean range) {
		isRange = range;
	}

	public boolean isRegex() {
		return isRegex;
	}

	public void setRegex(boolean regex) {
		isRegex = regex;
	}

	@Override
	public String toString() {
		return "Code{" +
				"code='" + code + '\'' +
				", label='" + label + '\'' +
				'}';
	}
}
