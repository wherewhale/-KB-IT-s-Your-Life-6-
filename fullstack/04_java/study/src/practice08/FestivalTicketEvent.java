package practice08;

public class FestivalTicketEvent extends AbstractTicketEvent {
    @Override
    public void fanEntry() {
        Runnable ticketingTask = () -> {
            System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도 중!");
        };

        Thread[] fans = new Thread[ticketCount];

        for (int i = 0; i < fans.length; i++) {
            fans[i] = new Thread(ticketingTask, "팬" + (i + 1));
            fans[i].start();
        }

        for (Thread fan : fans) {
            try {
                fan.join(); // 각 스레드가 종료될 때까지 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public FestivalTicketEvent(int ticketCount) {
        super(ticketCount);
    }

}
