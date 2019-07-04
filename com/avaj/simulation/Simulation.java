package com.avaj.simulation;

import com.avaj.simulation.aircrafts.AircraftFactory;

import java.io.BufferedReader;
import java.io.FileReader;

public class Simulation{
    public static void main(String[] args) throws Exception{

        WeatherTower weathertower = new WeatherTower();

        int lif = 1;

        if (args.length == 1){
            if(LogOutput.getLogOut().simfile != null) {
                try{
                    // read file
                    BufferedReader br = new BufferedReader(new FileReader(args[0]));  


                        // pass the first line for num of simulations
                        String line = br.readLine();

                        // store number of simulations
                        int numofsims = Integer.parseInt(line);
                        if (numofsims <= 0){
                            br.close();
                            throw new RuntimeException("number of cycles is a non positive integer");
                        }

                        // main loop for making flyables (and registering them ???)

                        while ((line = br.readLine()) != null){
                            lif++;
                            weathertower.register(AircraftFactory.newAircraft(line.split(" ")[0], 
                            line.split(" ")[1], 
                            Integer.parseInt(line.split(" ")[2]),
                            Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4])));
                    }
                    br.close();


                    for(int i = 0; i < numofsims; i++){
                        weathertower.changeWeather();
                    }

                    LogOutput.getLogOut().closelog();

                } catch (NumberFormatException e){
                    System.out.println("expected int values for coordinates : "+e.getMessage()+" line "+lif);                 
                } catch (Exception fException){
                    System.out.println("custom error : "+fException.getMessage()); 
                } 
            }
        } else {
            System.out.println("Run the program with 1 argument (scenario.txt file)"); 
        }
    }
}