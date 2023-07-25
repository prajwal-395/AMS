package com.gatech.ams;

import java.util.ArrayList;

public class Pilot extends Person {
    private String taxID;
    private int experience;
    private ArrayList<String> listOfLicenses;

    private Airline hiringAirline;

    public Pilot(String identifier, String fName, String lName, String taxID, int experience, String location) {
        super(fName, lName, identifier, location);
        this.taxID = taxID;
        this.experience = experience;
        this.listOfLicenses = new ArrayList<>();
    }

    public String getTaxID() {
        return taxID;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public ArrayList<String> getLicenses() {
        return listOfLicenses;
    }

    public Airline getHiringAirline() {
        return hiringAirline;
    }

    public void setHiringAirline(Airline hiringAirline) {
        this.hiringAirline = hiringAirline;
    }



    
    public void toggleLicense(String newLicense) {
        boolean exists = false;
        for (int i = 0; i < listOfLicenses.size(); i++) {
            String license = listOfLicenses.get(i);
            if (license.equals(newLicense)) {
                listOfLicenses.remove(newLicense);
                exists = true;
                return;
            }
        }
        if (!exists) {
            listOfLicenses.add(newLicense);
        }
    }

    @Override
    public String toString() {
        return "person " + this.getIdentifier() + " is a pilot named: " + this.getfName() +
                " " + this.getlName() + " with a tax identifier: " +
                this.getTaxID() + " and experience of " +
                this.getExperience() + " trips";


    }
}
