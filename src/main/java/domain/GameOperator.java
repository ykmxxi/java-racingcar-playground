package domain;

public class GameOperator {

	private static final int FOUR = 4;

	public boolean isGreaterThanOrEqualThanFour() {
		return RandomNumberGenerator.createRandomNumber() >= FOUR;
	}

}
