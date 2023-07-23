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
        mShowProps.setOnAction(actionEvent -> showPropInfo()); // todo showAllAircraftsInfo());
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
        add.setOnAction(event -> addAirlineInfo());
        show.setOnAction(event -> showAirlineInfo());
        vbox.getChildren().addAll(add,show);
        creatShowScreen(vbox);
    }
    //add airline screen
    private void addAirlineInfo(){
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        TextField name = new TextField();
        name.setPromptText("Enter Airline Name: ");
        TextField revenue = new TextField();
        revenue.setPromptText("Enter Airline Revenue: ");
        Button addAirline = new Button("Add Airline");
        Button backButton = new Button("Back to Airline scene");
        addAirline.setOnAction(event -> ams.createAirline(new Airline(name.getText(),Double.parseDouble(revenue.getText()))));
        backButton.setOnAction(event -> showAirlineScene());
        vbox.getChildren().addAll(name,revenue,addAirline,backButton);
        creatShowScreen(vbox);
    }
    //show airlines 
    private void showAirlineInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Label l = new Label("AirlineView");
        String s = ams.showAirlines();
        l.setText(s);
        Button backButton = new Button("Back to Airline scene");
        backButton.setOnAction(event -> showAirlineScene());
        vbox.getChildren().addAll(l,backButton);
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
        add.setOnAction(event -> addAirportInfo());
        show.setOnAction(event -> showAirportInfo());
        vbox.getChildren().addAll(add,show);
        creatShowScreen(vbox);
    }
    private void addAirportInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        TextField code = new TextField();
        code.setPromptText("Enter Airport/IATA Code/: ");
        TextField name = new TextField();
        name.setPromptText("Enter Airport Name: ");
        TextField city = new TextField();
        city.setPromptText("Enter Airport City: ");
        TextField state = new TextField();
        state.setPromptText("Enter Airport State: ");
        TextField country = new TextField();
        country.setPromptText("Enter Airport Country: ");
        Button addAirport = new Button("Add Airport");
        Button backButton = new Button("Back to Airport scene");
        addAirport.setOnAction(event -> ams.createAirport(new Airport(code.getText(),name.getText(),city.getText(),state.getText(),country.getText())));
        backButton.setOnAction(event -> showAirportScene());
        vbox.getChildren().addAll(code,name,city,state,country,addAirport,backButton);
        creatShowScreen(vbox);
    }
    private void showAirportInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Label l = new Label("AirPortView");
        String s = ams.showAirports();
        l.setText(s);
        Button backButton = new Button("Back to Airport scene");
        backButton.setOnAction(event -> showAirportScene());
        vbox.getChildren().addAll(l,backButton);
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
        add.setOnAction(event -> addPilotInfo());
        show.setOnAction(event -> showPilotInfo());
        vbox.getChildren().addAll(add,show);
        creatShowScreen(vbox);
    }
    private void showPilotInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Label l = new Label("PilotView");
        String s = ams.showPilots();
        l.setText(s);
        Button backButton = new Button("Back to Pilot scene");
        backButton.setOnAction(event -> showPilotScene());
        vbox.getChildren().addAll(l,backButton);
        creatShowScreen(vbox);
    }
    private void addPilotInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        TextField identifier = new TextField();
        identifier.setPromptText("Enter pilotID: ");
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
        Button addPilot = new Button("Add Pilot");
        Button backButton = new Button("Back to Pilot scene");
        Pilot p = new Pilot(identifier.getText(),fName.getText(),lName.getText(),taxID.getText(),Integer.parseInt(experience.getText()),location.getText());
        addPilot.setOnAction(event -> ams.createPilot(p,location.getText()));
        backButton.setOnAction(event -> showPilotScene());
        vbox.getChildren().addAll(identifier,fName,lName,taxID,experience,location,addPilot,backButton);
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
        add.setOnAction(event -> addPassengerInfo());
        show.setOnAction(event -> showPassengerInfo());
        vbox.getChildren().addAll(add,show);
        creatShowScreen(vbox);
    }
    private void showPassengerInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Label l = new Label("PassengerView");
        String s = ams.showPassenger();
        l.setText(s);
        Button backButton = new Button("Back to Passenger scene");
        backButton.setOnAction(event -> showPassengerScene());
        vbox.getChildren().addAll(l,backButton);
        creatShowScreen(vbox);
    }
    private void addPassengerInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        TextField id = new TextField();
        id.setPromptText("Enter Identifier/: ");
        TextField fname = new TextField();
        fname.setPromptText("Enter First Name/: ");
        TextField lname = new TextField();
        lname.setPromptText("Enter Last Name: ");
        TextField ffmiles = new TextField();
        ffmiles.setPromptText("Enter Frequent Flier Miles: ");
        TextField pfunds = new TextField();
        pfunds.setPromptText("Enter Passenger funds: ");
        TextField location = new TextField();
        location.setPromptText("Enter Location: ");
        Button addPassenger = new Button("Add Passenger");
        Button backButton = new Button("Back to Passenger scene");
        addPassenger.setOnAction(event -> ams.createPassenger(new Passenger(id.getText(), fname.getText(), lname.getText(), Integer.parseInt(ffmiles.getText()), Integer.parseInt(pfunds.getText()), location.getText()), location.getText()));
        backButton.setOnAction(event -> showPassengerScene());
        vbox.getChildren().addAll(id,fname,lname,ffmiles,pfunds,location,addPassenger,backButton);
        creatShowScreen(vbox);
    }
    //endregion

    private void showPeopleInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Label l = new Label("People View");
        String s = ams.showPeople();
        l.setText(s);
        Button backButton = new Button("Back to Passenger scene");
        backButton.setOnAction(event -> showPassengerScene());
        vbox.getChildren().addAll(l,backButton);
        creatShowScreen(vbox);
    }


    //region Flight Section
    private void showFlightScene() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Button add = new Button("Add Flight");
        Button show = new Button("Show Flights");
        add.setOnAction(event -> addFlightInfo());
        show.setOnAction(event -> showFlightInfo());
        vbox.getChildren().addAll(add,show);
        creatShowScreen(vbox);
    }
    private void addFlightInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
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
        Button addFlight = new Button("Add Flight");
        Button backButton = new Button("Back to Flight scene");
        Airline airline = ams.getAirlineFromAMS(airlineName.getText());
        addFlight.setOnAction(Event -> ams.createFlight(airlineName.getText(),new Flight(airline, flightNum.getText(), Integer.parseInt(cost.getText()),Integer.parseInt(progress.getText()),routeName.getText(),LocalTime.parse(nextTime.getText()),tailNum.getText())));
        backButton.setOnAction(event -> showFlightScene());
        vbox.getChildren().addAll(airlineName,flightNum,cost,progress,routeName,nextTime,tailNum,addFlight,backButton);
        creatShowScreen(vbox);
    }
    private void showFlightInfo(){
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Label l = new Label("FlightView");
        String s =  ""; //ams.showFlight(); Todo
        l.setText(s);
        Button backButton = new Button("Back to Flight scene");
        backButton.setOnAction(event -> showFlightScene());
        vbox.getChildren().addAll(l,backButton);
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
        add.setOnAction(event -> addJetInfo());
        show.setOnAction(event -> showJetInfo());
        vbox.getChildren().addAll(add,show);
        creatShowScreen(vbox);
    }
    private void addJetInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        TextField tailNum = new TextField();
        tailNum.setPromptText("Enter tail number: ");
        TextField seatCap = new TextField();
        seatCap.setPromptText("Enter seating capacity: ");
        TextField speed = new TextField();
        speed.setPromptText("Enter speed: ");
        TextField engineNum = new TextField();
        engineNum.setPromptText("Enter number of engines: ");
        Button addJet = new Button("Add Jet");
        Button backButton = new Button("Back to Jet scene");
        addJet.setOnAction(event -> ams.createJet(new Jet( tailNum.getText(),Integer.parseInt(seatCap.getText()),Double.parseDouble(speed.getText()),Integer.parseInt(engineNum.getText()))));
        backButton.setOnAction(event -> showJetScene());
        vbox.getChildren().addAll(tailNum,seatCap,speed,engineNum,addJet,backButton);
        creatShowScreen(vbox);



    }
    private void showJetInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Label l = new Label("JetView");
        String s = ams.showAirplanes(); //Todo
        l.setText(s);
        Button backButton = new Button("Back to Jet scene");
        backButton.setOnAction(event -> showJetScene());
        vbox.getChildren().addAll(l,backButton);
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
        Label l = new Label("Propellor View");
        String s = ams.showAirplanes();
        l.setText(s);
        Button backButton = new Button("Back to Propellor scene");
        backButton.setOnAction(event -> showPropScene());
        vbox.getChildren().addAll(l,backButton);
        creatShowScreen(vbox);
    }
    private void addPropInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        TextField tailNum = new TextField();
        tailNum.setPromptText("Enter tail number: ");
        TextField seatCap = new TextField();
        seatCap.setPromptText("Enter seating capacity: ");
        TextField speed = new TextField();
        speed.setPromptText("Enter speed: ");
        TextField engineNum = new TextField();
        engineNum.setPromptText("Enter number of engines: ");
        Label skids = new Label("Landing Skids: ");
        ComboBox<String> landingSkids = new ComboBox<String>();
        landingSkids.getItems().addAll("True", "False");
        Button addJet = new Button("Add Prop");
        Button backButton = new Button("Back to Prop scene");
        addJet.setOnAction(event -> ams.createProp(new Propeller(tailNum.getText(),Integer.parseInt(seatCap.getText()),Double.parseDouble(speed.getText()),Integer.parseInt(engineNum.getText()),Boolean.parseBoolean(landingSkids.getValue()))));
        backButton.setOnAction(event -> showJetScene());
        vbox.getChildren().addAll(tailNum,seatCap,speed,engineNum,skids, landingSkids,addJet,backButton);
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
        add.setOnAction(event -> addLegInfo());
        show.setOnAction(event -> showLegInfo());
        vbox.getChildren().addAll(add,show);
        creatShowScreen(vbox);
    }
    private void showLegInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Label l = new Label("Leg View");
        String s = ""; //
        l.setText(s);
        Button backButton = new Button("Back to Leg scene");
        backButton.setOnAction(event -> showLegScene());
        vbox.getChildren().addAll(l,backButton);
        creatShowScreen(vbox);
    }
    private void addLegInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        TextField departsFrom = new TextField();
        departsFrom.setPromptText("Enter departure airport name: ");
        TextField distance = new TextField();
        distance.setPromptText("Enter distance: ");
        TextField arrivesAt = new TextField();
        arrivesAt.setPromptText("Enter arrival airport name: ");
        Button addLeg = new Button("Add Leg");
        Button backButton = new Button("Back to showLegScene scene");
        Airport oDepartsFrom = ams.getAirportFromAMS(departsFrom.getText());
        Airport oArrivesAt = ams.getAirportFromAMS(arrivesAt.getText());
        addLeg.setOnAction(event -> ams.createLeg(departsFrom.getText(),arrivesAt.getText(),new Leg(oDepartsFrom ,distance.getText() , oArrivesAt)));
        backButton.setOnAction(event -> showLegScene());
        vbox.getChildren().addAll(departsFrom,distance,arrivesAt,addLeg,backButton);
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
        add.setOnAction(event -> addRouteInfo());
        show.setOnAction(event -> showRouteInfo());
        vbox.getChildren().addAll(add,show);
        creatShowScreen(vbox);
    }
    private void showRouteInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Label l = new Label("Routes View");
        String s = ams.showRoutes();
        l.setText(s);
        Button backButton = new Button("Back to Routes scene");
        backButton.setOnAction(event -> showRouteScene());
        vbox.getChildren().addAll(l,backButton);
        creatShowScreen(vbox);
    }
    private void addRouteInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        TextField name = new TextField();
        name.setPromptText("Enter route name: ");
        TextField departsFrom = new TextField();
        departsFrom.setPromptText("Enter departure airport name: ");
        TextField hop = new TextField();
        hop.setPromptText("Enter first hop: ");
        Button addRoute = new Button("Add Route");
        Button backButton = new Button("Back to showRouteScene scene");
        Airport a = ams.getAirportFromAMS(departsFrom.getText());
        addRoute.setOnAction(event -> ams.createRoute(new Route(name.getText(),a), departsFrom.getText(), hop.getText()));
        backButton.setOnAction(event -> showRouteScene());
        vbox.getChildren().addAll(name,departsFrom,hop,addRoute,backButton);
        creatShowScreen(vbox);
    }
    //endregion

}