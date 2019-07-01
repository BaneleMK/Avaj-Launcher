package avaj.simulation;

import avaj.weatherprovider.*;

public class WeatherTower extends Tower{
    public String getWeather(){
        return WeatherProvider.getWeather;
    }

    private void changeWeather(){
        //this.conditionsChanged();
        // do some change weather stuff, help?
    }
};