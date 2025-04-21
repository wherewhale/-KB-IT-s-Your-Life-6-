package ch08.sec04;

public class RemoteControlExample {
    public static void main(String[] args) {
        RemoteControl rc = new Television();
        rc.turnOn();
        rc.setVolume(100);
        rc.turnOff();
    }
}
