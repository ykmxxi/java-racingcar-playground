package domain;

import java.util.Collections;
import java.util.List;

public class Race {

	private final List<Car> cars;
	private final int retryCount;

	public Race(List<Car> cars, int retryCount) {
		this.cars = cars;
		this.retryCount = retryCount;
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	public void playRound() {
		for (int round = 1; round <= retryCount; round++) {
			play();
		}
	}

	private void play() {
		for (Car car : cars) {
			if (car.canMove()) {
				car.updatePosition();
			}
		}
	}

}
