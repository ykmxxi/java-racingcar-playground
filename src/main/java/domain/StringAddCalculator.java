package domain;

public class StringAddCalculator {

	private final Splitter splitter;
	private final Calculator calculator;
	private final Validator validator;

	public StringAddCalculator() {
		this.splitter = new Splitter();
		this.calculator = new Calculator();
		this.validator = new Validator();
	}

	public int splitAndSum(String input) {
		if (validator.isNullOrEmpty(input)) {
			return 0;
		}
		validator.validate(input);
		return calculator.add(splitter.split(input));
	}

}
