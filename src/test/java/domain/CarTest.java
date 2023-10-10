package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	void 위치_갱신() {
		// given
		Car car = new Car("name");

		// when
		car.updatePosition();

		// then
		assertThat(car.getName()).isEqualTo("name");
		assertThat(car.getPosition()).isEqualTo(2);
	}

}
