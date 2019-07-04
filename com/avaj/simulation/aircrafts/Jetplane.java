package com.avaj.simulation.aircrafts;
import com.avaj.simulation.aircrafts.Flyable;
import com.avaj.simulation.aircrafts.Aircraft;
import com.avaj.simulation.*;

class JetPlane extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    @Override
    public void updateConditions(){
        switch(weatherTower.getWeather(this.coordinates)){
            case "SUN":
                coordinates.setaddLatitude(10);
                coordinates.setaddHeight(2);
                LogOutput.getLogOut().put("JetPlane#"+this.name+"("+this.id+"): Weather is sunny HOT so passengers stay cool");
                break;
            case "RAIN":
                coordinates.setaddLatitude(5);
                LogOutput.getLogOut().put("JetPlane#"+this.name+"("+this.id+"): Weather is rainy so...yeah we're getting wet");
                break;
            case "FOG":
                coordinates.setaddLatitude(1);
                LogOutput.getLogOut().put("JetPlane#"+this.name+"("+this.id+"): Weather is foggy so if you cant see a thing...yikes well your blind");
                break;
            case "SNOW":
                coordinates.setaddHeight(-7);
                LogOutput.getLogOut().put("JetPlane#"+this.name+"("+this.id+"): Weather is ..snowy? Yeah folks i cant keep cool in this weather im landing us in panic");
                break;
        }
        if (coordinates.getHeight() <= 0){
            this.weatherTower.unregister(this);
            LogOutput.getLogOut().put("Tower says: JetPlane#"+this.name+"("+this.id+") Landing");
            LogOutput.getLogOut().put("Tower says: JetPlane#"+this.name+"("+this.id+") unregistered from weather tower 😂");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        LogOutput.getLogOut().put("Tower says: Jetplane#"+this.name+"("+this.id+") registered to weather tower");
    }
};

