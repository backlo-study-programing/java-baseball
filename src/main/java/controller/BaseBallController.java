package controller;

import model.BadInput;
import model.BallManager;
import model.ScoreManager;
import vIew.OutputView;

public class BaseBallController {
    private final BallManager ballManager;
    private ScoreManager scoreManager;
    private BadInput badInput;
    private boolean power;

    public BaseBallController() {
        power = true;
        ballManager = new BallManager();
        ballManager.setBalls();
    }

    public void run() {
        while (power) {
            int userNumber = OutputView.roundStart();
            ballManager.setUserBalls(userNumber);
            if (isBadInput(userNumber)) {
                continue;
            }
            result();
        }
    }

    private boolean isBadInput(int userNumber) {
        badInput = new BadInput(ballManager.getUserBalls(), userNumber);
        return badInput.hasBadInput();
    }

    private void result(){
        scoreManager = new ScoreManager(ballManager.getUserBalls(), ballManager.getBalls());
        scoreManager.gatherScore();
        if (scoreManager.isAllStrike()) {
            power = false;
        }
    }
}
