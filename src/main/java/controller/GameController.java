package controller;

import java.util.List;

import domain.GameOperator;
import domain.Validator;
import view.InputView;

public class GameController {

	private final InputView inputView;
	private final Validator validator;
	private final GameOperator gameOperator;

	public GameController() {
		this.inputView = new InputView();
		this.validator = new Validator();
		this.gameOperator = new GameOperator();
	}

	public List<String> getCarNamesAndValidate() {
		String input = inputView.readCarNames();
		List<String> carNames = gameOperator.splitCarNames(input);
		carNames.forEach(validator::isLessThanOrEqualFive);
		validator.isCarCountGreaterThanOrEqualTwo(input);
		return carNames;
	}

}
