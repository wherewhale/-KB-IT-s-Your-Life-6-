package ch15.sec06.exam03;

import ch15.sec06.exam03.command.Command;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class QueueExample {
    //Command 패턴으로 구현한 메시지 처리 방식
    public static void main(String[] args) {
        Queue<Message> messageQueue = new LinkedList<>();

        Map<String, Command> commands = new HashMap<>();
        commands.put("sendMail", new SendMailCommand());
        commands.put("sendSMS", new SendSMSCommand());
        commands.put("sendKakaotalk", new SendKakaotalkCommand());

        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "신용권"));
        messageQueue.offer(new Message("sendKakaotalk", "감자바"));


        while (!messageQueue.isEmpty()) {
            Message message = messageQueue.poll();

            // Command 호출
            Command command = commands.get(message.command);
            if (command != null) {
                command.execute(message);
            }

            //만약 상태를 저장해야 하는 커맨드가 존재한다면 따로 클래스 생성
            //싱글톤 패턴으로 구축하고 사용하는 형식
            //class Context {
            //    int speed;
            //    boolean run;
            //}
        }
    }
}
