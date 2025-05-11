package practice13;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ResultWriter {
    public static void saveResult(UserInfo user) {
        String[] result = SajuCalculator.calculateSaju(user.getBirth());
        Map<String, Integer> map = SajuAnalyzer.analyzeAndReturnMap();

        String data = String.format("[%s]님의 2025년 신년 사주 요약\n\n사주팔자: %s년 %s월 %s일\n오행 비율: 목%d 화%d 토%d 금%d 수%d\n운세진단: %s"
                , user.getName(), result[0], result[1], result[2], map.get("목"), map.get("화"), map.get("토"), map.get("금"), map.get("수"), SajuAnalyzer.getElementMessage(SajuAnalyzer.findDominantElement(map)));

        try (BufferedWriter bw = new BufferedWriter((new FileWriter("/Users/son-yeongho/Desktop/Work/공부/-KB-IT-s-Your-Life-6-/fullstack/04_java/study/src/practice13/fortune_result.txt")))){
            bw.write(data);
            bw.flush();
            System.out.println("✅ 전체 분석 결과가 fortune_result.txt에 저장되었습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
