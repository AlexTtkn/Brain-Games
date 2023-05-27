package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GCDGame {
    private static final int BOUNDS_FOR_GCD_GAME = 100;
    public static void gcdChoice() {
        String clientName = Engine.greetingsClient();
        System.out.println("Find the greatest common divisor of given numbers.");
        for (int i = 0; i < Engine.getCounterOfRounds(); i++) {
            int randomNumber1 = new Random().nextInt(BOUNDS_FOR_GCD_GAME);
            int randomNumber2 = new Random().nextInt(BOUNDS_FOR_GCD_GAME);
            String correctAnswer = String.valueOf(getNod(randomNumber1, randomNumber2));
            System.out.println("Question: " + randomNumber1 + " " + randomNumber2);
            String clientAnswer = Engine.checkCorrectAnswer(correctAnswer, clientName);
            if (!clientAnswer.equals(correctAnswer)) {
                Engine.wrongAnswer(clientAnswer, correctAnswer, clientName);
                break;
            }
        }
    }

    private static int getNod(int number1, int number2) {
        while (number1 != 0 && number2 != 0) {
            if (number1 > number2) {
                number1 %= number2;
            } else {
                number2 %= number1;
            }
        }
        return number1 + number2;
    }
}
