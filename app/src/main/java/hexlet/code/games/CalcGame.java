package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class CalcGame implements Engine {
    public static void calcChoice() {
        Scanner scanner = new Scanner(System.in);
        String clientName = Engine.greetingsClient();
        System.out.println("What is the result of the expression?");
        int answersCount = 0;
        while (true) {
            String expression = getRandomExpression();
            int resultOfExpression = gerAsIntRandomExpression(expression);
            System.out.printf("Question: %s\n", expression);
            String clientAnswer = scanner.nextLine();
            if (Integer.parseInt(clientAnswer) == resultOfExpression) {
                System.out.printf("Your answer: %s \nCorrect!\n", clientAnswer);
                answersCount++;
                if (answersCount == 3) {
                    System.out.printf("Congratulations, %s\n", clientName);
                    break;
                }
            } else {
                CalcGame calcGame = new CalcGame();
                calcGame.wrongAnswer(clientAnswer, String.valueOf(resultOfExpression), clientName);
                break;
            }
        }
    }

    public static String getRandomExpression() {
        StringBuilder stringVersionOfExpression = new StringBuilder();
        int borderForNumber = 20;
        int randomNumber1 = new Random().nextInt(borderForNumber + 1);
        int randomNumber2 = new Random().nextInt(borderForNumber + 1);
        int mathSing = new Random().nextInt(3);
        switch (mathSing) {
            case 0 -> stringVersionOfExpression.append(randomNumber1).append(" + ").append(randomNumber2);
            case 1 -> stringVersionOfExpression.append(randomNumber1).append(" - ").append(randomNumber2);
            case 2 -> stringVersionOfExpression.append(randomNumber1).append(" * ").append(randomNumber2);
            default -> System.out.println("Something wrong");
        }
        return stringVersionOfExpression.toString();
    }

    public static int gerAsIntRandomExpression(String expression) {
        String[] splitter = expression.split(" ");
        int firstNumber = Integer.parseInt(splitter[0]);
        int secondNumber = Integer.parseInt(splitter[2]);
        char mathSing = splitter[1].charAt(0);
        return switch (mathSing) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            default -> throw new IllegalStateException("Unexpected value: " + mathSing);
        };
    }

    @Override
    public void wrongAnswer(String wrongAnswer, String rightAnswer, String clientName) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'. \n",
                wrongAnswer, rightAnswer);
        System.out.printf("Let's try again, %s\n", clientName);
    }
}
