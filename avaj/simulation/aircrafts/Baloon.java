package avaj.simulation.aircrafts;
import avaj.simulation.aircrafts.Aircraft;
import avaj.simulation.aircrafts.Flyable;
import avaj.simulation.*;

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
                System.out.println("Baloon#"+this.name+"("+this.id+"): Its sunny so lets fly high honey");
                break;
            case "RAIN":
                coordinates.setaddHeight(-5);
                System.out.println("Baloon#"+this.name+"("+this.id+"): its raining, i wish balloons had some cover");
                break;
            case "FOG":
                coordinates.setaddHeight(-3);
                System.out.println("Baloon#"+this.name+"("+this.id+"): im legally blind in this fog...im taking us down");
                break;
            case "SNOW":
                coordinates.setaddHeight(-15);
                System.out.println("Baloon#"+this.name+"("+this.id+"): Well thats the end for my height");
                break;
        }
        if (coordinates.getHeight() <= 0){
            this.weatherTower.unregister(this);
            System.out.println("Tower says: Baloon#"+this.name+"("+this.id+") Landing");
            System.out.println("Tower says: Baloon#"+this.name+"("+this.id+") unregistered from weather tower");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Baloon#"+this.name+"("+this.id+") registered to weather tower");
    }
}

