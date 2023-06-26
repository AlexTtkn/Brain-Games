package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class ProgressionGame {
    private static final int BOUND_FOR_PROGRESSION_GAME = 10;
    private static final String PROGRESSION_GAME_QUESTION = "What number is missing in the progression?";

    public static void startProgressionGame() {
        String[][] progressionGameInfo = new String[Engine.COUNTER_OF_ROUNDS][2];
        for (int i = 0; i < progressionGameInfo.length; i++) {
            int randomNumber1 = Utils.getRandomInt(Engine.ONE, BOUND_FOR_PROGRESSION_GAME);
            int randomNumber2 = Utils.getRandomInt(Engine.ONE, BOUND_FOR_PROGRESSION_GAME);
            int pointsPosition = Utils.getRandomInt(Engine.ONE, BOUND_FOR_PROGRESSION_GAME) - Engine.ONE;
            String[] array = generateQuestion(randomNumber1, randomNumber2);
            String correctAnswer = array[pointsPosition];
            String gameQuestion = getQuestionToString(array, pointsPosition);
            progressionGameInfo[i][0] = gameQuestion;
            progressionGameInfo[i][1] = correctAnswer;
        }
        Engine.run(progressionGameInfo, PROGRESSION_GAME_QUESTION);
    }


    private static String getQuestionToString(String[] numbers, int numberToHide) {
        StringBuilder question = new StringBuilder();
        String points = "..";
        for (int i = 0; i < numbers.length; i++) {
            if (i == numberToHide) {
                question.append(points).append(" ");
            } else {
                question.append(numbers[i]).append(" ");
            }
        }
        return question.toString().trim();
    }

    private static String[] generateQuestion(int startNumber, int step) {
        String[] array = new String[BOUND_FOR_PROGRESSION_GAME];
        for (int j = 0; j < array.length; j++) {
            array[j] = String.valueOf(startNumber);
            startNumber += step;
        }
        return array;
    }
}
