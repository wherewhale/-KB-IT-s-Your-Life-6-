package practice08;

public interface TicketBuyer {
    void buyTicket();

    void waitTurn();                     // 재도전 시 대기 시간 (sleep)

    void entranceMessage(String name);   // 입장 성공 시 출력할 메시지
}
