package com.tul.ta.model.weather;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Weather {

    private int lowTemperature;
    private int highTemperature;
    private String description;
    private String date;

    public Weather() {
    }

    public Weather(int lowTemperature, int highTemperature, String description, Date date) {
        this.lowTemperature = lowTemperature;
        this.highTemperature = highTemperature;
        this.description = description;
        this.date = new SimpleDateFormat("yyyyMMdd").format(date);
    }

    public int getLowTemperature() {
        return lowTemperature;
    }

    public void setLowTemperature(int lowTemperature) {
        this.lowTemperature = lowTemperature;
    }

    public int getHighTemperature() {
        return highTemperature;
    }

    public void setHighTemperature(int highTemperature) {
        this.highTemperature = highTemperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "[" + date + "] " + description + " lowest temperature: " + lowTemperature + " Highest temperature: " + highTemperature;
    }
}
