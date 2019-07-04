package com.avaj.simulation.aircrafts;
import com.avaj.simulation.aircrafts.Flyable;
import com.avaj.simulation.aircrafts.Aircraft;
import com.avaj.simulation.*;

class Helicopter extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    @Override
    public void updateConditions(){
        switch(weatherTower.getWeather(this.coordinates)){
            case "SUN":
                coordinates.setaddLongitude(10);
                coordinates.setaddHeight(2);
                LogOutput.getLogOut().put("Helicopter#"+this.name+"("+this.id+"): Time to roll with the sun");
                break;
            case "RAIN":
                coordinates.setaddLongitude(5);
                LogOutput.getLogOut().put("Helicopter#"+this.name+"("+this.id+"): Whats Rain? ill chop it with my blades. up we go");
                break;
            case "FOG":
                coordinates.setaddLongitude(1);
                LogOutput.getLogOut().put("Helicopter#"+this.name+"("+this.id+"): What is this Fog thing? i cant see it. let me go up just a bit");
                break;
            case "SNOW":
                coordinates.setaddHeight(-12);
                LogOutput.getLogOut().put("Helicopter#"+this.name+"("+this.id+"): Oh i know snow...yep you cant chop that, time to fly low");
                break;
                
        }
        if (coordinates.getHeight() <= 0){
            this.weatherTower.unregister(this);
            LogOutput.getLogOut().put("Tower says: Helicopter#"+this.name+"("+this.id+") Landing");
            LogOutput.getLogOut().put("Tower says: Helicopter#"+this.name+"("+this.id+") unregistered from weather tower 😂");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        LogOutput.getLogOut().put("Tower says: Helicopter#"+this.name+"("+this.id+") registered to weather tower");
    }
};