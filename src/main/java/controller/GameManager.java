package controller;

import model.BaseBall;
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
        }
        viewGame.winGamePrint();
        nextGame();
    }
}