package ch07.sec08.exam01;

public class KumhoTire extends Tire {
    @Override
    public void roll() {
        System.out.print("금호타이어가 ");
        super.roll();
    }
}
