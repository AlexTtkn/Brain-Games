package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EvenGame {
    private static final int BOUND_FOR_EVEN_GAME = 1000;

    public static void startEven() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Map<String, String> storeResponses = new HashMap<>();
        for (int i = 0; i < Engine.COUNTER_OF_ROUNDS; i++) {
            int numberForEvenGame = new Random().nextInt(BOUND_FOR_EVEN_GAME) + Engine.ADDITIONAL_ONE;
            String correctAnswer = isEven(numberForEvenGame) ? "yes" : "no";
            String gameQuestion = "Question: " + numberForEvenGame;
            storeResponses.put(gameQuestion, correctAnswer);
        }
        Engine.run(storeResponses);
    }

    private static boolean isEven(int num1) {
        return num1 % 2 == 0;
    }
}
