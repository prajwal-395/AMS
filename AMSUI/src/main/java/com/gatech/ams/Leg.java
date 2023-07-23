package com.gatech.ams;

public class Leg {
	private int distance;
	private Airport depAirport;
	private Airport arrAirport;

	public  Leg (Airport departsFrom, String distance, Airport arrivesAt) {
		// TODO we might want to change this later on in the AC class instead of parsingInt here
		// that way we can also change the method header to be an int
		this.distance = Integer.parseInt(distance);
		this.arrAirport = arrivesAt;
		this.depAirport = departsFrom;

	}
	
	public Leg(int distance) {
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public Airport getDepartAirport() {
		return this.depAirport;
	}

	public Airport getArrivalAirport() {
		return this.arrAirport;
	}
    
    // TODO: helper method to udpate the progess


	@Override
	public String toString() {

		return  "Leg: " + this.getDepartAirport().getIATA()  + "-->" + this.getDistance() + " --> "
				+ this.getArrivalAirport().getIATA() + System.lineSeparator();

	}
}
