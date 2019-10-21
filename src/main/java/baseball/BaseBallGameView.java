package baseball;

import java.util.*;
import java.util.stream.IntStream;

public class BaseBallGameView {

	private final static Scanner scanner = new Scanner(System.in);

	public static List<Integer> inputNumber() {

		System.out.print("숫자를 입력해주세요 : ");
		String inputNumber = scanner.nextLine();

		List<Integer> userInputNumbers = new ArrayList<>();

		IntStream.range(0, inputNumber.length()).forEach(i -> {
			userInputNumbers.add(Character.getNumericValue(inputNumber.charAt(i)));
		});

		return userInputNumbers;
	}

	public static void printStrikeAndBall(int strike, int ball) {
		if ((strike == 0) && (ball == 0)) {
			System.out.println("낫싱");
		} else {
			System.out.println(strike + " 스트라이크 " + ball + " 볼");
		}
	}

	public static int restartOREndGame() {
		System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");
		int newGameorEndGameInputNumber = scanner.nextInt();
		scanner.nextLine(); // 버퍼 지우기

		return newGameorEndGameInputNumber;
	}

}