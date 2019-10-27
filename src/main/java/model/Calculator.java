package model;

public class Calculator {

    public int calculate(int num1, String operation, int num2) {
        return checkOperation(operation, num1, num2);
    }

    public int checkOperation(String operation, int num1, int num2) {
        if(operation.equals("+")) {
            return sum(num1, num2);
        }
        if(operation.equals("-")) {
            return substract(num1, num2);
        }
        if(operation.equals("*")) {
            return multiply(num1, num2);
        }
        if(operation.equals("/")) {
            return division(num1, num2);
        }
        return 0;
    }

    private int sum(int num1, int num2) {
        return num1 + num2;
    }

    private int substract(int num1, int num2) {
        return num1 - num2;
    }

    private int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private int division(int num1, int num2) {
        return num1 / num2;
    }
}
