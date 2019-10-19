package controller;

import model.Player;
import view.InputView;
import view.OutputView;

import java.util.*;
import java.util.stream.IntStream;

public class BaseballManagement {
    public static final int LIMITNUMBER = 3;
    public static int ReGameFlag = 1;
    public static boolean GameFlag = true;
    private long strikeCount = 0;
    private List<Integer> userBaseballNumber;
    private Player player;
    private InputView inputView;
    private OutputView outputView;

    public BaseballManagement() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void GameStart() {
        while(ReGameFlag == 1) {
            run();
        }
    }

    public void run() {
        setPlayer(createRandomNumber());
        while(GameFlag) {
            inputUserBaseballNumber();
            strikeOrBallOrOutProcessing();
            endGame();
        }
        ReGameFlag = Integer.parseInt(inputView.inputMenu());
        GameFlag = true;
    }

    public void setPlayer(List<Integer> RandomNumberList){
        player = new Player(RandomNumberList);
    }

    private List<Integer> createRandomNumber(){
        List<Integer> randomNumberList = new ArrayList<Integer>();
        new Random()
                .ints(1,10)
                .limit(LIMITNUMBER)
                .boxed()
                .distinct()
                .forEach(num->randomNumberList.add(num));

        return checkRandomNumberList(randomNumberList);
    }

    private List<Integer> checkRandomNumberList(List<Integer> randomNumberList) {
        return (randomNumberList.size() == LIMITNUMBER) ? randomNumberList : createRandomNumber();
    }

    public void inputUserBaseballNumber() {
        userBaseballNumber = new ArrayList<>();
        convertToIntegerAdd(inputView.inputBaseballNumber());
    }

    private void convertToIntegerAdd(List<String> stringList) {
        for (int i = 0; i < stringList.size(); i++) {
            userBaseballNumber.add(Integer.parseInt(stringList.get(i)));
        }
    }

    private List<Integer> makeCompareList() {
        List<Integer> compareList = new ArrayList<>();
        userBaseballNumber.stream()
                .forEach(userNum->player.getBaseballNum().stream()
                                                        .forEach(comNum->compare(userNum,comNum, compareList)));
        return compareList;
    }
    private long checkBall(List<Integer> compareList) {
        long ballCount = IntStream.range(1,compareList.size())
                .filter(i -> i%4 > 0 && compareList.get(i) == 1)
                .count();
        if(ballCount != 0) {
            outputView.ballPrint(ballCount);
        }
        return ballCount;
    }

    private long checkStrike(List<Integer> compareList) {
        strikeCount = IntStream.range(0,compareList.size())
                .filter(i -> i%4 == 0 && compareList.get(i) == 1)
                .count();
        if(strikeCount != 0){
            outputView.strikePrint(strikeCount);
        }

        GameFlag = (strikeCount == LIMITNUMBER) ? false  : true;

        return strikeCount;
    }

    public void strikeOrBallOrOutProcessing() {
        List<Integer> compareList = makeCompareList();
        long outCheck = checkBall(compareList) + checkStrike(compareList);
        if(outCheck == 0){
            outputView.outPrint();
        }
    }

    private void compare(Integer userNum, Integer comNum, List<Integer> compareList) {
        compareList.add((userNum == comNum) ? 1 : 0);
    }

    public void endGame() {
        GameFlag = (strikeCount == LIMITNUMBER) ? false : true;
    }

}
