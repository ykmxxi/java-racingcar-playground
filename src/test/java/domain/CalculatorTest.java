package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void test() {
		// given
		Calculator calculator = new Calculator();
		List<String> numbers = List.of("1", "2", "3");

		// when
		int result = calculator.add(numbers);

		// then
		assertThat(result).isEqualTo(6);
	}

}
