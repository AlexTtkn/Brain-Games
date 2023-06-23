package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ONE = 1;
    public static final int COUNTER_OF_ROUNDS = 3;

    public static void run(String[][] questionsAndAnswers, String gameQuestion) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String clientName = scanner.nextLine();
        System.out.printf("Hello, %s! \n", clientName);
        System.out.println(gameQuestion);
        for (String[] pair : questionsAndAnswers) {
            System.out.println("Question: " + pair[0]);
            System.out.print("Your answer: ");
            String clientAnswer = scanner.nextLine();
            if (clientAnswer.equals(pair[1])) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'. \n",
                        clientAnswer, pair[1]);
                System.out.printf("Let's try again, %s!\n", clientName);
                return;
            }
        }
        System.out.printf("Congratulations, %s!\n", clientName);
    }
}
