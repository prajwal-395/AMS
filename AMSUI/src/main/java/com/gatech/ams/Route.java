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

    //TODO - extend route and create route

    //     public void extendRoute(String name, String nextLegName) {
    //     Route route = getRoute(name);

    //     if (route != null) {
    //         Airport nextHop = getAirport(nextLegName);

    //         if (nextHop != null) {
    //             List<Leg> localLegList = route.getLegs();
    //             if (localLegList.size() > 0) {
    //                 Leg lastLeg = localLegList.get(localLegList.size() - 1);
    //                 String lastStop = lastLeg.getArrivalAirport();
    //                 //TODO - figure out why ternary works
    //                 //so we have dep which im assuming to be the departure airport for our new leg, but 

    //                 for (Leg l : legList) {
    //                     if ((l.getArrivalAirport().equals(nextLegName)) && (l.getDepartAirport().equals(lastStop))) {
    //                         route.addLegInRoute(l);
    //                         // break;
    //                     }
                    
    //                 }
    //             }
    //         }
    //     }

    // }


    @Override
    public String toString() {
        return "Route " + this.getRouteName() + ": " + this.getDepartsFrom();
    }
}