package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;
import java.util.Map;

public class EvenGame {
    private static final int BOUND_FOR_EVEN_GAME = 1000;
    private static final String EVEN_GAME_QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void start() {
        Map<String, String> questionsAndAnswers = new HashMap<>();
        for (int i = 0; i < Engine.COUNTER_OF_ROUNDS; i++) {
            int randomNumber = Utils.getRandomInt(Engine.ADDITIONAL_ONE, BOUND_FOR_EVEN_GAME);
            String correctAnswer = getCorrectAnswer(randomNumber) ? "yes" : "no";
            String gameQuestion = "Question: " + randomNumber;
            questionsAndAnswers.put(gameQuestion, correctAnswer);
        }
        Engine.run(questionsAndAnswers, EVEN_GAME_QUESTION);
    }

    private static boolean getCorrectAnswer(int num1) {
        return num1 % 2 == 0;
    }
}
