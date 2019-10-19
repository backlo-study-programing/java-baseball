package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String inputMenu() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextLine();
    }

    public List<String> inputBaseballNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Arrays.asList(scanner.nextLine().split(""));
    }
}