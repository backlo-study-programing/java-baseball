package model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Baseball {
    private final String ball;
    private final int OUT_OF_RANGE = 0;
    private final int BALL_COUNT = 3;
    private List<String> balls = new ArrayList<>(BALL_COUNT);

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

    private String createRandNum() {
        int randNum = (new Random(System.currentTimeMillis()).nextInt(10));
        if (randNum == OUT_OF_RANGE) return createRandNum();
        return Integer.toString(randNum);
    }

    private void removeDuplication() {
        balls = new ArrayList<>(new HashSet<>(balls));
    }

    private String makeTotalBall() {
       return balls.stream()
               .map(n -> String.valueOf(n))
               .collect(Collectors.joining());
    }

    public List<String> getBalls() {
        return balls;
    }

    public String getBall() {   // 쓸 일 없으면 빼기
        return ball;
    }
}
