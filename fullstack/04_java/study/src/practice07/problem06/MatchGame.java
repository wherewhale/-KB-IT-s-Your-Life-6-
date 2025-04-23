package practice07.problem06;

import java.util.Random;

public abstract class MatchGame implements VsSelectable {
    protected Celebrity[] candidates;

    public abstract void initializeCandidates();

    public abstract Celebrity playGame();

    public void printCandidates() {
        for (int i = 0; i < candidates.length; i++) {
            System.out.println(candidates[i].toString());
        }
    }

    public void shuffle() {
        for (int i = candidates.length - 1; i >= 0; i--) {
            Random rand = new Random();
            int j = rand.nextInt(i + 1);// 0부터 i까지 중에서 선택
            Celebrity temp = candidates[j];
            candidates[j] = candidates[i];
            candidates[i] = temp;
        }
    }
}
