package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class GameOperatorTest {

	@Test
	void test() {
		// given
		GameOperator gameOperator = new GameOperator();
		String carNames = "pobi,crong,honux";

		// when
		List<String> result = gameOperator.splitCarNames(carNames);

		// then
		assertThat(result).containsExactly("pobi", "crong", "honux");
	}

}
