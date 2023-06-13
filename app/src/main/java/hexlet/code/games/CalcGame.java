package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CalcGame {
    private static final int BOUND_FOR_CALC_GAME = 20;

    public static void startCalc() {
        System.out.println("What is the result of the expression?");
        Map<String, String> storeResponses = new HashMap<>();
        for (int i = 0; i < Engine.COUNTER_OF_ROUNDS; i++) {
            int randomNumber1 = new Random().nextInt(BOUND_FOR_CALC_GAME) + Engine.ADDITIONAL_ONE;
            int randomNumber2 = new Random().nextInt(BOUND_FOR_CALC_GAME) + Engine.ADDITIONAL_ONE;
            char[] operators = {'+', '-', '*'};
            int index = new Random().nextInt(operators.length);
            char operator = operators[index];
            String correctAnswer = String.valueOf(countCorrectAnswer(randomNumber1, randomNumber2, operator));
            String gameQuestion = "Question: " + getRandomQuestion(randomNumber1, randomNumber2, index);
            storeResponses.put(gameQuestion, correctAnswer);
        }
        Engine.run(storeResponses);
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
