package model;

import vIew.OutputView;

import java.util.List;

public class ScoreManager {
    private static final int ALL_STRIKE = 3;
    private static final int BALL_COUNT = 3;
    private final List<Ball> userBalls;
    private final List<Ball> balls;
    private int[] scores;

    public ScoreManager(List<Ball> userBalls, List<Ball> balls) {
        this.userBalls = userBalls;
        this.balls = balls;
    }

    public int[] gatherScore() {
        int[] scores = new int[2];//1번째는 strike score, 2번째는 ball score
        scores = checkScores(BALL_COUNT, scores);
        OutputView.printRoundScore(scores);
        this.scores = scores;
        return scores;
    }

    private int[] checkScores(int compareBallIndex, int[] scores) {
        int[] updatedScores = scores;
        if (--compareBallIndex < 0) {
            return updatedScores;
        }
        checkScores(compareBallIndex, updatedScores);//재귀함수
        return getUpdatedScores(compareBallIndex, updatedScores);
    }

    private int[] getUpdatedScores(int compareBallIndex, int[] updatedScores) {
        for (int index = 0; index < BALL_COUNT; index++) {
            updatedScores = getBallOrStrikePoint(index, compareBallIndex, updatedScores);
        }
        return updatedScores;
    }

    private int[] getBallOrStrikePoint(int index, int compareBallIndex, int[] updatedScores) {
        if (index == compareBallIndex) {//strike 점수
            updatedScores[0] += getPoint(index, compareBallIndex);
        }
        if (index != compareBallIndex) {//ball 점수
            updatedScores[1] += getPoint(index, compareBallIndex);
        }
        return updatedScores;
    }

    private int getPoint(int index, int compareIndex) {
        if (balls.get(index).isSameNumber(userBalls.get(compareIndex))) {
            return 1;
        }
        return 0;
    }

    public boolean isAllStrike(){
        if(scores[0] == ALL_STRIKE) {
            return true;
        }
        return false;
    }
}
