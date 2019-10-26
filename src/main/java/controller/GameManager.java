package controller;

import model.BaseBall;
<<<<<<< HEAD
import view.InputUserNumber;
import view.ViewGame;

public class GameManager {
    private final int ALL_STRIKE = 3;
    private BaseBall BaseBall;
    private InputUserNumber scanNumber;
    private ViewGame viewGame;

    public GameManager() {
        BaseBall = new BaseBall();
        scanNumber = new InputUserNumber();
        viewGame = new ViewGame();
    }

    private boolean challengeOnce() {
        scanNumber.oneGamePrint();
        BaseBall.initUserNumber(scanNumber.inputUserBall());
        printStatus();
        if(BaseBall.countStrike() == ALL_STRIKE) return false;
        return true;
    }

    private void printStatus() {
        if(BaseBall.countStrike() == 0 && BaseBall.countBall() == 0) {
            viewGame.nothingPrint();
            return ;
        }
        viewGame.strikePrint(BaseBall.countStrike());
        viewGame.ballPrint(BaseBall.countBall());
    }

    private void nextGame() {
        int next = viewGame.nextGameNumber();
        if (next == 1 || next == 2) {
            playBaseBallGame(next);
        }
        viewGame.closeNumberError();
        nextGame();
    }

    public void playBaseBallGame(int nextGameStatus) {
        if(nextGameStatus == 2) {
            System.exit(1);
        }
        BaseBall.resetComputerBall();
        while (true) {
            if(!challengeOnce()) break;
=======
import view.InputData;
import view.ViewGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GameManager {
    private BaseBall computer = new BaseBall();
    private InputData scanData = new InputData();
    private ViewGame viewGame = new ViewGame();
    private List<Integer> userNumber = new ArrayList<>();
    private int strike;
    private int ball;
    public GameManager() {
        oneGamePlay();
    }

    private boolean challengeOnce() {
        userNumber.clear();
        viewGame.oneGamePrint();
        setUserNumber(scanData.inputUserBall());
        countBallAndStrike();
        printStatus();
        if(strike == 3) return false;
        return true;
    }

    private void printStatus(){
        if(strike == 0 && ball == 0) {
            viewGame.nothingPrint();
            return ;
        }
        viewGame.strikePrint(strike);
        viewGame.ballPrint(ball);
    }
    private void countBallAndStrike() {
        this.ball= countBall();
        this.strike = countStrike();
    }
    private void setUserNumber(String userBall) {
        for(int i = 0 ; i<userBall.length() ; i++) {
            userNumber.add(Integer.parseInt(userBall.split("")[i]));
        }
    }

    private void oneGamePlay() {
        computer.resetAllBall();
        while (challengeOnce()) {
>>>>>>> a0ac3cff4d92c4385ea582458fe06a2b05c405fb
        }
        viewGame.winGamePrint();
        nextGame();
    }
<<<<<<< HEAD
}
=======

    private void nextGame() {
        int next = scanData.nextGameNuber();
        switch (next) {
            case 1 : oneGamePlay();
                break;
            case 2 : System.exit(1);
                break;
            default : viewGame.closeNumberError();
                nextGame();
                break;
        }
    }

    private int countBall() {
        return IntStream.range(0,userNumber.size())
                        .map(i -> (computer.getBalls().get(i) == userNumber.get((i + 1) % 3)) || (computer.getBalls().get(i) == userNumber.get((i + 2) % 3)) ? 1:0)
                        .sum();
    }

    private int countStrike() {
        return IntStream.range(0,userNumber.size())
                .map(i -> (computer.getBalls().get(i) == userNumber.get(i)) ? 1:0)
                .sum();
    }


}
>>>>>>> a0ac3cff4d92c4385ea582458fe06a2b05c405fb
