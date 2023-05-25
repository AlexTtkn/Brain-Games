package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ProgressionGame implements Engine {
    private static String correctAnswer;

    private static String getCorrectAnswer() {
        return correctAnswer;
    }

    private static void setCorrectAnswer(String correctAnswer) {
        ProgressionGame.correctAnswer = correctAnswer;
    }

    public static void progressionChoice() {
        Scanner scanner = new Scanner(System.in);
        String clientName = Engine.greetingsClient();
        System.out.println("What number is missing in the progression?");
        int answersCount = 0;
        while (true) {
            System.out.println(new ProgressionGame().getQuestion());
            String clientAnswer = scanner.nextLine();
            if (clientAnswer.equals(getCorrectAnswer())) {
                System.out.printf("Your answer: %s \nCorrect!\n", clientAnswer);
                answersCount++;
                if (answersCount == 3) {
                    System.out.printf("Congratulations, %s\n", clientName);
                    break;
                }
            } else {
                ProgressionGame progressionGame = new ProgressionGame();
                progressionGame.wrongAnswer(clientAnswer, getCorrectAnswer(), clientName);
                break;
            }
        }
    }

    @Override
    public void wrongAnswer(String wrongAnswer, String rightAnswer, String clientName) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'. \n",
                wrongAnswer, rightAnswer);
        System.out.printf("Let's try again, %s\n", clientName);
    }

    @Override
    public String getQuestion() {
        String[] matrix = new String[10];
        int randomNumber1 = new Random().nextInt(10);
        int randomNumber2 = new Random().nextInt(10);
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = String.valueOf(randomNumber1);
            randomNumber1 += randomNumber2;
        }
        int pointsPosition = new Random().nextInt(10);
        String points = "..";
        setCorrectAnswer(matrix[pointsPosition]);
        matrix[pointsPosition] = points;
        return "Question: " + Arrays.toString(matrix);

    }
}
