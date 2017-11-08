package com.codeseavers.homeserver.model;

import java.util.List;

public interface Sensor {

	Room getRoom();
	List<Measurement<?>> getMeasurements();
}
