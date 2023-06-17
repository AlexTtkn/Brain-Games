package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;
import java.util.Map;

public class GCDGame {
    private static final int BOUNDS_FOR_GCD_GAME = 100;
    private static final String GCD_GAME_QUESTION = "Find the greatest common divisor of given numbers.";

    public static void start() {
        Map<String, String> questionsAndAnswers = new HashMap<>();
        for (int i = 0; i < Engine.COUNTER_OF_ROUNDS; i++) {
            int randomNumber1 = Utils.getRandomInt(Engine.ADDITIONAL_ONE, BOUNDS_FOR_GCD_GAME);
            int randomNumber2 = Utils.getRandomInt(Engine.ADDITIONAL_ONE, BOUNDS_FOR_GCD_GAME);
            String correctAnswer = String.valueOf(getCorrectAnswer(randomNumber1, randomNumber2));
            String gameQuestion = "Question: " + randomNumber1 + " " + randomNumber2;
            questionsAndAnswers.put(gameQuestion, correctAnswer);
        }
        Engine.run(questionsAndAnswers, GCD_GAME_QUESTION);
    }

    private static int getCorrectAnswer(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return a + b;
    }
}
