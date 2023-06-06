package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Engine {
    public static Map<String, String> mapToStoreResponses = new HashMap<>();
    public static int answersCounter;
    public static final int ADDITIONAL_ONE = 1;
    public static final int COUNTER_OF_ROUNDS = 3;

    public static void checkCorrectAnswer(Map<String, String> map) {
        Scanner scanner = new Scanner(System.in);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.print("Your answer: ");
            String clientAnswer = scanner.nextLine();
            if (clientAnswer.equals(entry.getValue())) {
                System.out.println("Correct!");
                answersCounter++;
                printCongratulations();
            } else {
                printWrongAnswer(clientAnswer, entry.getValue());
                break;
            }

        }
    }

    private static void printCongratulations() {
        if (answersCounter == COUNTER_OF_ROUNDS) {
            System.out.printf("Congratulations, %s!\n", Cli.clientName);
        }
    }

    private static void printWrongAnswer(String clientAnswer, String correctAnswer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'. \n",
                clientAnswer, correctAnswer);
        System.out.printf("Let's try again, %s!\n", Cli.clientName);
    }
}
