package avaj.simulation.aircrafts;

import avaj.simulation.aircrafts.Flyable;
import avaj.simulation.aircrafts.Aircraft;
import avaj.simulation.WeatherTower;

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
                System.out.println("Helicopter#"+this.name+"("+this.id+"): Time to roll with the sun");
                break;
            case "RAIN":
                coordinates.setaddHeight(5);
                System.out.println("Helicopter#"+this.name+"("+this.id+"): Whats Rain? ill chop it with my blades. up we go");
                break;
            case "FOG":
                coordinates.setaddHeight(1);
                System.out.println("Helicopter#"+this.name+"("+this.id+"): What is this Fog thing? i cant see it. let me go up just a bit");
                break;
            case "SNOW":
                coordinates.setaddHeight(-12);
                System.out.println("Helicopter#"+this.name+"("+this.id+"): Oh i know snow...yep you cant chop that, time to fly low");
                break;
                
        }
        if (coordinates.getHeight() <= 0){
            this.weatherTower.unregister(this);
            System.out.println("Tower says: Helicopter#"+this.name+"("+this.id+") Landing");
            System.out.println("Tower says: Helicopter#"+this.name+"("+this.id+") unregistered from weather tower");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Helicopter#"+this.name+"("+this.id+") registered to weather tower");
    }
};