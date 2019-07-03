package avaj.simulation;

import avaj.simulation.aircrafts.Coordinates;
import avaj.weatherprovider.*;

public class WeatherTower extends Tower{
    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather(){
        this.conditionsChanged();
    }
};