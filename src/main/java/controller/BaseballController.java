package controller;

import model.Baseball;
import model.GameCurrentResult;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.exit;

public class BaseballController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Baseball computerBall;
    private List<String> balls = new ArrayList<>();
    private GameCurrentResult currentResult = new GameCurrentResult();

    public void playGame() {
        computerBall = new Baseball();
        gameStart();
        outputView.printEnd();
        checkRestart();
    }

    public void gameStart() {
        String userBall;
        do {
            System.out.println(computerBall.getBall());
            currentResult.initResult();
            userBall = inputView.inputNumber();
            balls = splitBall(userBall);
            countStrikeAndBall();
            outputView.printResult(currentResult.getStrike(), currentResult.getBall());
        } while (checkAnswer(userBall));
    }

    public List<String> splitBall(String ball) {
        return Arrays.asList(ball.split(""));
    }

    public void checkRestart() {
        int num = inputView.choiceNumber();
        Restart selectedNum = Restart.of(num);
        selectedNum.controllerConsumer.accept(this);
    }

    public void gameEnd() {
        exit(0);
    }

    public void countStrikeAndBall() {
        for (int i = 0; i < balls.size(); i++) {
            checkStrike(i);
            checkBall(i);
        }
    }

    public void checkStrike(int num) {
        if (balls.get(num).equals(computerBall.getBalls().get(num))) {
            currentResult.plusStrike();
        }
    }

    public void checkBall(int num) {
        if (balls.contains(computerBall.getBalls().get(num)) && !(balls.get(num).equals(computerBall.getBalls().get(num)))) {
            currentResult.plusBall();
        }
    }

    public boolean checkAnswer(String userBall) {
        return (userBall.equals(computerBall.getBall()) ? false : true);
    }

}
