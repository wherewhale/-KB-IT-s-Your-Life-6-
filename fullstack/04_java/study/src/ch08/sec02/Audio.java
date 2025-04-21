package ch08.sec02;

public class Audio implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }

    // 아래와 같은 형식으로 메소드를 만들어서 사용해도, Type을 어떻게 선언하느냐에 따라 사용이 불가할 수도 있다.
    void test() {
        System.out.println("이건 문제가 안되나?");
    }
}
