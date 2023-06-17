package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String clientName;

    public static void greetingsClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        clientName = scanner.nextLine();
        System.out.printf("Hello, %s! \n", clientName);
    }

    public static String getClientName() {
        return clientName;
    }
}

