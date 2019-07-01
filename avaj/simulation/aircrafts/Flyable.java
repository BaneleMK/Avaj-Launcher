package avaj.simulation.aircrafts;
import avaj.simulation.WeatherTower;

public interface Flyable{
    public void updateConditions();

    public void registerTower(WeatherTower WeatherTower);
}