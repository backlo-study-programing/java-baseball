package model;

import java.util.*;

public class CreateThreeRandomNumber {

	private final int MAX_BALL = 3;
	private final int MAX_RANDOM_LIMIT = 9;

	public List<Integer> createRandomNumbers() {

		Set<Integer> randomNumberSet = new HashSet<Integer>();

		while (randomNumberSet.size() != MAX_BALL) {
			int randomNumber = (int) (Math.random() * MAX_RANDOM_LIMIT + 1);
			randomNumberSet.add(randomNumber);
			randomNumberSet.remove(0);
		}

		return new ArrayList<>(randomNumberSet);
	}

}
