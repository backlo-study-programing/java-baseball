package baseballgame;

import java.util.ArrayList;
import java.util.List;

public class BaseBallController {
    private static final int BALL_BOUND = 3;
    private static final int ALL_STRIKE = 3;
    private final List<BaseBallModel> balls;
    private List<BaseBallModel> userBalls;
    private BaseBallBadInputController badInputController;
    private boolean power;

    BaseBallController() {
        balls = new ArrayList<>();
        power = true;
        setBalls();
    }

    public void setBalls() {
        balls.add(new BaseBallModel());
        while (balls.size() < BALL_BOUND) {//서로 다른 수 만드는 루프
            BaseBallModel newBall = new BaseBallModel();
            checkSameNumbers(newBall);//같은 수 있으면 node 삭제
            balls.add(newBall);
        }
    }

    private void checkSameNumbers(BaseBallModel newBall) {
        for (int index = 0; index < balls.size(); index++)
            deleteSameNumber(index, newBall);
    }

    private void deleteSameNumber(int index, BaseBallModel newBall) {
        if (balls.get(index).isSameNumber(newBall))
            balls.remove(index);
    }

    public void run() {
        while (power) {
            BaseBallView.printRoundStart();
            int userNumber = BaseBallView.getUserNumber();
            setUserBalls(userNumber);
            if (isBadInput(userNumber))
                continue;
            isFinalRound(getScore());
        }
    }

    private void setUserBalls(int userNumber) {
        userBalls = new ArrayList<>();
        userBalls.add(getFirstUserBall(userNumber));
        userBalls.add(getSecondUserBall(userNumber));
        userBalls.add(getThirdUserBall(userNumber));
    }

    private BaseBallModel getFirstUserBall(int userNumber) {
        int firstBall = userNumber / 100;
        BaseBallModel firstBallModel = new BaseBallModel(firstBall);
        return firstBallModel;
    }

    private BaseBallModel getSecondUserBall(int userNumber) {
        int secondBall = userNumber % 100 / 10;
        BaseBallModel secondBallModel = new BaseBallModel(secondBall);
        return secondBallModel;
    }

    private BaseBallModel getThirdUserBall(int userNumber) {
        int thirdBall = userNumber % 10;
        BaseBallModel thirdBallModel = new BaseBallModel(thirdBall);
        return thirdBallModel;
    }

    private boolean isBadInput(int userNumber) {
        badInputController = new BaseBallBadInputController(userBalls, userNumber);
        boolean badInputWithZero = badInputController.isBadInputWithZero();
        boolean badInputWithDigits = badInputController.isBadInputOverThreeDigits();
        boolean badInputWithSameNumber = badInputController.isBadInputWithSameNumber();
        if (badInputWithDigits == false && badInputWithZero == false && badInputWithSameNumber == false)
            return false;
        return true;
    }

    private int getScore() {
        int[] scores = new int[2];//1번째는 strike score, 2번째는 ball score
        scores = checkScores(BALL_BOUND, scores);
        BaseBallView.printRoundScore(scores);
        return scores[0];
    }

    private int[] checkScores(int compareBallIndex, int[] scores) {
        int[] updatedScores = scores;
        if (--compareBallIndex < 0) //재귀함수 탈출 조건
            return updatedScores;
        checkScores(compareBallIndex, updatedScores);//재귀함수
        for (int index = 0; index < BALL_BOUND; index++)
            updatedScores = getBallOrStrikePoint(index, compareBallIndex, updatedScores);
        return updatedScores;
    }

    private int[] getBallOrStrikePoint(int index, int compareBallIndex, int[] updatedScores) {
        if (index == compareBallIndex)//strike 점수
            updatedScores[0] += getPoint(index, compareBallIndex);
        else//ball 점수
            updatedScores[1] += getPoint(index, compareBallIndex);
        return updatedScores;
    }

    private int getPoint(int index, int compareIndex) {
        if (balls.get(index).isSameNumber(userBalls.get(compareIndex))) return 1;
        return 0;
    }

    private void isFinalRound(int score) {
        if (score == ALL_STRIKE)
            power = false;
    }
}
