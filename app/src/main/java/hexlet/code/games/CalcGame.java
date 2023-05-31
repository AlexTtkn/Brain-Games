package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class CalcGame {
    private static final int BOUND_FOR_CALC_GAME = 20;

    public static void calcChoice() {
        Engine.greetingsClient();
        System.out.println("What is the result of the expression?");
        for (int i = 0; i < Engine.getCounterOfRounds(); i++) {
            int randomNumber1 = new Random().nextInt(BOUND_FOR_CALC_GAME) + Engine.getAdditionalOne();
            int randomNumber2 = new Random().nextInt(BOUND_FOR_CALC_GAME) + Engine.getAdditionalOne();
            char[] operators = {'+', '-', '*'};
            int index = new Random().nextInt(operators.length);
            char operator = operators[index];
            String correctAnswer = String.valueOf(countCorrectAnswer(randomNumber1, randomNumber2, operator));
            String gameQuestion = "Question: " + getRandomQuestion(randomNumber1, randomNumber2, index);
            String clientAnswer = Engine.checkCorrectAnswer(correctAnswer, gameQuestion);
            if (!clientAnswer.equals(correctAnswer)) {
                Engine.printWrongAnswer(clientAnswer, correctAnswer);
                break;
            }
        }
    }

    private static String getRandomQuestion(int num1, int num2, int mathSing) {
        StringBuilder stringVersionOfQuestion = new StringBuilder();
        switch (mathSing) {
            case 0 -> stringVersionOfQuestion.append(num1).append(" + ").append(num2);
            case 1 -> stringVersionOfQuestion.append(num1).append(" - ").append(num2);
            case 2 -> stringVersionOfQuestion.append(num1).append(" * ").append(num2);
            default -> System.out.println("Something wrong");
        }
        return stringVersionOfQuestion.toString();
    }

    private static int countCorrectAnswer(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}
