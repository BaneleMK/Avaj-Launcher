package avaj.simulation;

import avaj.simulation.aircrafts.AircraftFactory;
import avaj.simulation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.print.DocFlavor.STRING;

public class Simulation{

    public static void main(String[] args) throws Exception{

        WeatherTower weathertower = new WeatherTower();

        if (args.length > 0){
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

                    /*
                        // test to see if it parses the first line to int as per format expected
                        if (numofsims >= 0){
                        System.out.printf("number of sims: %d\n", numofsims); 
                        } else {
                            System.out.printf("number of sims: %d :: less then 0\n", numofsims); 
                        }
                    */
                    // main loop for making flyables (and registering them ???)

                    while ((line = br.readLine()) != null){
                        weathertower.register(AircraftFactory.newAircraft(line.split(" ")[0], 
                        line.split(" ")[1], 
                        Integer.parseInt(line.split(" ")[2]),
                        Integer.parseInt(line.split(" ")[3]),
                        Integer.parseInt(line.split(" ")[4])));
            
                }
                
                for(int i = 0; i < numofsims; i++){
                    weathertower.conditionsChanged();
                }

                br.close();
            } catch (Exception fException){
                System.out.println("custom error : "+fException.getMessage()); 
            } 

            /*
            
            exception for simulation number

            catch (Exception NumberFormatException){
                System.out.println("simularion number error: "+NumberFormatException.getMessage()); 
            }

            */
        } else {
            System.out.println("Run the program with 1 argument (scenario.txt file)"); 
        }
    }
}