package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class EvenGame {
    private static final int BOUND_FOR_EVEN_GAME = 1000;

    public static void evenChoice() {
        Engine.greetingsClient();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < Engine.getCounterOfRounds(); i++) {
            int randomNumber = new Random().nextInt(BOUND_FOR_EVEN_GAME) + Engine.getAdditionalOne();
            String correctAnswer = isEven(randomNumber) ? "yes" : "no";
            String gameQuestion = "Question: " + randomNumber;
            String clientAnswer = Engine.checkCorrectAnswer(correctAnswer, gameQuestion);
            if (!clientAnswer.equals(correctAnswer)) {
                Engine.printWrongAnswer(clientAnswer, correctAnswer);
                break;
            }
        }
    }

    private static boolean isEven(int num1) {
        return num1 % 2 == 0;
    }
}
