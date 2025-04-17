package practice02;

import java.util.Scanner;

public class Problem08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 키보드와 Scanner 연결

        boolean run = true; // while 루프 종료 조건 변수

        int balance = 0;

        while(run) {
            System.out.println("--------------------------------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료" );
            System.out.println("--------------------------------------");
            System.out.print("선택> ");

            String strNum = scanner.nextLine(); // 키보드에서 입력한 내용을 읽음(문자열)

            if(strNum.equals("1")) {
                System.out.print("예금액> ");
                int amount = scanner.nextInt();
                scanner.nextLine(); // 개행을 소비하기 위한 목적
                balance += amount;
            } else if(strNum.equals("2")) {
                System.out.print("출금액> ");
                int amount = scanner.nextInt();
                scanner.nextLine(); // 개행을 소비하기 위한 목적
                balance -= amount;
            } else if(strNum.equals("3")) {
                System.out.println("잔고>" + balance);
            } else {
                run = false;
            }
        }
        System.out.println("프로그램 종료");
    }
}
