package command;

import java.util.Scanner;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        // 관례상 default는 대문자로 해서, 그냥 엔터를 치면 default값이 입력되도록 구성
        System.out.print("종료할까요?(Y/n) ");
        String answer = scanner.nextLine();
        scanner.close();
        if(answer.isEmpty() || answer.equalsIgnoreCase("Y") ) {
            System.exit(0);
        }
    }
}
