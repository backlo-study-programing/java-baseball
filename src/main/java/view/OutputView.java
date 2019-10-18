package view;

public class OutputView {
    private final int ZERO = 0;

    public void printResult(int strike, int ball) {
        if(strike == ZERO && ball == ZERO)
            printNothing();
        printStrike(strike);
        printBall(ball);
        System.out.println();
    }
    public void printStrike(int strikeCount) {
        if(strikeCount != ZERO)
            System.out.print(strikeCount + "스트라이크 ");
    }

    public void printBall(int ballCount) {
        if(ballCount != ZERO)
            System.out.print(ballCount + "볼 ");
    }

    public void printNothing() {
        System.out.print("낫싱 ");
    }
    public void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
