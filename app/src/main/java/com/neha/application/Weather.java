package com.neha.application;

public class Weather {
     public String temp;
     public int pressure;
     public int humidity;
     public String min_temp;
     public String max_temp;
     public int sunrise;
     public int sunset;
     public String name;

    public Weather() {

    }

    public Weather(String temp, int pressure, int humidity, String min_temp, String max_temp, int sunrise, int sunset, String name) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.sunrise = sunrise;
        this.sunrise = sunset;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temp='" + temp + '\'' +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", min_temp='" + min_temp + '\'' +
                ", max_temp='" + max_temp + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", name='" + name + '\'' +
                '}';
    }
}
