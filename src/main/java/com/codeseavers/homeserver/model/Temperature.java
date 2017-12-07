package com.codeseavers.homeserver.model;

import java.util.Date;

public class Temperature implements Measurement<Double> {

	private Date timestamp;
	private String unit = "CELSIUS";
	private double value;

	public Temperature() {
	}
	
	public Temperature(double value) {
		this.timestamp = new Date();
		this.value = value;
	}

	@Override
	public Double getValue() {
		return this.value;
	}

	@Override
	public String getUnit() {
		return this.unit;
	}

	@Override
	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setValue(double value) {
		this.value = value;
		this.timestamp = new Date();
	}
}
