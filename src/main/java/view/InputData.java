package view;

import java.util.Scanner;

public class InputData {

    public String inputUserBall(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int nextGameNuber(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
