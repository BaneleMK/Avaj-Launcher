package avaj.simulation.aircrafts;

import avaj.simulation.aircrafts.Coordinates;

public abstract class Aircraft{
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    private static long idCounter = 0;
    
    protected Aircraft(String name, Coordinates coordinates){
        this.id = this.nextid();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextid(){
        return (Aircraft.idCounter)++;
        // what is the next id
        // seems as if its the just the way of allocating an id for your current aircraft from the static id counter
    }
}