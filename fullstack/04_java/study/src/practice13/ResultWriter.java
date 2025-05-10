package practice13;

public class ResultWriter {
    public static void saveResult(UserInfo user) {
        String[] result = SajuCalculator.calculateSaju(user.getBirth());
        SajuAnalyzer.getElementMessage(SajuAnalyzer.findDominantElement(SajuAnalyzer.analyzeAndReturnMap()));

        String data = "[" + user.getName() + "] 님은 2025년 신년 사주 요약\n\n사주팔자: " + result[0] + "년" + result[1] + "월" + result[2] + "일\n" +
        결과를 포맷팅해서 파일에 저장
        BufferedWriter + FileWriter
    }
}
