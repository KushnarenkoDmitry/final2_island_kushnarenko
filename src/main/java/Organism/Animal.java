package Organism;

import Random.RandomValues;
import Settings.Settings;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

//@Getter
public abstract class Animal extends Unit implements Cloneable {}
//    public double weightUnit;
//    public double maxUnitPerLocation;
//    public double speedMoveUnitByLocation;
//    public double fullSaturation;
//
//
//    public Animal() {
//        weightUnit = Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexWeightUnit];
//        maxUnitPerLocation = Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexMaxUnitPerLocation];
//        speedMoveUnitByLocation = Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.integerSpeedMoveUnitByLocation];
//        fullSaturation = Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexFullSaturation];
//    }
//
//    private boolean isHungry() {
//        return this.weightUnit <= Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexWeightUnit];
//    }
//
//
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
////    public void checkWeightAndDelete() {
////        if (weightUnit < (Settings.CHARACTERISTICS_OF_ANIMALS.get(this.getClass())[Settings.indexWeightUnit] /2)) {
////
////            this = null;
////        }
////    }
//
//    public void move() {
//    }
//
//
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
//}
//    public void eat(Map<Class<? extends Unit>, ArrayList<Unit>> mapAnimalsInLocation) {
//        Map<Class<? extends Unit>, Integer> edible = Settings.CHARACTERISTICS_OF_EATING.get(this.getClass());
//        for (Class<? extends Unit> unitInLocation : mapAnimalsInLocation.keySet()) {
//            for (Class<? extends Unit> whoIsEdibleHere : edible.keySet()) {
//                if (unitInLocation.isInstance(whoIsEdibleHere)){
//                   mapAnimalsInLocation.get(whoIsEdibleHere).remove(whoIsEdibleHere);
//
//                }
//            }
//        }
//    }

//    public void setFullSaturation(double fullSaturation) {
//        this.fullSaturation = fullSaturation;
//    }
//    public void eat(Map<Class<? extends Unit>, ArrayList<Unit>> mapAnimalsInLocation) {
//        Map<Class<? extends Unit>, Integer> mapWhoCanEat = Settings.CHARACTERISTICS_OF_EATING.get(this.getClass());
//        //Integer percentageOfEating = mapWhoCanEat.get(unit);
//        Set<Class<? extends Unit>> unitInLocation = mapAnimalsInLocation.keySet();
//        for (Class<? extends Unit> inLocation : unitInLocation) {
//            for (Class<? extends Unit> isEdible : Settings.CHARACTERISTICS_OF_EATING.get(this.getClass()).keySet()) {
//                if (!isEdible.isInstance(inLocation)) {
//                } else {
//                    mapAnimalsInLocation.remove()
//                    isEdible = null;
//                }
//            }
//        }
//    }
//    public void eat(Map<Class<? extends Unit>, ArrayList<Unit>> mapAnimalsInLocation, Class<? extends Unit> unit) {
//        Map<Class<? extends Unit>, Integer> mapWhoCanEat = Settings.CHARACTERISTICS_OF_EATING.get(this.getClass());
//        Integer percentageOfEating = mapWhoCanEat.get(unit);
//        Set<Class<? extends Unit>> unitInLocation = mapAnimalsInLocation.keySet();
//        for (Class<? extends Unit> inLocation : unitInLocation) {
//            for (Class<? extends Unit> isEdible : Settings.CHARACTERISTICS_OF_EATING.get(this.getClass()).keySet()) {
//                if (!isEdible.isInstance(inLocation)) {
//                } else{
//                    unit = null;
//                }
//            }
//        }
//    }

//        for (Class<? extends Unit> inLocation : unitInLocation) {
//            for (Class<? extends Unit> eating : classes) {
//                if (inLocation instanceof ) ;
//
//            }
//
//        }




