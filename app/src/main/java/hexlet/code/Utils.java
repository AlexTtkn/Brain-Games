package hexlet.code;

import java.util.Random;

public class Utils {
    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + Engine.ADDITIONAL_ONE) + min;
    }
    public static int getRandomInt(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
}
