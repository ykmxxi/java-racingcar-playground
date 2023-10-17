package controller;

import java.util.List;
import java.util.stream.Collectors;

import domain.Car;
import domain.GameOperator;
import domain.Race;
import domain.Validator;
import view.InputView;
import view.OutputView;

public class GameController {

	private final InputView inputView;
	private final Validator validator;

	public GameController() {
		this.inputView = new InputView();
		this.validator = new Validator();
	}

	public void run() {
		List<String> carNames = getCarNamesAndValidate();
		int numberOfAttempts = getNumberOfAttemptsAndValidate();
		playGame(carNames, numberOfAttempts);
	}

	private List<String> getCarNamesAndValidate() {
		OutputView.printNameInputGuide();
		String input = inputView.readCarNames();
		GameOperator gameOperator = new GameOperator();
		List<String> carNames = gameOperator.splitCarNames(input);
		validateCarNames(input, carNames);
		return carNames;
	}

	private void validateCarNames(String input, List<String> carNames) {
		for (String carName : carNames) {
			if (!validator.isLessThanOrEqualFive(carName)) {
				throw new RuntimeException();
			}
		}
		if (!validator.isCarCountGreaterThanOrEqualTwo(input)) {
			throw new RuntimeException();
		}
	}

	private int getNumberOfAttemptsAndValidate() {
		OutputView.printNumberOfAttemptsGuide();
		String input = inputView.readNumberOfAttempts();
		int numberOfAttempts = Integer.parseInt(input);
		validateNumberOfAttempts(numberOfAttempts);
		return numberOfAttempts;
	}

	private void validateNumberOfAttempts(int numberOfAttempts) {
		if (!validator.isBetweenOneAndNine(numberOfAttempts)) {
			throw new RuntimeException();
		}
	}

	private void playGame(List<String> carNames, int numberOfAttempts) {
		List<Car> cars = carNames.stream()
								 .map(Car::new)
								 .collect(Collectors.toList());
		Race race = new Race(cars);
		play(carNames, numberOfAttempts, race);
		OutputView.printChampionNames(race.notifyChampionNames());
	}

	private void play(List<String> carNames, int numberOfAttempts, Race race) {
		System.out.println("실행 결과");
		OutputView.printExecutionResult(carNames, race.createRoundResult());
		for (int round = 1; round <= numberOfAttempts; round++) {
			race.playRound();
			OutputView.printExecutionResult(carNames, race.createRoundResult());
		}
	}

}
