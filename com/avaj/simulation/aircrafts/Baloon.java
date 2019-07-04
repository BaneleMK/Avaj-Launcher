package com.avaj.simulation.aircrafts;
import com.avaj.simulation.aircrafts.Aircraft;
import com.avaj.simulation.aircrafts.Flyable;
import com.avaj.simulation.*;

class Baloon extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    @Override
    public void updateConditions(){
        switch(weatherTower.getWeather(this.coordinates)){
            case "SUN":
                coordinates.setaddLongitude(2);
                coordinates.setaddHeight(4);
                LogOutput.getLogOut().put("Baloon#"+this.name+"("+this.id+"): Its sunny so lets fly high honey");
                break;
            case "RAIN":
                coordinates.setaddHeight(-5);
                LogOutput.getLogOut().put("Baloon#"+this.name+"("+this.id+"): its raining, i wish balloons had some cover");
                break;
            case "FOG":
                coordinates.setaddHeight(-3);
                LogOutput.getLogOut().put("Baloon#"+this.name+"("+this.id+"): im legally blind in this fog...im taking us down");
                break;
            case "SNOW":
                coordinates.setaddHeight(-15);
                LogOutput.getLogOut().put("Baloon#"+this.name+"("+this.id+"): Well thats the end for my height");
                break;
        }
        if (coordinates.getHeight() <= 0){
            this.weatherTower.unregister(this);
            LogOutput.getLogOut().put("Tower says: Baloon#"+this.name+"("+this.id+") Landing");
            LogOutput.getLogOut().put("Tower says: Baloon#"+this.name+"("+this.id+") unregistered from weather tower 😂");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        LogOutput.getLogOut().put("Tower says: Baloon#"+this.name+"("+this.id+") registered to weather tower");
    }
}

