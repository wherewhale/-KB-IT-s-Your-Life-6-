package practice07.problem03;

import practice07.problem02.Celebrity;

public class FemaleMatchGame extends MatchGame {
    private Celebrity[] celebrities;

    FemaleMatchGame(Celebrity[] celebrities) {
        this.celebrities = celebrities;
        initializeCandidates();
    }

    @Override
    public void initializeCandidates() {
        // celebrities 배열을 candidates 배열로 복사
        candidates = new Celebrity[celebrities.length];
        for (int i = 0; i < celebrities.length; i++) {
            candidates[i] = celebrities[i]; // 얕은 복사 (객체 주소 복사)
        }
    }

    @Override
    public Celebrity playGame() {
        return null;
    }

    @Override
    public void printCandidates() {
        System.out.println("[여자 연예인 월드컵 참가자 명단]");
        super.printCandidates();
    }
}
