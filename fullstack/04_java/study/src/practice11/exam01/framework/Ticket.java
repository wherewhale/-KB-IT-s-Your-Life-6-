package practice11.exam01.framework;

public abstract class Ticket {
    protected String owner;

    public abstract void enter();

    @Override
    public String toString() {
        return "[MetaMonTicket:" + owner + "]";
    }
}
