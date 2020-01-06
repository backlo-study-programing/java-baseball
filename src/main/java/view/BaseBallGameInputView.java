package view;

import java.util.*;
import java.util.stream.*;

public class BaseBallGameInputView {

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
}
