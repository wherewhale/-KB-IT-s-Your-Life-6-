package ch16.sec05.exam01;

public class Person {
    public void action(Calacuable calcuable) {
        double result = calcuable.calc(10, 4);
        System.out.println("결과: " + result);
    }
}
