package practice08;

public abstract class AbstractTicketEvent {
    protected int ticketCount;

    private void openAnnouncement() {
        System.out.printf("이벤트 시작! 남은 티켓: %d장\n", ticketCount);
    }

    protected abstract void fanEntry();

    private void closingAnnouncement() {
        System.out.println("이벤트 종료! 모두 수고하셨습니다 🎉");
    }

    public AbstractTicketEvent(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public final void startEvent() {
        openAnnouncement();
        fanEntry();
        closingAnnouncement();
    }
}
