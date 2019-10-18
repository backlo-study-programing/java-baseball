package view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String num = scanner.next();
        return num;
    }

    public int choiceNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int num = scanner.nextInt();
        return num;
    }
}
