package practice10.queue;

import java.util.LinkedList;
import java.util.Queue;

public class DollQueueManager {
    Queue<String> dollQueue = new LinkedList<>();

    // 고객 등록
    public void registerCustomer(String name) {
        dollQueue.offer(name);
        System.out.printf("\uD83D\uDC49 %s 님이 대기열에 등록되었습니다.\n", name);
    }

    // 첫 고객 뽑기 실행
    public void processNextCustomer() {
        String nextPerson = dollQueue.poll();
        System.out.printf("🎉%s 님! 인형 뽑기 하러 오세요!", nextPerson);
    }

    public String getNextCustomer() {
        if (dollQueue.isEmpty()) {
            System.out.println("⛔ 대기 중인 고객이 없습니다.");
            return null;
        } else {
            String newPerson = dollQueue.poll();
            System.out.printf("🎉%s 님! 인형 뽑기 하러 오세요!\n", newPerson);
            return newPerson;
        }
    }

    // 현재 대기열 출력
    public void showWaitingList() {
        System.out.println(dollQueue);
    }
}

