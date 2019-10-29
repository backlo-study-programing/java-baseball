package controller;

import java.util.List;

import model.BaseBall;
import model.CreateThreeRandomNumber;
import model.ManageMentBallsAndUserNumbers;
import view.BaseBallGameInputView;
import view.BaseBallGameOutputview;

public class BaseBallGameController {

	private boolean continueGameFlag = true;

	private final int RESTART_GAME = 1;
	private final int THREE_STRIKE = 3;

	public void run() {
		do {
			ManageMentBallsAndUserNumbers manageMentBallsAndUserNumbers = new ManageMentBallsAndUserNumbers();
			CreateThreeRandomNumber createThreeRandomNumber = new CreateThreeRandomNumber();
			List<Integer> createdRandomNumbers = createThreeRandomNumber.createRandomNumbers();

			createBallList(manageMentBallsAndUserNumbers, createdRandomNumbers);
			startGame(manageMentBallsAndUserNumbers);

			continueGameFlag = true;
		} while (BaseBallGameOutputview.restartOREndGame() == RESTART_GAME);
	}

	private void createBallList(ManageMentBallsAndUserNumbers manageMentBallsAndUserNumbers, List<Integer> computerRandomNumbers) {
		computerRandomNumbers.stream().forEach(i -> { manageMentBallsAndUserNumbers.addBall(new BaseBall(i)); });
	}

	private void startGame(ManageMentBallsAndUserNumbers manageMentBallsAndUserNumbers) {
		while (continueGameFlag) {
			List<Integer> userInputNumbers = BaseBallGameInputView.inputNumber();
			manageMentBallsAndUserNumbers.inputUserNumbers(userInputNumbers);

			judge(manageMentBallsAndUserNumbers);
		}
	}

	private void judge(ManageMentBallsAndUserNumbers manageMentBallsAndUserNumbers) {

		int strike = manageMentBallsAndUserNumbers.countStrike();
		int ball = manageMentBallsAndUserNumbers.countBall();

		BaseBallGameOutputview.printStrikeAndBall(strike, ball);

		if (strike == THREE_STRIKE) {
			continueGameFlag = false;
		}

		clearToZeroStrikeAndBall(strike, ball);
	}

	private void clearToZeroStrikeAndBall(int strike, int ball) {
		strike = 0;
		ball = 0;
	}

}