package strategy;

public enum Hand {
    //자체적으로 생성자를 가지며, Singleton과 같은 방식
    ROCK("바위", 0),
    SCISSORS("가위", 1),
    PAPER("보", 2);
    //그냥 나열할 때에는 세미콜론이 없는데, 생성자를 직접 만들어서 운영할 때에는 세미콜론이 필요

    private String name;
    private int handvalue;

    //외부에서는 생성자로 정보를 줄 수 없게 private로 선언
    private Hand(String name, int handvalue) {
        this.name = name;
        this.handvalue = handvalue;
    }

    private static Hand[] hands = {
            ROCK, SCISSORS, PAPER
    };

    public static Hand getHand(int handvalue) {
        return hands[handvalue];
    }

    // 인스턴스 메서드 선언 (이 아래부터)
    // 무승부는 0, this가 이기면 1, h가 이기면-1
    private int fight(Hand h) {
        if(this == h) {
            return 0;
        } else if((this.handvalue + 1) % 3 == h.handvalue) {
            //승부 결정짓는 공식
            //if문을 복잡하게 구성하지 않아도 가능
            return 1;
        } else {
            return -1;
        }
    }
    // this가 h보다 강할 때 true
    public boolean isStrongerThan(Hand h) {
        return fight(h) == 1;
    }
    // this가 h보다 약할 때 true
    public boolean isWeakerThan(Hand h) {
        return fight(h) == -1;
    }
    // 가위 바위 보의 문자열 표현
    @Override
    public String toString() {
        // 영어로 되어있던 표현을 한글로 표기할 수 있도록
        return name;
    }
}
