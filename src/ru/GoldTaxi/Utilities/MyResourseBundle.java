package ru.GoldTaxi.Utilities;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by k.beliaev on 24.11.2016.
 */
public class MyResourseBundle {


    public static ResourceBundle getBundle() throws IOException {
        return ResourceBundle.getBundle("Bundle", MyLocale.getLocale());
    }
}
