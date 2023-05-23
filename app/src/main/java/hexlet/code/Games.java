package hexlet.code;

import java.util.Scanner;

public class Games {
    public static void evenChoice() {
        Scanner scanner = new Scanner(System.in);
        String clientName = greetingsClient();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        int answersCount = 0;
        while (true) {
            int randomNumber = (int) (Math.random() * 1000);
            System.out.println("Question: " + randomNumber);
            String clientAnswer = scanner.nextLine();
            if ((randomNumber % 2 == 0 && "yes".equals(clientAnswer))
                    || (randomNumber % 2 == 1 && "no".equals(clientAnswer))) {
                System.out.printf("Your answer: %s \nCorrect!\n", clientAnswer);
                answersCount++;
                if (answersCount == 3) {
                    System.out.printf("Congratulations, %s\n", clientName);
                    break;
                }
            } else {
                String rightAnswer = clientAnswer.equals("yes") ? "no" : "yes";
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'. \n", clientAnswer, rightAnswer);
                System.out.printf("Let's try again, %s\n", clientName);
                break;
            }
        }
    }

    public static String greetingsClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String clientName = scanner.nextLine();
        System.out.printf("Hello, %s! \n", clientName);
        return clientName;
    }
}
