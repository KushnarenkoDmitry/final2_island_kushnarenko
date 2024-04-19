package Organism;

import Settings.Settings;
import World.Island;
import World.Location;
import entity.Plant;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Unit implements Cloneable {
    public double weightUnit;
    public double maxUnitPerLocation;
    public double speedMoveUnitByLocation;
    public double fullSaturation;


    public Unit() {
        weightUnit = Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexWeightUnit];
        maxUnitPerLocation = Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexMaxUnitPerLocation];
        speedMoveUnitByLocation = Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.integerSpeedMoveUnitByLocation];
        fullSaturation = Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexFullSaturation];
    }

    public boolean isHungry() {
        return this.weightUnit <= Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexWeightUnit];
    }

    public boolean eat(Unit unit) {
        Integer chance = Settings.CHARACTERISTICS_OF_EATING.get(this.getClass()).get(unit.getClass());
        int randomChance = ThreadLocalRandom.current().nextInt(100) + 1;
        if (chance >= randomChance) {
            this.weightUnit += Settings.CHARACTERISTICS_OF_ANIMALS.get(unit.getClass())[Settings.indexWeightUnit];
        }
        return chance >= randomChance;
    }

    public ArrayList<Integer> move(int x, int y, Island island) {
        int speed = (int) Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.integerSpeedMoveUnitByLocation];
        for (int i = 0; i < speed; i++) {
            int direction = ThreadLocalRandom.current().nextInt(speed);
            switch (direction) {
                case 1:
                    if (x - 1 >= 0) {
                        Location location = island.locations[x - 1][y];
                        ArrayList<Unit> units = location.mapAnimalsInLocation.get(this.getClass());
                        if (units != null && units.size() < Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexMaxUnitPerLocation]) {
                            x--;
                        }
                    }
                    break;
                case 2:
                    if (y - 1 >= 0) {
                        Location location = island.locations[x][y - 1];
                        ArrayList<Unit> units = location.mapAnimalsInLocation.get(this.getClass());
                        if (units != null && units.size() < Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexMaxUnitPerLocation]) {
                            y--;
                        }
                    }
                    break;
                case 3:
                    if (x + 1 < island.x) {
                        Location location = island.locations[x + 1][y];
                        ArrayList<Unit> units = location.mapAnimalsInLocation.get(this.getClass());
                        if (units != null && units.size() < Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexMaxUnitPerLocation]) {
                            x++;
                        }
                    }
                    break;
                case 4:
                    if (y + 1 < island.y) {
                        Location location = island.locations[x][y + 1];
                        ArrayList<Unit> units = location.mapAnimalsInLocation.get(this.getClass());
                        if (units != null && units.size() < Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexMaxUnitPerLocation]) {
                            y++;
                        }
                    }
                    break;
            }
        }
        return new ArrayList<>(Arrays.asList(x, y));
    }


//    public void toReproduce(Map<Class<? extends Unit>, ArrayList<Unit>> mapAnimalsInLocation) throws CloneNotSupportedException {
//        Set<Class<? extends Unit>> unitSetInLocation = mapAnimalsInLocation.keySet();
//        for (Class<? extends Unit> unitInLocation : unitSetInLocation) {
//            if (this.getClass().equals(unitInLocation)
////                    && mapAnimalsInLocation.get(this.getClass()).size()%2 == 0
//                    && this.weightUnit == this.weightUnit
//                    && mapAnimalsInLocation.get(this.getClass()).size()
//                    < Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexMaxUnitPerLocation]) {
//                ArrayList<Unit> oneSpecies = mapAnimalsInLocation.get(this.getClass());
//
//                oneSpecies.add((Unit) this.clone());
//
//            }
//        }
//
//    }
    public void toReproduce (Location location) throws CloneNotSupportedException {
        if (location.mapAnimalsInLocation.containsKey(this.getClass())){
            double[] carectUnit = Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass());
            double maxUnitInLocation = carectUnit[Settings.indexMaxUnitPerLocation];
            ArrayList<Unit> arrListThisUnits = location.mapAnimalsInLocation.get(this.getClass());
            boolean randomReproduce = new Random().nextBoolean();

            if (arrListThisUnits.size() >= 2
                    && arrListThisUnits.size() < maxUnitInLocation
                    && randomReproduce && !(this instanceof Plant)){
                ArrayList<Unit> oneSpecies = location.mapAnimalsInLocation.get(this.getClass());
                oneSpecies.add((Unit) this.clone());

            }
        }

    }
}



//   public ArrayList<Integer> move(int x, int y, Island island) {
//        int speed = (int) Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.integerSpeedMoveUnitByLocation];
//        for (int i = 0; i < speed; i++) {
//            // енам создать
//            int direction = ThreadLocalRandom.current().nextInt(speed);
//            switch (direction) {
//                case 1:
//                    if (x - 1 > 0) {// в лево///// ghfdh+1
//                        Location location = island.locations[x - 1][y];
//                        if (location.mapAnimalsInLocation.get(this.getClass()).size() < Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexMaxUnitPerLocation]) {
//                            x--;
//                            break;
//                        }
//
//                    }//LEFT
//                case 2:
//                    if (y - 1 > 0) {
//                        Location location = island.locations[x][y - 1];
//                        if (location.mapAnimalsInLocation.get(this.getClass()).size() < Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexMaxUnitPerLocation]) {
//                            y--;
//                            break;
//                        }
//                    }
//                case 3:
//                    if (x + 1 <= island.x) {
//                        Location location = island.locations[x + 1][y];
//                        if (location.mapAnimalsInLocation.get(this.getClass()).size() < Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexMaxUnitPerLocation]) {
//                            x++;
//                            break;
//                        }
//                    }
//                case 4:
//                    if (y + 1 <= island.y) {
//                        Location location = island.locations[x][y + 1];
//                        if (location.mapAnimalsInLocation.get(this.getClass()).size() < Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexMaxUnitPerLocation]) {
//                            x++;
//                            break;
//                        }
//                    }
//
//            }
//        }
//        return new ArrayList<Integer>(Arrays.asList(x, y));
//    }


//    public void eat(Map<Class<? extends Unit>, ArrayList<Unit>> mapAnimalsInLocation) {
//        Map<Class<? extends Unit>, Integer> edible = Settings.CHARACTERISTICS_OF_EATING.get(this.getClass());
//        for (Class<? extends Unit> unitInLocation : mapAnimalsInLocation.keySet()) {
//            for (Class<? extends Unit> whoIsEdibleHere : edible.keySet()) {
//                if (unitInLocation.equals(whoIsEdibleHere)) {
//
//                    if (RandomValues.intRandomEat <= Settings.CHARACTERISTICS_OF_EATING.get(this.getClass()).get(whoIsEdibleHere)) {
//                        ArrayList<Unit> edibleAnimals = mapAnimalsInLocation.get(whoIsEdibleHere);
//                        if (!edibleAnimals.isEmpty() && isHungry()) {
//                            edibleAnimals.remove(0);
//                            edibleAnimals = null;
//
//                            this.weightUnit += Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexFullSaturation];
//                            System.out.println(this.getClass().toString() + " Поел");
//                        }
//                    } else {
//                        System.out.println(this.toString() + " Не Поел");
//                    }
//                }
//
//            }
//        }
//    }
//    public void checkWeightAndDelete() {
//        if (weightUnit < (Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexWeightUnit] /2)) {
//
//            this = null;
//        }
//    }

//public ArrayList<Integer> move(int x, int y, Island island) {
//    int speed = (int) Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.integerSpeedMoveUnitByLocation];
//    for (int i = 0; i < speed; i++) {
//        int direction = ThreadLocalRandom.current().nextInt(speed);
//        switch (direction) {
//            case 1:
//                if (x - 1 > 0) {
//                    Location location = island.()[x - 1][y];
//                    // Ваши действия с объектом Location
//                    x--;
//                }
//                break; // Добавьте break, чтобы выходить из switch после каждого case
//            case 2:
//                if (y - 1 > 0) {
//                    // Ваши действия с объектом Location
//                    y--;
//                }
//                break;
//        }
//    }
//    return new ArrayList<>(Arrays.asList(x, y));
//}

//    public ArrayList<Integer> move(int x, int y,Island locations) {
//        int speed = (int)Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.integerSpeedMoveUnitByLocation];
//        for (int i = 0; i < speed; i++) {
//            // енам создать
//            int direction = ThreadLocalRandom.current().nextInt(speed);
//            switch (direction) {
//                case 1:
//                    if (x - 1 > 0) {// в лево///// ghfdh+1
//                       Location location = island.locations[x - 1][y];
//                       //если в этой локации не максимум этих юнитов то меняем координату
//                        x--;
//                    }//LEFT
//                case 2:
//                    if (y - 1 > 0) { y--;}//HI
//            }
//        }
//        return new ArrayList<Integer>(Arrays.asList(x,y));
//    }

