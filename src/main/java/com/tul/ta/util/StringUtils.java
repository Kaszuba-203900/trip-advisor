package com.tul.ta.util;

public class StringUtils {
    public static String getCityName(String cityName) {
        String arr[];
        if (cityName.contains("/")) {
            arr = cityName.split("/", 2);
            return arr[0];
        }
        if (cityName.contains(" ")) {
            arr = cityName.split(" ", 2);
            return arr[0];
        } else {
            return cityName;
        }
    }
}
