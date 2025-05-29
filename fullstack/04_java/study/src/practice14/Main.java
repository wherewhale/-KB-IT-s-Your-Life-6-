package practice14;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Product, String> logs = new HashMap<>();
        // 준비
        Manager manager = new Manager();
        manager.register("insta", new CardTemplate("Instagram Story", "*"));
        manager.register("twit", new CardTemplate("Tweet Style", "-"));
        manager.register("short", new CardTemplate("YouTube Shorts", "#"));
        Scanner sc = new Scanner(System.in);
        String userInput = "";

        while (!userInput.equals("exit")) {
            manager.printRegisteredStyles();
            System.out.print("사용할 스타일 이름 입력 (종료: exit): ");
            userInput = sc.nextLine();
            if (userInput.equals("exit")) break;

            Product p = manager.create(userInput);
            System.out.print("출력할 문구 입력: ");
            String comment = sc.nextLine();
            if (p == null) {
                System.out.print("[Error] 등록되지 않은 스타일입니다: " + userInput);
            } else {
                logs.put(p, comment);
                p.use(comment);
            }
        }

        logs.forEach(Product::use);

    }
}
