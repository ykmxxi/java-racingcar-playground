package view;

public class OutputView {

	private static final String NAME_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 5자 이하 쉼표(,)를 기준으로 구분, 2대 이상을 입력).";

	public static void printNameInputGuide() {
		System.out.println(NAME_INPUT_GUIDE);
	}

}
