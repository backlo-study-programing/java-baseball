package model;

import vIew.OutputView;
import java.util.List;

public class BadInput {
    private static final int BALL_COUNT = 3;
    private final List<Ball> userBalls;
    private final int userNumber;

    public BadInput(List<Ball> userBalls, int userNumber) {
        this.userBalls = userBalls;
        this.userNumber = userNumber;
    }

    public boolean hasBadInput() {
        boolean badInputWithZero = isBadInputWithZero();
        boolean badInputWithDigits = isBadInputOverThreeDigits();
        boolean badInputWithSameNumber = isBadInputWithSameNumber();
        if (badInputWithDigits == false && badInputWithZero == false && badInputWithSameNumber == false) {
            return false;
        }
        return true;
    }

    private boolean isBadInputWithZero() {
        Ball badBall = new Ball(0);
        boolean isZero = false;
        for (int i = 0; i < BALL_COUNT && isZero == false; i++) {
            isZero = userBalls.get(i).isSameNumber(badBall);
        }
        if (isZero) {
            OutputView.printWithOutZero();
        }
        return isZero;
    }

    private boolean isBadInputOverThreeDigits() {
        if (userNumber >= 100 && userNumber <= 999) {
            return false;
        }
        OutputView.printWithThreeDigits();
        return true;
    }

    private boolean isBadInputWithSameNumber() {
        if (userBalls.get(0).isSameNumber(userBalls.get(1)) ||
                userBalls.get(0).isSameNumber(userBalls.get(2)) ||
                userBalls.get(1).isSameNumber(userBalls.get(2))) {
            OutputView.printWithOutSameNumber();
            return true;
        }
        return false;
    }
}
