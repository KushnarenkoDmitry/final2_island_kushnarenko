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

