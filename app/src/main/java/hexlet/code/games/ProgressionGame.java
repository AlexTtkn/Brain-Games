package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

public class ProgressionGame {
    private static final int BOUND_FOR_PROGRESSION_GAME = 10;
    private static final String[] MATRIX = new String[BOUND_FOR_PROGRESSION_GAME];

    public static void progressionChoice() {
        Cli.greetingsClient();
        System.out.println("What number is missing in the progression?");
        for (int i = 0; i < Engine.COUNTER_OF_ROUNDS; i++) {
            generateQuestion();
            String correctAnswer = hireCorrectNumber();
            String gameQuestion = "Question: " + printNumbers();
            Engine.mapToStoreResponses.put(gameQuestion, correctAnswer);
        }
        Engine.checkCorrectAnswer(Engine.mapToStoreResponses);
    }

    private static String printNumbers() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < MATRIX.length; i++) {
            if (i == MATRIX.length - 1) {
                str.append(MATRIX[i]);
            } else {
                str.append(MATRIX[i]).append(" ");
            }
        }
        return str.toString();
    }

    private static String hireCorrectNumber() {
        int pointsPosition = new Random().nextInt(BOUND_FOR_PROGRESSION_GAME);
        String points = "..";
        String correctAnswer = MATRIX[pointsPosition];
        MATRIX[pointsPosition] = points;
        return correctAnswer;
    }

    private static void generateQuestion() {
        int randomNumber1 = new Random().nextInt(BOUND_FOR_PROGRESSION_GAME);
        int randomNumber2 = new Random().nextInt(BOUND_FOR_PROGRESSION_GAME);
        for (int j = 0; j < MATRIX.length; j++) {
            MATRIX[j] = String.valueOf(randomNumber1);
            randomNumber1 += randomNumber2;
        }
    }
}
