package com.codeseavers.homeserver.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codeseavers.homeserver.model.Measurement;
import com.codeseavers.homeserver.model.Room;
import com.codeseavers.homeserver.model.Sensor;

public interface SensorRepository extends MongoRepository<Sensor, String> {

	public List<Sensor> findSensorsByRoom(Room room);

	public List<Sensor> findSensorsByRoomAndMeasurements(Room room, List<Class<? extends Measurement<?>>> measurement);
}
