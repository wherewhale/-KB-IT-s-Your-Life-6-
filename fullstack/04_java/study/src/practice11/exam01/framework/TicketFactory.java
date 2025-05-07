package practice11.exam01.framework;

public abstract class TicketFactory {
    public final Ticket create(String owner) {
        Ticket t = createTicket(owner);
        registerTicket(t);
        return t;
    }

    protected abstract Ticket createTicket(String owner);

    protected abstract void registerTicket(Ticket ticket);
}
