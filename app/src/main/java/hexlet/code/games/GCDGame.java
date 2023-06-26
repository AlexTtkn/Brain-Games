package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class GCDGame {
    private static final int BOUNDS_FOR_GCD_GAME = 100;
    private static final String GCD_GAME_QUESTION = "Find the greatest common divisor of given numbers.";

    public static void startGCDGame() {
        String[][] gcdGameInfo = new String[Engine.COUNTER_OF_ROUNDS][2];
        for (int i = 0; i < gcdGameInfo.length; i++) {
            int randomNumber1 = Utils.getRandomInt(Engine.ONE, BOUNDS_FOR_GCD_GAME);
            int randomNumber2 = Utils.getRandomInt(Engine.ONE, BOUNDS_FOR_GCD_GAME);
            String correctAnswer = String.valueOf(getCorrectAnswer(randomNumber1, randomNumber2));
            String gameQuestion = randomNumber1 + " " + randomNumber2;
            gcdGameInfo[i][0] = gameQuestion;
            gcdGameInfo[i][1] = correctAnswer;
        }
        Engine.run(gcdGameInfo, GCD_GAME_QUESTION);
    }

    private static int getCorrectAnswer(int a, int b) {
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
