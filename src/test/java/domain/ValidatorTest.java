package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

	@Test
	void null_또는_빈_문자열_검증_통과() {
		// given
		String nullInput = null;
		String emptyInput = "";

		// when
		boolean nullResult = validator.isNullOrEmpty(nullInput);
		boolean emptyResult = validator.isNullOrEmpty(emptyInput);

		// then
		assertThat(nullResult).isTrue();
		assertThat(emptyResult).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {",", ":"})
	void test(String input) {
		// when
		boolean result = validator.isBasicDelimiter(input);

		// then
		assertThat(result).isTrue();
	}

}
