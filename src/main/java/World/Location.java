package World;

import Organism.*;
import Settings.Settings;
import entity.Bear;
import entity.Buffalo;
import entity.Horse;
import entity.Plant;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Location {
    public static Random random = new Random();
    public Map<Class<? extends Unit>, ArrayList<Unit>> mapAnimalsInLocation = new HashMap<>();
    public static final Map<Class<? extends Unit>, double[]> maxUnitsPerLocation = Settings.CHARACTERISTICS_OF_ANIMALS;

    // Проверка присутствует ли данный юнит в локации или нет
    public boolean isPresenceOfUnitLocation(Unit unit) {
        return mapAnimalsInLocation.containsKey(unit.getClass());
    }
//    public boolean isPresenceOfUnitLocation(Class<? extends Animal> unitClass) {
//        return mapAnimalsInLocation.containsKey(unitClass);
//    }
    public boolean isPresenceOfUnitLocation(Class<? extends Unit> unitClass) {
        return mapAnimalsInLocation.containsKey(unitClass);
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
//    public boolean addUnitLocation(Unit unit) {
//        if (!isCanAddUnit(unit)) {
//            return false;
//        }
//        mapAnimalsInLocation.putIfAbsent(unit.getClass(), new ArrayList<>());
//        ArrayList<Unit> units = mapAnimalsInLocation.get(unit.getClass());
//        units.add(unit);
//        return true;
//    }
    public boolean addUnitLocation(Unit unit) {
        synchronized (mapAnimalsInLocation) {
            if (!isCanAddUnit(unit)) {
                return false;
            }
            mapAnimalsInLocation.putIfAbsent(unit.getClass(), new ArrayList<>());
            ArrayList<Unit> units = mapAnimalsInLocation.get(unit.getClass());
            units.add(unit);
            return true;
        }
    }


//    public void fillLocation() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        for (Class<? extends Unit> unit : Settings.CHARACTERISTICS_OF_ANIMALS.keySet()) {
//            double maxUnitQty = Settings.CHARACTERISTICS_OF_ANIMALS.get(unit)[Settings.indexMaxUnitPerLocation];
//            int newUnitQty = random.nextInt( (int) maxUnitQty / 3);
//            for (int i = 0; i < newUnitQty; i++) {
//                Unit newUnit = (Unit) Class.forName(unit.getName()).getConstructor().newInstance();
//                this.addUnitLocation(newUnit);
//            }
//
//        }
//    }
public void fillLocation() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(Settings.CHARACTERISTICS_OF_ANIMALS.size());

    for (Class<? extends Unit> unit : Settings.CHARACTERISTICS_OF_ANIMALS.keySet()) {
        executor.execute(() -> {
            try {
                double maxUnitQty = Settings.CHARACTERISTICS_OF_ANIMALS.get(unit)[Settings.indexMaxUnitPerLocation];
                int newUnitQty = random.nextInt((int) maxUnitQty / 3);
                for (int i = 0; i < newUnitQty; i++) {
                    Unit newUnit = (Unit) Class.forName(unit.getName()).getConstructor().newInstance();
                    this.addUnitLocation(newUnit);
                }
            } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    executor.shutdown();
    executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
}


    // Тестовый принт для себя
    public void print() {
        for (Class<? extends Unit> unit : mapAnimalsInLocation.keySet()) {
            System.out.println(mapAnimalsInLocation.get(unit).size());
        }

    }

    public boolean isEmpty() {
        return !mapAnimalsInLocation.isEmpty();
   //     for (Class<? extends Unit> unit : mapAnimalsInLocation.keySet())
     //       if (!mapAnimalsInLocation.get(unit).isEmpty()) {
      //          return true;
       //     }
     //   return false;
        // проверяет есть ли живые организмы
    }


}

