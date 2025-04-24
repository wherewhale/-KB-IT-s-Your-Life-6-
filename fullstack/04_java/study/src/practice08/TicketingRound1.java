package practice08;

public class TicketingRound1 {
    public static void main(String[] args) {
        Thread fan1 = new Thread(new Runnable() { // 작업 스레드 생성
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도 중!");
            }
        });
        fan1.setName("팬1");

        Thread fan2 = new Thread(new Runnable() { // 작업 스레드 생성
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도 중!");
            }
        });
        fan2.setName("팬2");

        System.out.println("=== run() 직접 호출 테스트 ===");
        fan1.start();
        fan1.run();
        fan2.start();
    }

}
