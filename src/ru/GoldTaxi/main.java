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
        Initialization.getInstance();
        OrderReader.getInstance();
        CarSearch.getInstance();
        DriverSearch.getInstance();
        ArrayList<Car> carArrayList = Initialization.initCarArray();
        ArrayList<Driver> driverArrayList = Initialization.initDriverArray();
        while (true) {
            Order order = OrderReader.orderRead();
            Car reservedCar = CarSearch.searchFreeCar(carArrayList, order);
            Driver reservedDriver = DriverSearch.searchFreeDiver(driverArrayList, order);
            if (reservedCar == null | reservedDriver == null){
               System.out.println("В данный момент нет подходящего автомобиля, попробуйте позже.");
            } else {
            System.out.println("Вам назначена: "+ reservedCar + ", " + reservedDriver);
            }
        }
    }
}
