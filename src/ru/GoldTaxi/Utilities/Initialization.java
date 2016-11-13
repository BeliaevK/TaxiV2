package ru.GoldTaxi.Utilities;

import ru.GoldTaxi.Entities.Car;
import ru.GoldTaxi.Entities.Driver;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Scala on 13.11.2016.
 */
public class Initialization {
    public static ArrayList<Car> initCarArray() {
        Random rdm = new Random();
        ArrayList<Driver> driverArray = new ArrayList<Driver>();
        ArrayList<Car> carArray = new ArrayList<Car>();
        for (int i = 0; i < 10; i++) {
            driverArray.add(new Driver("Водитель" + " " + (i+1), "884825050" + i));
        }
        for (int i = 0; i < 10; i++) {
            carArray.add(new Car("Автомобиль" + " " + (i+1), driverArray.get(i), "AA " + rdm.nextInt(999) + " A 163",
                    rdm.nextBoolean(), rdm.nextBoolean(), Car.getTypeOfClassEconomic(),
                    Car.getTypeOfStatusFree()));
        }
        return carArray;
    }
}
