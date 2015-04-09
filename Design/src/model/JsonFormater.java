package model;

/**
 * Is used to format strings to a JSON format that is easy to read.
 * 
 * @author rasmus östberg
 *
 */
public class JsonFormater {
	/**
	 * Formats the given string to a readable JSON format
	 * 
	 * @param unformatedString
	 * @return String the formated String.
	 */
	public String format(String unformatedString) {
		String base = "";
		int depth = 0;

		for (int i = 0; i < unformatedString.length(); i++) {
			char c = unformatedString.charAt(i);
			if (isBracket(unformatedString.charAt(i))) {
				if (isleftBracket(c)) {
					depth++;
					base += c;
					base += "\n";
					base += getTabs(depth);
				} else {
					depth--;
					base += "\n";
					base += getTabs(depth);
					base += c;
				}
			} else if (isComma(c)) {
				base += c;
				base += "\n";
				base += getTabs(depth);
			} else {
				base += c;
			}
		}
		return base;

	}

	protected boolean isleftBracket(char c) {
		return (c == '[' || c == '{');
	}

	protected boolean isRightBracket(char c) {
		return (c == ']' || c == '}');
	}

	protected boolean isBracket(char c) {
		return isleftBracket(c) || isRightBracket(c);
	}

	protected String getTabs(int tabs) {
		String base = "";
		for (int i = 0; i < tabs; i++) {
			base += "\t";
		}
		return base;
	}

	protected boolean isComma(char c) {
		return c == ',';
	}
}
