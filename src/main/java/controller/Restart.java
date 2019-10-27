package controller;

import java.util.Arrays;
import java.util.function.Consumer;

public enum Restart {
    RESTART(1, BaseballController::playGame),
    STOP(2, BaseballController::gameEnd);

    private int selectedNum;
    Consumer<BaseballController> controllerConsumer;

    Restart(int selectedNum, Consumer<BaseballController> controllerConsumer) {
        this.selectedNum = selectedNum;
        this.controllerConsumer = controllerConsumer;
    }

    public static Restart of(int selectedNum) {
        return Arrays.stream(values())
                .filter(index -> index.selectedNum == selectedNum)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s은 1 또는 2에 해당되지 않습니다.", selectedNum)));
    }
}
