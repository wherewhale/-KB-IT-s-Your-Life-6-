package practice10.popularity;


import java.util.*;

public class DollPopularityManager {
    private Map<String, Integer> countMap = new HashMap<>();

    public void addDoll(String doll) {
        countMap.put(doll, countMap.getOrDefault(doll, 0) + 1);
    }

    public void showRanking() {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(countMap.entrySet());

        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> doll1, Map.Entry<String, Integer> doll2) {
                if (doll1.getValue() > doll2.getValue()) return -1;
                else if (doll1.getValue().equals(doll2.getValue())) return 0;
                else return 1;
            }
        });

        System.out.println("\uD83D\uDD25 인형별 인기 순위 (많이 뽑힌 순):");
        for (int i = 0; i < entryList.size(); i++) {
            Map.Entry<String, Integer> entry = entryList.get(i);
            System.out.print((i + 1) + ". ");
            System.out.print(entry.getKey() + " - " + entry.getValue() + "회\n");

        }
    }

}

