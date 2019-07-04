package com.avaj.simulation;

import com.avaj.simulation.aircrafts.Flyable;
import java.util.ArrayList;

public abstract class Tower{
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        if (!observers.contains(flyable)){
            observers.add(flyable);
            flyable.registerTower((WeatherTower)this); // lol will it work
        }
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionsChanged(){
        for (int i = 0; i < observers.size() ; i++)
            observers.get(i).updateConditions();
    }
}