package view;

import java.util.List;

public class OutputView {

	private static final String NAME_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 5자 이하 쉼표(,)를 기준으로 구분, 2대 이상을 입력).";
	private static final String ATTEMPTS_NUMBER_INPUT_GUIDE = "시도할 회수는 몇회인가요?(1에서 9사이의 숫자를 입력)";
	public static final String CHAMPION_GUIDE = "가 최종 우승했습니다.";

	public static void printNameInputGuide() {
		System.out.println(NAME_INPUT_GUIDE);
	}

	public static void printNumberOfAttemptsGuide() {
		System.out.println(ATTEMPTS_NUMBER_INPUT_GUIDE);
	}

	public static void printExecutionResult(List<String> carNames, List<String> roundResult) {
		for (int idx = 0; idx < carNames.size(); idx++) {
			String name = carNames.get(idx);
			String result = roundResult.get(idx);
			System.out.println(name + " : " + result);
		}
	}

	public static void printChampionNames(List<String> championNames) {
		System.out.println(getChampionNames(championNames) + CHAMPION_GUIDE);
	}

	private static String getChampionNames(List<String> championNames) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int idx = 0; idx < championNames.size(); idx++) {
			stringBuilder.append(championNames.get(idx));
			if (idx != championNames.size() - 1) {
				stringBuilder.append(", ");
			}
		}
		return stringBuilder.toString();
	}

}
