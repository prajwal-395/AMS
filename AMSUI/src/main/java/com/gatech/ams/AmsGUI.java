package com.gatech.ams;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalTime;

public class AmsGUI extends Application {

    private Stage primaryStage;
    private double x = 800;
    private double y = 600;

    AirlineManagementSystem ams = null;

    //BorderPane borderPane = new BorderPane();


    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        //stage.setScene(scene);

        ams = new AirlineManagementSystem();

        populateSystem(ams);

        this.primaryStage = stage;
        stage.setResizable(true);
        stage.setX(x);
        stage.setY(y);
        primaryStage.setTitle("Airlines Management System!");

        //show home screen
        Scene homeScene = homeScreen();
        primaryStage.setScene(homeScene);
        primaryStage.show();

    }

    private void populateSystem(AirlineManagementSystem ams) {
        AirlineController simulator = new AirlineController(ams);
        simulator.TestCommandLoop();
    }

    public static void main(String[] args) {
        launch();
    }

    private Scene homeScreen() {

        BorderPane borderPane = getLayout();
        VBox vbox = new VBox();
        borderPane.setCenter(vbox);
        Scene homeScene = new Scene(borderPane, x, y);

//        Button airlineButton = new Button("Airlines");
        Button airportButton = new Button("Airports");
//        Button flightButton = new Button("Flights");
//        Button passengerButton = new Button("Passengers");
//        Button pilotButton = new Button("Pilots");
//        Button jetButton = new Button("Jets");
//        Button propButton = new Button("Props");
//        Button routeButton = new Button("Routes");
//        Button legButton = new Button("Legs");

//        airlineButton.setOnAction(event -> showAirlineScene());
        airportButton.setOnAction(event -> ams.showAirports());
//        flightButton.setOnAction(event -> showFlightScene());
//        passengerButton.setOnAction(event -> showPassengerScene());
//        pilotButton.setOnAction(event -> showPilotScene());
//        jetButton.setOnAction(event -> showJetScene());
//        propButton.setOnAction(event -> showPropScene());
//        routeButton.setOnAction(event -> showRouteScene());
//        legButton.setOnAction(event -> showLegScene());


//        vbox.getChildren().add(airlineButton);
//        vbox.getChildren().add(flightButton);
//        vbox.getChildren().add(airportButton);
//        vbox.getChildren().add(passengerButton);
//        vbox.getChildren().add(pilotButton);
//        vbox.getChildren().add(jetButton);
//        vbox.getChildren().add(propButton);
//        vbox.getChildren().add(routeButton);
//        vbox.getChildren().add(legButton);

        return homeScene;

    }

    private void creatShowScreen(VBox vBox){
        BorderPane borderPane = getLayout();
        borderPane.setCenter(vBox);
        Scene scene = new Scene(borderPane, x, y);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private BorderPane getLayout() {
        BorderPane borderPane = new BorderPane();
        MenuBar mb = createMenu();
        borderPane.setTop(mb);
        return borderPane;
    }


    private MenuBar createMenu(){

        // create a menubar
        MenuBar mb = new MenuBar();

        Menu airlineMenu = new Menu("Airlines");
        Menu airportMenu = new Menu("Airports");
        Menu flightMenu = new Menu("Flights");
        Menu peopleMenu = new Menu("People");
        Menu aircraftMenu = new Menu("Aircrafts");
        Menu routeMenu = new Menu("Route Mgmt");

        //region Airline Menu Section
        // create menuitems for Airlines
        MenuItem mShowAirlines = new MenuItem("Show Airlines");
        MenuItem mAddAirlines = new MenuItem("Add Airlines");
        // add menu items to menu
        airlineMenu.getItems().add(mShowAirlines);
        airlineMenu.getItems().add(mAddAirlines);
        // Set events for menu items
        mAddAirlines.setOnAction(actionEvent -> addAirlineInfo());
        mShowAirlines.setOnAction(actionEvent -> showAirlineInfo());
    //endregion

        //region Airport Menu Section
        //create menu item for Airport
        MenuItem mShowAirport = new MenuItem("Show Airport");
        MenuItem mAddAirport = new MenuItem("Add Airport");
        // add menu items to menu
        airportMenu.getItems().add(mShowAirport);
        airportMenu.getItems().add(mAddAirport);
        // Set events for menu items
        mAddAirport.setOnAction(actionEvent -> addAirportInfo());
        mShowAirport.setOnAction(actionEvent -> showAirportInfo());
        //endregion

        //region Flight Menu Section
        //create menu item for Flight
        MenuItem mShowFlight = new MenuItem("Show Flight");
        MenuItem mAddFlight = new MenuItem("Add Flight");
        // add menu items to menu
        flightMenu.getItems().add(mShowFlight);
        flightMenu.getItems().add(mAddFlight);
        // Set events for menu items
        mAddFlight.setOnAction(actionEvent -> addFlightInfo());
        mShowFlight.setOnAction(actionEvent -> showFlightInfo());
        //endregion

        //region Aircrafts Menu Section
        //create menu item for Flight
        MenuItem mShowJets = new MenuItem("Show Jets");
        MenuItem mAddJets = new MenuItem("Add Jets");
        MenuItem mShowProps = new MenuItem("Show Propellors");
        MenuItem mAddProps = new MenuItem("Add Propellors");
        MenuItem mshowAircraft = new MenuItem("Show All Aircrafts");

        // add menu items to menu
        aircraftMenu.getItems().add(mShowJets);
        aircraftMenu.getItems().add(mAddJets);
        aircraftMenu.getItems().add(mShowProps);
        aircraftMenu.getItems().add(mAddProps);
        aircraftMenu.getItems().add(mshowAircraft);

        // Set events for menu items
        mAddJets.setOnAction(actionEvent -> addJetInfo());
        mShowJets.setOnAction(actionEvent -> showJetInfo());
        mAddProps.setOnAction(actionEvent -> addPropInfo());
        mShowProps.setOnAction(actionEvent -> showPropInfo());
        mshowAircraft.setOnAction(actionEvent -> showAllAircraftInfo()); // todo showAllAircraftsInfo());
        //endregion

        //region People Menu Section
        //create menu item for Flight
        MenuItem mShowPass = new MenuItem("Show Passengers");
        MenuItem mAddPass = new MenuItem("Add Passengers");
        MenuItem mShowPilot = new MenuItem("Show Pilots");
        MenuItem mAddPilot = new MenuItem("Add Pilots");
        MenuItem mshowPeople = new MenuItem("Show All People");

        // add menu items to menu
        peopleMenu.getItems().add(mShowPass);
        peopleMenu.getItems().add(mAddPass);
        peopleMenu.getItems().add(mShowPilot);
        peopleMenu.getItems().add(mAddPilot);
        peopleMenu.getItems().add(mshowPeople);

        // Set events for menu items
        mAddPass.setOnAction(actionEvent -> addPassengerInfo());
        mShowPass.setOnAction(actionEvent -> showPassengerInfo());
        mAddPilot.setOnAction(actionEvent -> addPilotInfo());
        mShowPilot.setOnAction(actionEvent -> showPilotInfo());
        mshowPeople.setOnAction(actionEvent -> showPeopleInfo()); // todo showPeopleInfo());
        //endregion


        //region Routes & legs Menu Section
        //create menu item for Flight
        MenuItem mShowRoutes = new MenuItem("Show Routes");
        MenuItem mAddRoutes = new MenuItem("Add Routes");
        MenuItem mShowLegs = new MenuItem("Show Legs");
        MenuItem mAddLegs = new MenuItem("Add Legs");

        // add menu items to menu
        routeMenu.getItems().add(mShowRoutes);
        routeMenu.getItems().add(mAddRoutes);
        routeMenu.getItems().add(mShowLegs);
        routeMenu.getItems().add(mAddLegs);

        // Set events for menu items
        mAddRoutes.setOnAction(actionEvent -> addRouteInfo());
        mShowRoutes.setOnAction(actionEvent -> showRouteInfo());
        mAddLegs.setOnAction(actionEvent -> addLegInfo());
        mShowLegs.setOnAction(actionEvent -> showLegInfo());
        //endregion

        // add menu to menubar
        mb.getMenus().add(airlineMenu);
        mb.getMenus().add(airportMenu);
        mb.getMenus().add(flightMenu);
        mb.getMenus().add(peopleMenu);
        mb.getMenus().add(aircraftMenu);
        mb.getMenus().add(routeMenu);

       airlineMenu.setOnAction(event -> showAirlineScene());

       airportMenu.setOnAction(event -> showAirportScene());

        return  mb;

    }

    private void showHomeScreen(){
        Scene scene = homeScreen();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //region Airline Section
    //Show airlines
    private void showAirlineScene() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Button add = new Button("Add Airline");
        Button show = new Button("Show Airlines");

        add.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        show.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        add.setOnAction(event -> addAirlineInfo());
        show.setOnAction(event -> showAirlineInfo());
        vbox.getChildren().addAll(add,show);
        creatShowScreen(vbox);
    }
    //add airline screen
    private void addAirlineInfo(){
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20,20,20,20));
        vbox.setSpacing(10);

        Label lscreen = new Label("Create New Airline");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label lname = new Label("Airline Name:");
        TextField name = new TextField();
        name.setPromptText("Enter Airline Name: ");
        Label lrevenue = new Label("Airline Revenue:");
        TextField revenue = new TextField();
        revenue.setPromptText("Enter Airline Revenue: ");
        Button addAirline = new Button("Add Airline");
        Button backButton = new Button("Back to Airline Scene");

        addAirline.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        addAirline.setOnAction(event -> ams.createAirline(new Airline(name.getText(),Double.parseDouble(revenue.getText()))));
        backButton.setOnAction(event -> showAirlineScene());
        vbox.getChildren().addAll(lscreen,lname,name,lrevenue,revenue,addAirline,backButton);
        creatShowScreen(vbox);
    }
    //show airlines 
    private void showAirlineInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("All Airlines Details");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label l = new Label("AirlineView");
        String s = ams.showAirlines();
        l.setText(s);
        Button backButton = new Button("Back to Airline Scene");

        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        backButton.setOnAction(event -> showAirlineScene());
        vbox.getChildren().addAll(lscreen,l,backButton);
        creatShowScreen(vbox);
    }
    //endregion

    //region Airport Section
    private void showAirportScene() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Button add = new Button("Add Airport");
        Button show = new Button("Show Airports");

        add.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        show.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        add.setOnAction(event -> addAirportInfo());
        show.setOnAction(event -> showAirportInfo());
        vbox.getChildren().addAll(add,show);
        creatShowScreen(vbox);
    }
    private void addAirportInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("Create New Airport");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label lcode = new Label("Airport/IATA Code:");
        TextField code = new TextField();
        code.setPromptText("Enter Airport/IATA Code: ");
        Label lname = new Label("Airport Name:");
        TextField name = new TextField();
        name.setPromptText("Enter Airport Name: ");
        Label lcity = new Label("City:");
        TextField city = new TextField();
        city.setPromptText("Enter Airport City: ");
        Label lstate = new Label("State:");
        TextField state = new TextField();
        state.setPromptText("Enter Airport State: ");
        Label lcountry = new Label("Country:");
        TextField country = new TextField();
        country.setPromptText("Enter Airport Country: ");

        Button addAirport = new Button("Add Airport");
        Button backButton = new Button("Back to Airport Scene");

        addAirport.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        addAirport.setOnAction(event -> ams.createAirport(new Airport(code.getText(),name.getText(),city.getText(),state.getText(),country.getText())));
        backButton.setOnAction(event -> showAirportScene());
        vbox.getChildren().addAll(lscreen,lcode,code,lname,name,lcity,city,lstate,state,lcountry,country,addAirport,backButton);
        creatShowScreen(vbox);
    }
    private void showAirportInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("All Airport Details");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label l = new Label("AirPortView");
        String s = ams.showAirports();
        l.setText(s);
        Button backButton = new Button("Back to Airport Scene");

        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        backButton.setOnAction(event -> showAirportScene());
        vbox.getChildren().addAll(lscreen,l,backButton);
        creatShowScreen(vbox);
    }
    //endregion

    //region Pilot Section
    private void showPilotScene() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Button add = new Button("Add Pilot");
        Button show = new Button("Show Pilots");

        add.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        show.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        add.setOnAction(event -> addPilotInfo());
        show.setOnAction(event -> showPilotInfo());
        vbox.getChildren().addAll(add,show);
        creatShowScreen(vbox);
    }
    private void showPilotInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("All Pilots");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label l = new Label("PilotView");
        String s = ams.showPilots();
        l.setText(s);
        Button backButton = new Button("Back to People Scene");

        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        backButton.setOnAction(event -> showPassengerScene());
        vbox.getChildren().addAll(lscreen,l,backButton);
        creatShowScreen(vbox);
    }
    private void addPilotInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("Create New Pilot");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label lidentifier = new Label("Pilot Identifier:");
        TextField identifier = new TextField();
        identifier.setPromptText("Enter Pilot ID: ");
        Label lFname = new Label("First Name:");
        TextField fName = new TextField();
        fName.setPromptText("Enter First Name: ");
        Label lLname = new Label("Last Name:");
        TextField lName = new TextField();
        lName.setPromptText("Enter last Name: ");
        Label lTaxId = new Label("Tax Id:");
        TextField taxID = new TextField();
        taxID.setPromptText("Enter Tax Id: ");
        Label lexperience = new Label("Pilot Experience in Years:");
        TextField experience = new TextField();
        experience.setPromptText("Enter Pilot Experience: ");
        Label lLocation = new Label("Location Name:");
        TextField location = new TextField();
        location.setPromptText("Enter Location: ");

        Button addPilot = new Button("Add Pilot");
        Button backButton = new Button("Back to People Scene");

        addPilot.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        //Pilot p = new Pilot(identifier.getText(),fName.getText(),lName.getText(),taxID.getText(),Integer.parseInt(experience.getText()),location.getText());
        //addPilot.setOnAction(event -> ams.createPilot(p,location.getText()));
        addPilot.setOnAction(event -> ams.createPilot(new Pilot(identifier.getText(),fName.getText(),lName.getText(),
                                                        taxID.getText(),Integer.parseInt(experience.getText()),
                                                        location.getText()),location.getText()));

        backButton.setOnAction(event -> showPassengerScene());
        vbox.getChildren().addAll(lscreen,lidentifier,identifier,lFname,fName,lLname,lName,lTaxId,taxID,lexperience,experience,lLocation,location,addPilot,backButton);
        creatShowScreen(vbox);

    }
    //endregion

    //region Passenger Section
    private void showPassengerScene() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Button add = new Button("Add Passenger");
        Button show = new Button("Show Passengers");
        Button add1 = new Button("Add Pilot");
        Button show1 = new Button("Show Pilots");
        Button people = new Button("Show All People");

        add.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        show.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        add1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        show1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        people.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        add.setOnAction(event -> addPassengerInfo());
        show.setOnAction(event -> showPassengerInfo());
        add1.setOnAction(event -> addPilotInfo());
        show1.setOnAction(event -> showPilotInfo());
        people.setOnAction(event -> showPeopleInfo());

        vbox.getChildren().addAll(add,show,add1,show1,people);
        creatShowScreen(vbox);
    }
    private void showPassengerInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("All Passengers");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label l = new Label("PassengerView");
        String s = ams.showPassenger();
        l.setText(s);
        Button backButton = new Button("Back to People Scene");

        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        backButton.setOnAction(event -> showPassengerScene());
        vbox.getChildren().addAll(lscreen,l,backButton);
        creatShowScreen(vbox);
    }
    private void addPassengerInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("Create New Passenger");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label lidentifier = new Label("Passenger Identifier:");
        TextField id = new TextField();
        id.setPromptText("Enter Identifier/: ");
        Label lFname = new Label("First Name:");
        TextField fname = new TextField();
        fname.setPromptText("Enter First Name/: ");
        Label lLname = new Label("Last Name:");
        TextField lname = new TextField();
        lname.setPromptText("Enter Last Name: ");
        Label lFFmiles = new Label("Frequent Flier Miles:");
        TextField ffmiles = new TextField();
        ffmiles.setPromptText("Enter Frequent Flier Miles: ");
        Label lPFunds = new Label("Passenger Funds:");
        TextField pfunds = new TextField();
        pfunds.setPromptText("Enter Passenger Funds: ");
        Label lLocation = new Label("Location:");
        TextField location = new TextField();
        location.setPromptText("Enter Location: ");

        Button addPassenger = new Button("Add Passenger");
        Button backButton = new Button("Back to People Scene");

        addPassenger.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        addPassenger.setOnAction(event -> ams.createPassenger(new Passenger(id.getText(), fname.getText(), lname.getText(), Integer.parseInt(ffmiles.getText()), Integer.parseInt(pfunds.getText()), location.getText()), location.getText()));
        backButton.setOnAction(event -> showPassengerScene());
        vbox.getChildren().addAll(lscreen,lidentifier,id,lFname,fname,lLname,lname,lFFmiles,ffmiles,lPFunds,pfunds,lLocation,location,addPassenger,backButton);
        creatShowScreen(vbox);
    }
    private void showPeopleInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("All Pilots and Passengers ");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label l = new Label("People View");
        String s = ams.showPeople();
        l.setText(s);
        Button backButton = new Button("Back to People Scene");

        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        backButton.setOnAction(event -> showPassengerScene());
        vbox.getChildren().addAll(lscreen,l,backButton);
        creatShowScreen(vbox);
    }

    //endregion




    //region Flight Section
    private void showFlightScene() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Button add = new Button("Add Flight");
        Button show = new Button("Show Flights");

        add.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        show.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        add.setOnAction(event -> addFlightInfo());
        show.setOnAction(event -> showFlightInfo());
        vbox.getChildren().addAll(add,show);
        creatShowScreen(vbox);
    }
    private void addFlightInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("Create New Flight");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label lAirline = new Label("Airline Name:");
        TextField airlineName = new TextField();
        airlineName.setPromptText("Enter Airline Name: ");
        Label lFlightNum = new Label("Flight Number:");
        TextField flightNum = new TextField();
        flightNum.setPromptText("Enter flight Number: ");
        Label lcost = new Label("Flight Cost:");
        TextField cost = new TextField();
        cost.setPromptText("Enter Flight Cost: ");
        Label lprogress = new Label("Route Progress:");
        TextField progress = new TextField();
        progress.setPromptText("Enter Route Progress: ");
        Label lroutename = new Label("Route Name:");
        TextField routeName = new TextField();
        routeName.setPromptText("Enter Route Name: ");
        Label lNextTime = new Label("Next Status Change:");
        TextField nextTime = new TextField();
        nextTime.setPromptText("Enter Next_Status_Change: ");
        Label ltailNum = new Label("Aircraft Tail Number:");
        TextField tailNum = new TextField();
        tailNum.setPromptText("Enter Aircraft Tail Number: ");

        Button addFlight = new Button("Add Flight");
        Button backButton = new Button("Back to Flight Scene");

        addFlight.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");


        addFlight.setOnAction(Event -> createFlight(airlineName.getText(),flightNum.getText(),
                                                    Integer.parseInt(cost.getText()),Integer.parseInt(progress.getText()),
                                                    routeName.getText(),LocalTime.parse(nextTime.getText()),
                                                    tailNum.getText()));

        backButton.setOnAction(event -> showFlightScene());
        vbox.getChildren().addAll(lscreen,lAirline,airlineName,lFlightNum,flightNum,lcost,cost,lprogress,progress,lroutename,routeName,lNextTime,nextTime,ltailNum,tailNum,addFlight,backButton);
        creatShowScreen(vbox);
    }

    private void createFlight(String airlineName, String flightNum, Integer cost, Integer progress, String routeName, LocalTime nextTime, String tailNum){

        Airline airline = ams.getAirlineFromAMS(airlineName);
        Route route = ams.getRouteFromAMS(routeName);
        Airplane supportingAirPlane = ams.getAirplaneFromAMS(tailNum);

        Flight flight = new Flight(airline, flightNum,cost,progress, route,nextTime,supportingAirPlane);
        ams.createFlight(airlineName,flight);
    }

    private void showFlightInfo(){

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Label lscreen = new Label("All Flights");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label l = new Label("FlightView");
        String s =  ams.showFlights();
        l.setText(s);
        Button backButton = new Button("Back to Flight Scene");

        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        backButton.setOnAction(event -> showFlightScene());
        vbox.getChildren().addAll(lscreen,l,backButton);
        creatShowScreen(vbox);
    }
    //endregion

    //region showAircraft
    private void showAllAircraftInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("All Aircrafts");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label l = new Label("Aircraft View");
        String s = ams.showAirplanes(); //Todo
        l.setText(s);
        Button backButton = new Button("Back to Aircraft Scene");

        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        backButton.setOnAction(event -> showJetScene());
        vbox.getChildren().addAll(lscreen,l,backButton);
        creatShowScreen(vbox);
    }

    //endregion

    //region Jet Section
    private void showJetScene() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Button add = new Button("Add Jet");
        Button show = new Button("Show Jets");
        Button add1 = new Button("Add Propellors");
        Button show1 = new Button("Show Propellors");
        Button aircraft = new Button("Show All Aircrafts");

        add.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        show.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        add1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        show1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        aircraft.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        add.setOnAction(event -> addJetInfo());
        show.setOnAction(event -> showJetInfo());
        add1.setOnAction(event -> addPropInfo());
        show1.setOnAction(event -> showPropInfo());
        aircraft.setOnAction(event -> showAllAircraftInfo());

        vbox.getChildren().addAll(add,show,add1,show1,aircraft);
        creatShowScreen(vbox);
    }
    private void addJetInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("Create New Jet");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label ltailNum = new Label("Aircraft Number:");
        TextField tailNum = new TextField();
        tailNum.setPromptText("Enter Aircraft Tail Number: ");
        Label lseatCap = new Label("Jet Seating Capacity:");
        TextField seatCap = new TextField();
        seatCap.setPromptText("Enter Seating Capacity: ");
        Label lspeed = new Label("Jet Speed:");
        TextField speed = new TextField();
        speed.setPromptText("Enter Speed: ");
        Label lengineNum = new Label("Number of Engines:");
        TextField engineNum = new TextField();
        engineNum.setPromptText("Enter Number of Engines: ");

        Button addJet = new Button("Add Jet");
        Button backButton = new Button("Back to Aircraft Scene");

        addJet.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        addJet.setOnAction(event -> ams.createJet(new Jet( tailNum.getText(),Integer.parseInt(seatCap.getText()),Double.parseDouble(speed.getText()),Integer.parseInt(engineNum.getText()))));
        backButton.setOnAction(event -> showJetScene());
        vbox.getChildren().addAll(lscreen,ltailNum,tailNum,lseatCap,seatCap,lspeed,speed,lengineNum,engineNum,addJet,backButton);
        creatShowScreen(vbox);



    }
    private void showJetInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("All Jets");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label l = new Label("JetView");
        String s = ams.showJetAirplanes(); //Todo
        l.setText(s);
        Button backButton = new Button("Back to Aircraft Scene");

        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        backButton.setOnAction(event -> showJetScene());
        vbox.getChildren().addAll(lscreen,l,backButton);
        creatShowScreen(vbox);
    }
    //endregion

    //region Prop Section
    private void showPropScene() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Button add = new Button("Add Prop");
        Button show = new Button("Show Props");
        add.setOnAction(event -> addPropInfo());
        show.setOnAction(event -> showPropInfo());
        vbox.getChildren().addAll(add,show);
        creatShowScreen(vbox);
    }
    private void showPropInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("All Propellors");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label l = new Label("Propellor View");
        String s = ams.showPropAirplanes();
        l.setText(s);
        Button backButton = new Button("Back to Aircraft Scene");

        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        backButton.setOnAction(event -> showJetScene());
        vbox.getChildren().addAll(lscreen,l,backButton);
        creatShowScreen(vbox);
    }
    private void addPropInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("Create New Propellor");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label ltailNum = new Label("Propellor Tail Number:");
        TextField tailNum = new TextField();
        tailNum.setPromptText("Enter Tail Number: ");
        Label lseatCap = new Label("Seating Capacity:");
        TextField seatCap = new TextField();
        seatCap.setPromptText("Enter Seating Capacity: ");
        Label lspeed = new Label("Propellor Speed:");
        TextField speed = new TextField();
        speed.setPromptText("Enter Speed: ");
        Label lengineNum = new Label("Number of Engines:");
        TextField engineNum = new TextField();
        engineNum.setPromptText("Enter Number of Engines: ");
        Label skids = new Label("Landing Skids: ");
        ComboBox<String> landingSkids = new ComboBox<String>();
        landingSkids.getItems().addAll("True", "False");

        Button addProp = new Button("Add Prop");
        Button backButton = new Button("Back to Aircraft Scene");

        addProp.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        addProp.setOnAction(event -> ams.createProp(new Propeller(tailNum.getText(),Integer.parseInt(seatCap.getText()),Double.parseDouble(speed.getText()),Integer.parseInt(engineNum.getText()),Boolean.parseBoolean(landingSkids.getValue()))));
        backButton.setOnAction(event -> showJetScene());
        vbox.getChildren().addAll(lscreen,ltailNum,tailNum,lseatCap,seatCap,lspeed,speed,lengineNum,engineNum,skids,landingSkids,addProp,backButton);
        creatShowScreen(vbox);
    }
//endregion


    //region leg Section
    private void showLegScene() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Button add = new Button("Add Leg");
        Button show = new Button("Show Legs");

        add.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        show.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        add.setOnAction(event -> addLegInfo());
        show.setOnAction(event -> showLegInfo());
        vbox.getChildren().addAll(add,show);
        creatShowScreen(vbox);
    }
    private void showLegInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("All Legs");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label l = new Label("Leg View");
        String s = ams.showLegs(); //
        l.setText(s);
        Button backButton = new Button("Back to Leg Scene");

        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        backButton.setOnAction(event -> showLegScene());
        vbox.getChildren().addAll(lscreen,l,backButton);
        creatShowScreen(vbox);
    }
    private void addLegInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("Create New Leg");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label ldepartsFrom = new Label("Departure Airport Name:");
        TextField departsFrom = new TextField();
        departsFrom.setPromptText("Enter Departure Airport Name: ");
        Label ldistance = new Label("Distancee:");
        TextField distance = new TextField();
        distance.setPromptText("Enter distance: ");
        Label larrivesAt = new Label("Arrival Airport Name:");
        TextField arrivesAt = new TextField();
        arrivesAt.setPromptText("Enter Arrival Airport Name: ");

        Button addLeg = new Button("Add Leg");
        Button backButton = new Button("Back to Leg Scene");

        addLeg.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        //Airport oDepartsFrom = ams.getAirportFromAMS(departsFrom.getText());
        //Airport oArrivesAt = ams.getAirportFromAMS(arrivesAt.getText());
        addLeg.setOnAction(event -> ams.createLeg(departsFrom.getText(),distance.getText(), arrivesAt.getText()));
        backButton.setOnAction(event -> showLegScene());
        vbox.getChildren().addAll(lscreen,ldepartsFrom,departsFrom,ldistance,distance,larrivesAt,arrivesAt,addLeg,backButton);
        creatShowScreen(vbox);
    }
//endregion

    //region Route Section
    private void showRouteScene() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Button add = new Button("Add Route");
        Button show = new Button("Show Routes");

        add.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        show.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        add.setOnAction(event -> addRouteInfo());
        show.setOnAction(event -> showRouteInfo());
        vbox.getChildren().addAll(add,show);
        creatShowScreen(vbox);
    }
    private void showRouteInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("All Routes");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label l = new Label("Routes View");
        String s = ams.showRoutes();
        l.setText(s);
        Button backButton = new Button("Back to Routes Scene");

        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        backButton.setOnAction(event -> showRouteScene());
        vbox.getChildren().addAll(lscreen,l,backButton);
        creatShowScreen(vbox);
    }
    private void addRouteInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        Label lscreen = new Label("Create New Route");
        lscreen.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        lscreen.setTextFill(Color.web("Blue"));

        Label lname = new Label("Route Name:");
        TextField name = new TextField();
        name.setPromptText("Enter route name: ");
        Label ldepartsFrom = new Label("Departure Airport Name:");
        TextField departsFrom = new TextField();
        departsFrom.setPromptText("Enter Departure Airport Name: ");
        Label lhop = new Label("First Hop Name:");
        TextField hop = new TextField();
        hop.setPromptText("Enter First Hop: ");
        Button addRoute = new Button("Add Route");
        Button backButton = new Button("Back to Routes Scene");

        addRoute.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        //Airport a = ams.getAirportFromAMS(departsFrom.getText());
        addRoute.setOnAction(event -> ams.createRoute(new Route(name.getText(),
                                    ams.getAirportFromAMS(departsFrom.getText())),
                                                        departsFrom.getText(), hop.getText()));
        backButton.setOnAction(event -> showRouteScene());
        vbox.getChildren().addAll(lscreen,lname,name,ldepartsFrom,departsFrom,lhop,hop,addRoute,backButton);
        creatShowScreen(vbox);
    }


    //endregion

}