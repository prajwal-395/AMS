package com.gatech.ams;

import java.util.ArrayList;
import java.util.List;

public class Airline {
    private String airlineName;
    private double revenue;

    private List<Airplane> airplanesOfAirline;
    private List<Flight> flightsOfAirline;

    public Airline(String name, double revenue) {
        this.airlineName = name;
        this.revenue = revenue;
        this.airplanesOfAirline = new ArrayList<Airplane>();
        this.flightsOfAirline = new ArrayList<Flight>();
    }

    public String getAirlineName() {
        return this.airlineName;
    }
    
    public Double getAirlineRevenue() {
        return this.revenue;
    }

    public void setAirlineRevenue(int revenue) {
        this.revenue += revenue;
    }
    
    public List<Airplane> getAirplanesOfAirline() {
        return airplanesOfAirline;
    }

    public void addToAirplanesOfAirline(Airplane airplane) {
        airplanesOfAirline.add(airplane);
    }

    public List<Flight> getFlightOfAirline() {
        return flightsOfAirline;
    }

    public void addToAirplanesOfAirline(Flight flight) {
        flightsOfAirline.add(flight);
    }

    public Flight getFlightFromAirline(String flightNumber) {
        for(Flight f : flightsOfAirline) {
            if(f.getFlightID().equals(flightNumber))
                return f;
        }
        return null;
    }

    public void assignPilot(String flightNumber, Pilot pilot) {
        Flight flight = getFlightFromAirline(flightNumber);
        Airplane plane = flight.getSupportingAirplane();

        if(flight ==null || plane ==null){
            System.out.println("error: please check flight Number again.");
        }
        if(pilot ==null){
            System.out.println("error: pilot is null.");
        }

        if ((pilot.getLicenses().contains("jet")) && (plane instanceof Jet) || (pilot.getLicenses().contains("prop")) && (plane instanceof Propeller)) {
            plane.getAssignedPilots().add(pilot);
            System.out.println("Pilot assigned successfully!");
        } else {
            System.out.println("error: the pilot does not have the right licenses to fly this plane!");
        }
    }

    public void flightLanding(String flightNumber) {
        Flight flight = getFlightFromAirline(flightNumber);
        Airplane plane = flight.getSupportingAirplane();
        Leg newLandedLocation = flight.getRoute().getLegList().get(flight.getProgessState());
        // set the inAir boolean in plane to false
        plane.setInAir(false);
        // add experience to pilots and frequent flier miles to passangers
        // update the locations of all the people on the plane
        int numMiles = newLandedLocation.getDistance();
        for (Pilot pilot : plane.getAssignedPilots()) {
            pilot.setExperience(pilot.getExperience() + 1);
            pilot.setLocation(newLandedLocation.getArrivalAirport().getIATA());
        }
        for (Passenger passenger : plane.getPassengers()) {
            passenger.setfrequentFlyerMiles(passenger.getfrequentFlyerMiles() + numMiles);
            passenger.setLocation(newLandedLocation.getArrivalAirport().getIATA());
        }
        // check if the plane is at the end of its route, and if so recyle stuff as indicated by the else statement
        if (flight.getProgessState() < flight.getRoute().getLegList().size()) {
            flight.setProgressState(flight.getProgessState() + 1);
            //update nextTime
            flight.updateNextTime();
        } else {
            // TODO "and, for the case where the airplane is already at the final airport in the
            // route, we must recycle the crew so that they can leave the plane, get some rest, and
            // prepare for their next flight. We must also remove the flight once it has reached the
            // end of its route.""
            retireFlight(flightNumber);
        }
    }

    public void flightTakeoff(String flightNumber) {
        Flight flight = getFlightFromAirline(flightNumber);
        Airplane plane = flight.getSupportingAirplane();

        plane.setInAir(true);

        if ((plane.getAssignedPilots().size() > 1) && (plane instanceof Propeller)) {
            for (Pilot pilot : plane.getAssignedPilots()) {
                pilot.getLicenses().contains("jet");
            }
        } else if ((plane.getAssignedPilots().size() > 2) && (plane instanceof Jet)) {
            for (Pilot pilot : plane.getAssignedPilots()) {
                pilot.getLicenses().contains("jet");
            }
        }
    }

    //TODO retireFlight
    public void retireFlight(String flightNumber) {
        Flight flight = getFlightFromAirline(flightNumber);
        Airplane plane = flight.getSupportingAirplane();

        // Check to see that flight is completed? And there are no more passengers on the flight
        
        // Unassign pilots from supporting airplane
        plane.getAssignedPilots().clear();
        // Unassign airplane from Flight
        flight.setSupportingAirplane(null);
        // Remove flight from flight arraylist
        flightsOfAirline.remove(flight);
        // Remove flight from universal flight list
    }

    @Override
    public String toString() {
        return "Airline " + this.getAirlineName() + " has a current revenue of: " + this.getAirlineRevenue() + " USD." + System.lineSeparator();
    }
}
