package com.codeseavers.homeserver.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.codeseavers.homeserver.model.Measurement;
import com.codeseavers.homeserver.model.Reading;
import com.codeseavers.homeserver.model.Room;
import com.codeseavers.homeserver.model.Sensor;

public interface ReadingRepository extends MongoRepository<Reading, String> {
	
	@Query("")
	public List<Reading> getReadingByMeasurementAndSensor(Measurement<?> measurement, Sensor sensor);
	
	@Query("")
	public List<Reading> getReadingBySensorAndRoom(Sensor sensor, Room room);
}
