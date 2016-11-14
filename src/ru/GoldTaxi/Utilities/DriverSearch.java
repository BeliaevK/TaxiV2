package ru.GoldTaxi.Utilities;



import ru.GoldTaxi.Entities.Driver;
import ru.GoldTaxi.Entities.Order;

import java.util.ArrayList;

/**
 * Created by k.beliaev on 14.11.2016.
 */
public class DriverSearch {
    private static DriverSearch instance;

    public static DriverSearch getInstance() {
        if (instance == null) {
            instance = new DriverSearch();
        }
        return instance;
    }

    public static Driver searchFreeDiver(ArrayList<Driver> driverArrayList, Order order) {
        Driver reservedDriver = null;
        for (Driver driver : driverArrayList) {
            if (DriverSearch.compareOrderToDriver(driver)) {
                reservedDriver = driver;
                reservedDriver.setDriverStatus(Driver.getTypeOfDriverStatusReserved());
                order.setDriverReserver(reservedDriver);
                break;
            }
        }
            if (reservedDriver == null) {
                return null;
            } else {
                return reservedDriver;
            }
    }

    private static boolean compareOrderToDriver(Driver driver) {
        boolean isSuitDriver = true;
        if (Driver.getTypeOfDriverStatusReserved().equals(driver.getDriverStatus())) isSuitDriver = false;
        return isSuitDriver;
    }
}
