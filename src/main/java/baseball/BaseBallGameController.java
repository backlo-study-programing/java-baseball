package baseball;

import java.util.*;
import java.util.stream.*;

public class BaseBallGameController {

	private BaseBallGameView baseBallGameView;
	private BaseBall baseBall;
	private List<Integer> inputNumbers;
	private List<Integer> createdRandomNumbers;
	private int strike = 0;
	private int ball = 0;
	private boolean continueGameFlag = true;

	public BaseBallGameController() {
		baseBallGameView = new BaseBallGameView();
		baseBall = new BaseBall();
	}

	private void judge() {

		strike = countStrike();
		ball = countBall();

		baseBallGameView.printStrikeAndBall(strike, ball);

		if (strike == 3) {
			continueGameFlag = false;
		}

		clearToZeroStrikeAndBall();
	}

	private void clearToZeroStrikeAndBall() {
		strike = 0;
		ball = 0;
	}

	private int countBall() { // 자리수는 다르고 숫자만 같다면
		return IntStream.range(0, 3)
				.map(i -> (
						(createdRandomNumbers.get(i) == inputNumbers.get((i + 1) % 3))
						|| (createdRandomNumbers.get(i) == inputNumbers.get((i + 2) % 3))
						) ? 1 : 0)
				.sum();
	}

	private int countStrike() { // 자리수가 같으면 strike
		return IntStream.range(0, 3)
				.map(i -> (
						(createdRandomNumbers.get(i) == inputNumbers.get(i))
						) ? 1 : 0)
				.sum();
	}

	private void startGame() {
		while (continueGameFlag) {
			inputNumbers = baseBallGameView.inputNumber();
			judge();
		}
	}

	public void run() {
		do {
			baseBall.clearRandomNumbers();
			createdRandomNumbers = baseBall.createRandomNumber();
			startGame();
			continueGameFlag = true;
		} while (baseBallGameView.restartOREndGame() == 1);
	}

}
