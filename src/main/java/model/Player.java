package model;

import java.util.List;

public class Player {
    private List<Integer> baseballNum;

    public Player(List<Integer> baseballNum) {
        this.baseballNum = baseballNum;
    }

    public List<Integer> getBaseballNum() {
        return this.baseballNum;
    }
}
