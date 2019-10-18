package baseball;

import java.util.*;

public class BaseBall {

	private List<Integer> randomNumberList = new ArrayList<>();

	public List<Integer> createRandomNumber() {

		// HashSet은 중복을 허용하지 않음
<<<<<<< HEAD
		// 순서대로 들어가지는 않는다.
=======
		// 순서대로 들어가지는 않음
>>>>>>> e40bc2b30570b2da4b406ad4e3a822c78d6cc3cf
		// 3자리 숫자들의 자릿수의 순서가 의미가 없다고 판단하여 사용해보았습니다.
		Set<Integer> randomNumberSet = new HashSet<Integer>();

		while (randomNumberSet.size() != 3) {
			int randomNumber = (int) (Math.random() * 9 + 1);
			randomNumberSet.add(randomNumber);
			randomNumberSet.remove(0);
		}
		
<<<<<<< HEAD
		return new ArrayList<>(randomNumberSet);
=======
		return new ArrayList<Integer>(randomNumberSet);
>>>>>>> e40bc2b30570b2da4b406ad4e3a822c78d6cc3cf
	}

	public void clearRandomNumbers() {
		randomNumberList.clear();
	}

}