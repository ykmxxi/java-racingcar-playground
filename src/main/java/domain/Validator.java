package domain;

import java.util.Arrays;

public class Validator {

	private static final String NUMBER_REGEX = "[1-9]\\d*";
	private static final String BASIC_DELIMITER_REGEX = "[,:]";

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

}
