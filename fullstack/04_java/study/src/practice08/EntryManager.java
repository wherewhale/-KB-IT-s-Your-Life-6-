package practice08;

import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

public class EntryManager {
    private Queue<Fan> waitingQueue = new LinkedList<>(); // ✅ 단일 대기열
    @Getter
    private int ticketCount;

    public EntryManager(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    // ✅ 등록 시 VIP는 앞에 추가, 일반 팬은 뒤에 추가
    public void registerFan(Fan fan) {
        if (fan.isVIP()) {
            // VIP는 대기열 앞에 넣기 → LinkedList 사용이므로 가능
            ((LinkedList<Fan>) waitingQueue).addFirst(fan);
        } else {
            waitingQueue.offer(fan); // 일반 팬은 뒤에
        }
    }

    // ✅ 본인이 줄 맨 앞에 있을 때만 입장 가능
    public synchronized boolean processEntry(Fan fan) {
        if (waitingQueue.isEmpty()) return false;

        // ✅ 1. 대기열에 fan보다 먼저 등록된 VIP가 있는지 찾기
        for (Fan waitingFan : waitingQueue) {
            if (waitingFan.isVIP()) {
                // VIP가 큐 안에 있고, 나보다 먼저라면
                if (waitingFan != fan) {
                    // 내가 일반 팬이면 기다려야 함
                    if (!fan.isVIP()) return false;

                    // 내가 VIP인데 줄 앞이 아님 → 기다려야 함
                    if (waitingQueue.peek() != fan) return false;
                }
                break; // VIP인 경우 검사 끝
            }
        }

        // ✅ 2. 본인이 맨 앞이면 입장
        if (waitingQueue.peek() == fan) {
            ticketCount--;
            waitingQueue.poll();
            return true;
        }

        return false;
    }


}
