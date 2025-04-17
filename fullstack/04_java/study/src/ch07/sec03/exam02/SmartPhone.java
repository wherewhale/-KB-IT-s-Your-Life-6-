package ch07.sec03.exam02;

public class SmartPhone extends Phone {
    //자식 생성자 선언
    public SmartPhone(String model, String color) {
        //super 클래스 생성자를 직접 작성하지 않으면 에러가 발생한다.
        super(model, color);
        System.out.println("SmartPhone(String model, String color) 생성자 실행됨");
    }
}
