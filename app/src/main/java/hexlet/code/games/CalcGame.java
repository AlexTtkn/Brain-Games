package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class CalcGame implements Engine {

    private static String correctAnswer;

    private static String getCorrectAnswer() {
        return correctAnswer;
    }

    private static void setCorrectAnswer(String correctAnswer) {
        CalcGame.correctAnswer = correctAnswer;
    }
    public static void calcChoice() {
        Scanner scanner = new Scanner(System.in);
        String clientName = Engine.greetingsClient();
        System.out.println("What is the result of the expression?");
        int answersCount = 0;
        while (true) {
            System.out.println(new CalcGame().getQuestion());
            String clientAnswer = scanner.nextLine();
            if (clientAnswer.equals(getCorrectAnswer())) {
                System.out.printf("Your answer: %s \nCorrect!\n", clientAnswer);
                answersCount++;
                if (answersCount == 3) {
                    System.out.printf("Congratulations, %s\n", clientName);
                    break;
                }
            } else {
                CalcGame calcGame = new CalcGame();
                calcGame.wrongAnswer(clientAnswer, getCorrectAnswer(), clientName);
                break;
            }
        }
    }

    private static String getRandomExpression() {
        StringBuilder stringVersionOfExpression = new StringBuilder();
        int n = 20;
        int randomNumber1 = new Random().nextInt(n + 1);
        int randomNumber2 = new Random().nextInt(n + 1);
        int mathSing = new Random().nextInt(3);
        switch (mathSing) {
            case 0 -> stringVersionOfExpression.append(randomNumber1).append(" + ").append(randomNumber2);
            case 1 -> stringVersionOfExpression.append(randomNumber1).append(" - ").append(randomNumber2);
            case 2 -> stringVersionOfExpression.append(randomNumber1).append(" * ").append(randomNumber2);
            default -> System.out.println("Something wrong");
        }
        return stringVersionOfExpression.toString();
    }

    private static int gerAsIntRandomExpression(String expression) {
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

    @Override
    public String getQuestion() {
        String expression = getRandomExpression();
        int resultOfExpression = gerAsIntRandomExpression(expression);
        setCorrectAnswer(String.valueOf(resultOfExpression));
        return "Question: " + expression;
    }
}
