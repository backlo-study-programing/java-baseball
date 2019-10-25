package model;

import java.util.Random;

public class Ball {
    private final int number;

    public Ball(int number) {
        this.number = number;
    }

    private int getNumber() {
        return this.number;
    }

    public boolean isSameNumber(Ball balls) {
        if (this.number == balls.getNumber()) return true;
        return false;
    }
}
