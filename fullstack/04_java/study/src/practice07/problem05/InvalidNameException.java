package practice07.problem05;

public class InvalidNameException extends Exception {
    // 생성자에서 예외 메시지를 받아서 부모 클래스(Exception)에게 전달
    public InvalidNameException(String message) {
        super(message);
    }
}
