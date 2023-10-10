package domain;

import static org.assertj.core.api.Assertions.assertThat;

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

}
