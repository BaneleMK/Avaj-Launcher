package avaj.simulation.aircrafts;

public abstract class AircraftFactory{

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Coordinates coords = new Coordinates(longitude, latitude, height);
        switch (type) {
            case "JetPlane":
                JetPlane jPlane = new JetPlane(name, coords);
                return jPlane;
            
            case "Baloon":
                Baloon Bloon = new Baloon(name, coords);
                return Bloon;
        
            case "Helicopter":
                Helicopter heli = new Helicopter(name, coords);
                return heli;

            default:
                throw new RuntimeException("invalid flyable type");
        }
    }
}