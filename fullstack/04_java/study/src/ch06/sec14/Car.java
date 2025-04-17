package ch06.sec14;

public class Car {
    //필드 선언
    private int speed;
    private boolean stop;


    public void getSpeed() {
        System.out.printf("현재 속도: %d\n", speed);
    }

    public void setSpeed(int speed) {
        if (speed < 0) {
            this.speed = 0;
        } else {
            this.speed = speed;
        }
        System.out.printf("현재 속도: %d\n", this.speed);
    }

    public void setStop(boolean stop) {
        this.stop = stop;
        if (stop) {
            speed = 0;
        }
    }

    public boolean isStop() {
        return stop;
    }
}
