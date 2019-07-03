package avaj.simulation;

import java.io.FileWriter;

class LogOutput {
    try {
        FileWriter fw = new FileWriter("simulation.txt");




    } catch (Exception e) {
        System.out.println("LogOutput error : "+e.getMessage()); 
    }
    
}