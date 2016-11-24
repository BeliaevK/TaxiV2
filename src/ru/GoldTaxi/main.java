package ru.GoldTaxi;

import ru.GoldTaxi.Entities.Car;
import ru.GoldTaxi.Entities.Driver;
import ru.GoldTaxi.Entities.Order;
import ru.GoldTaxi.Utilities.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Scala on 13.11.2016.
 */
public class main {
    public static void main(String[] args) throws IOException {

        Locale locale = MyLocale.getLocale();
     //   ResourceBundle resourceBundle = MyResourseBundle.getBundle();
        Initialization initialization = Initialization.getInstance();
        ArrayList<Car> carArrayList = initialization.initCarArray();
        ArrayList<Driver> driverArrayList = initialization.initDriverArray();
        while (true) {
            Order order = OrderReader.getInstance().orderRead();
            Car reservedCar = CarSearch.getInstance().searchFreeCar(carArrayList, order);
            Driver reservedDriver = DriverSearch.getInstance().searchFreeDiver(driverArrayList, order);
            if (reservedCar == null | reservedDriver == null){
               System.out.println(MyResourseBundle.getBundle().getString("notfoundcar"));
            } else {
            System.out.println(MyResourseBundle.getBundle().getString("appointed") + ": "+ reservedCar + ", " + reservedDriver);
            }
        }
    }
}
