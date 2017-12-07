package com.codeseavers.homeserver.model;

import java.util.List;

public class DHT22 implements Sensor {

	private Room room;
	private final List<Class<? extends Measurement<?>>> measurements;

	public DHT22() {
		this.measurements = List.of(Temperature.class, Humidity.class);
	}
	
	@Override
	public Room getRoom() {
		return this.room;
	}

	@Override
	public List<Class<? extends Measurement<?>>> getMeasurements() {
		return this.measurements; 
	}

	@Override
	public void setRoom(Room room) {
		this.room = room;
	}
}
