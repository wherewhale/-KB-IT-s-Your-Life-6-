//package practice08;
//
//public class TicketingRound3 {
//    public static void main(String[] args) {
//        EntryManager entryManager = new EntryManager(5);
//
//
//        Fan[] fans = {
//                new Fan("팬1", false, entryManager),
//                new Fan("팬2", true, entryManager),
//                new Fan("팬3", false, entryManager),
//                new Fan("팬4", true, entryManager),
//                new Fan("팬5", false, entryManager)
//        };
//
//        Thread[] threads = new Thread[fans.length];
//        System.out.printf("이벤트 시작! 남은 티켓: %d장\n", entryManager.getTicketCount());
//
//        for (int i = 0; i < fans.length; i++) {
//            threads[i] = new Thread(fans[i]);
//            threads[i].start();
//        }
//
//
//        for (Thread thread : threads) {
//            try {
//                thread.join(); // 각 스레드가 종료될 때까지 대기
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println("이벤트 종료! 모두 수고하셨습니다 🎉");
//    }
//}
