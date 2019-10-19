package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class BaseBall {
    private final int MAX_BALL_COUNT = 3;
    private final int MAX_RANDOM_NUMBER = 9;
    private List<Integer> balls = new ArrayList<>();

    public BaseBall() {
        setAllBalls();
    }

    private int getRandom() {
        int random = new Random().nextInt(MAX_RANDOM_NUMBER);
        return (random + 1);
    }

    private void setBall() {
        balls.add(getRandom());
        HashSet<Integer> tmpball = new HashSet<Integer>(balls);
        balls = new ArrayList<>(tmpball);
    }

    private void setAllBalls() {
        while (balls.size() != 3){
            setBall();
        }
    }

    public void resetAllBall() {
        balls.clear();
        setAllBalls();
    }

    public List<Integer> getBalls() {
        return this.balls;
    }
}
