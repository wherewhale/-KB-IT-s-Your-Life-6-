package practice08;

import lombok.Getter;

public class Fan implements Runnable {
    @Getter
    private String name;
    @Getter
    private boolean isVIP;
    @Getter
    private TicketBuyer ticketBuyer;

    private EntryManager entryManager;

    public Fan(String name, boolean isVIP, EntryManager entryManager, TicketBuyer ticketBuyer) {
        this.name = name;
        this.isVIP = isVIP;
        this.entryManager = entryManager;
        this.ticketBuyer = ticketBuyer;

    }

    @Override
    public void run() {
        entryManager.registerFan(this);

        while (!entryManager.processEntry(this)) {
            ticketBuyer.waitTurn();
        }

        ticketBuyer.entranceMessage(name);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
