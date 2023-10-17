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
	private final GameOperator gameOperator;

	public GameController() {
		this.inputView = new InputView();
		this.validator = new Validator();
		this.gameOperator = new GameOperator();
	}

	public void run() {
		List<String> carNames = getCarNamesAndValidate();
		int numberOfAttempts = getNumberOfAttemptsAndValidate();
		playGame(carNames, numberOfAttempts);
	}

	private List<String> getCarNamesAndValidate() {
		OutputView.printNameInputGuide();
		String input = inputView.readCarNames();
		List<String> carNames = gameOperator.splitCarNames(input);
		carNames.forEach(validator::isLessThanOrEqualFive);
		validator.isCarCountGreaterThanOrEqualTwo(input);
		return carNames;
	}

	private int getNumberOfAttemptsAndValidate() {
		OutputView.printNumberOfAttemptsGuide();
		String input = inputView.readNumberOfAttempts();
		int numberOfAttempts = Integer.parseInt(input);
		validator.isBetweenOneAndNine(numberOfAttempts);
		return numberOfAttempts;
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
