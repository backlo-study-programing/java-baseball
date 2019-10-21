package baseball;

import java.util.*;
import java.util.stream.*;

public class BaseBallGameController {

	private List<Integer> inputNumbers;
	private List<Integer> createdRandomNumbers  = new ArrayList<>();
	private List<BaseBall> createdRandomBalls = new ArrayList<>();

	private int strike = 0;
	private int ball = 0;

	private boolean continueGameFlag = true;

	private final int RESTART_GAME = 1;
	private final int THREE_STRIKE = 3;
	private final int HOW_MANY_BALLS = 3;

	public void run() {
		do {
			clearRandomNumbers();
			createThreeBalls();
			startGame();
			continueGameFlag = true;
		} while (BaseBallGameView.restartOREndGame() == RESTART_GAME);
	}

	private void createThreeBalls() {
		for (int i = 0; i < HOW_MANY_BALLS; i++) {
			BaseBall ball = new BaseBall();
			checkOverlapped(ball);
		}
	}

	private void checkOverlapped(BaseBall ball) {
		if (ball.verifyBallAndCreateBall(createdRandomBalls)) {
			createdRandomBalls.add(ball);
			createdRandomNumbers.add(ball.getNumber());
		}
	}

	private void clearRandomNumbers() {
		createdRandomBalls.clear();
		createdRandomNumbers.clear();
	}

	private void startGame() {
		while (continueGameFlag) {
			inputNumbers = BaseBallGameView.inputNumber();
			judge();
		}
	}

	private void judge() {

		strike = sumStrike();
		ball = sumBall();

		BaseBallGameView.printStrikeAndBall(strike, ball);

		if (strike == THREE_STRIKE) {
			continueGameFlag = false;
		}

		clearToZeroStrikeAndBall();
	}

	private void clearToZeroStrikeAndBall() {
		strike = 0;
		ball = 0;
	}

	private int sumBall() { // 자리수는 다르고 숫자만 같다면
		return IntStream.range(0, 3).map(i -> ((createdRandomNumbers.get(i) == inputNumbers.get((i + 1) % 3))
				|| (createdRandomNumbers.get(i) == inputNumbers.get((i + 2) % 3))) ? 1 : 0).sum();
	}

	private int sumStrike() { // 자리수가 같으면 strike
		return IntStream.range(0, 3).map(i -> ((createdRandomNumbers.get(i) == inputNumbers.get(i))) ? 1 : 0).sum();
	}
}