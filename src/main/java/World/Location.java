package World;

import Organism.*;
import Settings.Settings;
import entity.Bear;
import entity.Buffalo;
import entity.Horse;
import entity.Plant;

import java.util.*;

public class Location {
    public Map<Class<? extends Unit>, ArrayList<Unit>> mapAnimalsInLocation = new HashMap<>();
    public static final Map<Class<? extends Unit>, double[]> maxUnitsPerLocation = Settings.CHARACTERISTICS_OF_ANIMALS;

    // Проверка присутствует ли данный юнит в локации или нет
    private boolean isPresenceOfUnitLocation(Unit unit) {
        return mapAnimalsInLocation.containsKey(unit.getClass());
    }
    // Проверка на возможность заполнения локации данным юнитов
    private boolean isCanAddUnit(Unit unit) {
        if (!isPresenceOfUnitLocation(unit)) {
            return true;
        } else {
            ArrayList<Unit> units = mapAnimalsInLocation.get(unit.getClass());
            double maxUnitsThisLocation = Settings.CHARACTERISTICS_OF_ANIMALS.get(unit.getClass())[Settings.indexMaxUnitPerLocation];
            return units.size() < maxUnitsThisLocation;
        }
    }


    // Добавление юнитов в локацию
    public boolean addUnitLocation(Unit unit) {
        if (!isCanAddUnit(unit)) {
            return false;
        }
        mapAnimalsInLocation.putIfAbsent(unit.getClass(), new ArrayList<>());
        ArrayList<Unit> units = mapAnimalsInLocation.get(unit.getClass());
        units.add(unit);
        return true;
    }
        // Тестовый принт для себя
    public void print() {
        for (Class<? extends Unit> unit : mapAnimalsInLocation.keySet()) {
            System.out.println(mapAnimalsInLocation.get(unit).size());
        }

    }


}

