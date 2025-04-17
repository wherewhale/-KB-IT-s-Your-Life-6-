package practice02;

import java.util.Scanner;

public class Problem09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        double [] scores = null;


        while(flag) {
            System.out.println("-------------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료" );
            System.out.println("-------------------------------------------------------");
            System.out.print("선택> ");
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    System.out.print("학생수> ");
                    int studentNum = scanner.nextInt();
                    scores = new double[studentNum];

                    break;
                case 2:
                    for (int i = 0; i < scores.length; i++) {
                        System.out.printf("score[%d]> ", i);
                        int score = scanner.nextInt();
                        scores[i] = score;
                    }
                    break;
                case 3:
                    int index = 0;
                    for (double i : scores) {
                        index++;
                        System.out.printf("score[%d]> %d\n", index, (int)i);
                    }
                    break;
                case 4:
                    int max = 0;
                    double sum = 0;

                    for (int i = 0; i < scores.length; i++) {
                        if (scores[i] > max) {
                            max = (int) scores[i];
                        }
                        sum += scores[i];
                    }
                    System.out.println("최고 점수: " + max);
                    System.out.println("평균 점수: " + sum / scores.length);
                    break;
                default:
                    flag = false;
            }
        }
        System.out.println("프로그램 종료");

    }
}
