import Organism.Animal;
import Organism.Unit;
import Settings.Settings;
import World.Island;
import World.Location;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StartLifeIsland {
    Island island = new Island();

    public void startLife() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, InterruptedException {
        this.island.fillIsland();

    }

    public void startLifeCycle() {
        printIslandInfo();
    }

    public void lifeOneDay() throws CloneNotSupportedException {
        eatAllAnimals();
        toReproduceAllAnimals();
        moveAllAnimals();
        // updateAnimals();// отнимаю у животных вес проверяю вес если 0 удаляю с локации
        //return isGameOver();
    }

    public void updateAnimals() {

    }

    public void toReproduceAllAnimals() throws CloneNotSupportedException {
        for (int i = 0; i < island.x; i++) {
            for (int j = 0; j < island.y; j++) {
                Location location = island.locations[i][j];
                Set<Class<? extends Unit>> classesAtTheLocation = new HashSet<>(location.mapAnimalsInLocation.keySet());
                for (Class<? extends Unit> unitClass : classesAtTheLocation){
                    ArrayList<Unit> units = new ArrayList<>(location.mapAnimalsInLocation.get(unitClass));
                    for (Unit reproduceUnit : units){
                        reproduceUnit.toReproduce(location);
                    }
                }
            }
        }
    }
    public void moveAllAnimals() {
        for (int i = 0; i < island.x; i++) {
            for (int j = 0; j < island.y; j++) {
                Location location = island.locations[i][j];
                for (Map.Entry<Class<? extends Unit>, ArrayList<Unit>> entry : new ArrayList<>(location.mapAnimalsInLocation.entrySet())) {
                    // Class<? extends Unit> unitClass = entry.getKey();
                    ArrayList<Unit> units = entry.getValue();
                    for (Unit unit : new ArrayList<>(units)) {
                        ArrayList<Integer> arrCoord = unit.move(i, j, island);
                        int x = arrCoord.get(0);
                        int y = arrCoord.get(1);
                        Location locationTo = island.locations[x][y];
                        locationTo.addUnitLocation(unit);
                        units.remove(unit);
                    }
                }
            }
        }
    }


    public void eatAllAnimals() {
        for (int i = 0; i < island.x; i++) {
            for (int j = 0; j < island.y; j++) {
                Location location = island.locations[i][j];
                for (Class<? extends Unit> animal : Settings.sequenceAnimalEat) {
                    if (!location.isPresenceOfUnitLocation(animal)) {
                        continue;
                    }
                    Set<Class<? extends Unit>> setEdibleAnimals = Settings.CHARACTERISTICS_OF_EATING.get(animal).keySet();
                    for (Unit unit : new ArrayList<>(location.mapAnimalsInLocation.get(animal))) {
                        for (Class<? extends Unit> edibleUnit : setEdibleAnimals) {
                            if (!location.isPresenceOfUnitLocation(edibleUnit)) {
                                continue;
                            }
                            ArrayList<Unit> arrUnits = new ArrayList<>(location.mapAnimalsInLocation.get(edibleUnit));
                            for (Unit currentUnit : arrUnits) {
                                if (!unit.isHungry()) {
                                    break;
                                }
                                if (unit.eat(currentUnit)) {
                                    location.mapAnimalsInLocation.get(currentUnit.getClass()).remove(currentUnit);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void printIslandInfo() {
        for (int i = 0; i < island.x; i++) {
            for (int j = 0; j < island.y; j++) {
                Location location = island.locations[i][j];
                Set<Class<? extends Unit>> whoInLocation = location.mapAnimalsInLocation.keySet();
                System.out.println("\nВ локации " + i + "-" + j + "\n");

                for (Class<? extends Unit> unitClass : whoInLocation) {
                    System.out.print(unitClass.getSimpleName() + " " + location.mapAnimalsInLocation.get(unitClass).size() + " " + "\n");
                }
            }
        }
    }
}
