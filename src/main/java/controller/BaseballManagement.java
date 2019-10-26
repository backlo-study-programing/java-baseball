package controller;

import model.Computer;
import view.InputView;
import view.OutputView;

import java.util.*;
import java.util.stream.IntStream;

import static model.Computer.LIMIT_NUMBER;
import static model.GameFlag.*;

public class BaseballManagement {
    private InputView inputView;
    private OutputView outputView;

    public BaseballManagement() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void GameStart() {
        while (ReGameFlag == GAME_START) {
            run();
            CheckReGameFlag(Integer.parseInt(inputView.inputMenu()));
            CheckFinishGameFlag(true);
        }
    }

    private void run() {
        Computer computer = new Computer();
        List<Integer> userBaseballNumber = new ArrayList<>();
        System.out.println(computer.getBaseballNum().get(0)+"" + computer.getBaseballNum().get(1) + "" +computer.getBaseballNum().get(2));
        while (FinishGameFlag) {
            inputUserBaseballNumber(userBaseballNumber);
            ballCheckHandler(userBaseballNumber, computer);
            strikeCheckHandler(userBaseballNumber, computer);
            outCheckHandler(computer);
            userBaseballNumber.clear();
            CheckFinishGameFlag(computer.getStrikeCount() != LIMIT_NUMBER);
        }
    }

    private void inputUserBaseballNumber(List<Integer> userBaseballNumber) {
        convertToIntegerAdd(userBaseballNumber, inputView.inputBaseballNumber());
    }

    private void convertToIntegerAdd(List<Integer> userBaseballNumber, List<String> stringList) {
        for (String s : stringList) {
            userBaseballNumber.add(Integer.parseInt(s));
        }
    }

    private void ballCheckHandler(List<Integer> userBaseballNumber, Computer computer) {
        computer.putBallCount(
                IntStream.range(0, LIMIT_NUMBER)
                        .filter(userIndex -> BallCheckFilter(computer, userBaseballNumber, userIndex) != 0)
                        .count()
        );
        ballCheck(computer);
    }

    private long BallCheckFilter(Computer computer, List<Integer> userBaseballNum, int userIndex) {
        return IntStream.range(0, LIMIT_NUMBER)
                .filter(computerIndex -> ballCheckFilter(computer, userBaseballNum, userIndex, computerIndex))
                .count();
    }

    private boolean ballCheckFilter(Computer computer, List<Integer> userBaseballNum, int userIndex, int computerIndex) {
        return (userIndex != computerIndex) &&
                userBaseballNum.get(userIndex).equals(computer.getBaseballNum().get(computerIndex));
    }

    private void ballCheck(Computer computer) {
        if (computer.getBallCount() != 0) {
            outputView.ballPrint(computer.getBallCount());
        }
    }

    private void strikeCheckHandler(List<Integer> userBaseballNumber, Computer computer) {
        computer.putStrikeCount(IntStream.range(0, LIMIT_NUMBER)
                .filter(index -> computer.getBaseballNum().get(index).equals(userBaseballNumber.get(index)))
                .count());
        strikeCheck(computer);
    }

    private void strikeCheck(Computer computer) {
        if (computer.getStrikeCount() != 0) {
            outputView.strikePrint(computer.getStrikeCount());
        }
    }

    private void outCheckHandler(Computer computer) {
        if ((computer.getBallCount() + computer.getStrikeCount()) == 0) {
            outputView.outPrint();
        }
    }
}
