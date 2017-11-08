package com.codeseavers.homeserver.model;

import java.util.Date;

public interface Measurement<T> {
	
	T getValue();
	
	String getUnit();
	
	Date getTimestamp();
}
