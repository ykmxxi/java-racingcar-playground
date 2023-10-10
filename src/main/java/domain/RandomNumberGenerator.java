package domain;

import java.util.Random;

public class RandomNumberGenerator {

	public static int createRandomNumber() {
		return new Random().nextInt(9) + 1;
	}

}
