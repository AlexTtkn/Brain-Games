package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class EvenGame {
    private static final int BOUND_FOR_EVEN_GAME = 1000;
    public static void evenChoice() {
        String clientName = Engine.greetingsClient();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < Engine.getCounterOfRounds(); i++) {
            int randomNumber = new Random().nextInt(BOUND_FOR_EVEN_GAME);
            String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";
            System.out.println("Question: " + randomNumber);
            String clientAnswer = Engine.checkCorrectAnswer(correctAnswer, clientName);
            if (!clientAnswer.equals(correctAnswer)) {
                Engine.wrongAnswer(clientAnswer, correctAnswer, clientName);
                break;
            }
        }
    }
}
