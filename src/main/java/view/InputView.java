package view;

import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);
	private static final String ERROR_MESSAGE = "값을 입력해 주세요.";

	public String readCarNames() {
		String carNames = scanner.nextLine();
		if (isEmptyOrWhitespaces(carNames)) {
			throw new RuntimeException(ERROR_MESSAGE);
		}
		return carNames;
	}

	public String readNumberOfAttempts() {
		String numberOfAttempts = scanner.nextLine();
		if (isEmptyOrWhitespaces(numberOfAttempts)) {
			throw new RuntimeException(ERROR_MESSAGE);
		}
		return numberOfAttempts;
	}

	public boolean isEmptyOrWhitespaces(String input) {
		return input.isBlank();
	}

}
