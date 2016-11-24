package ru.GoldTaxi.Utilities;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by k.beliaev on 24.11.2016.
 */
public class MyResourseBundle {
    private ResourceBundle bundle;

    public MyResourseBundle(Locale locale) {
        bundle = ResourceBundle
                .getBundle("Bundle", locale);
    }


/*    public static ResourceBundle getBundle(){
        return ResourceBundle.getBundle("Bundle", locale);
    }*/

    public String getValue(String key) {
        return bundle.getString(key);
    }

}

