package ru.GoldTaxi.Utilities;

import ru.GoldTaxi.Entities.Car;
import ru.GoldTaxi.Entities.Driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Scala on 13.11.2016.
 */
public class Initialization {

    private static Initialization instance;

    public static Initialization getInstance() {
        if (instance == null) {
            instance = new Initialization();
        }
        return instance;
    }

    public static ArrayList<Car> initCarArray() throws IOException {
        Random rdm = new Random();
        ArrayList<Car> carArray = new ArrayList<Car>();
        for (int i = 0; i < 10; i++) {
            carArray.add(new Car(MyResourseBundle.getBundle() + " " + (i+1), "AA " + rdm.nextInt(999) + " A 163",
                    rdm.nextBoolean(), rdm.nextBoolean(), Car.getTypeOfClassEconomic(),
                    Car.getTypeOfCarStatusFree()));
        }
        return carArray;
    }

    public static ArrayList<Driver> initDriverArray() throws IOException {
        ArrayList<Driver> driverArray = new ArrayList<Driver>();
        for (int i = 0; i < 10; i++) {
            driverArray.add(new Driver(MyResourseBundle.getBundle() + " " + (i+1), "884825050" + i,Driver.getTypeOfDriverStatusFree()));
        }
        return driverArray;
    }
}
