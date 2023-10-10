package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

	private final Validator validator = new Validator();

	@ParameterizedTest
	@ValueSource(strings = {"k", "crong"})
	void 자동차_이름_검증_통과(String name) {
		// when
		boolean result = validator.isLessThanOrEqualFive(name);

		// then
		assertThat(result).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "malone"})
	void 자동차_이름_검증_실패(String name) {
		// when
		boolean result = validator.isLessThanOrEqualFive(name);

		// then
		assertThat(result).isFalse();
	}

	@Test
	void 자동차_2대_이상_검증_성공() {
		// given
		String input = "pobi,krong";

		// when
		boolean result = validator.isCarCountGreaterThanOrEqualTwo(input);

		// then
		assertThat(result).isTrue();
	}

	@Test
	void 자동차_2대_이상_검증_실패() {
		// given
		String input = "pobi";

		// when
		boolean result = validator.isCarCountGreaterThanOrEqualTwo(input);

		// then
		assertThat(result).isFalse();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 9})
	void _1부터_9사이_숫자_검증_성공(int number) {
		// when
		boolean result = validator.isBetweenOneAndNine(number);

		// then
		assertThat(result).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 10})
	void _1부터_9사이_숫자_검증_실패(int number) {
		// when
		boolean result = validator.isBetweenOneAndNine(number);

		// then
		assertThat(result).isFalse();
	}

}
