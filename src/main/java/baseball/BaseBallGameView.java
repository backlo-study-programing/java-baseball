package baseball;

import java.util.*;

public class BaseBallGameView {

	private final Scanner scanner = new Scanner(System.in);

	public List<Integer> inputNumber() {

		System.out.print("숫자를 입력해주세요 : ");
		String inputNumber = scanner.nextLine();

		ArrayList<Integer> userInputNumbers = new ArrayList<Integer>();

		for (int i = 0; i < inputNumber.length(); i++) {
			userInputNumbers.add(Character.getNumericValue(inputNumber.charAt(i)));
		}

		return userInputNumbers;
	}

	public void printStrikeAndBall(int strike, int ball) {
		if ((strike == 0) && (ball == 0)) {
			System.out.println("낫싱");
		} else {
			System.out.println(strike + " 스트라이크 " + ball + " 볼");
		}
	}

	public int restartOREndGame() {
		System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");
		int newGameorEndGameInputNumber = scanner.nextInt();
		scanner.nextLine(); // 버퍼 지우기

		return newGameorEndGameInputNumber;
	}

}
