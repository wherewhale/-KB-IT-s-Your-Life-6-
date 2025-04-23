package practice07.problem04;

import java.util.Scanner;
import java.util.regex.Pattern;

public class AppMain {
    public static final String NUM_REGEX = "^[0-9]+$";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaleCelebrity[] maleCelebs = {
                new MaleCelebrity("박서준"),
                new MaleCelebrity("차은우"),
                new MaleCelebrity("정해인")
        };

        FemaleCelebrity[] femaleCelebs = {
                new FemaleCelebrity("아이유"),
                new FemaleCelebrity("장원영")
        };


        try {
            System.out.println("=== 이상형 월드컵 ===");
            System.out.println("1. 남자 연예인 월드컵");
            System.out.println("2. 여자 연예인 월드컵");
            System.out.print("경기를 선택하세요: ");
            String select = sc.nextLine();

            if (!Pattern.matches(NUM_REGEX, select)) {
                throw new InvalidGenderException(">> 숫자만 입력하세요! (1 또는 2)");
            }

            if (Integer.parseInt(select) > 2 || Integer.parseInt(select) < 1) {
                throw new InvalidGenderException(">> 잘못된 선택입니다! 1 또는 2만 입력하세요.");
            }

            switch (Integer.parseInt(select)) {
                case 1:
                    System.out.println();
                    MaleMatchGame maleGame = new MaleMatchGame(maleCelebs);
                    maleGame.printCandidates();
                    break;
                case 2:
                    System.out.println();
                    FemaleMatchGame femaleGame = new FemaleMatchGame(femaleCelebs);
                    femaleGame.printCandidates();
                    break;
            }

        } catch (InvalidGenderException e) {
            System.err.println(e.getMessage());
        }


    }
}
