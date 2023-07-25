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
                    //if (passenger.getVacationSpots().get(passenger.getCurrentVacationSpot() + 1).equals(legList.get(flight.getProgessState() + 1).getArrivalAirport())) {
                    if (passenger.getVacationSpots().contains(matchLeg.getArrivalAirport())) {
                        if (passenger.getPassengerFunds() >= flight.getCost()) {
                            passenger.setPassengerFunds(passenger.getPassengerFunds() - flight.getCost());
                            airline.setAirlineRevenue(flight.getCost());
                            if (passengers.size() <= seatingCapacity) {
                                passengers.add(passenger);
                                System.out.println("passenger Boaridng:" + passenger.getIdentifier());
                            } else {
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

        List<Passenger> passengerDisembarkList = new ArrayList<>();

        if (!(inAir)) {
            Airplane plane = flight.getSupportingAirplane();
            List<Leg> flightLegs = flight.getRoute().getLegList();
            for (Passenger passenger : plane.getPassengers()) {
                int currentVacationSpots = passenger.getCurrentVacationSpot();

                if(currentVacationSpots < 0) currentVacationSpots = 0;

                if(passenger.getVacationSpots().size() < currentVacationSpots){
                    System.out.println("Seems Passenger is already disembarked");
                    continue;
                }

                Airport nextPassangerAirport = passenger.getVacationSpots().get(currentVacationSpots);
                int flightProgress = flight.getProgessState();
                if(flightProgress < 1) {
                    System.out.println("problem with fligh progress");
                    flightProgress = 1;
                }
                if (flightLegs.get(flightProgress - 1).getArrivalAirport() == nextPassangerAirport) {
                    passengerDisembarkList.add(passenger);
                    passenger.setCurrentVacationSpot(passenger.getCurrentVacationSpot() + 1);
                    System.out.println("passengerDisEmbarking:" + passenger.getIdentifier());
                }

            }
            plane.getPassengers().removeAll(passengerDisembarkList);
        }

    }

    @Override
    public String toString() {
        return "Airplane " + this.getTailNumber() + " is a " + this.getPropulsionType() + " with "
                + this.getSeatingCapacity() + " seats and " + this.getEngineNum()
                + " engine(s) that flies " + this.getSpeed() + " miles per hour" + System.lineSeparator();
    }
}