package com.codeseavers.homeserver.model;

import java.util.ArrayList;
import java.util.List;

public class DHT22 implements Sensor {

	private Room room;
	private List<Measurement<?>> measurements;

	public DHT22() {
		this.measurements = new ArrayList<>();		
	}
	
	@Override
	public Room getRoom() {
		return this.room;
	}

	@Override
	public List<Measurement<?>> getMeasurements() {
		return this.measurements; 
	}

	public void addTemperature(Temperature measure) {
		this.measurements.add(measure);
	}

	public void addHumidity(Humidity measure) {
		this.measurements.add(measure);
	}
}
