import controller.BaseBallController;
import vIew.OutputView;

public class BaseBallApplication {
    private static final int restartInput = 1;
    private static final int finishInput = 2;
    private static boolean power = true;

    public static void main(String[] args) {
        OutputView.printgameStart();
        while (power) {
            new BaseBallController().run();
            isFinishOrRestart();
        }
    }

    private static void isFinishOrRestart() {
        int finishOrRestart = 0;
        while (finishOrRestart != restartInput && finishOrRestart != finishInput) {
            finishOrRestart = OutputView.gameEnd();
            setPower(finishOrRestart);
        }
    }

    private static void setPower(int finishOrRestart) {
        if (finishOrRestart == 2){
            power = false;
        }
    }
}
