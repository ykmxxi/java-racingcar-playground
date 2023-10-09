package domain;

import java.util.Scanner;

public class View {

	private static final Scanner scanner = new Scanner(System.in);

	public String readString() {
		return scanner.nextLine();
	}

}
