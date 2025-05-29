package strategy;

public interface Strategy {
    Hand nextHand();
    // 다음에 어떤 손을 낼지 정함
    // 이겼는지에 대한 여부에 따라 결과 도출
    void study(boolean win);
}
