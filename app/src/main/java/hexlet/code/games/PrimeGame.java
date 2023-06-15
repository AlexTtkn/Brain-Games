package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PrimeGame {
    private static final int BOUND_FOR_PRIME_GAME = 3571;

    public static void start() {
        Map<String, String> storeResponses = new HashMap<>();
        for (int i = 0; i < Engine.COUNTER_OF_ROUNDS; i++) {
            int randomNumber = new Random().nextInt(BOUND_FOR_PRIME_GAME) + Engine.ADDITIONAL_ONE;
            String correctAnswer = getCorrectAnswer(randomNumber) ? "yes" : "no";
            String gameQuestion = "Question: " + randomNumber;
            storeResponses.put(gameQuestion, correctAnswer);
        }
        Engine.run(storeResponses);
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
