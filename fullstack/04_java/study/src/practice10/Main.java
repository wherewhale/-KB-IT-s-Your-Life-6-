package practice10;

import practice10.history.DollHistoryManager;
import practice10.popularity.DollPopularityManager;
import practice10.queue.DollQueueManager;
import practice10.stack.DollStackManager;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DollQueueManager dollQueueManager = new DollQueueManager();
        DollStackManager dollStackManager = new DollStackManager();
        DollHistoryManager dollHistoryManager = new DollHistoryManager();
        DollPopularityManager popularityManager = new DollPopularityManager();

        Map<Integer, Command> commands = new HashMap<>();
        commands.put(1, new RegisterCustomerCommand(dollQueueManager));
        commands.put(2, new GetNewDollCommand(dollQueueManager, dollStackManager, dollHistoryManager, popularityManager));
        commands.put(3, new ShowWaitingListCommand(dollQueueManager));
        commands.put(4, new ShowStackCommand(dollStackManager));
        commands.put(5, new ShowAllHistoryCommand(dollHistoryManager));
        commands.put(6, new ShowUniqueHistoryCommand(dollHistoryManager));
        commands.put(7, new ShowRankingCommand(popularityManager));

        int select = -1;


        while (select != 0) {
            System.out.println();
            System.out.println("""
                    === 유라의 인형뽑기 가게 ===
                    [1] 고객 등록
                    [2] 뽑기 진행 (보관 + 기록)
                    [3] 현재 대기열 보기
                    [4] 보관함 보기
                    [5] 고객별 인형 기록 보기
                    [6] 중복 제거된 인형 목록 보기
                    [7] 인형별 인기 순위 보기
                    [0] 종료""");

            System.out.print("선택 >> ");

            select = sc.nextInt();

            Command command = commands.get(select);

            if (select == 0) {
                break;
            } else if (command != null) {
                command.execute();
            }

        }
    }
}
