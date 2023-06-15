package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ProgressionGame {
    private static final int BOUND_FOR_PROGRESSION_GAME = 10;

    public static void start() {
        Map<String, String> storeResponses = new HashMap<>();
        for (int i = 0; i < Engine.COUNTER_OF_ROUNDS; i++) {
            String[] array = generateQuestion();
            String correctAnswer = hireCorrectNumber(array);
            String gameQuestion = "Question: " + printNumbers(array);
            storeResponses.put(gameQuestion, correctAnswer);
        }
        Engine.run(storeResponses);
    }

    private static String printNumbers(String[] numbers) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) {
                str.append(numbers[i]);
            } else {
                str.append(numbers[i]).append(" ");
            }
        }
        return str.toString();
    }

    private static String hireCorrectNumber(String[] numbers) {
        int pointsPosition = new Random().nextInt(BOUND_FOR_PROGRESSION_GAME);
        String points = "..";
        String correctAnswer = numbers[pointsPosition];
        numbers[pointsPosition] = points;
        return correctAnswer;
    }

    private static String[] generateQuestion() {
        int randomNumber1 = new Random().nextInt(BOUND_FOR_PROGRESSION_GAME);
        int randomNumber2 = new Random().nextInt(BOUND_FOR_PROGRESSION_GAME);
        String[] array = new String[BOUND_FOR_PROGRESSION_GAME];
        for (int j = 0; j < array.length; j++) {
            array[j] = String.valueOf(randomNumber1);
            randomNumber1 += randomNumber2;
        }
        return array;
    }
}
