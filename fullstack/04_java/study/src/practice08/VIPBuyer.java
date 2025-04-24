package practice08;

public class VIPBuyer implements TicketBuyer {
    @Override
    public void buyTicket() {

    }

    @Override
    public void waitTurn() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void entranceMessage(String name) {
        System.out.printf("VIP %s 입장 완료!\n", name);
    }
}
