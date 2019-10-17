package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Baseball {
    private final int ball;
    private final int OUT_OF_RANGE = 0;
    private final int BALL_COUNT = 3;
    private List<Integer> balls = new ArrayList<>(BALL_COUNT);

    public Baseball() {
        insertBallNumber();
        ball = makeTotalBall();
    }

    private void insertBallNumber() {
        while (balls.size() != BALL_COUNT) {
            balls.add(balls.size(), createRandNum());
            removeDuplication();
        }
    }

    private int createRandNum() {
        int randNum = (new Random(System.currentTimeMillis()).nextInt(10));
        if (randNum == OUT_OF_RANGE) return createRandNum();
        return randNum;
    }

    private void removeDuplication() {
        balls = new ArrayList<>(new HashSet<>(balls));
    }

    private int makeTotalBall() {
        int multiply = 100;
        int totalBall = 0;
        for (int i = 0; i < BALL_COUNT; i++) {
            totalBall += multiply * balls.get(i);
            multiply /= 10;
        }
        return totalBall;
    }

    public int getBall() {
        return ball;
    }
}
