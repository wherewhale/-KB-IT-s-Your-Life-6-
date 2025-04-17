package ch07.sec04.exam01;

public class Computer extends Calculator {
    //메소드 오버라이딩
    @Override // 컴파일 시 정확히 오버라이딩이 되었는지 체크 해줌
    public double areaCircle(double r) {
        //만약, 이름을 조금이라도 다르게 선언하면 오버라이딩이 아니라 새로운 메소드를 선언하는 것
        //매개 변수에만 차이가 존재하면 오버라이딩이 아니라, 오버로딩이다.
        //이러한 차이의 문제를 해결하기 위해 @Override를 붙이는 것
        System.out.println("Computer 객체의 areaCircle() 실행");
        return Math.PI * r * r;
    }

    // ctrl + O 로 오버라이딩을 쉽게 할 수 있다.
    //@Override
    //public double areaCircle(double r) {
    //    return super.areaCircle(r);
    //}
}
