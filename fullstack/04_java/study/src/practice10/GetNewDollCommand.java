package practice10;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import practice10.history.DollHistoryManager;
import practice10.popularity.DollPopularityManager;
import practice10.queue.DollQueueManager;
import practice10.stack.DollStackManager;

import java.util.Scanner;

@AllArgsConstructor
@NoArgsConstructor
public class GetNewDollCommand implements Command {
    DollQueueManager dollQueueManager;
    DollStackManager dollStackManager;
    DollHistoryManager dollHistoryManager;
    DollPopularityManager popularityManager;
    Scanner sc = new Scanner(System.in);

    public GetNewDollCommand(DollQueueManager dollQueueManager, DollStackManager dollStackManager, DollHistoryManager dollHistoryManager, DollPopularityManager popularityManager) {
        this.dollQueueManager = dollQueueManager;
        this.dollStackManager = dollStackManager;
        this.dollHistoryManager = dollHistoryManager;
        this.popularityManager = popularityManager;
    }

    @Override
    public void execute() {
        String person = dollQueueManager.getNextCustomer();
        if (person != null) {
            String doll = dollStackManager.storeRandomDoll();
            dollHistoryManager.addHistory(person, doll);
            popularityManager.addDoll(doll);
            System.out.printf("👉 %s 님, 한 번 더 뽑으시겠습니까? (y/n): ", person);


            sc.nextLine();
            String tempSelect = sc.nextLine();


            if (tempSelect.toLowerCase().equals("y")) {
                dollQueueManager.registerCustomer(person);
                System.out.println("\uD83D\uDD01" + person + " 님이 다시 대기열에 등록되었습니다.");
            }
        }

    }
}
