package model;

import java.util.*;
import java.util.stream.*;

public class ManageMentBallsAndUserNumbers {

	private List<Integer> userInputNumbers;
	private List<BaseBall> balls;

	public ManageMentBallsAndUserNumbers() {
		balls = new ArrayList<>();
	}

	public void addBall(BaseBall ball) {
		balls.add(ball);
	}

	public void inputUserNumbers(List<Integer> userInputNumbers) {
		this.userInputNumbers = userInputNumbers;
	}

	public int countBall() {
		return IntStream.range(0, 3).map(i -> ((balls.get(i).getRandomNumber() == userInputNumbers.get((i + 1) % 3))
				|| (balls.get(i).getRandomNumber() == userInputNumbers.get((i + 2) % 3))) ? 1 : 0).sum();
	}

	public int countStrike() { // 자리수가 같으면 strike
		return IntStream.range(0, 3).map(i -> ((balls.get(i).getRandomNumber() == userInputNumbers.get(i))) ? 1 : 0)
				.sum();
	}

}
