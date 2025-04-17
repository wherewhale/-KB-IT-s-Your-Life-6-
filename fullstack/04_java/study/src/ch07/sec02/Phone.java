package ch07.sec02;

public class Phone {
    //필드 선언
    public String model;
    public String color;

    //생성자를 만들지 않았기 때문에, 컴파일러에서 기본 생성자를 만들어준다.

    //메소드 선언
    public void bell() {
        System.out.println("벨이 울립니다.");
    }

    public void sendVoice(String message) {
        System.out.println("자기: " + message);
    }

    public void receiveVoice(String message) {
        System.out.println("상대방: " + message);
    }

    public void hangUp() {
        System.out.println("전화를 끊습니다.");
    }
}
