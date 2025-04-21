package practice05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Payment payment;
        PaymentManager manager = new PaymentManager();

        while (true) {
            System.out.print("\n=== 유니페이 결제 시스템 === \n" +
                    "[1] 신용카드\n" +
                    "[2] 카카오페이\n" +
                    "[0] 종료\n" +
                    "결제 수단을 선택하세요:");

            int userInput = sc.nextInt();
            sc.nextLine();

            if (userInput == 1) {
                payment = new CreditCard();
            } else if (userInput == 0) {
                break;
            } else {
                payment = new KakaoPay();
                System.out.println("[카카오페이 사용자 인증을 진행하시겠습니까? (y/n)]");

                if (sc.nextLine().equalsIgnoreCase("y")) {
                    ((KakaoPay) payment).authenticate();
                }

                System.out.println("[카카오페이] 결제를 준비합니다...");
            }

            if (payment.beforePay()) {
                System.out.print("결제 금액을 입력하세요:\n" + ">> ");
                int amount = sc.nextInt();
                manager.process(payment, amount);
            } else {
                System.out.println("[결제 실패: 준비 단계에서 중단]");
            }
        }

        manager.printSummary();
    }
}
