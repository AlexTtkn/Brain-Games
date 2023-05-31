package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class PrimeGame {
    private static final int BOUND_FOR_PRIME_GAME = 3571;

    public static void primeChoice() {
        Engine.greetingsClient();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        for (int i = 0; i < Engine.getCounterOfRounds(); i++) {
            int randomNumber = new Random().nextInt(BOUND_FOR_PRIME_GAME) + Engine.getAdditionalOne();
            String correctAnswer = isPrime(randomNumber) ? "yes" : "no";
            String gameQuestion = "Question: " + randomNumber;
            String clientAnswer = Engine.checkCorrectAnswer(correctAnswer, gameQuestion);
            if (!clientAnswer.equals(correctAnswer)) {
                Engine.printWrongAnswer(clientAnswer, correctAnswer);
                break;
            }
        }
    }

    private static boolean isPrime(int number) {
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
