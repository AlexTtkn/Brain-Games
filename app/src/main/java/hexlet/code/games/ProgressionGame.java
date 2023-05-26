package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Random;

public class ProgressionGame {
    public static void progressionChoice() {
        String clientName = Engine.greetingsClient();
        System.out.println("What number is missing in the progression?");
        for (int i = 0; i < 3; i++) {
            String[] matrix = new String[10];
            int randomNumber1 = new Random().nextInt(10);
            int randomNumber2 = new Random().nextInt(10);
            for (int j = 0; j < matrix.length; j++) {
                matrix[j] = String.valueOf(randomNumber1);
                randomNumber1 += randomNumber2;
            }
            int pointsPosition = new Random().nextInt(10);
            String points = "..";
            String correctAnswer = matrix[pointsPosition];
            matrix[pointsPosition] = points;
            System.out.println("Question: " + Arrays.toString(matrix));
            String clientAnswer = Engine.checkCorrectAnswer(correctAnswer, clientName);
            if (!clientAnswer.equals(correctAnswer)) {
                Engine.wrongAnswer(clientAnswer, correctAnswer, clientName);
                break;
            }
        }
    }
}
