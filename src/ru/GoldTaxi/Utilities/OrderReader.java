package ru.GoldTaxi.Utilities;

import ru.GoldTaxi.Entities.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Scala on 13.11.2016.
 */
public class OrderReader {

    private static OrderReader instance;

    public static OrderReader getInstance() {
        if (instance == null) {
            instance = new OrderReader();
        }
        return instance;
    }

    public static Order orderRead() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Order order = null;
        boolean isCorrectOrder = false;
        while (!isCorrectOrder) {
            String s = reader.readLine();
            String[] sSplit = s.split("\\|");
            if (checkOrderFieldsIsCorrect(sSplit)) {
                if (sSplit.length == 2) {
                    order = new Order(sSplit[0], sSplit[1], false, false, 0);
            } else
                    try {
                        if (sSplit.length == 5)
                            order = new Order(sSplit[0], sSplit[1], Boolean.parseBoolean(sSplit[2]), Boolean.parseBoolean(sSplit[3]),
                                    Integer.parseInt(sSplit[4]));
                    }catch (NumberFormatException e){
                        System.out.println("Неверный формат заявки. Пример: \n 1) Начальная улица|Конечная улица " +
                                "\n 2) Начальная улица|Конечная улица|0|0|0");
                    }
            } else {
                System.out.println("Неверный формат заявки. Пример: \n 1) Начальная улица|Конечная улица " +
                        "\n 2) Начальная улица|Конечная улица|0|0|0");
            }
            if (order != null) isCorrectOrder = true;
        }
        return order;
    }
    private static boolean checkOrderFieldsIsCorrect(String[] sSplit) {
        boolean isCorrect = true;
        if (sSplit.length < 1) isCorrect = false;
        if (sSplit.length == 3) isCorrect = false;
        if (sSplit.length == 4) isCorrect = false;
        try {
            if (sSplit[0].length() == 0) isCorrect = false;
            if (sSplit[1].length() == 0) isCorrect = false;
        } catch (NumberFormatException e) {
            isCorrect = false;
        } catch (ArrayIndexOutOfBoundsException e) {
            isCorrect = false;
        }
        return isCorrect;
    }
}
