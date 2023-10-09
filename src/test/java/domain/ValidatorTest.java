package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ValidatorTest {

	private final Validator validator = new Validator();

	@Test
	void 숫자_검증_통과() {
		// given
		String input = "1";

		// when
		boolean result = validator.isNumber(input);

		// then
		assertThat(result).isTrue();
	}

	@Test
	void 숫자_검증_실패() {
		// given
		String input = "one";

		// when
		boolean result = validator.isNumber(input);

		// then
		assertThat(result).isFalse();
	}

}
