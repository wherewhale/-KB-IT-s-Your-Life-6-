package practice13;

public class SajuCalculator {
    public static String[] calculateSaju(String birth) {
        String[] heavenlyStems = {"갑", "을", "병", "정", "무", "기", "경", "신", "임", "계"};
        String[] earthlyBranches = {"자", "축", "인", "묘", "진", "사", "오", "미", "신", "유", "술", "해"};

        String[] parts = birth.split("-");   // "1994-07-21" → ["1994", "07", "21"]
        int year = Integer.parseInt(parts[0]); // year = 1994
        int month = Integer.parseInt(parts[1]); // month = 7
        int day = Integer.parseInt(parts[2]);   // day = 21

        String stem1 = heavenlyStems[year % 10];    // 예: 1994 % 10 → 4 → "무"
        String branch1 = earthlyBranches[year % 12]; // 예: 1994 % 12 → 2 → "인"

        String stem2 = heavenlyStems[month % 10];    // 7 % 10 → 7 → "신"
        String branch2 = earthlyBranches[month % 12]; // 7 % 12 → 7 → "미"

        int total = year + month + day;     // 1994 + 7 + 21 = 2022
        String stem3 = heavenlyStems[total % 10];     // 2022 % 10 → 2 → "병"
        String branch3 = earthlyBranches[total % 12]; // 2022 % 12 → 6 → "오"

        return new String[]{stem1 + branch1, stem2 + branch2, stem3 + branch3};
    }

    public static String formatSaju(String birth) {
        String[] result = calculateSaju(birth);

        //"연: 갑술\n월: 계미\n일: 병신"
        return "연: " + result[0] + "\n월: " + result[1] + "\n일: " + result[2];
    }
}
