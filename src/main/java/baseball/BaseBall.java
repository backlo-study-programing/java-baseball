package baseball;

import java.util.*;

public class BaseBall {

	private int number;

	public BaseBall() {
		number = createRandomNumber();
	}

	public int createRandomNumber() {
		return (int) (Math.random() * 9 + 1);
	}

	public int getNumber() {
		return number;
	}

	public boolean verifyBallAndCreateBall(List<BaseBall> createdRandomNumBallList) {
		if (createdRandomNumBallList.size() == 1) {
			checkOverlapTenNumber(createdRandomNumBallList);
		} else if(createdRandomNumBallList.size() == 2){
			checkOverlapOneNumber(createdRandomNumBallList);
		}
		
		return true;
	}

	private void checkOverlapTenNumber(List<BaseBall> createdRandomNumBallList) {
		while (number == createdRandomNumBallList.get(0).getNumber()) {
			number = createRandomNumber();
		}
	}

	private void checkOverlapOneNumber(List<BaseBall> createdRandomNumBallList) {
		while ((createdRandomNumBallList.get(0).getNumber() == number)
				|| (createdRandomNumBallList.get(1).getNumber() == number)) {
			number = createRandomNumber();
		}
	}
}