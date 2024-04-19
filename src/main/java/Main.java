import entity.Buffalo;
import entity.Plant;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CloneNotSupportedException, InterruptedException {
        StartLifeIsland startLifeIsland = new StartLifeIsland();
        startLifeIsland.startLife();
        System.out.println("День 1");
        startLifeIsland.startLifeCycle();
        for (int i = 2; i < 5; i++) {
            System.out.println("День " + i);
            startLifeIsland.lifeOneDay();
            startLifeIsland.startLifeCycle();
        }
//        Buffalo buffalo = new Buffalo();
//        Plant plant = new Plant();
//        System.out.println(buffalo.eat(plant));
//        System.out.println(buffalo.weightUnit);

    }
}
