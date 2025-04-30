package command;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Command Interface 배열 타입으로 배열 생성 (다형성)
        //다형성을 기반으로 OCP 동작
        Command[] commands = {
                new AddCommand(),
                new OpenCommand(),
                new PrintCommand(),
                new ExitCommand()
        };

        while(true) {
            Scanner scanner = new Scanner(System.in);
            // 메뉴 운영 + 배열 연동
            System.out.println("1: Add, 2: Open, 3: Print, 4: Exit");
            System.out.print("선택: ");
            int sel = scanner.nextInt();
            // 핵심 코드는 아래와 같으며, 무엇을 실행하던 모양이 똑같다는 특징이 존재
            commands[sel-1].execute();
            // 명령어에 변화가 있을때 해당 코드에는 변화가 없다.
        }
    }
}
