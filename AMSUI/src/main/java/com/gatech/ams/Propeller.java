package com.gatech.ams;

public class Propeller extends Airplane {

    public Propeller(String tailNumber, int seatingCapacity, double speed, int engineNum, boolean landingSkids) {
        super(tailNumber, seatingCapacity, speed, engineNum);
        setLandingSkids(landingSkids);
    }

    public String getPropulsionType() {
        return "prop";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}