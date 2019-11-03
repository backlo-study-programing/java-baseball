package model;

import java.util.*;
import java.util.stream.IntStream;

public class Computer {
    private static final int MAX_RANDOM_NUMBER = 9;
    public static final int LIMIT_NUMBER = 3;

    private List<Integer> comBaseballNum;
    private long strikeCount = 0;
    private long ballCount = 0;

    public Computer() {
        comBaseballNum = new ArrayList<>();
        makeRandomNumber();
    }

    private void makeRandomNumber() {
        Set<Integer> randomNum = new HashSet<>();
        while (randomNum.size() != LIMIT_NUMBER) {
            randomNum.add(new Random().nextInt(MAX_RANDOM_NUMBER) + 1);
        }
        addRandomNumber(randomNum);
    }

    private void addRandomNumber(Set<Integer> randomNum) {
        this.comBaseballNum.addAll(randomNum);
    }


    public long getStrikeCount() {
        return strikeCount;
    }

    public void putBallCount(long ballCount) {
        this.ballCount = ballCount;
    }

    public void putStrikeCount(long strikeCount) {
        this.strikeCount = strikeCount;
    }

    public long getBallCount() {
        return ballCount;
    }

    public List<Integer> getBaseballNum() {
        return this.comBaseballNum;
    }

}
