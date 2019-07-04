package com.avaj.simulation.aircrafts;
import com.avaj.simulation.WeatherTower;

public interface Flyable{
    public void updateConditions();

    public void registerTower(WeatherTower WeatherTower);
}