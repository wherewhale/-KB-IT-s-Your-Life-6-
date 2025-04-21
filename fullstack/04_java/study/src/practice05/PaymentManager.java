package practice05;

public class PaymentManager {
    int sum;
    int credit = 0;
    int kakao = 0;

    public void process(Payment payment, int amount) {
        if (payment.beforePay()) {
            if (payment.pay(amount)) {
                this.sum += amount;
                payment.approve();
                payment.cancel("테스트 취소");

                if (payment instanceof KakaoPay) {
                    this.kakao++;
                    ((KakaoPay) payment).sendNotification();
                } else {
                    this.credit++;
                    System.out.println("[알림 서비스 없음]");
                }


            } else {
                System.out.println("[결제 실패: 승인/취소 건너뜀]");
            }
        } else {
            System.out.println("[결제 실패: 준비 단계에서 중단]");
        }
    }

    public void printSummary() {
        System.out.printf("✅ 결제 통계 요약\n" +
                "총 결제 횟수: %d회\n" +
                "총 결제 금액: %d원\n" +
                "[CreditCard] : %d건\n" +
                "[KakaoPay] : %d건", credit + kakao, sum, credit, kakao);
    }
}
