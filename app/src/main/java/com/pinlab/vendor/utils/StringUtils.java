package com.pinlab.vendor.utils;


/**
 * Created by kalyan pvs on 26-Oct-16.
 */

public class StringUtils {


    public static String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }
}