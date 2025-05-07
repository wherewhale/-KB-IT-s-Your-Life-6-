package practice11.exam01;

import practice11.exam01.framework.Ticket;
import practice11.exam01.framework.TicketFactory;
import practice11.exam01.metamong.MetaMonTicketFactory;

public class Main {
    public static void main(String[] args) {
        TicketFactory factory = new MetaMonTicketFactory();
        Ticket jiwoo = factory.create("지우");
        Ticket isul = factory.create("이슬이");

        System.out.println();

        jiwoo.enter();
        isul.enter();
    }
}
