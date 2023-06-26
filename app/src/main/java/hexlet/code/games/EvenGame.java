package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class EvenGame {
    private static final int BOUND_FOR_EVEN_GAME = 1000;
    private static final String EVEN_GAME_QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void startEvenGame() {
        String[][] evenGameInfo = new String[Engine.COUNTER_OF_ROUNDS][2];
        for (int i = 0; i < evenGameInfo.length; i++) {
            int randomNumber = Utils.getRandomInt(Engine.ONE, BOUND_FOR_EVEN_GAME);
            String correctAnswer = getCorrectAnswer(randomNumber) ? "yes" : "no";
            String gameQuestion = Integer.toString(randomNumber);
            evenGameInfo[i][0] = gameQuestion;
            evenGameInfo[i][1] = correctAnswer;
        }
        Engine.run(evenGameInfo, EVEN_GAME_QUESTION);
    }

    private static boolean getCorrectAnswer(int num1) {
        return num1 % 2 == 0;
    }
}
