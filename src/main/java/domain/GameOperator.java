package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameOperator {

	private static final int FOUR = 4;

	public boolean isGreaterThanOrEqualThanFour() {
		return RandomNumberGenerator.createRandomNumber() >= FOUR;
	}

	public List<String> splitCarNames(String carNames) {
		return Arrays.stream(carNames.split(","))
					 .collect(Collectors.toUnmodifiableList());
	}

}
