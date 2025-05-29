package strategy;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0;
    private int currentHandValue = 0;
    private int[][] history = {
            {1, 1, 1,},
            {1, 1, 1,},
            {1, 1, 1,},
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        //현재 nextHand는 각각 나온 값의 크기를 범위로 설정하여, 무엇을 낼 지 결정
        int bet = random.nextInt(getSum(currentHandValue));
        int handvalue = 0;
        if (bet < history[currentHandValue][0]) { //주먹내서 이겼던 개수
            handvalue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) { //주먹내서 이겼던 개수 + 가위내서 이겼던 개수
            handvalue = 1;
        } else {
            handvalue = 2;
        }
        prevHandValue = currentHandValue;
        currentHandValue = handvalue;
        return Hand.getHand(handvalue);
    }

    private int getSum(int handvalue) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[handvalue][i];
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        //이긴 경우
        if (win) {
            //현재의 값만 1추가
            history[prevHandValue][currentHandValue]++;
        } else {
            //현재 값을 제외한 값을 1증가
            //다른 수식을 선택하는 수식 참고
            history[prevHandValue][(currentHandValue + 1) % 3]++;
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
    //만약, 가위, 바위, 보의 비율을 50 : 30 : 20으로 내고 싶다면?
    // -> 0과 1사이에서 랜덤 함수의 결과를 각각 0.5, 0.8, 1 과 같은 범위로 설정
    // 이렇게 하면 원하는 비율대로 낼 수 있음


}
