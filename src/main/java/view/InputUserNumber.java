package view;

import java.util.Scanner;

public class InputUserNumber {

    public String inputUserBall() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void oneGamePrint() {
        System.out.println("숫자를 입력해주세요 : ");
    }

}
