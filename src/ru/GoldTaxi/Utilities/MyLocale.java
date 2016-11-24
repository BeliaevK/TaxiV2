package ru.GoldTaxi.Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * Created by k.beliaev on 24.11.2016.
 */
public class MyLocale {

    public static Locale getLocale() throws IOException {
        System.out.println("Select your language: 'en' or 'ru'");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s =reader.readLine();
        if (s.equals("en"))
            return new Locale("en","Us");
        else if (s.equals("ru")) {
            return new Locale("en", "Us");
        }
    return null;
    }
}
