package com.codeseavers.homeserver.model;

import java.util.Date;

public class Humidity implements Measurement<Double> {
	
	public Double value;
	private String unit = "PERCENT";
	private Date timestamp;

	@Override
	public Double getValue() {
		return this.value;
	}

	@Override
	public String getUnit() {
		return this.unit ;
	}

	@Override
	public Date getTimestamp() {
		return this.timestamp;
	}
}
