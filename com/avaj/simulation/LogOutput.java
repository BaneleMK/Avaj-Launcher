package com.avaj.simulation;

import java.io.PrintWriter;

public class LogOutput {
    private static LogOutput logOutput;
    
    public PrintWriter simfile;

    private LogOutput(){
        try {
            simfile = new PrintWriter("simulation.txt");
             // "valid file found and PrintWriter made everyone is happy yey"
        } catch (Exception e) {
            System.out.println("File conflict error: "+ e.getMessage());
        }
    }

    public void closelog(){
            // "closing the PrintWriter out stream";
            simfile.close();
    }

    public void put(String log){
        simfile.println(log); 
    }

    public static LogOutput getLogOut(){
        if (logOutput == null){
            logOutput = new LogOutput();
        }
        return logOutput;
    }

}