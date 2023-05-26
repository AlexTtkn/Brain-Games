package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class ProgressionGame {
    private static final String[] MATRIX = new String[10];

    public static void progressionChoice() {
        String clientName = Engine.greetingsClient();
        System.out.println("What number is missing in the progression?");
        for (int i = 0; i < 3; i++) {
            int randomNumber1 = new Random().nextInt(10);
            int randomNumber2 = new Random().nextInt(10);
            for (int j = 0; j < MATRIX.length; j++) {
                MATRIX[j] = String.valueOf(randomNumber1);
                randomNumber1 += randomNumber2;
            }
            int pointsPosition = new Random().nextInt(10);
            String points = "..";
            String correctAnswer = MATRIX[pointsPosition];
            MATRIX[pointsPosition] = points;
            System.out.print("Question: ");
            printNumbers();
            String clientAnswer = Engine.checkCorrectAnswer(correctAnswer, clientName);
            if (!clientAnswer.equals(correctAnswer)) {
                Engine.wrongAnswer(clientAnswer, correctAnswer, clientName);
                break;
            }
        }
    }

    private static void printNumbers() {
        for (int i = 0; i < MATRIX.length; i++) {
            if (i == MATRIX.length - 1) {
                System.out.println(MATRIX[i]);
            } else {
                System.out.print(MATRIX[i] + ", ");
            }
        }
    }
}
