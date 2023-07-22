package com.gatech.ams;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Simple Airline Management System!");
        AirlineController simulator = new AirlineController();
        //simulator.commandLoop();
        simulator.TestCommandLoop();
    }
}
