package practice07.problem02;

import java.util.Scanner;
import java.util.regex.Pattern;

public class AppMain {
    public static final String REGEX = "^[가-힣]{2,10}$";

    public static void main(String[] args) {
        MaleCelebrity[] maleCelebrityArr;
        FemaleCelebrity[] femaleCelebrityArr;
        Scanner sc = new Scanner(System.in);

        // 사용자 입력
        System.out.print("남자 연예인 몇 명 등록할까요? ");
        int celebrityNum = sc.nextInt();
        sc.nextLine(); // 버퍼 클리어

        maleCelebrityArr = new MaleCelebrity[celebrityNum];

        for (int i = 0; i < maleCelebrityArr.length; i++) {
            while (true) {
                try {
                    System.out.print("이름 입력: ");
                    String name = sc.nextLine();
                    MaleCelebrity newCelebrity = new MaleCelebrity(name);

                    // 형식 검증
                    if (!Pattern.matches(REGEX, newCelebrity.getName())) {
                        throw new InvalidNameException("이름은 한글 2~10자여야 합니다!");
                    }

                    // 중복 검증
                    boolean isDuplicate = false;
                    for (int j = 0; j < i; j++) {
                        if (newCelebrity.equals(maleCelebrityArr[j])) {
                            isDuplicate = true;
                            break;
                        }
                    }

                    if (isDuplicate) {
                        System.out.println(">> 중복된 이름입니다. 등록하지 않습니다.");
                        continue; // 다시 입력 받기
                    }

                    // 등록
                    maleCelebrityArr[i] = newCelebrity;
                    break; // 정상 입력 시 while 탈출

                } catch (InvalidNameException e) {
                    System.err.println("😡 탈락! 잘못된 이름입니다: " + e.getMessage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.print("여자 연예인 몇 명 등록할까요? ");
        celebrityNum = sc.nextInt();
        sc.nextLine(); // 버퍼 클리어

        femaleCelebrityArr = new FemaleCelebrity[celebrityNum];

        for (int i = 0; i < femaleCelebrityArr.length; i++) {
            while (true) {
                try {
                    System.out.print("이름 입력: ");
                    String name = sc.nextLine();
                    FemaleCelebrity newCelebrity = new FemaleCelebrity(name);

                    // 형식 검증
                    if (!Pattern.matches(REGEX, newCelebrity.getName())) {
                        throw new InvalidNameException("이름은 한글 2~10자여야 합니다!");
                    }

                    // 중복 검증
                    boolean isDuplicate = false;
                    for (int j = 0; j < i; j++) {
                        if (newCelebrity.equals(femaleCelebrityArr[j])) {
                            isDuplicate = true;
                            break;
                        }
                    }

                    if (isDuplicate) {
                        System.out.println(">> 중복된 이름입니다. 등록하지 않습니다.");
                        continue; // 다시 입력 받기
                    }

                    // 등록
                    femaleCelebrityArr[i] = newCelebrity;
                    break; // 정상 입력 시 while 탈출

                } catch (InvalidNameException e) {
                    System.err.println("😡 탈락! 잘못된 이름입니다: " + e.getMessage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // 확인 출력 (옵션)
        System.out.println("\n[남자 연예인 리스트]");
        for (int i = 0; i < maleCelebrityArr.length; i++) {
            System.out.println(maleCelebrityArr[i].toString());
        }

        System.out.println("\n[여자 연예인 리스트]");
        for (int i = 0; i < femaleCelebrityArr.length; i++) {
            System.out.println(femaleCelebrityArr[i].toString());
        }
    }
}
