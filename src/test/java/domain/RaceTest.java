package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class RaceTest {

	@Test
	void 라운드_진행_결과_생성() {
		// given
		Race race = new Race();

		// when
		race.playRound();
		List<String> results = race.createRoundResult();

		// then
		List<String> expected = race.getCars().stream()
									.map(Car::getPosition)
									.map("-"::repeat)
									.collect(Collectors.toList());

		assertThat(results).isEqualTo(expected);
	}

}
