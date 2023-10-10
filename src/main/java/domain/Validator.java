package domain;

public class Validator {

	private static final int FIVE = 5;

	public boolean isLessThanOrEqualFive(String name) {
		return !name.isBlank() && name.length() <= FIVE;
	}

}
