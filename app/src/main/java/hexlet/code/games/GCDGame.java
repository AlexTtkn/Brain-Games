package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

public class GCDGame {
    private static final int BOUNDS_FOR_GCD_GAME = 100;

    public static void gcdChoice() {
        Cli.greetingsClient();
        System.out.println("Find the greatest common divisor of given numbers.");
        for (int i = 0; i < Engine.COUNTER_OF_ROUNDS; i++) {
            int randomNumber1 = new Random().nextInt(BOUNDS_FOR_GCD_GAME) + Engine.ADDITIONAL_ONE;
            int randomNumber2 = new Random().nextInt(BOUNDS_FOR_GCD_GAME) + Engine.ADDITIONAL_ONE;
            String correctAnswer = String.valueOf(countCorrectAnswer(randomNumber1, randomNumber2));
            String gameQuestion = "Question: " + randomNumber1 + " " + randomNumber2;
            Engine.getMapToStoreResponses().put(gameQuestion, correctAnswer);
        }
        Engine.checkCorrectAnswer(Engine.getMapToStoreResponses());
    }

    private static int countCorrectAnswer(int a, int b) {
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
