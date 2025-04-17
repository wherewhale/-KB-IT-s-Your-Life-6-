package ch07.sec02;

public class SmartPhone extends Phone {
    //필드 선언
    public boolean wifi;

    //생성자 선언
    public SmartPhone(String model, String color) {
        //여기서 model과 color는 어디서 나온걸까?
        //(phone 클래스를 보지 못한 사람의 경우에는 직관적이지 않다.)
        this.model = model;
        this.color = color;
    }

    //메소드 선언
    public void setWifi(boolean wifi) {
        this.wifi = wifi;
        System.out.println("와이파이 상태를 변경했습니다.");
    }

    public void internet() {
        System.out.println("인터넷에 연결합니다.");
    }
}
