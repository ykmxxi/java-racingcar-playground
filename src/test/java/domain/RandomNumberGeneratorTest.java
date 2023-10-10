package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

	@Test
	void 난수_생성_테스트() {
		// given
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

		// when
		int result = randomNumberGenerator.createRandomNumber();

		// then
		System.out.println("result = " + result);
		assertThat(result).isGreaterThanOrEqualTo(0)
						  .isLessThanOrEqualTo(9);
	}

}
