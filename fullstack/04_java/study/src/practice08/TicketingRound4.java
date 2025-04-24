package practice08;

public class TicketingRound4 {
    public static void main(String[] args) {
        EntryManager entryManager = new EntryManager(5);

        Thread noticeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int extraNotices = 1;
                while (true) {
                    int remaining = entryManager.getTicketCount();

                    if (remaining > 0) {
                        System.out.printf("[공지] 남은 티켓: %d장\n", remaining);
                    } else {
                        if (extraNotices > 1) {
                            System.out.println("[공지] 모든 티켓이 소진되었습니다.");
                            extraNotices--;
                        } else {
                            System.out.println("[공지] 모든 티켓이 소진되었습니다. 공지 스레드 종료.");
                            break;
                        }
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        break;
                    }


                }

            }
        });

        noticeThread.setDaemon(true);
        noticeThread.start(); // 공지 스레드 시작


        Fan[] fans = {
                new Fan("팬1", false, entryManager, new RegularBuyer()),
                new Fan("팬2", true, entryManager, new VIPBuyer()),
                new Fan("팬3", false, entryManager, new RegularBuyer()),
                new Fan("팬4", true, entryManager, new VIPBuyer()),
                new Fan("팬5", false, entryManager, new SlowBuyer())
        };

        Thread[] threads = new Thread[fans.length];
        System.out.printf("이벤트 시작! 남은 티켓: %d장\n", entryManager.getTicketCount());

        for (int i = 0; i < fans.length; i++) {
            threads[i] = new Thread(fans[i]);
            threads[i].start();
            if (fans[i].isVIP()) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }
        }


        for (Thread thread : threads) {
            try {
                thread.join(); // 각 스레드가 종료될 때까지 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("이벤트 종료! 모두 수고하셨습니다 🎉");
    }
}
