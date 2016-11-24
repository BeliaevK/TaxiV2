package ru.GoldTaxi.Entities;

import ru.GoldTaxi.Utilities.MyLocale;
import ru.GoldTaxi.Utilities.MyResourseBundle;

import java.io.IOException;

/**
 * Created by Scala on 13.11.2016.
 */
public class Driver {
    private String name;
    private String telephone;
    private String driverStatus;
    private static final String TYPE_OF_DRIVER_STATUS_FREE = "Свободен";
    private static final String TYPE_OF_DRIVER_STATUS_RESERVED = "Занят";
  //  private MyResourseBundle myBundle = new MyResourseBundle(MyLocale.getLocale(MyLocale.findLocale()));

    public Driver (String name, String telephone, String driverStatus) throws IOException {
        this.name = name;
        this.telephone = telephone;
        this.setDriverStatus(driverStatus);
    }

    public static String getTypeOfDriverStatusFree() {
        return TYPE_OF_DRIVER_STATUS_FREE;
    }

    public static String getTypeOfDriverStatusReserved() {
        return TYPE_OF_DRIVER_STATUS_RESERVED;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }

    @Override
    public String toString() {
        return this.name + ", " + /*myBundle.getValue("telephone") +*/": " + this.telephone;
    }



}
