package practice03.Problem02;

import java.util.Scanner;

public class Input {
    static Scanner sc = new Scanner(System.in);

    String read(String title) {
        System.out.print(title + ": ");
        return sc.nextLine();
    }

    String read(String title, String defaultValue) {
        System.out.print(title);
        System.out.printf("(%s): ", defaultValue);
        String userInput = sc.nextLine();
        return userInput.isEmpty() ? defaultValue : userInput;
    }

    int readInt(String title) {
        System.out.print(title + ": ");
        String userInput = sc.nextLine();
        return Integer.parseInt(userInput);
    }

    boolean confirm(String title, boolean defaultValue) {
        String description = defaultValue ? "(Y/n)" : "(y/N)";
        System.out.print(title + description + ": ");
        String userInput = sc.nextLine();

        if (userInput.isEmpty()) {
            return defaultValue;
        } else {
            return userInput.equals("Y");
        }
    }

    boolean confirm(String title) {
        return confirm(title, true);
    }
}

