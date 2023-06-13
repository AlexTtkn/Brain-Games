package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ProgressionGame {
    private static final int BOUND_FOR_PROGRESSION_GAME = 10;
    private static final String[] MATRIX = new String[BOUND_FOR_PROGRESSION_GAME];

    public static void startProgression() {
        System.out.println("What number is missing in the progression?");
        Map<String, String> storeResponses = new HashMap<>();
        for (int i = 0; i < Engine.COUNTER_OF_ROUNDS; i++) {
            generateQuestion();
            String correctAnswer = hireCorrectNumber();
            String gameQuestion = "Question: " + printNumbers();
            storeResponses.put(gameQuestion, correctAnswer);
        }
        Engine.run(storeResponses);
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
