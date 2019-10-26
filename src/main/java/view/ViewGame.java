package view;

import java.util.Scanner;

public class ViewGame {

    public void strikePrint(int strike) {
        System.out.println(strike + "스트라이크");
    }

    public void ballPrint(int ball) {
        System.out.println(ball + "볼");
    }

    public void nothingPrint() {
        System.out.println("낫싱");
    }

    public void winGamePrint() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void closeNumberError() {
        System.out.println("다시 입력해주세요. (1, 2)");
    }

    public int nextGameNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
