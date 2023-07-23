package com.gatech.ams;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AirlineScreen {

    private AirlineManagementSystem ams;

    private void setAms(AirlineManagementSystem ams){
        this.ams = ams;
    }

    private VBox showAirlineScene() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Button add = new Button("Add Airline");
        Button delete = new Button("Remove Airline");
        Button show = new Button("Show Airlines");
        add.setOnAction(event -> addAirlineInfo());
        //delete.setOnAction(event -> showHomeScreen());
        show.setOnAction(event -> showAirlineInfo());
        vbox.getChildren().addAll(add,delete,show);
        //creatShowScreen(vbox);
        return vbox;
    }

    public VBox addAirlineInfo(){
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
        //creatShowScreen(vbox);
        return vbox;
    }

    private VBox showAirlineInfo() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        Label l = new Label("AirlineView");
        String s = ams.showAirlines();
        l.setText(s);
        Button backButton = new Button("Back to Airline scene");
        backButton.setOnAction(event -> showAirlineScene());
        vbox.getChildren().addAll(l,backButton);

        //creatShowScreen(vbox);
        return vbox;
    }
}
