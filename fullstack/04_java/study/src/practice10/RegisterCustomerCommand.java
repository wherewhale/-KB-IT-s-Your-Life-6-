package practice10;

import practice10.queue.DollQueueManager;
import practice10.util.RandomCustomerProvider;

public class RegisterCustomerCommand implements Command {
    private DollQueueManager queueManager;

    public RegisterCustomerCommand(DollQueueManager queueManager) {
        this.queueManager = queueManager;
    }

    @Override
    public void execute() {
        String name = RandomCustomerProvider.getRandomCustomer();
        queueManager.registerCustomer(name);
    }
}
