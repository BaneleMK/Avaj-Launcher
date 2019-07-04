package com.avaj.simulation;

import com.avaj.simulation.aircrafts.Coordinates;
import com.avaj.weatherprovider.*;

public class WeatherTower extends Tower{
    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather(){
        this.conditionsChanged();
    }
};