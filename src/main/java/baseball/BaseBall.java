package baseball;

import java.util.*;

public class BaseBall {

	private List<Integer> randomNumberList = new ArrayList<Integer>();

	public List<Integer> createRandomNumber() {

		int hundredNumber = (int) (Math.random() * 9 + 1);
		int tenNumber = (int) (Math.random() * 9 + 1);
		while (hundredNumber == tenNumber) {
			tenNumber = (int) (Math.random() * 9 + 1);
		}

		int oneNumber = (int) (Math.random() * 9 + 1);
		while ((hundredNumber == oneNumber) || (tenNumber == oneNumber)) {
			oneNumber = (int) (Math.random() * 9 + 1);
		}

		randomNumberList.add(hundredNumber);
		randomNumberList.add(tenNumber);
		randomNumberList.add(oneNumber);
		
		return randomNumberList;
	}
	
	public void clearRandomNumbers() {
		randomNumberList.clear();
	}

}
