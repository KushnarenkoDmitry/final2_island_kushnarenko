package Settings;

import Organism.*;
import entity.*;

import java.util.*;

public class Settings {
    public static enum directionOfMove{
        LEFT,
        RIGHT,
        DOWN,
        UP
    }
    public static ArrayList<Class<? extends Unit>> sequenceAnimalEat = new ArrayList<>();
    static {
        Collections.addAll(sequenceAnimalEat, Bear.class, Eagle.class,Snake.class, Wolf.class, Fox.class, WildBoar.class,
                Mouse.class,Caterpillar.class, Horse.class, Deer.class, Rabbit.class, Goat.class, Sheep.class,Buffalo.class, Caterpillar.class);
    }

    public static final Map<Class<? extends Unit>, double[]> CHARACTERISTICS_OF_ANIMALS = new HashMap<>();

    static {
        CHARACTERISTICS_OF_ANIMALS.put(Bear.class, new double[]{500, 5, 2, 80});
        CHARACTERISTICS_OF_ANIMALS.put(Buffalo.class, new double[]{700, 10, 3, 100});
        CHARACTERISTICS_OF_ANIMALS.put(Caterpillar.class, new double[]{0.01, 1000, 0, 0});
        CHARACTERISTICS_OF_ANIMALS.put(Deer.class, new double[]{300, 20, 4, 50});
        CHARACTERISTICS_OF_ANIMALS.put(Duck.class, new double[]{1, 200, 4, 0.15});
        CHARACTERISTICS_OF_ANIMALS.put(Eagle.class, new double[]{6, 20, 3, 1});
        CHARACTERISTICS_OF_ANIMALS.put(Fox.class, new double[]{8, 30, 2, 2});
        CHARACTERISTICS_OF_ANIMALS.put(Goat.class, new double[]{60, 140, 3, 10});
        CHARACTERISTICS_OF_ANIMALS.put(Horse.class, new double[]{400, 20, 4, 60});
        CHARACTERISTICS_OF_ANIMALS.put(Mouse.class, new double[]{0.05, 500, 1, 0.01});
        CHARACTERISTICS_OF_ANIMALS.put(Rabbit.class, new double[]{2, 150, 2, 0.45});
        CHARACTERISTICS_OF_ANIMALS.put(Sheep.class, new double[]{70, 140, 3, 15});
        CHARACTERISTICS_OF_ANIMALS.put(Snake.class, new double[]{15, 30, 1, 3});
        CHARACTERISTICS_OF_ANIMALS.put(WildBoar.class, new double[]{400, 50, 2, 50});
        CHARACTERISTICS_OF_ANIMALS.put(Wolf.class, new double[]{50, 30, 3, 8});
        CHARACTERISTICS_OF_ANIMALS.put(Plant.class, new double[]{1, 200, 0, 0});
    }

    public static Integer indexWeightUnit = 0;
    public static Integer indexMaxUnitPerLocation = 1;
    public static Integer integerSpeedMoveUnitByLocation = 2;
    public static Integer indexFullSaturation = 3;

    public static final Map<Class<? extends Unit>, Map<Class<? extends Unit>, Integer>> CHARACTERISTICS_OF_EATING = new HashMap<>();

    public static final Map<Class<? extends Unit>, Integer> BEAR_CHARACTERISTICS_EAT = new HashMap<>();
    public static final Map<Class<? extends Unit>, Integer> BUFFALO_CHARACTERISTICS_EAT = new HashMap<>();
    public static final Map<Class<? extends Unit>, Integer> CATERPILLAR_CHARACTERISTICS_EAT = new HashMap<>();
    public static final Map<Class<? extends Unit>, Integer> DEER_CHARACTERISTICS_EAT = new HashMap<>();
    public static final Map<Class<? extends Unit>, Integer> DUCK_CHARACTERISTICS_EAT = new HashMap<>();
    public static final Map<Class<? extends Unit>, Integer> EAGLE_CHARACTERISTICS_EAT = new HashMap<>();
    public static final Map<Class<? extends Unit>, Integer> FOX_CHARACTERISTICS_EAT = new HashMap<>();
    public static final Map<Class<? extends Unit>, Integer> GOAT_CHARACTERISTICS_EAT = new HashMap<>();
    public static final Map<Class<? extends Unit>, Integer> HORSE_CHARACTERISTICS_EAT = new HashMap<>();
    public static final Map<Class<? extends Unit>, Integer> MOUSE_CHARACTERISTICS_EAT = new HashMap<>();
    public static final Map<Class<? extends Unit>, Integer> RABBIT_CHARACTERISTICS_EAT = new HashMap<>();
    public static final Map<Class<? extends Unit>, Integer> SHEEP_CHARACTERISTICS_EAT = new HashMap<>();
    public static final Map<Class<? extends Unit>, Integer> SNAKE_CHARACTERISTICS_EAT = new HashMap<>();
    public static final Map<Class<? extends Unit>, Integer> WILDBOAR_CHARACTERISTICS_EAT = new HashMap<>();
    public static final Map<Class<? extends Unit>, Integer> WOLF_CHARACTERISTICS_EAT = new HashMap<>();

    static {
        BEAR_CHARACTERISTICS_EAT.put(Snake.class, 80);
        BEAR_CHARACTERISTICS_EAT.put(Horse.class, 40);
        BEAR_CHARACTERISTICS_EAT.put(Deer.class, 80);
        BEAR_CHARACTERISTICS_EAT.put(Rabbit.class, 80);
        BEAR_CHARACTERISTICS_EAT.put(Mouse.class, 90);
        BEAR_CHARACTERISTICS_EAT.put(Goat.class, 70);
        BEAR_CHARACTERISTICS_EAT.put(Sheep.class, 70);
        BEAR_CHARACTERISTICS_EAT.put(WildBoar.class, 50);
        BEAR_CHARACTERISTICS_EAT.put(Buffalo.class, 20);
        BEAR_CHARACTERISTICS_EAT.put(Duck.class, 10);
        BUFFALO_CHARACTERISTICS_EAT.put(Plant.class, 100);
        CATERPILLAR_CHARACTERISTICS_EAT.put(Plant.class, 100);
        DEER_CHARACTERISTICS_EAT.put(Plant.class, 100);
        DUCK_CHARACTERISTICS_EAT.put(Caterpillar.class, 90);
        DUCK_CHARACTERISTICS_EAT.put(Plant.class, 100);
        EAGLE_CHARACTERISTICS_EAT.put(Fox.class, 10);
        EAGLE_CHARACTERISTICS_EAT.put(Rabbit.class, 90);
        EAGLE_CHARACTERISTICS_EAT.put(Mouse.class, 90);
        EAGLE_CHARACTERISTICS_EAT.put(Duck.class, 80);
        FOX_CHARACTERISTICS_EAT.put(Rabbit.class, 70);
        FOX_CHARACTERISTICS_EAT.put(Mouse.class, 90);
        FOX_CHARACTERISTICS_EAT.put(Duck.class, 60);
        FOX_CHARACTERISTICS_EAT.put(Caterpillar.class, 40);
        GOAT_CHARACTERISTICS_EAT.put(Plant.class, 100);
        HORSE_CHARACTERISTICS_EAT.put(Plant.class, 100);
        MOUSE_CHARACTERISTICS_EAT.put(Caterpillar.class, 90);
        MOUSE_CHARACTERISTICS_EAT.put(Plant.class, 100);
        RABBIT_CHARACTERISTICS_EAT.put(Plant.class, 100);
        SHEEP_CHARACTERISTICS_EAT.put(Plant.class, 100);
        SNAKE_CHARACTERISTICS_EAT.put(Fox.class, 15);
        SNAKE_CHARACTERISTICS_EAT.put(Rabbit.class, 20);
        SNAKE_CHARACTERISTICS_EAT.put(Mouse.class, 40);
        SNAKE_CHARACTERISTICS_EAT.put(Duck.class, 10);
        WILDBOAR_CHARACTERISTICS_EAT.put(Mouse.class, 50);
        WILDBOAR_CHARACTERISTICS_EAT.put(Caterpillar.class, 90);
        WILDBOAR_CHARACTERISTICS_EAT.put(Plant.class, 100);
        WOLF_CHARACTERISTICS_EAT.put(Horse.class, 10);
        WOLF_CHARACTERISTICS_EAT.put(Deer.class, 15);
        WOLF_CHARACTERISTICS_EAT.put(Rabbit.class, 60);
        WOLF_CHARACTERISTICS_EAT.put(Mouse.class, 80);
        WOLF_CHARACTERISTICS_EAT.put(Goat.class, 60);
        WOLF_CHARACTERISTICS_EAT.put(Sheep.class, 70);
        WOLF_CHARACTERISTICS_EAT.put(WildBoar.class, 15);
        WOLF_CHARACTERISTICS_EAT.put(Buffalo.class, 10);
        WOLF_CHARACTERISTICS_EAT.put(Duck.class, 40);
    }

    static {
        CHARACTERISTICS_OF_EATING.put(Bear.class, BEAR_CHARACTERISTICS_EAT);
        CHARACTERISTICS_OF_EATING.put(Caterpillar.class, CATERPILLAR_CHARACTERISTICS_EAT);
        CHARACTERISTICS_OF_EATING.put(Buffalo.class, BUFFALO_CHARACTERISTICS_EAT);
        CHARACTERISTICS_OF_EATING.put(Deer.class, DEER_CHARACTERISTICS_EAT);
        CHARACTERISTICS_OF_EATING.put(Duck.class, DUCK_CHARACTERISTICS_EAT);
        CHARACTERISTICS_OF_EATING.put(Eagle.class, EAGLE_CHARACTERISTICS_EAT);
        CHARACTERISTICS_OF_EATING.put(Fox.class, FOX_CHARACTERISTICS_EAT);
        CHARACTERISTICS_OF_EATING.put(Goat.class, GOAT_CHARACTERISTICS_EAT);
        CHARACTERISTICS_OF_EATING.put(Horse.class, HORSE_CHARACTERISTICS_EAT);
        CHARACTERISTICS_OF_EATING.put(Mouse.class, MOUSE_CHARACTERISTICS_EAT);
        CHARACTERISTICS_OF_EATING.put(Rabbit.class, RABBIT_CHARACTERISTICS_EAT);
        CHARACTERISTICS_OF_EATING.put(Sheep.class, SHEEP_CHARACTERISTICS_EAT);
        CHARACTERISTICS_OF_EATING.put(Snake.class, SNAKE_CHARACTERISTICS_EAT);
        CHARACTERISTICS_OF_EATING.put(WildBoar.class, WILDBOAR_CHARACTERISTICS_EAT);
        CHARACTERISTICS_OF_EATING.put(Wolf.class, WOLF_CHARACTERISTICS_EAT);
    }
}
//public enum Animals {
//    BEAR,
//    BUFFALO,
//    CATERPILLAR,
//    DEER,
//    DUCK,
//    EAGLE,
//    FOX,
//    GOAT,
//    HORSE,
//    MOUSE,
//    RABBIT,
//    SHEEP,
//    SNAKE,
//    WILDBOAR,
//    WOLF
//}
