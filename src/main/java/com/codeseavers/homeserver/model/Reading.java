package com.codeseavers.homeserver.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Reading {

	@Id
	public String Id;
	
	private Sensor sensor;
	private List<Measurement<?>> measurements;

	public Reading(Sensor sensor, List<Measurement<?>> measurements) {
		this.sensor = sensor;
		this.measurements = measurements;
	}
	
	public Sensor getSensor() {
		return sensor;
	}
	
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	public List<Measurement<?>> getMeasurements() {
		return measurements;
	}
	
	public void setMeasurements(List<Measurement<?>> measurements) {
		this.measurements = measurements;
	}
}
