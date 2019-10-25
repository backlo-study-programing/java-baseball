package vIew;

public class OutputView {

    public static void printgameStart() {
        System.out.println("Baseball 게임을 시작합니다.");
    }

    public static int roundStart() {
        System.out.println("숫자를 입력해 주세요 : ");
        return InputView.getUserNumber();
    }

    public static void printRoundScore(int[] scores) {
        StringBuilder stringBuilder = new StringBuilder();
        if (scores[0] == 0 && scores[1] == 0) {
            System.out.println("포볼");
            return;
        }
        if (scores[0] != 0)
            stringBuilder.append(scores[0] + " 스트라이크 ");
        if (scores[1] != 0)
            stringBuilder.append(scores[1] + " 볼 ");
        System.out.println(stringBuilder);
    }

    public static int gameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하시려면 2를 입력하세요.");
        return InputView.getRestartOrFinish();
    }

    public static void printWithOutZero() {
        System.out.println("*0을 제외한 숫자만 입력하세요.*");
    }

    public static void printWithThreeDigits() {
        System.out.println("*세자리의 정수만 입력하세요.*");
    }

    public static void printWithOutSameNumber() {
        System.out.println("*서로 다른 숫자를 입력하세요.*");
    }
}
