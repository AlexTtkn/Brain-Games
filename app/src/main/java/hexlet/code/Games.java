package hexlet.code;

import java.util.Scanner;

public class Games {
    public static String greetingsClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String clientName = scanner.nextLine();
        System.out.printf("Hello, %s! \n", clientName);
        return clientName;
    }
}
