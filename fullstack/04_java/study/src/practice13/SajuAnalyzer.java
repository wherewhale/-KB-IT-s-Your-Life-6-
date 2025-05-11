package practice13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SajuAnalyzer {
    static Map<Character, String> sajuMap = Map.of(
            '갑', "목", '을', "목",
            '병', "화", '정', "화",
            '무', "토", '기', "토",
            '경', "금", '신', "금",
            '임', "수", '계', "수"
    );

    public static Map<String, Integer> analyzeAndReturnMap() {
        Map<String, Integer> mapResult = new HashMap<>(
                Map.of("목", 0, "화", 0, "토", 0, "금", 0, "수", 0)
        );

        try (BufferedReader br = new BufferedReader(
                new FileReader("/Users/son-yeongho/Desktop/Work/공부/-KB-IT-s-Your-Life-6-/fullstack/04_java/study/src/practice13/fortune_saju.txt")
        )) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null && count < 3) {
                if (!line.contains(": ")) continue;
                String[] tempBuffer = line.split(": ");
                if (tempBuffer.length < 2) continue;

                String temp = tempBuffer[1].trim();

                for (int j = 0; j < temp.length(); j++) {
                    char c = temp.charAt(j);
                    if (sajuMap.containsKey(c)) {
                        String element = sajuMap.get(c);
                        mapResult.put(element, mapResult.getOrDefault(element, 0) + 1);
                    }
                }
                count++;
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return mapResult;
    }

    public static String findDominantElement(Map<String, Integer> mapResult) {
        return mapResult.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("없음");
    }

    public static String getElementMessage(String key) {
        return switch (key) {
            case "수" -> "💧 수(水)가 강한 당신은 유연하고 섬세한 성격입니다. 감수성이 풍부하며, 타인의 감정에 잘 공감하고 배려하는 마음이 깊습니다.";
            case "목" -> "🌳 목(木)이 강한 당신은 성실하고 성장지향적인 성격입니다. 주변과의 조화를 중시하며 끊임없이 발전하려는 의지가 강합니다.";
            case "금" -> "⚔️ 금(金)이 강한 당신은 냉철하고 판단력이 뛰어난 성격입니다. 규칙과 질서를 중시하며, 상황을 이성적으로 분석하는 능력이 탁월합니다.";
            case "화" -> "🔥 화(火)가 강한 당신은 열정적이고 표현력이 뛰어난 성격입니다. 감정을 솔직하게 드러내며, 사람들과의 교류를 즐깁니다.";
            case "토" -> "🪨 토(土)가 강한 당신은 안정적이고 책임감 있는 성격입니다. 신뢰를 중시하며, 묵묵히 자신의 역할을 다하는 스타일입니다.";
            default -> "오행 정보를 알 수 없습니다.";
        };
    }

    // 테스트용 메인
    public static void analyzeSaju() {
        Map<String, Integer> result = analyzeAndReturnMap();

        System.out.println("[오행 분석 결과]");
        result.forEach((k, v) -> System.out.println(k + ": " + v));

        String maxKey = findDominantElement(result);
        System.out.println("\n[성향 해석]");
        System.out.println(getElementMessage(maxKey));
    }
}
