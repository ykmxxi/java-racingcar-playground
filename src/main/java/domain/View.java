package domain;

import java.util.Scanner;

public class View {

	private static final Scanner scanner = new Scanner(System.in);
	private static final String RESULT_ARROW = " => ";

	public String readString() {
		return scanner.nextLine();
	}

	public void printResult(String input, String result) {
		System.out.println(input + RESULT_ARROW + result);
	}

}
