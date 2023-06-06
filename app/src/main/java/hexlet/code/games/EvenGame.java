package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

public class EvenGame {
    private static final int BOUND_FOR_EVEN_GAME = 1000;

    public static void evenChoice() {
        Cli.greetingsClient();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < Engine.COUNTER_OF_ROUNDS; i++) {
            int randomNumber = new Random().nextInt(BOUND_FOR_EVEN_GAME) + Engine.ADDITIONAL_ONE;
            String correctAnswer = isEven(randomNumber) ? "yes" : "no";
            String gameQuestion = "Question: " + randomNumber;
            Engine.getMapToStoreResponses().put(gameQuestion, correctAnswer);
        }
        Engine.checkCorrectAnswer(Engine.getMapToStoreResponses());
    }

    private static boolean isEven(int num1) {
        return num1 % 2 == 0;
    }
}
