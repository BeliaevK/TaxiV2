package ru.GoldTaxi;

import ru.GoldTaxi.Entities.Car;
import ru.GoldTaxi.Entities.Order;
import ru.GoldTaxi.Utilities.CarSearch;
import ru.GoldTaxi.Utilities.Initialization;
import ru.GoldTaxi.Utilities.OrderReader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Scala on 13.11.2016.
 */
public class main {
    public static void main(String[] args) throws IOException {
        ArrayList<Car> carArrayList = Initialization.initCarArray();
/*        while (true) {*/
            Order order = OrderReader.getInstance().orderRead();
            CarSearch.searchFreeCar(carArrayList, order);
       /* }*/
    }
}
