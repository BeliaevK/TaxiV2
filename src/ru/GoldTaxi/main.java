package ru.GoldTaxi;

import ru.GoldTaxi.Entities.Car;
import ru.GoldTaxi.Entities.Order;
import ru.GoldTaxi.Utilities.CarSearch;
import ru.GoldTaxi.Utilities.Initialization;
import ru.GoldTaxi.Utilities.MyResourseBundle;
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
        while (true) {
            Order order = OrderReader.getInstance().orderRead();
            Car reservedCar = CarSearch.getInstance().searchFreeCar(carArrayList, order);
            if (reservedCar == null){
               System.out.println(MyResourseBundle.getBundle().getString("notfoundcar"));
            } else {
            System.out.println(MyResourseBundle.getBundle().getString("appointed") + ": "+ reservedCar);
            }
        }
    }
}
