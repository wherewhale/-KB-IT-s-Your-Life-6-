package strategy;

import java.util.Random;

public class WinningStrategy implements Strategy{
    private Random random;
    private boolean won = false;
    private Hand prevHand;
    public WinningStrategy(int seed) {
        random = new Random(seed);
    }
    @Override
    public Hand nextHand() {
        // 이기지 못했다면 랜덤하게 새롭게 낸다.
        if(!won) {
            prevHand = Hand.getHand(random.nextInt(3));
        }
        // 이겼으면 그대로 낸다.
        return prevHand;
    }
    @Override
    public void study(boolean win) {
        //이전에 이겼는지 졌는지 저장
        won = win;
    }
}
