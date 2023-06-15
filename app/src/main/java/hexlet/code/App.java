package hexlet.code;
import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {
    private static String clientChose;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        clientChose = scanner.nextLine();
        switch (clientChose) {
            case "1" -> {
                System.out.println("Your choice: 1\n");
                Cli.greetingsClient();
            }
            case "2" -> {
                System.out.println("Your choice: 2\n");
                EvenGame.start();
            }
            case "3" -> {
                System.out.println("Your choice: 3\n");
                CalcGame.start();
            }
            case "4" -> {
                System.out.println("Your choice: 4\n");
                GCDGame.start();
            }
            case "5" -> {
                System.out.println("Your choice: 5\n");
                ProgressionGame.start();
            }
            case "6" -> {
                System.out.println("Your choice: 6\n");
                PrimeGame.start();
            }
            case "0" -> System.out.println("Exit");
            default -> System.out.println("Something wrong");
        }
    }

    public static String getClientChose() {
        return clientChose;
    }
}
