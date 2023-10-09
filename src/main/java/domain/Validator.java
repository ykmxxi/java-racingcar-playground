package domain;

public class Validator {

	private static final String NUMBER_REGEX = "[1-9]\\d*";

	public boolean isNumber(String input) {
		return input.matches(NUMBER_REGEX);
	}

}
