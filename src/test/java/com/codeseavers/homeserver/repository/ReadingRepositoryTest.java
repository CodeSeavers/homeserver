package com.codeseavers.homeserver.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.codeseavers.homeserver.config.MongoDbTestConfiguration;
import com.codeseavers.homeserver.model.DHT22;
import com.codeseavers.homeserver.model.Reading;
import com.codeseavers.homeserver.model.Room;
import com.codeseavers.homeserver.model.Sensor;
import com.codeseavers.homeserver.model.Temperature;
import com.codeseavers.homeserver.repositories.ReadingRepository;
import com.codeseavers.homeserver.repositories.RoomRepository;
import com.codeseavers.homeserver.repositories.SensorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(MongoDbTestConfiguration.class)
public class ReadingRepositoryTest {

	@Autowired
	ReadingRepository readings;
	
	@Autowired
	RoomRepository rooms;

	@Autowired
	SensorRepository sensors;

	private DHT22 temperatureSensor;

	private Room wohnzimmer;

	@Before
	public void setupRoom() {
		this.wohnzimmer = new Room("Wohnzimmer", "EG", 750l, 450l, 235l);
		this.rooms.insert(this.wohnzimmer);

		this.temperatureSensor = new DHT22();
		this.temperatureSensor.setRoom(this.wohnzimmer);
	}
	
	@After
	public void roomService() {
		
	}

	@Test
	public void repository_exists() {
		assertThat(this.readings, is(notNullValue()));
	}

	@Test
	public void basic_insert() {

		final List<Sensor> findSensorsByRoom = this.sensors.findSensorsByRoomAndMeasurements(this.wohnzimmer,
				List.of(Temperature.class));
		final Sensor sensor = findSensorsByRoom.stream().findFirst().orElse(mock(DHT22.class));

		final Temperature temperature = new Temperature();
		temperature.setValue(25);

		final Reading reading = new Reading(sensor, List.of(temperature));

		this.readings.insert(reading);

		final List<Reading> all = this.readings.findAll();
		assertThat(all, hasSize(1));
		assertThat(all.get(0).getMeasurements().get(0), is(instanceOf(Temperature.class)));

		final Temperature measurement = (Temperature) all.get(0).getMeasurements().get(0);
		assertThat(measurement.getValue(), is(equalTo(25.0)));
	}
}
