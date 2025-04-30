package practice10;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import practice10.queue.DollQueueManager;

@NoArgsConstructor
@AllArgsConstructor
public class ShowWaitingListCommand implements Command {
    DollQueueManager dollQueueManager;

    @Override
    public void execute() {
        dollQueueManager.showWaitingList();
    }
}
