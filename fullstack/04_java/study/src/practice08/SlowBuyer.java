package practice08;

public class SlowBuyer implements TicketBuyer {
    @Override
    public void buyTicket() {

    }

    @Override
    public void waitTurn() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void entranceMessage(String name) {
        System.out.printf("%s: 처음이라 떨려요... 입장 완료!\n", name);
    }

}
