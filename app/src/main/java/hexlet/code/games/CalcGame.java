package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class CalcGame {
    private static final int BOUND_FOR_CALC_GAME = 20;
    private static final String CALC_GAME_QUESTION = "What is the result of the expression?";

    public static void startCalcGame() {
        String[][] calcGameInfo = new String[Engine.COUNTER_OF_ROUNDS][2];
        for (int i = 0; i < calcGameInfo.length; i++) {
            int randomNumber1 = Utils.getRandomInt(Engine.ONE, BOUND_FOR_CALC_GAME);
            int randomNumber2 = Utils.getRandomInt(Engine.ONE, BOUND_FOR_CALC_GAME);
            char[] operators = {'+', '-', '*'};
            int index = Utils.getRandomInt(Engine.ONE, operators.length) - Engine.ONE;
            char operator = operators[index];
            String correctAnswer = String.valueOf(getCorrectAnswer(randomNumber1, randomNumber2, operator));
            String gameQuestion = randomNumber1 + " " + operator + " " + randomNumber2;
            calcGameInfo[i][0] = gameQuestion;
            calcGameInfo[i][1] = correctAnswer;
        }
        Engine.run(calcGameInfo, CALC_GAME_QUESTION);
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
