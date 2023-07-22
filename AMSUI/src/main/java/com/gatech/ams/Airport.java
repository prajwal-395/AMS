package com.gatech.ams;

import java.util.ArrayList;

public class Airport {
    private String IATA_code;
    private String airportName;
    private String city;
    private String state;
    private String country;

    private ArrayList<Person> peopleAtAirport= new ArrayList<Person>();
    
    //TODO method to get all the legs to other airports --> this would be helpful for the show_airlines method at the end
    // basically when you create a leg, since it constructs it with a dpearture and arrival airport

    public Airport(String IATA_code, String airportName, String cityName, String stateName, String countryName) {
        this.IATA_code = IATA_code;
        this.airportName = airportName;
        this.city = cityName;
        this.state = stateName;
        this.country = countryName;
    }

    public String getIATA() {
        return IATA_code;
    }

    public void setIATA(String IATA_code) {
        this.IATA_code = IATA_code;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String cityName) {
        this.city = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String stateName) {
        this.state = stateName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String countryName) {
        this.country = countryName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    //TODO get all people at this airport
    // basically all we have to do parse through the AC list of people and check their location
    public void addPeopleAtAirport() {
        AirlineManagementSystem a = new AirlineManagementSystem();
        for (Passenger p : a.passengerList) {
            //TODO is this IATA code or is this the airport name
            if (p.getLocation() == IATA_code) {
                peopleAtAirport.add(p);
            };
        }
    }

    public ArrayList<Person> getPeopleAtAirport() {
        return peopleAtAirport;
    }

    public void setPeopleAtAiport(Person personAtAirport) {
        this.peopleAtAirport.add(personAtAirport);
    }
    
}
