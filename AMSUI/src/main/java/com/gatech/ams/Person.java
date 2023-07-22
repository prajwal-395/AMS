package com.gatech.ams;

public abstract class Person {
    private String fName;
    private String lName;
    private String identifier;
    private String location;

    public Person(String fName, String identifier, String location) {
        this.fName = fName;
        this.identifier = identifier;
        this.location = location;
    }

    public Person(String fName, String lName, String identifier, String location) {
        this.fName = fName;
        this.lName = lName;
        this.identifier = identifier;
        this.location = location;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", identifier='" + identifier + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
