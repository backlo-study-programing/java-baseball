package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
<<<<<<< HEAD
import java.util.stream.IntStream;
=======
>>>>>>> a0ac3cff4d92c4385ea582458fe06a2b05c405fb

public class BaseBall {
    private final int MAX_BALL_COUNT = 3;
    private final int MAX_RANDOM_NUMBER = 9;
<<<<<<< HEAD
    private List<Integer> computerNumber;
    private List<Integer> userNumber;

    public BaseBall() {
        computerNumber = new ArrayList<>();
        userNumber = new ArrayList<>();
        initComputerBalls();
    }

    private void initComputerBalls() {
        while (computerNumber.size() != MAX_BALL_COUNT){
            setBall();
        }
    }

    private void setBall() {
        computerNumber.add(getRandom());
        HashSet<Integer> newBall = new HashSet<Integer>(computerNumber);
        computerNumber = new ArrayList<>(newBall);
=======
    private List<Integer> balls = new ArrayList<>();

    public BaseBall() {
        setAllBalls();
>>>>>>> a0ac3cff4d92c4385ea582458fe06a2b05c405fb
    }

    private int getRandom() {
        int random = new Random().nextInt(MAX_RANDOM_NUMBER);
        return (random + 1);
    }

<<<<<<< HEAD
    public void resetComputerBall() {
        computerNumber.clear();
        initComputerBalls();
    }

    public void initUserNumber(String userBall) {
        userNumber.clear();
        for(int i = 0 ; i<userBall.length() ; i++) {
            userNumber.add(Integer.parseInt(userBall.split("")[i]));
        }
    }

    public int countBall() {
        return IntStream.range(0,userNumber.size())
                .map(i -> (getComputerNumber().get(i) == userNumber.get((i + 1) % 3)) || (getComputerNumber().get(i) == userNumber.get((i + 2) % 3)) ? 1 : 0)
                .sum();
    }

    public int countStrike() {
        return IntStream.range(0,userNumber.size())
                .map(i -> (getComputerNumber().get(i) == userNumber.get(i)) ? 1 : 0)
                .sum();
    }

    public List<Integer> getComputerNumber() {
        return this.computerNumber;
=======
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
>>>>>>> a0ac3cff4d92c4385ea582458fe06a2b05c405fb
    }
}
