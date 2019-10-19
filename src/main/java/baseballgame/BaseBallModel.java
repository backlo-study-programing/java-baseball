package baseballgame;

import java.util.Random;

public class BaseBallModel {
    private final int Bound = 9;
    private final int number;

    BaseBallModel() {
        number = getRandomNumber();
    }

    BaseBallModel(int number) {
        this.number = number;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(Bound) + 1;//1부터 9의 난수 받기
    }

    private int getNumber() {
        return this.number;
    }


    public boolean isSameNumber(BaseBallModel balls) {
        if (this.number == balls.getNumber()) return true;
        return false;
    }
}
