package practice07.problem06;

import java.util.Scanner;

public class MaleMatchGame extends MatchGame {
    private Celebrity[] celebrities;

    MaleMatchGame(Celebrity[] celebrities) {
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
        Celebrity[] current = candidates;
        int total = candidates.length;
        int round = 1;

        while (current.length > 1) {
            System.out.printf("=== %d라운드 ===\n", round);
            round++;
            int nextSize = (current.length + 1) / 2; // 홀수면 마지막 1명 자동 진출
            Celebrity[] nextRound = new Celebrity[nextSize];
            int index = 0;

            for (int i = 0; i < current.length; i += 2) {
                if (i == current.length - 1) {
                    // 자동 진출
                    System.out.println("🎉 " + current[i].getName() + " 자동 진출!");
                    nextRound[index++] = current[i];
                } else {
                    // 대결
                    Celebrity winner = selectWinner(current[i], current[i + 1]);
                    nextRound[index++] = winner;
                }
            }

            current = nextRound;
        }
        return current[0];
    }

    @Override
    public void printCandidates() {
        System.out.println("[남자 연예인 월드컵 참가자 명단]");
        super.printCandidates();
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

            if (input.equals("1")) {
                System.out.println("[" + c1.getName() + " 승리!]");
                return c1;
            }
            if (input.equals("2")) {
                System.out.println("[" + c2.getName() + " 승리!]");
                return c2;
            }

            System.out.println("⚠ 잘못된 입력입니다! 1 또는 2만 입력하세요.");
        }
    }
}
