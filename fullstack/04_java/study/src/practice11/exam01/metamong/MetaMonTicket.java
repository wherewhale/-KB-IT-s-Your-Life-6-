package practice11.exam01.metamong;

import practice11.exam01.framework.Ticket;

public class MetaMonTicket extends Ticket {
    public MetaMonTicket(String owner) {
        this.owner = owner;
        System.out.println(owner + "님의 메타몽 티켓을 발급합니다.");
    }

    @Override
    public void enter() {
        System.out.println(this + "님이 입장하였습니다.");
    }
}
