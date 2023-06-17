package hexlet.code;

import java.util.Map;
import java.util.Scanner;

public class Engine {
    public static final int ONE = 1;
    public static final int COUNTER_OF_ROUNDS = 3;

    public static void run(Map<String, String> map, String gameQuestion) {
        Cli.greetingsClient();
        System.out.println(gameQuestion);
        Scanner scanner = new Scanner(System.in);
        int answersCounter = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.print("Your answer: ");
            String clientAnswer = scanner.nextLine();
            if (clientAnswer.equals(entry.getValue())) {
                System.out.println("Correct!");
                answersCounter++;
                printCongratulations(answersCounter);
            } else {
                printWrongAnswer(clientAnswer, entry.getValue());
                break;
            }
        }
    }

    private static void printCongratulations(int answersCounter) {
        if (answersCounter == COUNTER_OF_ROUNDS) {
            System.out.printf("Congratulations, %s!\n", Cli.getClientName());
        }
    }

    private static void printWrongAnswer(String clientAnswer, String correctAnswer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'. \n",
                clientAnswer, correctAnswer);
        System.out.printf("Let's try again, %s!\n", Cli.getClientName());
    }
}
