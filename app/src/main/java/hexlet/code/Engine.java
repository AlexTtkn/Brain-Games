package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static int answersCount;

    public static String greetingsClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String clientName = scanner.nextLine();
        System.out.printf("Hello, %s! \n", clientName);
        return clientName;
    }

    public static void wrongAnswer(String wrongAnswer, String rightAnswer, String clientName) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'. \n",
                wrongAnswer, rightAnswer);
        System.out.printf("Let's try again, %s!\n", clientName);
    }

    public static String checkCorrectAnswer(String correctAnswer, String clientName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        String clientAnswer = scanner.nextLine();
        if (clientAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            answersCount++;
            if (answersCount == 3) {
                System.out.printf("Congratulations, %s!\n", clientName);
            }
        }
        return clientAnswer;
    }
}
