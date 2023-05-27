package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class PrimeGame {
    private static final int BOUND_FOR_PRIME_GAME = 3571;
    public static void primeChoice() {
        String clientName = Engine.greetingsClient();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        for (int i = 0; i < Engine.getCounterOfRounds(); i++) {
            int randomNumber = new Random().nextInt(BOUND_FOR_PRIME_GAME);
            String correctAnswer = isPrime(randomNumber);
            System.out.println("Question: " + randomNumber);
            String clientAnswer = Engine.checkCorrectAnswer(correctAnswer, clientName);
            if (!clientAnswer.equals(correctAnswer)) {
                Engine.wrongAnswer(clientAnswer, correctAnswer, clientName);
                break;
            }
        }
    }

    private static String isPrime(int number) {
        if (number <= 1) {
            return "no";
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
