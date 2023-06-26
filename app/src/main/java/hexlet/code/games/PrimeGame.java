package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class PrimeGame {
    private static final int BOUND_FOR_PRIME_GAME = 3571;
    private static final String PRIME_GAME_QUESTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startPrimeGame() {
        String[][] primeGameInfo = new String[Engine.COUNTER_OF_ROUNDS][2];
        for (int i = 0; i < primeGameInfo.length; i++) {
            int randomNumber = Utils.getRandomInt(Engine.ONE, BOUND_FOR_PRIME_GAME);
            String gameQuestion = Integer.toString(randomNumber);
            String correctAnswer = getCorrectAnswer(randomNumber) ? "yes" : "no";
            primeGameInfo[i][0] = gameQuestion;
            primeGameInfo[i][1] = correctAnswer;
        }
        Engine.run(primeGameInfo, PRIME_GAME_QUESTION);
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
