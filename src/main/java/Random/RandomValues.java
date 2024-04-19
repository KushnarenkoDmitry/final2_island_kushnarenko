package Random;

import java.util.concurrent.ThreadLocalRandom;

public class RandomValues {
    public static int intRandomEat = ThreadLocalRandom.current().nextInt(100);
    public static int intRandomEatCoordinateX = ThreadLocalRandom.current().nextInt(1,3);
    public static int intRandomEatCoordinateY = ThreadLocalRandom.current().nextInt(1,3);
    public static boolean reproduceBool = ThreadLocalRandom.current().nextBoolean();

}
