package com.gatech.ams;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;

public class AirlineManagementSystem {

    List<Airline> airlineList;
    List<Airplane> airplanesList;
    List<Pilot> pilotsList;
    List<Passenger> passengerList;
    List<Airport> airportList;
    List<Leg> legList;
    List<Route> routeList;
    List<Flight> flightList;

    public AirlineManagementSystem() {
        airlineList = new ArrayList<>();
        airplanesList = new ArrayList<>();
        pilotsList = new ArrayList<>();
        passengerList = new ArrayList<>();
        airportList = new ArrayList<>();
        legList = new ArrayList<>();
        routeList = new ArrayList<>();
        flightList = new ArrayList<>();
    }

    public void createAirline(Airline airline) {
        if (!(airlineList.contains(airline))) {
            airlineList.add(airline);
        }

        System.out.println("airline created successfully!");
    }

    public void createAirport(Airport airport) {
        if (!(airportList.contains(airport))) {
            airportList.add(airport);
        }
        System.out.print("airport created successfully!");
    }

    public void createFlight(String airlineName, Flight f) {
        Airline airline = getAirlineFromAMS(airlineName);
        if (!(flightList.contains(f))) {
            flightList.add(f);
            airline.getFlightOfAirline().add(f);
        }
        System.out.println("flight created successfully!");
    }

    public void createPassenger(Passenger passenger, String location) {
        passengerList.add(passenger);
        //TODO use the location to find where these people are and place them at the right airport
        Airport personCreateLocation = getAirportFromAMS(location);
        personCreateLocation.setPeopleAtAiport(passenger);
        System.out.println("passenger created successfully!");
    }

    public void createPilot(Pilot pilot, String location) {
        pilotsList.add(pilot);
        Airport personCreateLocation = getAirportFromAMS(location);
        personCreateLocation.setPeopleAtAiport(pilot);
        System.out.println("pilot created successfully!");
    }

    public void createJet(Airplane jet) {
        if (!airplanesList.contains(jet)) {
            airplanesList.add(jet);
        }
        System.out.print("jet created successfully!");
    }

    public void createProp(Airplane prop) {
        if (!airplanesList.contains(prop)) {
            airplanesList.add(prop);
        }
        System.out.print("prop created successfully!");
    }

    public void createLeg(String departsFrom, String arrivesAt, Leg leg) {
        legList.add(leg);
        System.out.print("leg created successfully!");
    }

    public void createRoute(Route route, String departsFrom, String hop) {
        Airport departure = getAirportFromAMS(departsFrom);
        Airport firstLeg = getAirportFromAMS(hop);
        Leg foundLeg = getLegFromAMS(departure, firstLeg);
        if (foundLeg == null) {
            System.out.println("Error: There is no leg like that yet to be able to create the route!");
        } else {
            route.addLegToRoute(foundLeg);
            routeList.add(route);
            System.out.print("route created successfully!");
        }
    }

    public void extendRoute(String routeName, String hop) {
        Route route = getRouteFromAMS(routeName);
        //TODO this line leads to a NullPointerException
        Airport lastLocation = route.getLegList()
                .get(route.getLegList().size() - 1).getArrivalAirport();
        Airport nextHop = getAirportFromAMS(hop);
        Leg legToAdd = getLegFromAMS(lastLocation, nextHop);
        if (legToAdd == null) {
            System.out.println("Error: That leg doesn't exist to extend the route!");
        } else {
            route.addLegToRoute(legToAdd);
        }
        System.out.print("route extended successfully!");
    }

    public void extendVacation(String personID, String destination) {
        Passenger passenger = getPassengerFromAMS(personID);
        Airport nextDestination = getAirportFromAMS(destination);
        if (passenger == null) {
           System.out.println("Error: That person doesn't exist or is not a passanger!");
        } else if (nextDestination == null) {
            System.out.println("Error: That Airport doesn't exist!");
        } else {
            passenger.getVacationSpots().add(nextDestination);
        }
        System.out.print("vacation extended successfully!");
    }

    public void toggleLicense(String pilotID, String license) {

        Pilot pilot = getPilotFromAMS(pilotID);
        if (!(pilot == null)) {
            pilot.toggleLicense(license);
        }
        System.out.print("license toggle successfully successfully!");
    }

    public void assignPilot(String airlineName, String flightID, String pilotID) {
        Airline airline = getAirlineFromAMS(airlineName);
        Pilot pilot = getPilotFromAMS(pilotID);
        if ((airline != null) || (pilot != null)) {
            airline.assignPilot(flightID, pilot);
        } else {
            System.out.println("airline or the assigned pilot doesn't exist!");
        }
    }

    public void flightLanding(String airlineName, String flightNumber) {
        Airline airline = getAirlineFromAMS(airlineName);
        if (airline != null) {
            airline.flightLanding(flightNumber);
        } else {
            System.out.println("Error: airline doesn't exist!");
        }
        System.out.println("flight successfully landed!");
    }

    public void flightTakeoff(String airlineName, String flightNumber) {
        Airline airline = getAirlineFromAMS(airlineName);
        if (airline != null) {
            airline.flightTakeoff(flightNumber);
        } else {
            System.out.println("error: airline doesn't exist!");
        }
        System.out.println("flight successfully taken off!");
    }

    public void passengersBoard(String airlineName, String flightNumber) {

        Airline airline = getAirlineFromAMS(airlineName);
        if (airline != null) {
            Flight flight = airline.getFlightFromAirline(flightNumber);
            if (flight != null) {
                Airplane plane = flight.getSupportingAirplane();
                plane.passengersBoard(airline, flight);
            }
        }
        System.out.println("passengers successfully boarded!");
    }

    public void passengersDisembark(String airlineName, String flightNumber) {
        //TODO passengersDisembark
        Airline airline = getAirlineFromAMS(airlineName);
        if (airline != null) {
            Flight flight = airline.getFlightFromAirline(flightNumber);
            if (flight != null) {
                Airplane plane = flight.getSupportingAirplane();
                plane.passengersDisembark(airline, flight);
            }
        }
        System.out.println("passengers successfully disembarked!");
    }

    public void retireFlight(String airlineName, String flightNumber) {

        Airline airline = getAirlineFromAMS(airlineName);
        if (airline != null) {
            Flight toRemove = getFlightFromAMS(flightNumber);
            airline.retireFlight(flightNumber);
            flightList.remove(toRemove);
        } else {
            System.out.println("airline doesn't exist!");
        }
        System.out.println("flight successfully retired!");
    }

    public String showAirlines() {

        StringBuffer sb = new StringBuffer();

        for (Airline airline : airlineList) {
            System.out.println(airline);
            sb.append(airline);
            //System.out.println("airline " + airline.getAirlineName() + " has a current revenue of: " + airline.getAirlineRevenue() + " USD");
        }

        System.out.println("all airlines have been displayed successfully!");
        return sb.toString();
    }

    public String showAirlinesDetail() {

        StringBuffer sb = new StringBuffer();

        for (Airline airline : airlineList) {
            System.out.println(airline);
            sb.append(airline);
            //System.out.println("airline " + airline.getAirlineName() + " has a current revenue of: " + airline.getAirlineRevenue() + " USD");
        }

        //System.out.println("all airlines have been displayed successfully!");
        return sb.toString();
    }

    public String showAirplanes() {
        StringBuffer sb = new StringBuffer();

        for (Airplane airplane : airplanesList) {
            System.out.println(airplane);
            sb.append(airplane);
            //System.out.println("airplane " + airplane.getTailNumber() + " is a " + airplane.getPropulsionType() + " with " + airplane.getSeatingCapacity() + " seats and " + airplane.getEngineNum() + " engine(s) that flies " + airplane.getSpeed() + " miles per hour");
        }
        System.out.println("all airplanes have been displayed successfully!");
        return sb.toString();
    }

    public String showAirports() {

        StringBuffer sb = new StringBuffer();

        for (Airport airport : airportList) {

            //System.out.println("airport " + airport.getIATA() + ": " + airport.getAirportName() + " is located in " + airport.getCity() + ", "+ airport.getState() + " (" + airport.getCountry() + ")");
            ////System.out.println("  legs to other airports");

            sb.append(airport);
            sb.append("  legs to other airports");

            for (Leg leg : legList) {
                if (leg.getDepartAirport() == airport) {

                    //System.out.print(" | " + leg.getDistance() + " --> " + leg.getArrivalAirport().getIATA());
                    sb.append(leg);
                }
            }
            sb.append("\n");
            sb.append("    people waiting at this airport");
            //System.out.println("\n");
            //System.out.println("    people waiting at this airport");

            //TODO there is a NullPointerException on this line as well
            for (Person person : airport.getPeopleAtAirport()) {
                //System.out.print(" | " + person.getIdentifier());
                sb.append(" | " + person.getIdentifier());
            }
        }

        System.out.println(sb.toString());
        System.out.println("all airports have been displayed successfully!");

        return sb.toString();
    }

    public String showPeople() {

        StringBuffer sb = new StringBuffer();

        sb.append(showPilots());

        sb.append(showPilots());

        //System.out.println(sb.toString());
        System.out.println("all people have been displayed successfully!");
        return sb.toString();
    }
    public String showPilots() {

        StringBuffer sb = new StringBuffer();

        for (Pilot pilot : pilotsList) {
           sb.append(pilot);
            if(pilot.getLicenses().size() > 0) {
                sb.append("  Qualifications");
                for (String qualification : pilot.getLicenses()) {
                    sb.append(" | " + qualification);
                }
            }

            sb.append("\n");
        }


        System.out.println(sb.toString());
        System.out.println("All pilots have been displayed successfully!");
        return sb.toString();
    }

    public String showPassenger() {

        StringBuffer sb = new StringBuffer();

        for (Passenger passenger : passengerList) {
            sb.append(passenger);
            if (passenger.getVacationSpots().size() > 0) {
                sb.append("  Vacations");
                for (Airport vacation : passenger.getVacationSpots()) {
                    sb.append(" | " + vacation.getIATA());
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        System.out.println("All passenger have been displayed successfully!");
        return sb.toString();
    }

    public String showRoutes() {

        StringBuffer sb = new StringBuffer();

        for (Route route : routeList) {
            sb.append("route " + route.getRouteName() + ": " + route.getDepartsFrom());
            for (Leg leg : route.getLegList()) {
                sb.append(" --> " + leg.getArrivalAirport());
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

        return sb.toString();
    }


    public Airline getAirlineFromAMS(String airlineName) {
        for (Airline a: airlineList) {
            if (a.getAirlineName().equals(airlineName)) {
                return a;
            }
        }
        return null;
    }

    public Airplane getAirplaneFromAMS(String tailNum) {
        for (Airplane a: airplanesList) {
            if (a.getTailNumber().equals(tailNum)) {
                return a;
            }
        }
        return null;
    }

    public Pilot getPilotFromAMS(String pilotID) {
        for (Pilot p : pilotsList) {
            if (p.getIdentifier().equals(pilotID)) {
                return p;
            }
        }
        return null;
    }

    public Passenger getPassengerFromAMS(String personID) {
        for (Passenger p: passengerList) {
            if (p.getIdentifier().equals(personID)) {
                return p;
            }
        }
        return  null;
    }

    public Airport getAirportFromAMS(String IATACode) {
        for (Airport a: airportList) {
            if (a.getIATA().equals(IATACode)) {
                return a;
            }
        }
        return null;
    }

    public Leg getLegFromAMS(Airport depAirport, Airport arrAirport) {
        for (Leg leg : legList) {
            if ((leg.getDepartAirport() == depAirport) && (leg.getArrivalAirport() == arrAirport)) {
                return leg;
            }
        }
        return null;
    }

    public Route getRouteFromAMS(String routeName) {
        for (Route r: routeList) {
            if (r.getRouteName().equals(routeName)) {
                return r;
            }
        }
        return  null;
    }

    public Flight getFlightFromAMS(String flightNum) {
        for (Flight f: flightList) {
            if (f.getFlightID().equals(flightNum)) {
                return f;
            }
        }
        return null;
    }


}
