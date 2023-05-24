package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    public static void evenChoice() {
        Scanner scanner = new Scanner(System.in);
        String clientName = Games.greetingsClient();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        int answersCount = 0;
        while (true) {
            int n = 1000;
            int randomNumber = new Random().nextInt(n + 1);
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
}
