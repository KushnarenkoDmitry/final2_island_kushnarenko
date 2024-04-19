

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CloneNotSupportedException, InterruptedException {
        StartLifeIsland startLifeIsland = new StartLifeIsland();
        startLifeIsland.startLife();
        System.out.println("##### День 1 ##### \n");
        startLifeIsland.startLifeCycle();
        for (int i = 2; i < 5; i++) {
            System.out.println("\n\n##### День " + i + " #####");
            startLifeIsland.lifeOneDay();
            startLifeIsland.startLifeCycle();
        }

    }
}
