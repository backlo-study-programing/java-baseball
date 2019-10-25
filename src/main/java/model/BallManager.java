package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallManager {
    private static final int BALL_BOUND = 9;
    private static final int BALL_COUNT = 3;
    private final List<Ball> balls;
    private List<Ball> userBalls;

    public BallManager(){
        balls = new ArrayList<>();
    }

    public List<Ball> getUserBalls(){
        return userBalls;
    }

    public List<Ball> getBalls(){
        return balls;
    }

    public void setBalls() {
        balls.add(new Ball(getRandomNumber()));
        while (balls.size() < BALL_COUNT) {
            Ball newBall = new Ball(getRandomNumber());
            checkSameNumbers(newBall);
            balls.add(newBall);
        }
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(BALL_BOUND) + 1;//1부터 9의 난수 받기
    }

    private void checkSameNumbers(Ball newBall) {
        for (int index = 0; index < balls.size(); index++) {
            deleteSameNumber(index, newBall);
        }
    }

    private void deleteSameNumber(int index, Ball newBall) {
        if (balls.get(index).isSameNumber(newBall)) {
            balls.remove(index);
        }
    }

    public void setUserBalls(int userNumber) {
        userBalls = new ArrayList<>();
        userBalls.add(getFirstUserBall(userNumber));
        userBalls.add(getSecondUserBall(userNumber));
        userBalls.add(getThirdUserBall(userNumber));
    }

    private Ball getFirstUserBall(int userNumber) {
        int firstBall = userNumber / 100;
        Ball firstBallModel = new Ball(firstBall);
        return firstBallModel;
    }

    private Ball getSecondUserBall(int userNumber) {
        int secondBall = userNumber % 100 / 10;
        Ball secondBallModel = new Ball(secondBall);
        return secondBallModel;
    }

    private Ball getThirdUserBall(int userNumber) {
        int thirdBall = userNumber % 10;
        Ball thirdBallModel = new Ball(thirdBall);
        return thirdBallModel;
    }

}
