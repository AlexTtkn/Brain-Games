package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class GCDGame implements Engine {
    public static void gcdChoice() {
        Scanner scanner = new Scanner(System.in);
        String clientName = Engine.greetingsClient();
        System.out.println("Find the greatest common divisor of given numbers.");
        int answersCount = 0;
        while (true) {
            int n = 100;
            int randomNumber1 = new Random().nextInt(n + 1);
            int randomNumber2 = new Random().nextInt(n + 1);
            System.out.printf("Question: %d %d\n", randomNumber1, randomNumber2);
            String clientAnswer = scanner.nextLine();
            int correctAnswer = getNod(randomNumber1, randomNumber2);
            if (correctAnswer == Integer.parseInt(clientAnswer)) {
                System.out.printf("Your answer: %s \nCorrect!\n", clientAnswer);
                answersCount++;
                if (answersCount == 3) {
                    System.out.printf("Congratulations, %s\n", clientName);
                    break;
                }
            } else {
                GCDGame gcdGame = new GCDGame();
                gcdGame.wrongAnswer(clientAnswer, String.valueOf(correctAnswer), clientName);
                break;
            }
        }
    }

    private static int getNod(int number1, int number2) {
        while (number1 != 0 && number2 != 0) {
            if (number1 > number2) {
                number1 %= number2;
            } else {
                number2 %= number1;
            }
        }
        return number1 + number2;
    }

    @Override
    public void wrongAnswer(String wrongAnswer, String rightAnswer, String clientName) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'. \n",
                wrongAnswer, rightAnswer);
        System.out.printf("Let's try again, %s\n", clientName);
    }
}
