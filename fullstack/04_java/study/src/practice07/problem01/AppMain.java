package practice07.problem01;

import java.util.Scanner;
import java.util.regex.Pattern;

public class AppMain {
    public static final String REGEX = "^[가-힣]{2,10}$";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("참가자 이름을 입력하세요: ");
        String name = sc.nextLine();
        String message;

        try {
            boolean result = Pattern.matches(REGEX, name);
            if (!result) {
                throw new InvalidNameException("이름은 한글 2~10자여야 합니다!");
            }
            System.out.println("(다음 단계로 진행합니다!)");
        } catch (InvalidNameException e) {
            message = e.getMessage();
            System.err.print("\uD83D\uDE21 탈락! 잘못된 이름입니다: ");
            System.err.println(message);
        }

    }

}
