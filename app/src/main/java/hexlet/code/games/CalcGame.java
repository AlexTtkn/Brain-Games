package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;
import java.util.Map;

public class CalcGame {
    private static final int BOUND_FOR_CALC_GAME = 20;
    private static final String CALC_GAME_QUESTION = "What is the result of the expression?";

    public static void start() {
        Map<String, String> questionsAndAnswers = new HashMap<>();
        for (int i = 0; i < Engine.COUNTER_OF_ROUNDS; i++) {
            int randomNumber1 = Utils.getRandomInt(Engine.ADDITIONAL_ONE, BOUND_FOR_CALC_GAME);
            int randomNumber2 = Utils.getRandomInt(Engine.ADDITIONAL_ONE, BOUND_FOR_CALC_GAME);
            char[] operators = {'+', '-', '*'};
            int index = Utils.getRandomInt(operators.length);
            char operator = operators[index];
            String correctAnswer = String.valueOf(getCorrectAnswer(randomNumber1, randomNumber2, operator));
            String gameQuestion = "Question: " + generateQuestion(randomNumber1, randomNumber2, index);
            questionsAndAnswers.put(gameQuestion, correctAnswer);
        }
        Engine.run(questionsAndAnswers, CALC_GAME_QUESTION);
    }

    private static String generateQuestion(int num1, int num2, int mathSing) {
        StringBuilder stringVersionOfQuestion = new StringBuilder();
        switch (mathSing) {
            case 0 -> stringVersionOfQuestion.append(num1).append(" + ").append(num2);
            case 1 -> stringVersionOfQuestion.append(num1).append(" - ").append(num2);
            case 2 -> stringVersionOfQuestion.append(num1).append(" * ").append(num2);
            default -> System.out.println("Something wrong");
        }
        return stringVersionOfQuestion.toString();
    }

    private static int getCorrectAnswer(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}
