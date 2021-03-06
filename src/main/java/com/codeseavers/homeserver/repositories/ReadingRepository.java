package com.codeseavers.homeserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.codeseavers.homeserver.model.Reading;

@Repository
public interface ReadingRepository extends MongoRepository<Reading, String> {
	
	/*@Query("")
	public List<Reading> getReadingByMeasurementAndSensor(Measurement<?> measurement, Sensor sensor);
	
	@Query("")
	public List<Reading> getReadingBySensorAndRoom(Sensor sensor, Room room);*/
}
