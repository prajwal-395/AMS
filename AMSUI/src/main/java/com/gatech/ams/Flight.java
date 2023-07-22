package com.gatech.ams;

import java.time.LocalTime;

public class Flight {

    private String flightID;
    private int cost;

    private int progressState;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private LocalTime next_time;

    private Route route;
    private Airplane supportingAirplane;
    private Airline owningAirline;

    public Flight(Airline owningAirline, String flightID, int cost, int progressState, String routeName, LocalTime next_time, String supportingAirplane) {
        AirlineManagementSystem a = new AirlineManagementSystem();
        
        this.owningAirline = owningAirline;
        this.flightID = flightID;
        this.cost = cost;
        this.progressState = progressState;
        //TODO getter for route --> do we create this list in AC or in routes
        this.route = a.getRouteFromAMS(routeName);
        this.next_time = next_time;
        this.supportingAirplane = a.getAirplaneFromAMS(supportingAirplane);
    }

    public Airline getOwningAirline() {
        return this.owningAirline;
    }

    public void setOwningAirline(Airline owningAirline) {
        this.owningAirline = owningAirline;
    }

    public String getFlightID() {
        return this.flightID;
    }

    public int getCost() {
        return this.cost;
    }

    public int getProgessState() {
        return progressState;
    }

    public void setProgressState(int progressState) {
        if (progressState <= getRoute().getLegList().size()) {
            this.progressState = progressState;
        } else {
            System.out.println("Error: progress state must be less than or equal to the number of segments in the route!");
        }
    }

    public Route getRoute() {
        return route;
    }

    public LocalTime getNextTime() {
        return next_time;
    }

    public void setNextTime(LocalTime next_time) {
        this.next_time = next_time;
    }

    public Airplane getSupportingAirplane() {
        return this.supportingAirplane;
    }

    public void setSupportingAirplane(Airplane supportingAirplane) {
        this.supportingAirplane = supportingAirplane;
    }

    public void setOwningAirline(Airplane supportingAirplane) {
        this.supportingAirplane = supportingAirplane;
    }

    //TODO methods to update the time variables
    public void updateNextTime() {
        if (!(supportingAirplane.getInAir())) {
            next_time = next_time.plusMinutes(30);
        } else {
            // double time = currentLeg().getDistance() / supportingAirplane.getSpeed();
            double time = route.getLegList().get(progressState).getDistance() / supportingAirplane.getSpeed();
            long mins = Math.round(time * 60);
            next_time = next_time.plusMinutes(mins);
        }
    }

    public void finalArrivalTIme() {
        for (Leg leg: route.getLegList()) {
            double distance = leg.getDistance();
            double time = distance / supportingAirplane.getSpeed();
            long mins = Math.round(time * 60);
            arrivalTime = arrivalTime.plusMinutes(mins);
        }

    }
}