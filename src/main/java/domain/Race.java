package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

	public List<String> createRoundResult() {
		return cars.stream()
				   .map(Car::getPosition)
				   .map("-"::repeat)
				   .collect(Collectors.toList());
	}

}
