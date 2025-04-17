package practice03.Problem02;

public class InputTest {
    public static void main(String[] args) {
        Input input = new Input();
        String userInput = input.read("이름");
        System.out.println("입력값: " + userInput);

        userInput = input.read("이름", "홍길동");
        System.out.println("입력값: " + userInput);

        int userNumberInput = input.readInt("나이");
        System.out.println("입력값: " + userNumberInput);

        boolean userBooleanInput = input.confirm("종료할까요?");
        System.out.println("입력값: " + userBooleanInput);

        userBooleanInput = input.confirm("종료할까요?");
        System.out.println("입력값: " + userBooleanInput);
//        종료할까요? (Y/n): n
//        입력값: false
//        종료할까요? (Y/n):
//        입력값: true
    }
}
