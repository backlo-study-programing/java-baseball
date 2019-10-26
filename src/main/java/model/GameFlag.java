package model;

public class GameFlag {

    public static final int GAME_START = 1;
    public static final int GAME_OVER = 2;
    public static boolean FinishGameFlag = true;
    public static int ReGameFlag = 1;

    public static void CheckFinishGameFlag(boolean finishGame) {
        FinishGameFlag = finishGame;
    }

    public static void CheckReGameFlag(int userSignal) {
        ReGameFlag = (userSignal == GAME_START) ? GAME_START : GAME_OVER;
    }
}
