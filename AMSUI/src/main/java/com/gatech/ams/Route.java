package com.gatech.ams;

import java.util.ArrayList;

public class Route {

    private String routeName;
    private Airport departsFrom;

    private ArrayList<Leg> legList;

    public Route (String routeName, Airport departsFrom) {
        this.routeName = routeName;
        this.departsFrom = departsFrom;
        legList = new ArrayList<>();
    }

    public String getRouteName() {
        return this.routeName;
    }

    public Airport getDepartsFrom() {
        return this.departsFrom;
    }

    public void setDepartsFrom(Airport departsFrom) {
        this.departsFrom = departsFrom;
    }

    public ArrayList<Leg> getLegList() {
        return legList;
    }

    public void addLegToRoute(Leg leg) {
        legList.add(leg);
    }

    @Override
    public String toString() {
        return "Route " + this.getRouteName() + ": " + this.getDepartsFrom();
    }
}