package vIew;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getUserNumber() {
        return scanner.nextInt();
    }

    public static int getRestartOrFinish() {
        return scanner.nextInt();
    }
}
