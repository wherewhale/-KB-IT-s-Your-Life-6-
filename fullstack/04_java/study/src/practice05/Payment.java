package practice05;

public interface Payment {
    default boolean beforePay() {
        System.out.println("[공통] 결제를 준비합니다...");
        return true;
    }

    boolean pay(int amount);          // 금액을 결제하는 기능

    void approve();                // 결제를 승인하는 기능

    void cancel(String reason);

    static void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
