package baseballgame;

import java.util.List;

public class BaseBallBadInputController {

    private static final int BALL_BOUND = 3;
    private final List<BaseBallModel> userBalls;
    private final int userNumber;

    BaseBallBadInputController(List<BaseBallModel> userBalls, int userNumber) {
        this.userBalls = userBalls;
        this.userNumber = userNumber;
    }

    public boolean isBadInputWithZero() {
        BaseBallModel badBall = new BaseBallModel(0);
        boolean isZero = false;
        for (int i = 0; i < BALL_BOUND && isZero == false; i++)
            isZero = userBalls.get(i).isSameNumber(badBall);
        if (isZero) BaseBallView.printWithOutZero();
        return isZero;
    }

    public boolean isBadInputOverThreeDigits() {
        if (userNumber >= 100 && userNumber <= 999)
            return false;
        BaseBallView.printWithThreeDigits();
        return true;
    }

    public boolean isBadInputWithSameNumber() {
        if (userBalls.get(0).isSameNumber(userBalls.get(1)) ||
                userBalls.get(0).isSameNumber(userBalls.get(2)) ||
                userBalls.get(1).isSameNumber(userBalls.get(2))) {
            BaseBallView.printWithOutSameNumber();
            return true;
        }
        return false;
    }
}
