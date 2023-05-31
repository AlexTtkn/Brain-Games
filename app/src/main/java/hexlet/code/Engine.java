package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static String clientName;

    public static String getClientName() {
        return clientName;
    }

    private static int answersCounter;

    public static int getAnswersCounter() {
        return answersCounter;
    }

    private static final int ADDITIONAL_ONE = 1;

    public static int getAdditionalOne() {
        return ADDITIONAL_ONE;
    }

    private static final int COUNTER_OF_ROUNDS = 3;

    public static int getCounterOfRounds() {
        return COUNTER_OF_ROUNDS;
    }

    public static void greetingsClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        clientName = scanner.nextLine();
        System.out.printf("Hello, %s! \n", clientName);
    }

    public static void printWrongAnswer(String clientAnswer, String correctAnswer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'. \n",
                clientAnswer, correctAnswer);
        System.out.printf("Let's try again, %s!\n", clientName);
    }

    public static String checkCorrectAnswer(String correctAnswer, String gameQuestion) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(gameQuestion);
        System.out.print("Your answer: ");
        String clientAnswer = scanner.nextLine();
        if (clientAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            answersCounter++;
            if (answersCounter == COUNTER_OF_ROUNDS) {
                System.out.printf("Congratulations, %s!\n", clientName);
            }
        }
        return clientAnswer;

    }
}
