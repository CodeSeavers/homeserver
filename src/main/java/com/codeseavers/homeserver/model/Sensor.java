package com.codeseavers.homeserver.model;

import java.util.List;

public interface Sensor {

	Room getRoom();

	void setRoom(Room room);

	List<Class<? extends Measurement<?>>> getMeasurements();
}
