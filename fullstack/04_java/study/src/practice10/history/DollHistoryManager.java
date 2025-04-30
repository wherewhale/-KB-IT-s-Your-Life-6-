package practice10.history;

import java.util.*;

public class DollHistoryManager {
    Map<String, List<String>> historyMap = new HashMap<>();

    public void addHistory(String customer, String doll) {
        if (historyMap.get(customer) != null) {
            historyMap.get(customer).add(doll);
        } else {
            List<String> dolls = new ArrayList<>();
            dolls.add(doll);
            historyMap.put(customer, dolls);
        }
        System.out.println("\uD83D\uDCD2 " + customer + " 님의 인형 기록에 '" + doll + "'이 추가되었습니다.");

    }

    public void showAllHistory() {
        System.out.println("\uD83D\uDCCB 고객별 인형 기록:");
        for (Map.Entry<String, List<String>> entry : historyMap.entrySet()) {
            String customer = entry.getKey();
            List<String> dolls = entry.getValue();
            System.out.println("- " + customer + ": " + dolls);
        }
    }

    public void showAllUniqueHistory() {
        if (historyMap.isEmpty()) {
            System.out.println("📋 아직 기록된 고객이 없습니다.");
        } else {
            for (String name : historyMap.keySet()) {
                Set<String> unique = new HashSet<>(historyMap.get(name));
                Iterator<String> it = unique.iterator();
                // print with iterator
                System.out.print("[");
                while (it.hasNext()) {
                    //객체를 하나 가져오기
                    String element = it.next();
                    System.out.print(element);
                    if (it.hasNext()) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            }
        }

    }
}
