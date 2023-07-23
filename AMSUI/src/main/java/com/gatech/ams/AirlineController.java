package com.gatech.ams;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirlineController {

    AirlineManagementSystem system = null;
    //constructor for Airline Controller to use the universal methods of the class
    public AirlineController() {
        system = new AirlineManagementSystem();
    };

    public AirlineController(AirlineManagementSystem ams) {
        system = ams;
    };

    public void commandLoop() {
        Scanner commandLineInput = new Scanner(System.in);
        String wholeInputLine;
        String[] tokens;
        final String DELIMITER = ",";

        while (true) {
            wholeInputLine = commandLineInput.nextLine();
            tokens = wholeInputLine.split(DELIMITER);
            System.out.println(">> " + wholeInputLine);

            if (cmdMethod(commandLineInput, DELIMITER,tokens, wholeInputLine))
                break;
        }

        System.out.println("simulation terminated");
        commandLineInput.close();
    }

    public void TestCommandLoop() {

        System.out.println("Inside Test Command Loop");
        Scanner commandLineInput = new Scanner(System.in);
        String wholeInputLine;
        String[] tokens;
        final String DELIMITER = ",";
        StringBuilder sb = new StringBuilder();

        // check Airline creation
        sb.append("create_airline,Ryan_Air,30\n");
        sb.append("create_airline,Delta,100\n");
        sb.append("create_airline,British_Airways,85\n");
        sb.append("show_airlines\n");

        // check Airport creation
        sb.append("create_airport,ATL,Hartsfield,Atlanta,Georgia,USA\n");
        sb.append("create_airport,JFK,John_F_Kennedy,New_York,New_York,USA\n");
        sb.append("create_airport,LHR,Heathrow,London,England,GBR\n");
        sb.append("create_airport,AMS,Schiphol,Amsterdam,Netherlands,NLD\n");
        sb.append("create_airport,BER,Brandenburg,Berlin,Germany,GER\n");
        sb.append("create_airport,CDG,Paris_Charles_de_Gaulle,Roissy_en_France,Paris,FRA\n");
        sb.append("create_airport,MAD,Madrid_Adolfo_Suarez_Barajas,Madrid,Barajas,ESP\n");
        sb.append("show_airports\n");

        // check pilot creation
        sb.append("create_pilot,p2,Allen,Smith,222-22-2222,2,ATL\n");
        sb.append("create_pilot,p3,Ellery,Candida,333-33-3333,3,ATL\n");
        sb.append("create_pilot,p5,Greg,Dowdle,555-55-5555,5,JFK\n");
        sb.append("create_pilot,p7,Charlotte,Dowdle,777-77-7777,7,JFK\n");
        sb.append("create_pilot,p11,Charlotte,Dowdle,111-11-1111,1,BER\n");
        sb.append("create_pilot,p13,Gina,Rosaria,131-31-3131,4,ATL\n");
        sb.append("create_pilot,p17,Samuel,Armstrong,171-71-7171,3,ATL\n");
        sb.append("create_pilot,p23,Warren,Dozier,232-32-323,4,BER\n");
        sb.append("create_pilot,p29,Harriet,Franks,292-92-929,8,JFK\n");
        sb.append("show_people");

// toggle pilot licenses
        sb.append("toggle_license,p2,jet\n");
        sb.append("toggle_license,p2,prop\n");
        sb.append("toggle_license,p2,prop\n");
        sb.append("toggle_license,p3,jet\n");
        sb.append("toggle_license,p3,prop\n");
        sb.append("toggle_license,p5,jet\n");
        sb.append("toggle_license,p7,jet\n");
        sb.append("toggle_license,p11,prop\n");
        sb.append("toggle_license,p13,jet\n");
        sb.append("toggle_license,p17,jet\n");
        sb.append("toggle_license,p23,jet\n");
        sb.append("toggle_license,p29,prop\n");
        sb.append("show_people\n");

// check passenger creation
        sb.append("create_passenger,p4,Charles,Jackson,400,300,ATL\n");
        sb.append("create_passenger,p6,Charles,Brown,400,200,ATL\n");
        sb.append("create_passenger,p8,Lucy,van_Pelt,500,200,ATL\n");
        sb.append("create_passenger,p9,Linus,van_Pelt,900,100,JFK\n");
        sb.append("create_passenger,p10,Clark,Kent,400,300,LHR\n");
        sb.append("create_passenger,p12,Lois,Lane,600,400,LHR\n");
        sb.append("create_passenger,p14,Diana,Prince,100,1000,BER\n");
        sb.append("create_passenger,p15,Oliver,Queen,300,100,AMS\n");
        sb.append("create_passenger,p16,Scott,Lang,300,100,AMS\n");
        sb.append("create_passenger,p18,Cassie,Lang,400,100,AMS\n");
        sb.append("create_passenger,p20,Hope,van_Dyne,500,700,AMS\n");
        sb.append("create_passenger,p21,Stephen,Strange,500,700,JFK\n");
        sb.append("create_passenger,p22,Monica,Rambeau,500,700,CDG\n");
        sb.append("show_people\n");

// check extending vacations
        sb.append("extend_vacation,p4,JFK\n");
        sb.append("extend_vacation,p8,BER\n");
        sb.append("extend_vacation,p8,CDG\n");
        sb.append("extend_vacation,p9,BER\n");
        sb.append("extend_vacation,p9,MAD\n");
        sb.append("extend_vacation,p10,BER\n");
        sb.append("extend_vacation,p12,BER\n");
        sb.append("extend_vacation,p12,CDG\n");
        sb.append("extend_vacation,p14,MAD\n");
        sb.append("extend_vacation,p15,BER\n");
        sb.append("extend_vacation,p16,BER\n");
        sb.append("extend_vacation,p16,MAD\n");
        sb.append(" extend_vacation,p18,CDG\n");
        sb.append("extend_vacation,p20,BER\n");
        sb.append("extend_vacation,p20,CDG\n");
        sb.append("extend_vacation,p21,LHR\n");
        sb.append("extend_vacation,p21,CDG\n");
        sb.append("extend_vacation,p22,MAD\n");
        sb.append("show_people\n");

// check leg creation and updating
        sb.append("create_leg,ATL,2900,AMS\n");

// ensure that updating one direction will also update/sync the opposite direction
        sb.append("create_leg,AMS,3900,ATL\n");
        sb.append("create_leg,ATL,700,JFK\n");
        sb.append("create_leg,JFK,3000,LHR\n");
        sb.append("create_leg,JFK,3500,BER\n");
        sb.append("create_leg,LHR,500,BER\n");
        sb.append("create_leg,AMS,300,BER\n");
        sb.append("create_leg,BER,500,CDG\n");
        sb.append("create_leg,BER,1000,MAD\n");
        sb.append("create_leg,CDG,600,MAD\n");
        sb.append("create_leg,MAD,600,CDG\n");

// check route creation
        sb.append("create_route,route_one,ATL,JFK\n");
        sb.append("create_route,route_two,ATL,JFK\n");
        sb.append("create_route,route_three,ATL,AMS\n");
        sb.append("show_routes\n");

// check route extension
        sb.append("extend_route,route_one,BER\n");
        sb.append("extend_route,route_one,CDG\n");
        sb.append("extend_route,route_one,MAD\n");
        sb.append("extend_route,route_two,LHR\n");
        sb.append("extend_route,route_two,BER\n");
        sb.append("extend_route,route_two,MAD\n");
        sb.append("extend_route,route_two,CDG\n");
        sb.append("extend_route,route_three,BER\n");
        sb.append("extend_route,route_three,MAD\n");
        sb.append("show_routes\n");

// check airplane creation
        sb.append("create_jet,n110sp,3,600,2\n");
        sb.append("create_prop,p506bp,2,300,2,true\n");
        sb.append("create_jet,n440fp,5,550,4\n");

// check create flight
        sb.append("create_flight,Delta,dl_10,200,0,route_one,07:00,n110sp\n");
        sb.append("create_flight,British_Airways,ba_17,200,1,route_two,07:30,n440fp\n");
        sb.append("create_flight,Delta,dl_33,100,0,route_three,08:15,n330pc\n");
        sb.append("create_flight,Ryan_Air,ry_19,100,2,route_one,08:30,p506bp\n");

// check assign pilots
        sb.append("assign_pilot,Delta,dl_10,p2\n");
        sb.append("assign_pilot,British_Airways,ba_17,p5\n");
        sb.append("assign_pilot,British_Airways,ba_17,p7\n");
        sb.append("assign_pilot,Ryan_Air,ry_19,p11\n");
        sb.append("assign_pilot,Delta,dl_33,p13\n");
        sb.append("assign_pilot,Delta,dl_33,p17\n");

// show initial simulation state
        sb.append("show_airlines\n");
        sb.append("show_airports\n");
        sb.append("show_people\n");
        sb.append("show_airplanes\n");
        sb.append("show_routes\n");

// simulate chronological flight sequence
        sb.append("passengers_board,Delta,dl_10\n");
        sb.append("assign_pilot,Delta,dl_10,p3\n");
        sb.append("passengers_board,British_Airways,ba_17\n");
        sb.append("flight_takeoff,British_Airways,ba_17\n");
        sb.append("passengers_board,Delta,dl_10\n");
        sb.append("flight_takeoff,Delta,dl_10\n");
        sb.append("passengers_board,Delta,dl_33\n");
        sb.append("flight_takeoff,Delta,dl_33\n");
        sb.append("passengers_board,Ryan_Air,ry_19\n");
        sb.append("flight_takeoff,Ryan_Air,ry_19\n");
        sb.append("flight_landing,Delta,dl_10\n");
        sb.append("passengers_disembark,Delta,dl_10\n");
        sb.append("passengers_board,Delta,dl_10\n");
        sb.append("flight_takeoff,Delta,dl_10\n");
        sb.append("flight_landing,Ryan_Air,ry_19\n");
        sb.append("passengers_disembark,Ryan_Air,ry_19\n");
        sb.append("passengers_board,Ryan_Air,ry_19\n");
        sb.append("flight_takeoff,Ryan_Air,ry_19\n");
        sb.append("flight_landing,British_Airways,ba_17\n");
        sb.append("passengers_disembark,British_Airways,ba_17\n");
        sb.append("flight_landing,Ryan_Air,ry_19\n");
        sb.append("passengers_disembark,Ryan_Air,ry_19\n");
        sb.append("retire_flight,Ryan_Air,ry_19\n");
        sb.append("passengers_board,British_Airways,ba_17\n");
        sb.append("flight_takeoff,British_Airways,ba_17\n");
        sb.append("flight_landing,British_Airways,ba_17\n");
        sb.append("passengers_disembark,British_Airways,ba_17\n");
        sb.append("flight_landing,Delta,dl_10\n");
        sb.append("passengers_disembark,Delta,dl_10\n");
        sb.append("passengers_board,British_Airways,ba_17\n");
        sb.append("flight_takeoff,British_Airways,ba_17\n");
        sb.append("passengers_board,Delta,dl_10\n");
        sb.append("flight_takeoff,Delta,dl_10\n");
        sb.append("flight_landing,Delta,dl_33\n");
        sb.append("passengers_disembark,Delta,dl_33\n");
        sb.append("flight_landing,Delta,dl_10\n");
        sb.append("passengers_disembark,Delta,dl_10\n");
        sb.append("flight_landing,British_Airways,ba_17\n");
        sb.append("passengers_disembark,British_Airways,ba_17\n");
        sb.append("passengers_board,Delta,dl_33\n");
        sb.append("flight_takeoff,Delta,dl_33\n");
        sb.append("passengers_board,Delta,dl_10\n");
        sb.append("flight_takeoff,Delta,dl_10\n");
        sb.append("flight_landing,Delta,dl_33\n");
        sb.append("passengers_disembark,Delta,dl_33\n");
        sb.append("passengers_board,British_Airways,ba_17\n");
        sb.append("flight_takeoff,British_Airways,ba_17\n");
        sb.append("flight_landing,Delta,dl_10\n");
        sb.append("passengers_disembark,Delta,dl_10\n");
        sb.append("retire_flight,Delta,dl_10\n");
        sb.append("passengers_board,Delta,dl_33\n");
        sb.append("flight_takeoff,Delta,dl_33\n");
        sb.append("flight_landing,British_Airways,ba_17\n");
        sb.append("passengers_disembark,British_Airways,ba_17\n");
        sb.append("retire_flight,British_Airways,ba_17\n");
        sb.append("flight_landing,Delta,dl_33\n");
        sb.append("passengers_disembark,Delta,dl_33\n");
        sb.append("retire_flight,Delta,dl_33\n");

// show final simulation state
        sb.append("show_airlines\n");
        sb.append("show_airports:\n");
        sb.append("show_people\n");
        sb.append("show_airplanes\n");
        sb.append("show_routes\n");


        String[] lines = sb.toString().split("\n");
        for (String s: lines){

            wholeInputLine = s;
            tokens = wholeInputLine.split(DELIMITER);
            System.out.println(">> " + wholeInputLine);

            if (cmdMethod(commandLineInput, DELIMITER,tokens, wholeInputLine))
                break;

        }
        System.out.println("simulation terminated");
        commandLineInput.close();
    }


    private boolean cmdMethod(Scanner commandLineInput, String DELIMITER, String[] tokens, String wholeInputLine) {
        try {
            // Determine the next command and echo it to the monitor for testing purposes


            if (tokens[0].indexOf("//") == 0) {
                // System.out.println(wholeInputLine);

                // instructions to create simulation resources
            } else if (tokens[0].equals("create_airline")) {
                System.out.println("name: " + tokens[1] + ", revenue: " + tokens[2]);

                system.createAirline(new Airline(tokens[1], Double.parseDouble(tokens[2])));

            } else if (tokens[0].equals("create_airport")) {
                System.out.print("code: " + tokens[1] + ", name: " + tokens[2] + ", city: " + tokens[3]);
                System.out.println(", state: " + tokens[4] + ", country: " + tokens[5]);

                //implementation
                system.createAirport(new Airport(tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]));


            } else if (tokens[0].equals("create_flight")) {
                System.out.print("airline: " + tokens[1] + ", number: " + tokens[2] + ", cost: " + tokens[3]);
                System.out.print(", route_progress: " + tokens[4] + ", route_name: " + tokens[5]);
                System.out.println(", next_status_change: " + tokens[6] + ", supporting_aircraft: " + tokens[7]);

                Airline airline = system.getAirlineFromAMS(tokens[1]);
                system.createFlight(tokens[1], new Flight(airline, tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), tokens[5], LocalTime.parse(tokens[6]), tokens[7]));

            } else if (tokens[0].equals("create_passenger")) {
                System.out.print("identifier: " + tokens[1] + ", first_name: " + tokens[2] + ", last_name: " + tokens[3]);
                System.out.println(", frequent_flyer_miles: " + tokens[4] + ", funds: " + tokens[5] + ", location: " + tokens[6]);

                system.createPassenger(new Passenger(tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6]), tokens[6]);

            } else if (tokens[0].equals("create_pilot")) {
                System.out.print("identifier: " + tokens[1] + ", first_name: " + tokens[2] + ", last_name: " + tokens[3]);
                System.out.println(", tax_identifier: " + tokens[4] + ", experience: " + tokens[5] + ", location: " + tokens[6]);

                system.createPilot(new Pilot(tokens[1], tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]), tokens[6]), tokens[6]);

            } else if (tokens[0].equals("create_jet")) {
                System.out.print("tail_number: " + tokens[1] + ", seating_capacity: " + tokens[2] + ", speed: " + tokens[3]);
                System.out.println(", engines: " + tokens[4]);

                system.createJet(new Jet(tokens[1],Integer.parseInt(tokens[2]),Double.parseDouble(tokens[3]),Integer.parseInt(tokens[4])));


            } else if (tokens[0].equals("create_prop")) {
                System.out.print("tail_number: " + tokens[1] + ", seating_capacity: " + tokens[2] + ", speed: " + tokens[3]);
                System.out.println(", engines: " + tokens[4] + ", landing_skids: " + tokens[5]);

                system.createProp(new Propeller(tokens[1],Integer.parseInt(tokens[2]),Double.parseDouble(tokens[3]),Integer.parseInt(tokens[4]), Boolean.parseBoolean(tokens[5])));

            } else if (tokens[0].equals("create_leg")) {
                System.out.println("departs_from: " + tokens[1] + ", distance: " + tokens[2] + ", arrives_at: " + tokens[3]);

                //TODO when creating a leg, run the find airline form AC method for both the
                // departure and arrival airports, that way we can pass those into the constuctor
                // as the type of Airport
                Airport departsFrom = system.getAirportFromAMS(tokens[1]);
                Airport arrivesAt = system.getAirportFromAMS(tokens[3]);
                if(departsFrom ==null || arrivesAt ==null){
                    System.out.println("problem in crerating leg: departing airpoort is : " + departsFrom + " arrival airport: " + arrivesAt);
                }
                else{
                    system.createLeg(tokens[1], tokens[3], new Leg(departsFrom, tokens[2], arrivesAt));
                }

            } else if (tokens[0].equals("create_route")) {
                System.out.println("name: " + tokens[1] + ", departs_from: " + tokens[2] + ", first_hop: " + tokens[3]);


                // this is the old code, but basically check to see if a leg exists and then pair em up
                // otherwise create a new leg --> actually throw an exception since we don't have a distance
                // to actually create that leg
                Airport departsFrom = system.getAirportFromAMS(tokens[2]);
                system.createRoute(new Route(tokens[1], departsFrom), tokens[2], tokens[3]);

            } else if (tokens[0].equals("extend_route")) {
                System.out.println("name: " + tokens[1] + ", next_hop: " + tokens[2]);

                system.extendRoute(tokens[1], tokens[2]);

            } else if (tokens[0].equals("extend_vacation")) {
                System.out.println("identifier: " + tokens[1] + ", destination: " + tokens[2]);

                system.extendVacation(tokens[1], tokens[2]);

            } else if (tokens[0].equals("toggle_license")) {
                System.out.println("identifier: " + tokens[1] + ", license: " + tokens[2]);

                system.toggleLicense(tokens[1], tokens[2]);

                // instructions to advance the simulation over time
            } else if (tokens[0].equals("assign_pilot")) {
                System.out.print("airline_name: " + tokens[1] + ", flight_number: " + tokens[2]);
                System.out.println("pilot_identifier: " + tokens[3]);

                system.assignPilot(tokens[1], tokens[2], tokens[3]);

            } else if (tokens[0].equals("flight_landing")) {
                System.out.println("airline_name: " + tokens[1] + ", flight_number: " + tokens[2]);

                system.flightLanding(tokens[1], tokens[2]);

            } else if (tokens[0].equals("flight_takeoff")) {
                System.out.println("airline_name: " + tokens[1] + ", flight_number: " + tokens[2]);

                system.flightTakeoff(tokens[1], tokens[2]);

            } else if (tokens[0].equals("passengers_board")) {
                System.out.println("airline_name: " + tokens[1] + ", flight_number: " + tokens[2]);

                system.passengersBoard(tokens[1], tokens[2]);

            } else if (tokens[0].equals("passengers_disembark")) {
                System.out.println("airline_name: " + tokens[1] + ", flight_number: " + tokens[2]);

                system.passengersDisembark(tokens[1], tokens[2]);

            } else if (tokens[0].equals("retire_flight")) {
                System.out.print("airline_name: " + tokens[1] + ", flight_number: " + tokens[2]);

                system.retireFlight(tokens[1], tokens[2]);

                // instructions to view the state of the simulation
            } else if (tokens[0].equals("show_airlines")) {
                System.out.println("DIAGNOSTIC ONLY | no parameters");

                System.out.println(system.showAirlines());

            } else if (tokens[0].equals("show_airplanes")) {
                System.out.println("DIAGNOSTIC ONLY | no parameters");

                String msg = system.showAirplanes();
                System.out.println(msg);

            } else if (tokens[0].equals("show_airports")) {
                System.out.println("DIAGNOSTIC ONLY | no parameters");

                System.out.println(system.showAirports());

            } else if (tokens[0].equals("show_people")) {
                System.out.println("DIAGNOSTIC ONLY | no parameters");

                System.out.println(system.showPeople());

            } else if (tokens[0].equals("show_routes")) {
                System.out.println("DIAGNOSTIC ONLY | no parameters");

                System.out.println(system.showRoutes());

            } else if (tokens[0].equals("stop")) {
                System.out.println("stop acknowledged");
                return true;

            } else {
                System.out.println("command " + tokens[0] + " NOT acknowledged");
            }
        } catch (Exception e) {
            displayMessage("error", "during command loop >> execution");
            e.printStackTrace();
            System.out.println();
        }
        return false;
    }


    void displayMessage(String status, String text_output) {
        System.out.println(status.toUpperCase() + ": " + text_output.toLowerCase());
    }

    // TODO all the methods we added to Airline Controller class


    //TODO add getLegFromAC method ??


    //TODO getRouteNameFromAC
    // return name of route or else give user an error saying that the route does not exist
}
