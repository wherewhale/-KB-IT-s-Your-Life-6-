package practice07.problem08;

import java.util.Random;
import java.util.Scanner;

public abstract class MatchGame implements VsSelectable {
    protected Celebrity[] candidates;
    HistoryManager historyManager = new HistoryManager();
    int round = 1;

    public abstract void initializeCandidates();

    public Celebrity playGame() {
        ;

        while (candidates.length > 1) {
            System.out.printf("=== %d라운드 ===\n", round);
            round++;
            int nextSize = (candidates.length + 1) / 2; // 홀수면 마지막 1명 자동 진출
            Celebrity[] nextRound = new Celebrity[nextSize];
            int index = 0;

            for (int i = 0; i < candidates.length; i += 2) {
                if (i == candidates.length - 1) {
                    // 자동 진출
                    System.out.println("🎉 " + candidates[i].getName() + " 자동 진출!");
                    nextRound[index++] = candidates[i];
                } else {
                    // 대결
                    Celebrity winner = selectWinner(candidates[i], candidates[i + 1]);
                    nextRound[index++] = winner;
                }
            }

            candidates = nextRound;
        }

        Celebrity finalWinner = candidates[0];
        WinnerAnnouncer announcer = new WinnerAnnouncer();
        announcer.printWinnerSummary(finalWinner);


        historyManager.showSelectionHistory();

        return candidates[0];
    }

    public void printCandidates() {
        for (Celebrity candidate : candidates) {
            System.out.println(candidate.toString());
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

    @Override
    public Celebrity selectWinner(Celebrity c1, Celebrity c2) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n누가 더 이상형인가요?");
            System.out.println("1. " + c1.getName());
            System.out.println("2. " + c2.getName());
            System.out.print("선택: ");
            String input = sc.nextLine();
            boolean isFinal = (candidates.length == 2);


            if (input.equals("1")) {
                System.out.println("[" + c1.getName() + " 승리!]");

                historyManager.saveSelection(round -1, c1, c2, c1, isFinal);
                return c1;
            }
            if (input.equals("2")) {
                System.out.println("[" + c2.getName() + " 승리!]");
                historyManager.saveSelection(round -1, c1, c2, c2, isFinal);
                return c2;
            }

            System.out.println("⚠ 잘못된 입력입니다! 1 또는 2만 입력하세요.");
        }
    }
}
