package model;

public class GameCurrentResult {
    private static final int ZERO_COUNT = 0;
    private int strike;
    private int ball;

    public void initResult() {
        strike = ZERO_COUNT;
        ball = ZERO_COUNT;
    }

    public void plusStrike() {
        strike++;
    }

    public void plusBall() {
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

}
