package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class RaceTest {

	@Test
	void 라운드_진행_결과_생성() {
		// given
		Race race = new Race(List.of(new Car("pobi"), new Car("crong")), 1);

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

	@Test
	void 우승자를_알려주는_기능() {
		// given
		Race race1 = new Race(List.of(new Car("pobi"), new Car("crong")), 0);
		Race race2 = new Race(List.of(new Car("pobi"), new Car("crong")), 0);

		// when
		List<Car> cars1 = race1.getCars();
		cars1.get(0).updatePosition();
		cars1.get(0).updatePosition();
		cars1.get(1).updatePosition();

		race2.getCars()
			 .forEach(Car::updatePosition);

		// then
		assertThat(race1.notifyChampionNames()).isEqualTo(List.of("pobi"));
		assertThat(race2.notifyChampionNames()).isEqualTo(List.of("pobi", "crong"));
	}

}
