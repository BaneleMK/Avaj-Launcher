package com.avaj.weatherprovider;

import com.avaj.simulation.aircrafts.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;

    private static String weather[] = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider(){

    }

    public static WeatherProvider getProvider(){
        if (weatherProvider == null){
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        return weather[(((coordinates.getLatitude()) % 4) + (coordinates.getLongitude() % 3) + ((coordinates.getHeight()) % 7)) % 4];
    }
}