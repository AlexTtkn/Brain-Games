package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;
import java.util.Map;

public class PrimeGame {
    private static final int BOUND_FOR_PRIME_GAME = 3571;
    private static final String PRIME_GAME_QUESTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void start() {
        Map<String, String> questionsAndAnswers = new HashMap<>();
        for (int i = 0; i < Engine.COUNTER_OF_ROUNDS; i++) {
            int randomNumber = Utils.getRandomInt(Engine.ONE, BOUND_FOR_PRIME_GAME);
            String correctAnswer = getCorrectAnswer(randomNumber) ? "yes" : "no";
            String gameQuestion = "Question: " + randomNumber;
            questionsAndAnswers.put(gameQuestion, correctAnswer);
        }
        Engine.run(questionsAndAnswers, PRIME_GAME_QUESTION);
    }

    private static boolean getCorrectAnswer(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
