package view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class InputViewTest {

	@Test
	void 빈_문자열_공백_검증() {
		// given
		InputView inputView = new InputView();

		// when & then
		assertThat(inputView.isEmptyOrWhitespaces("")).isTrue();
		assertThat(inputView.isEmptyOrWhitespaces("  ")).isTrue();
	}

}
