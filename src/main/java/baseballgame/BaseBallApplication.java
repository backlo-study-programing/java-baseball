package baseballgame;

public class BaseBallApplication {
    private static boolean power = true;
    private static final int restartInput = 1;
    private static final int finishInput = 2;

    private static void isFinishOrRestart() {
        int finishOrRestart = 0;
        while (finishOrRestart != restartInput && finishOrRestart != finishInput) {
            BaseBallView.printGameEnd();
            finishOrRestart = BaseBallView.getFinishOrRestart();
            setPower(finishOrRestart);
        }
    }

    private static void setPower(int finishOrRestart) {
        if (finishOrRestart == 2) power = false;
    }

    public static void main(String[] args) {
        BaseBallView.printgameStart();
        while (power) {
            new BaseBallController().run();
            isFinishOrRestart();
        }
    }
}
