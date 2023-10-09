package domain;

import java.util.List;

public class Calculator {

	public int add(List<String> numbers) {
		return numbers.stream()
					  .mapToInt(Integer::parseInt)
					  .sum();
	}

}
