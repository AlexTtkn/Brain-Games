package hexlet.code;
import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("0 - Exit");
        switch (scanner.nextLine()) {
            case "1" -> {
                System.out.println("Your choice: 1\n");
                Cli.greetingsClient();
            }
            case "2" -> {
                System.out.println("Your choice: 2\n");
                EvenGame.evenChoice();
            }
            case "3" -> {
                System.out.println("Your choice: 3\n");
                CalcGame.calcChoice();
            }
            case "4" -> {
                System.out.println("Your choice: 4\n");
                GCDGame.gcdChoice();
            }
            case "0" -> System.out.println("Exit");
            default -> System.out.println("Something wrong");
        }
    }
}
