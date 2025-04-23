package practice07.problem08;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HistoryManager {
    ArrayList<String> history = new ArrayList<>();

    public void saveSelection(int round, Celebrity c1, Celebrity c2, Celebrity winner, boolean isFinal){
        String roundString;
        if(isFinal) {
            roundString = "[결승]";
        } else {
            roundString = "[" + round + "라운드]";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("(yyyy-MM-dd HH:mm:ss)");
        Date now = new Date();
        String result = String.format("%s %s vs %s → 선택: %s %s", roundString, c1.getName(), c2.getName(), winner.getName(), sdf.format(now));

        history.add(result);
    }

    public void showSelectionHistory() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                \uD83D\uDCC2 히스토리를 어떤 순서로 볼까요?
                1. 최근 선택부터 (Stack: 후입선출)
                2. 오래된 선택부터 (Queue: 선입선출)
                선택: """);
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.println("=== [히스토리] ===");
        if (choice == 1) {
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println(history.get(i));
            }
        } else if (choice == 2) {
            for (String record : history) {
                System.out.println(record);
            }
        } else {
            System.out.println("잘못된 선택입니다.");
        }
    }
}
