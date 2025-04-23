package practice07.problem07;

import java.text.SimpleDateFormat;
import java.util.*;

public class WinnerAnnouncer {
    public void printWinnerSummary(Celebrity winner) {
        System.out.println("\uD83C\uDFC6 최종 우승자: " + winner.getName());
        System.out.println();

        getRandomComment();
        getDateFormatChoice();
        printSystemInfo();
    }

    public void getRandomComment() {
        String[] comments = {
                new String("운명적인 만남! \uD83D\uDC51"),
                new String("불꽃 튀는 승부! 🔥"),
                new String("눈부신 이상형입니다! ✨"),
                new String("모두가 인정한 최강 이상형! 🏆"),
                new String("세상에 이런 이상형이?! 🌟"),
                new String("만장일치! 역대급 이상형 탄생! 🎉"),
                //암튼 20개임
        };
        int num = (int) (Math.random() * comments.length) + 1;

        System.out.println(comments[num]);
    }

    public void getDateFormatChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n날짜 포맷을 선택하세요:");
        System.out.println("1. yyyy년 MM월 dd일 HH시 mm분 ss초");
        System.out.println("2. yyyy-MM-dd'T'HH:mm:ss (ISO 포맷)");
        System.out.println("3. yyyy/MM/dd HH:mm:ss");
        System.out.print("선택: ");

        int userInput = sc.nextInt();
        sc.nextLine();
        formatDate(userInput);
    }

    public void formatDate(int choice) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date now = new Date();

        if (choice == 1) {
            sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
        } else if (choice == 2) {
            sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss (ISO 포맷)");
        }

        System.out.println("\n\uD83D\uDCC5 발표 날짜: " + sdf.format(now));
    }

    public void printSystemInfo() {
        // 전체 시스템 속성 가져오기
        Properties props = System.getProperties();

        // java.로 시작하는 key만 모으기
        ArrayList<String> javaKeys = new ArrayList<>();
        for (Object keyObj : props.keySet()) {
            String key = keyObj.toString();
            if (key.startsWith("java.")) {
                javaKeys.add(key);
            }
        }

        // 오름차순 정렬
        Collections.sort(javaKeys);

        // 출력
        System.out.println("💻 시스템 정보:");
        for (String key : javaKeys) {
            System.out.println(key + " = " + props.getProperty(key));
        }

    }
}
