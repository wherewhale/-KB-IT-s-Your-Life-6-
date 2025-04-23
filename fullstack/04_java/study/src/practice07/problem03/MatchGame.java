package practice07.problem03;

import practice07.problem02.Celebrity;

public abstract class MatchGame {
    protected Celebrity[] candidates;

    public abstract void initializeCandidates();

    public abstract Celebrity playGame();

    public void printCandidates() {
        for (int i = 0; i < candidates.length; i++) {
            System.out.println(candidates[i].toString());
        }
    }
}
