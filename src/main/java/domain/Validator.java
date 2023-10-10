package domain;

public class Validator {

	private static final int FIVE = 5;
	private static final int TWO = 2;
	private static final String COMMA = ",";

	public boolean isLessThanOrEqualFive(String name) {
		return !name.isBlank() && name.length() <= FIVE;
	}

	public boolean isCarCountGreaterThanOrEqualTwo(String input) {
		if (isOneCar(input)) {
			return false;
		}
		return getCarCount(input) >= TWO;
	}

	private boolean isOneCar(String input) {
		return !input.contains(COMMA);
	}

	private int getCarCount(String input) {
		return input.split(COMMA).length;
	}

	public boolean isBetweenOneAndNine(int number) {
		return number > 0 && number < 10;
	}

}
