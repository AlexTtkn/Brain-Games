package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class CalcGame {
    private static final int BOUND_FOR_CALC_GAME = 20;

    public static void calcChoice() {
        String clientName = Engine.greetingsClient();
        System.out.println("What is the result of the expression?");
        for (int i = 0; i < Engine.getCounterOfRounds(); i++) {
            String expression = getRandomExpression();
            int resultOfExpression = gerAsIntRandomExpression(expression);
            String correctAnswer = String.valueOf(resultOfExpression);
            System.out.println("Question: " + expression);
            String clientAnswer = Engine.checkCorrectAnswer(correctAnswer, clientName);
            if (!clientAnswer.equals(correctAnswer)) {
                Engine.wrongAnswer(clientAnswer, correctAnswer, clientName);
                break;
            }
        }
    }

    private static String getRandomExpression() {
        StringBuilder stringVersionOfExpression = new StringBuilder();
        int randomNumber1 = new Random().nextInt(BOUND_FOR_CALC_GAME);
        int randomNumber2 = new Random().nextInt(BOUND_FOR_CALC_GAME);
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

}
