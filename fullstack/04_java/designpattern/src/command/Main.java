package command;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileService fs = new FileService();
        //Command Interface 배열 타입으로 배열 생성 (다형성)
        //다형성을 기반으로 OCP 동작
        Command[] commands = {
                new AddCommand(),
                //new OpenCommand(),
                //new PrintCommand(),
                //new ExitCommand()
                //new Command() { -> 익명 구현 객체 구현 방식
                //    @Override
                //    public void execute() {
                //        System.out.println("Add Command");
                //    }
                //},

                fs::open, // () -> fs.open()
                fs::print, // () -> fs.print()
                Main::exit // () -> Main.exit()
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

    public static void exit() {
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
