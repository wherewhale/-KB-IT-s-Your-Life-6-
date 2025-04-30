package ch15.sec06.exam02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        //Queue 컬렉션 생성
        Queue<Message> messageQueue = new LinkedList<>();
        //Produce 단계, 생산 단계라고 볼 수 있음
        //(T producer)

        //메시지 넣기
        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "신용권"));
        messageQueue.offer(new Message("sendKakaotalk", "감자바"));


        //메시지를 하나씩 꺼내어 처리
        //Consume 단계, 소비 단게 (T consumer)
        while (!messageQueue.isEmpty()) {
            Message message = messageQueue.poll(); // poll로 차례대로 꺼내서 사용
            switch (message.command) {
                case "sendMail":
                    System.out.println(message.to + "님에게 메일을 보냅니다.");
                case "sendSMS":
                    System.out.println(message.to + "님에게 SMS을 보냅니다.");
                case "sendKakaotalk":
                    System.out.println(message.to + "님에게 카카오톡을 보냅니다.");
            }
        }

        //전형적인 producer consumer형태
        //멀티 스레드를 이용한다면? -> 명령 생성자와 소비자가 나눠질 수 있다.
        //여기서 Queue는 공유 자원이자 통신 채널이다. (동기화 문제가 발생할 수 있음)

        /*
        SOLID 구조를 고려해서 작성해야 한다.
        현재는 기존 코드 변화에서 불편한 요소가 존재하므로 확장에 열려있어야 하는 O 원칙을 벗어남
         case 에 있어서도, 유연하지 못한 문제가 있다.
         */

    }
}
