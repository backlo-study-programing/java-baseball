package controller;

import model.Baseball;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private  Baseball computerBall;
    private String userBall;
    private List<String> balls = new ArrayList<>();
    private int strike;
    private int ball;

    public void initSetting() {
        strike = 0;
        ball = 0;
    }

    public void playGame() {
        computerBall = new Baseball();
        gameStart();
        outputView.printEnd();
        checkRestart();
    }

    public void gameStart() {
        do {
            initSetting();
            userBall = inputView.inputNumber();
            System.out.println(computerBall.getBall());
            balls = splitBall();
            countStrikeAndBall();
            outputView.printResult(strike, ball);
        } while (checkAnswer());
    }

    public List<String> splitBall() {
        return Arrays.asList(userBall.split(""));
    }

    public void checkRestart() {
        int num = inputView.choiceNumber();
        switch (num) {
            case 1:
                playGame();
                break;
            case 2:
                return;
            default:
                System.out.println("1 또는 2만 입력하세요.");
                checkRestart();
                break;
        }
    }

    public void countStrikeAndBall() {
        for (int i = 0; i < balls.size(); i++) {
            checkStrike(i);
            checkBall(i);
        }
    }

    public void checkStrike(int num) {
        if(balls.get(num).equals(computerBall.getBalls().get(num))) {
            strike++;
        }
    }

    public void checkBall(int num) {
        if(balls.contains(computerBall.getBalls().get(num)) && !(balls.get(num).equals(computerBall.getBalls().get(num)))) {
            ball++;
        }
    }

    public boolean checkAnswer() {
        if (userBall.equals(computerBall.getBall())) return false;
        return true;
    }

}
