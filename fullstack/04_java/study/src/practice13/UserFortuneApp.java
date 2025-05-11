package practice13;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

public class UserFortuneApp {
    public static void main(String[] args) {
        String name;
        String birth;
        UserInfo userInfo;
        Scanner sc = new Scanner(System.in);
        int input = -1;

        while (input != 0) {
            System.out.println();
            System.out.print("""
                    ============================
                    🎴 사주 운세 뽑기 머신
                    ============================
                    1. 사용자 정보 입력 및 저장
                    2. 사주 계산 및 결과 파일 저장
                    3. 오행 분석 및 성향 해석
                    4. 전체 운세 분석 결과 파일 저장
                    5. 사용자 전체 정보 객체 저장 및 복원
                    0. 종료
                    선택 >>>\s""");
            input = sc.nextInt();
            sc.nextLine();

            System.out.println();

            switch (input) {
                case 1:
                    System.out.println("[사주 운세 뽑기 머신]");
                    System.out.print("이름을 입력하세요: ");
                    name = sc.nextLine();
                    System.out.print("생년월일을 입력하세요 (예: 1994-07-21): ");
                    birth = sc.nextLine();
                    File file = new File("/Users/wha1e/Documents/Develop/IT's Your Life/-KB-IT-s-Your-Life-6-/fullstack/04_java/study/src/practice13/user_input.txt");

                    try {
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        String data = "이름 : " + name + "\n" + "생년월일: " + birth;
                        Files.writeString(Paths.get("/Users/wha1e/Documents/Develop/IT's Your Life/-KB-IT-s-Your-Life-6-/fullstack/04_java/study/src/practice13/user_input.txt"), data, Charset.forName("UTF-8"));

                        System.out.println("✅ 운명 파일(user_input.txt)에 정보가 기록되었습니다.");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    userInfo = UserFileService.loadUserInfo();
                    System.out.println();
                    System.out.println("[입력 정보 확인]");
                    System.out.println("이름: " + userInfo.getName());
                    System.out.println("생년월일: " + userInfo.getBirth());

                    UserFileService.saveSajuToFile(userInfo.getBirth());
                    break;
                case 3:
                    SajuAnalyzer.analyzeSaju();
                    break;
                case 4:
                    userInfo = UserFileService.loadUserInfo();
                    ResultWriter.saveResult(userInfo);
                    break;
                case 5:
                    userInfo = UserFileService.loadUserInfo();
                    String[] result = SajuCalculator.calculateSaju(userInfo.getBirth());
                    userInfo.setFortuneSummary(String.format("→ %s %s %s / %s", result[0], result[1], result[2], SajuAnalyzer.getElementMessage(SajuAnalyzer.findDominantElement(SajuAnalyzer.analyzeAndReturnMap()))));
                    UserObjectManager.saveUserObject(userInfo);
                    UserObjectManager.loadUserObject();
            }
        }

        System.out.println("\uD83C\uDF89 프로그램을 종료합니다. 안녕히 가세요!");

    }
}