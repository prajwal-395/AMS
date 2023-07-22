package com.gatech.ams;

public class Jet extends Airplane {
    

    public Jet(String tailNumber, int seatingCapacity, double speed, int engineNum) {
        super(tailNumber, seatingCapacity, speed, engineNum);
        setLandingSkids(false);
    }
    
    public String getPropulsionType() {
        return "jet";
    }
}
