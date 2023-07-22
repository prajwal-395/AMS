package com.gatech.ams;

import java.util.ArrayList;

public class Passenger extends Person {
    private int frequentFlierMiles;
    private int passengerFunds;
    private ArrayList<Airport> vacationSpots;
    private int currentVacationSpot;

    public Passenger(String identifier, String fName, int frequentFlierMiles, int passengerFunds, String location) {
        super(fName, identifier, location);
        this.frequentFlierMiles = frequentFlierMiles;
        this.passengerFunds = passengerFunds;
        this.vacationSpots = new ArrayList<>();
        this.currentVacationSpot = 0;
    }

    public Passenger(String identifier, String fName, String lName, int frequentFlierMiles, int passengerFunds, String location) {
        super(fName, lName, identifier, location);
        this.frequentFlierMiles = frequentFlierMiles;
        this.passengerFunds = passengerFunds;
        this.vacationSpots = new ArrayList<>();
        this.currentVacationSpot = 0;
    }

    public int getfrequentFlyerMiles() {
        return frequentFlierMiles;
    }

    public void setfrequentFlyerMiles(int frequentFlierMiles) {
       this.frequentFlierMiles = frequentFlierMiles;
    }

    public int getPassengerFunds() {
        return passengerFunds;
    }

    public void setPassengerFunds(int funds) {
        this.passengerFunds = funds;
    }

    public ArrayList<Airport> getVacationSpots() {
        return vacationSpots;
    }

    public void setVacationSpots(ArrayList<Airport> vacationSpots) {
        this.vacationSpots = vacationSpots;
    }

    public int getCurrentVacationSpot() {
        return currentVacationSpot;
    }

    public void setCurrentVacationSpot(int currentVacationSpot) {
        this.currentVacationSpot = currentVacationSpot;
    }

    //TODO extendVacation()
    
}
