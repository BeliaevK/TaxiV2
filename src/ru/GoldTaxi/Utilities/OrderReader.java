package ru.GoldTaxi.Utilities;

import ru.GoldTaxi.Entities.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ru.GoldTaxi.Utilities.MyLocale.*;

/**
 * Created by Scala on 13.11.2016.
 */
public class OrderReader {

    private static OrderReader instance;
    MyResourseBundle myBundle = new MyResourseBundle(getLocale(findLocale()));

    public OrderReader() throws IOException {
    }


    public static OrderReader getInstance() throws IOException {
        if (instance == null) {
            instance = new OrderReader();
        }
        return instance;
    }

    public  Order orderRead() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Order order = null;
        boolean isCorrectOrder = false;
        while (!isCorrectOrder) {
            String orderText = reader.readLine();
            String[] orderField = orderText.split("\\|");
            if (checkOrderFieldsIsCorrect(orderField)) {
                try {
                    switch (orderField.length) {
                        case 2:
                            order = new Order(orderField[0], orderField[1], false, false, 0);
                            break;
                        case 5:
                            order = new Order(orderField[0], orderField[1], Boolean.parseBoolean(orderField[2]),
                                    Boolean.parseBoolean(orderField[3]), Integer.parseInt(orderField[4]));
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(myBundle.getValue("appointed"));
                }
            }
                     else {
                            System.out.println(myBundle.getValue("appointed"));
                        }
                        if (order != null) isCorrectOrder = true;
                    }
                    return order;
                }

    private static boolean checkOrderFieldsIsCorrect(String[] orderText) {
        boolean isCorrect = true;
        if (orderText.length < 1 | orderText.length == 3 | orderText.length == 4) isCorrect = false;
        try {
            if (orderText[0].length() == 0 | orderText[1].length() == 0) isCorrect = false;
        } catch (NumberFormatException e) {
            isCorrect = false;
        } catch (ArrayIndexOutOfBoundsException e) {
            isCorrect = false;
        }
        return isCorrect;
    }
}
