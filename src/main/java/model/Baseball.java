package model;


import java.util.*;
import java.util.stream.Collectors;

public class Baseball {
    private final String ball;
    private static final int OUT_OF_RANGE = 0;
    private static final int BALL_COUNT = 3;
    private Set<String> balls = new HashSet<>(BALL_COUNT);

    public Baseball() {
        insertBallNumber();
        ball = makeTotalBall();
    }

    private void insertBallNumber() {
        while (balls.size() != BALL_COUNT) {
            balls.add(createRandNum());
        }
    }

    private String createRandNum() {
        int randNum = (new Random(System.currentTimeMillis()).nextInt(10));
        if (randNum == OUT_OF_RANGE) return createRandNum();
        return Integer.toString(randNum);
    }
    private String makeTotalBall() {
        return balls.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public List<String> getBalls() {
        List<String> balls = new ArrayList<>();
        balls.addAll(this.balls);
        return balls;
    }

    public String getBall() {   // 쓸 일 없으면 빼기
        return ball;
    }
}
