package ru.GoldTaxi;

import ru.GoldTaxi.Entities.Car;
import ru.GoldTaxi.Entities.Driver;
import ru.GoldTaxi.Entities.Order;
import ru.GoldTaxi.Utilities.CarSearch;
import ru.GoldTaxi.Utilities.DriverSearch;
import ru.GoldTaxi.Utilities.Initialization;
import ru.GoldTaxi.Utilities.OrderReader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Scala on 13.11.2016.
 */
public class main {
    public static void main(String[] args) throws IOException {
        Initialization initialization = Initialization.getInstance();
        ArrayList<Car> carArrayList = initialization.initCarArray();
        ArrayList<Driver> driverArrayList = initialization.initDriverArray();
        while (true) {
            Order order = OrderReader.getInstance().orderRead();
            Car reservedCar = CarSearch.getInstance().searchFreeCar(carArrayList, order);
            Driver reservedDriver = DriverSearch.getInstance().searchFreeDiver(driverArrayList, order);
            if (reservedCar == null | reservedDriver == null){
               System.out.println("В данный момент нет подходящего автомобиля, попробуйте позже.");
            } else {
            System.out.println("Вам назначена: "+ reservedCar + ", " + reservedDriver);
            }
        }
    }
}
