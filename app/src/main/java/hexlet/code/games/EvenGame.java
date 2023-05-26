package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class EvenGame {
    public static void evenChoice() {
        String clientName = Engine.greetingsClient();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < 3; i++) {
            int randomNumber = new Random().nextInt(1000);
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
