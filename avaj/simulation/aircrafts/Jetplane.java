package avaj.simulation.aircrafts;
import avaj.simulation.aircrafts.Flyable;
import avaj.simulation.aircrafts.Aircraft;
import avaj.simulation.*;

class JetPlane extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    @Override
    public void updateConditions(){
        switch(weatherTower.getWeather()){
            case "SUN":
                coordinates.setaddLongitude(10);
                coordinates.setaddHeight(2);
                System.out.println("JetPlane#"+this.name+"("+this.id+") Weather is sunny HOT so passengers stay cool");
                break;
            case "RAIN":
                coordinates.setaddHeight(5);
                System.out.println("JetPlane#"+this.name+"("+this.id+") Weather is rainy so...yeah we're getting wet");
                break;
            case "FOG":
                coordinates.setaddHeight(1);
                System.out.println("JetPlane#"+this.name+"("+this.id+") Weather is foggy so if you cant see a thing...yikes well your blind");
                break;
            case "SNOW":
                coordinates.setaddHeight(-7);
                System.out.println("JetPlane#"+this.name+"("+this.id+") Weather is ..snowy? Yeah folks i cant keep cool in this weather im landing us in panic");
                break;
        }
        if (coordinates.getHeight() <= 0){
            this.weatherTower.unregister(this);
            System.out.println("Tower says: Baloon#"+this.name+"("+this.id+") unregistered from weather tower");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Jetplane#"+this.name+"("+this.id+") registered to weather tower");
    }
};

