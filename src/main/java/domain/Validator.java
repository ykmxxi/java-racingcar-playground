package domain;

import java.util.Arrays;

public class Validator {

	private static final String NUMBER_REGEX = "[1-9]\\d*";
	private static final String BASIC_DELIMITER_REGEX = "[,:]";
	private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
	private static final String NEGATIVE_REGEX = "^-[1-9]\\d*";

	public void validate(String input) {
		if (!isNumberWithBasicDelimiter(input) && !isCustomDelimiter(input)) {
			throw new RuntimeException();
		}
		if (!isCustomDelimiter(input) && isNegative(input)) {
			throw new RuntimeException();
		}
	}

	public boolean isNumber(String input) {
		return input.matches(NUMBER_REGEX);
	}

	public boolean isNullOrEmpty(String input) {
		return input == null || input.isEmpty();
	}

	public boolean isBasicDelimiter(String input) {
		return input.matches(BASIC_DELIMITER_REGEX);
	}

	public boolean isNumberWithBasicDelimiter(String input) {
		return Arrays.stream(input.split(""))
					 .allMatch(token -> isNumber(token) || isBasicDelimiter(token));
	}

	public boolean isCustomDelimiter(String input) {
		return input.matches(CUSTOM_DELIMITER_REGEX);
	}

	public boolean isNegative(String input) {
		return input.matches(NEGATIVE_REGEX);
	}

}
