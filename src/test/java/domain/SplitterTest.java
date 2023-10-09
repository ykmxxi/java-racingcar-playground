package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class SplitterTest {

	private final Splitter splitter = new Splitter();

	@Test
	void 쉼표_구분자_입력_구분() {
		// given
		String input = "1,2,3";

		// when
		List<String> result = splitter.split(input);

		// then
		assertThat(result).containsExactly("1", "2", "3");
	}

	@Test
	void 콜론_구분자_입력_구분() {
		// given
		String input = "1:2:3";

		// when
		List<String> result = splitter.split(input);

		// then
		assertThat(result).containsExactly("1", "2", "3");
	}

	@Test
	void 커스텀_구분자_입력_구분() {
		// given
		String input = "//;\n1;2;3";

		// when
		List<String> result = splitter.split(input);

		// then
		assertThat(result).containsExactly("1", "2", "3");
	}

}
