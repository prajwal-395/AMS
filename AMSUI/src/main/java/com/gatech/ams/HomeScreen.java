package com.gatech.ams;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class HomeScreen extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        homeScreen();
        primaryStage.setTitle("Airline Management System");
        primaryStage.show();
    }

    private void homeScreen() {
        Button airlineButton = new Button("Airlines");
        Button airportButton = new Button("Airports");
        Button flightButton = new Button("Flights");
        Button passengerButton = new Button("Passengers");
        Button pilotButton = new Button("Pilots");
        Button jetButton = new Button("Jets");
        Button propButton = new Button("Props");
        Button routeButton = new Button("Routes");
        Button legButton = new Button("Legs");

        airlineButton.setOnAction(event -> showAirlineScene());
        airportButton.setOnAction(event -> showAirportScene());
        flightButton.setOnAction(event -> showFlightScene());
        passengerButton.setOnAction(event -> showPassengerScene());
        pilotButton.setOnAction(event -> showPilotScene());
        jetButton.setOnAction(event -> showJetScene());
        propButton.setOnAction(event -> showPropScene());
        routeButton.setOnAction(event -> showRouteScene());
        legButton.setOnAction(event -> showLegScene());

        VBox root = new VBox();
        root.getChildren().add(airlineButton);
        root.getChildren().add(airportButton);
        root.getChildren().add(flightButton);
        root.getChildren().add(passengerButton);
        root.getChildren().add(pilotButton);
        root.getChildren().add(jetButton);
        root.getChildren().add(propButton);
        root.getChildren().add(routeButton);
        root.getChildren().add(legButton);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
    }

    private void showAirlineScene() {
        Button add = new Button("Add Airline");
        Button delete = new Button("Remove Airline");
        Button show = new Button("Show Airlines");

        add.setOnAction(event -> airlineInfo());
        delete.setOnAction(event -> homeScreen());
        show.setOnAction(event -> homeScreen());

        VBox vbox = new VBox(10, add, delete, show);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    private void airlineInfo() {

        Button backButton = new Button("Back to Airline scene");
        backButton.setOnAction(event -> showAirlineScene());
        TextField name = new TextField();
        name.setPromptText("Enter Airline Name: ");

        TextField revenue = new TextField();
        revenue.setPromptText("Enter Airline Revenue: ");

        VBox vbox = new VBox(10, name, revenue, backButton);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    private void airportInfo() {

        Button backButton = new Button("Back to Airport scene");
        backButton.setOnAction(event -> showAirportScene());
        TextField code = new TextField();
        code.setPromptText("Enter IATA code: ");

        TextField name = new TextField();
        name.setPromptText("Enter airport name: ");

        TextField city = new TextField();
        city.setPromptText("Enter city: ");

        TextField state = new TextField();
        state.setPromptText("Enter state: ");

        TextField country = new TextField();
        country.setPromptText("Enter country: ");

        VBox vbox = new VBox(10, code, name, city, state, country, backButton);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    private void showAirportScene() {
        Button add = new Button("Add Airport");
        Button delete = new Button("Remove Airport");
        Button show = new Button("Show Airports");

        add.setOnAction(event -> airportInfo());
        delete.setOnAction(event -> homeScreen());
        show.setOnAction(event -> homeScreen());

        VBox vbox = new VBox(10, add, delete, show);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    private void showFlightScene() {
        Button add = new Button("Add Flight");
        Button delete = new Button("Remove Flight");
        Button show = new Button("Show Flights");

        add.setOnAction(event -> flightInfo());
        delete.setOnAction(event -> homeScreen());
        show.setOnAction(event -> homeScreen());

        VBox vbox = new VBox(10, add, delete, show);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    private void flightInfo() {

        Button backButton = new Button("Back to Flight scene");
        backButton.setOnAction(event -> showFlightScene());

        TextField airlineName = new TextField();
        airlineName.setPromptText("Enter airline name: ");

        TextField flightNum = new TextField();
        flightNum.setPromptText("Enter flight number: ");

        TextField cost = new TextField();
        cost.setPromptText("Enter flight cost: ");

        TextField progress = new TextField();
        progress.setPromptText("Enter route progress: ");

        TextField routeName = new TextField();
        routeName.setPromptText("Enter route name: ");

        TextField nextTime = new TextField();
        nextTime.setPromptText("Enter next_status_change: ");

        TextField tailNum = new TextField();
        tailNum.setPromptText("Enter aircraft tail number: ");

        VBox vbox = new VBox(10, airlineName, flightNum, cost, progress, routeName, nextTime, tailNum, backButton);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    private void showPassengerScene() {
        Button add = new Button("Add Passenger");
        Button delete = new Button("Remove Passenger");
        Button show = new Button("Show Passengers");

        add.setOnAction(event -> passengerInfo());
        delete.setOnAction(event -> homeScreen());
        show.setOnAction(event -> homeScreen());

        VBox vbox = new VBox(10, add, delete, show);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    private void passengerInfo() {

        Button backButton = new Button("Back to Passenger scene");
        backButton.setOnAction(event -> showPassengerScene());

        TextField identifier = new TextField();
        identifier.setPromptText("Enter personID: ");

        TextField fName = new TextField();
        fName.setPromptText("Enter first name: ");

        TextField lName = new TextField();
        lName.setPromptText("Enter last name: ");

        TextField miles = new TextField();
        miles.setPromptText("Enter frequent flyer miles: ");

        TextField funds = new TextField();
        funds.setPromptText("Enter funds: ");

        TextField location = new TextField();
        location.setPromptText("Enter location: ");

        VBox vbox = new VBox(10, identifier, fName, lName, miles, funds, location, backButton);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }


    private void showPilotScene() {
        Button add = new Button("Add Pilot");
        Button delete = new Button("Remove Pilot");
        Button show = new Button("Show Pilots");

        add.setOnAction(event -> pilotInfo());
        delete.setOnAction(event -> homeScreen());
        show.setOnAction(event -> homeScreen());

        VBox vbox = new VBox(10, add, delete, show);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    private void pilotInfo() {

        Button backButton = new Button("Back to Pilot scene");
        backButton.setOnAction(event -> showPilotScene());

        TextField identifier = new TextField();
        identifier.setPromptText("Enter personID: ");

        TextField fName = new TextField();
        fName.setPromptText("Enter first name: ");

        TextField lName = new TextField();
        lName.setPromptText("Enter last name: ");

        TextField taxID = new TextField();
        taxID.setPromptText("Enter taxID: ");

        TextField experience = new TextField();
        experience.setPromptText("Enter pilot experience: ");

        TextField location = new TextField();
        location.setPromptText("Enter location: ");

        VBox vbox = new VBox(10, identifier, fName, lName, taxID, experience, location, backButton);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    private void showJetScene() {
        Button add = new Button("Add Jet");
        Button delete = new Button("Remove Jet");
        Button show = new Button("Show Jets");

        add.setOnAction(event -> jetInfo());
        delete.setOnAction(event -> homeScreen());
        show.setOnAction(event -> homeScreen());

        VBox vbox = new VBox(10, add, delete, show);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    private void jetInfo() {

        Button backButton = new Button("Back to Jet scene");
        backButton.setOnAction(event -> showJetScene());

        TextField tailNum = new TextField();
        tailNum.setPromptText("Enter tail number: ");

        TextField seatCap = new TextField();
        seatCap.setPromptText("Enter seating capacity: ");

        TextField speed = new TextField();
        speed.setPromptText("Enter speed: ");

        TextField engines = new TextField();
        engines.setPromptText("Enter number of engines: ");


        VBox vbox = new VBox(10, tailNum, seatCap, speed, engines, backButton);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    private void showPropScene() {
        Button add = new Button("Add Prop");
        Button delete = new Button("Remove Prop");
        Button show = new Button("Show Props");

        add.setOnAction(event -> propInfo());
        delete.setOnAction(event -> homeScreen());
        show.setOnAction(event -> homeScreen());

        VBox vbox = new VBox(10, add, delete, show);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    private void propInfo() {

        Button backButton = new Button("Back to Prop scene");
        backButton.setOnAction(event -> showPropScene());

        TextField tailNum = new TextField();
        tailNum.setPromptText("Enter tail number: ");

        TextField seatCap = new TextField();
        seatCap.setPromptText("Enter seating capacity: ");

        TextField speed = new TextField();
        speed.setPromptText("Enter speed: ");

        TextField engines = new TextField();
        engines.setPromptText("Enter number of engines: ");

        Label skids = new Label("Landing Skids: ");

        ComboBox<String> landingSkids = new ComboBox<String>();
        landingSkids.getItems().addAll("True", "False");


        VBox vbox = new VBox(10, tailNum, seatCap, speed, engines, skids, landingSkids, backButton);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    private void showRouteScene() {
        Button add = new Button("Add Route");
        Button delete = new Button("Remove Route");
        Button show = new Button("Show Routes");

        add.setOnAction(event -> routeInfo());
        delete.setOnAction(event -> homeScreen());
        show.setOnAction(event -> homeScreen());

        VBox vbox = new VBox(10, add, delete, show);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    private void routeInfo() {

        Button backButton = new Button("Back to Route scene");
        backButton.setOnAction(event -> showRouteScene());

        TextField name = new TextField();
        name.setPromptText("Enter route name: ");

        TextField departure = new TextField();
        departure.setPromptText("Enter departure airport name: ");

        TextField hop = new TextField();
        hop.setPromptText("Enter first hop: ");


        VBox vbox = new VBox(10, name, departure, hop, backButton);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    private void showLegScene() {
        Button add = new Button("Add Leg");
        Button delete = new Button("Remove Leg");
        Button show = new Button("Show Legs");

        add.setOnAction(event -> legInfo());
        delete.setOnAction(event -> homeScreen());
        show.setOnAction(event -> homeScreen());

        VBox vbox = new VBox(10, add, delete, show);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    private void legInfo() {

        Button backButton = new Button("Back to Leg scene");
        backButton.setOnAction(event -> showLegScene());

        TextField departure = new TextField();
        departure.setPromptText("Enter departure airport name: ");

        TextField distance = new TextField();
        distance.setPromptText("Enter distance: ");

        TextField arrival = new TextField();
        arrival.setPromptText("Enter arrival airport name: ");


        VBox vbox = new VBox(10, departure, distance, arrival, backButton);
        vbox.setPrefSize(300, 250);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}