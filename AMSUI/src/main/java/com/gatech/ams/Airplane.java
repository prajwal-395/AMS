package com.gatech.ams;

import java.util.ArrayList;
import java.util.List;

public class Airplane {

    private int seatingCapacity;
    private double speed;
    private String tailNumber;
    private Airline owningAirline;
    private boolean landingSkids;
    private int engineNum;

    // false if ON_GROUND and true if IN_AIR
    private boolean inAir;

    private ArrayList<Passenger> passengers;
    private ArrayList<Pilot> assignedPilots;

    public Airplane(String tailNumber, int seatingCapacity, double speed, int engineNum) {
        this.tailNumber = tailNumber;
        this.seatingCapacity = seatingCapacity;
        this.speed = speed;
        this.engineNum = engineNum;
        this.assignedPilots = new ArrayList<>();
        this.passengers = new ArrayList<>();
        //set the plane state by default to ON_GROUND
        this.inAir = false;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public ArrayList<Pilot> getAssignedPilots() {
        return assignedPilots;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public double getSpeed() {
        return speed;
    }
        
    public int getEngineNum() {
        return engineNum;
    }

    public Airline getOwningAirline() {
        return owningAirline;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public boolean getLandingSkids() {
        return landingSkids;
    }

    public boolean getInAir() {
        return inAir;
    }

    public void setInAir(boolean inAir) {
        this.inAir = inAir;
    }

    public void setAirline(Airline owningAirline) {
        owningAirline = this.owningAirline;
    }

    public void setLandingSkids(boolean landingSkids) {
        this.landingSkids = landingSkids;
    }

    public String getPropulsionType() {
        return "experimental";
    }

    public void passengersBoard(Airline airline, Flight flight) {
        if (!(inAir)) {
            ArrayList<Leg> legList = flight.getRoute().getLegList();
            Leg matchLeg = legList.get(flight.getProgessState());
            // create a boarding location
            Airport boardingLocation = matchLeg.getDepartAirport();
            for (Person person : boardingLocation.getPeopleAtAirport()) {
                if (person instanceof Passenger) {
                    Passenger passenger = (Passenger) person;
                    //TODO should the vacation spot be +1?
                    if (passenger.getVacationSpots().get(passenger.getCurrentVacationSpot() + 1).equals(legList.get(flight.getProgessState() + 1).getArrivalAirport())) {
                        //TODO f the passenger has the funds to cover the flight cost, and the airplane
                        //supporting that flight has the seating capacity, then your system must track
                        //the passenger boarding the flight, and later getting off the flight at their
                        //desired destination. Your system must also track the number of miles earned
                        //by each passenger so that frequent flyer miles can be accounted for correctly.
                        if (passenger.getPassengerFunds() >= flight.getCost()) {
                            // TODO write a buyTicket() method to subtract funds from the passanger and add revenue to the airline
                            // or acutally...
                            passenger.setPassengerFunds(passenger.getPassengerFunds() - flight.getCost());
                            airline.setAirlineRevenue(flight.getCost());
                            if (passengers.size() <= seatingCapacity) {
                                passengers.add(passenger);
                            } else {
                                /* remove all passangers from that flight
                                this is kind of a crude method but because we don't have
                                a preexisting count of what people at an airport have an intent
                                to travel on a given plane to compare with the carrying capacity of the
                                flight
                                passengers.
                                */
                                passengers.clear();
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public void passengersDisembark(Airline airline, Flight flight) {
        if (!(inAir)) {
            Airplane plane = flight.getSupportingAirplane();
            for (Passenger passenger : plane.getPassengers()) {
                if (flight.getRoute().getLegList().get(flight.getProgessState() - 1).getArrivalAirport() == passenger.getVacationSpots().get(passenger.getCurrentVacationSpot())) {
                    plane.getPassengers().remove(passenger);
                    passenger.setCurrentVacationSpot(passenger.getCurrentVacationSpot() + 1);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Airplane " + this.getTailNumber() + " is a " + this.getPropulsionType() + " with "
                + this.getSeatingCapacity() + " seats and " + this.getEngineNum()
                + " engine(s) that flies " + this.getSpeed() + " miles per hour" + System.lineSeparator();
    }
}