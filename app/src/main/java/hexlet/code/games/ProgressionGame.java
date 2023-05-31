package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class ProgressionGame {
    private static final int BOUND_FOR_PROGRESSION_GAME = 10;
    private static final String[] MATRIX = new String[BOUND_FOR_PROGRESSION_GAME];

    public static void progressionChoice() {
        Engine.greetingsClient();
        System.out.println("What number is missing in the progression?");
        for (int i = 0; i < Engine.getCounterOfRounds(); i++) {
            int randomNumber1 = new Random().nextInt(BOUND_FOR_PROGRESSION_GAME);
            int randomNumber2 = new Random().nextInt(BOUND_FOR_PROGRESSION_GAME);
            for (int j = 0; j < MATRIX.length; j++) {
                MATRIX[j] = String.valueOf(randomNumber1);
                randomNumber1 += randomNumber2;
            }
            int pointsPosition = new Random().nextInt(BOUND_FOR_PROGRESSION_GAME);
            String correctAnswer = countCorrectAnswer(pointsPosition);
            String gameQuestion = "Question: " + printNumbers(pointsPosition);
            String clientAnswer = Engine.checkCorrectAnswer(correctAnswer, gameQuestion);
            if (!clientAnswer.equals(correctAnswer)) {
                Engine.printWrongAnswer(clientAnswer, correctAnswer);
                break;
            }
        }
    }

    private static String countCorrectAnswer(int hideNum) {
        return String.valueOf(ProgressionGame.MATRIX[hideNum]);
    }

    private static String printNumbers(int hidePos) {
        StringBuilder str = new StringBuilder();
        String points = "..";
        MATRIX[hidePos] = points;
        for (int i = 0; i < MATRIX.length; i++) {
            if (i == MATRIX.length - 1) {
                str.append(MATRIX[i]);
            } else {
                str.append(MATRIX[i]).append(" ");
            }
        }
        return str.toString();
    }
}
