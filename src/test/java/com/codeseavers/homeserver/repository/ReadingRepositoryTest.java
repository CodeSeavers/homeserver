package com.codeseavers.homeserver.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.List;

import com.codeseavers.homeserver.config.MongoDbTestConfiguration;
import com.codeseavers.homeserver.model.DHT22;
import com.codeseavers.homeserver.model.Humidity;
import com.codeseavers.homeserver.model.Reading;
import com.codeseavers.homeserver.model.Room;
import com.codeseavers.homeserver.model.Sensor;
import com.codeseavers.homeserver.model.Temperature;
import com.codeseavers.homeserver.repositories.ReadingRepository;
import com.codeseavers.homeserver.repositories.RoomRepository;
import com.codeseavers.homeserver.repositories.SensorRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

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

		this.sensors.insert(this.temperatureSensor);
	}
	
	@After
	public void roomService() {
		this.rooms.deleteAll();
		this.readings.deleteAll();
		this.sensors.deleteAll();
	}

	@Test
	public void repository_exists() {
		assertThat(this.readings, is(notNullValue()));
	}

	@Test
	public void basic_insert() {

		final List<Sensor> findSensorsByRoom = this.sensors.findSensorsByRoom(this.wohnzimmer);
		assertThat(findSensorsByRoom, hasSize(1));

		final List<Sensor> findSensorsByRoomAndMeasurement = this.sensors.findSensorsByRoomAndMeasurements(this.wohnzimmer, 
			List.of(Temperature.class.toString(), Humidity.class.toString()));
		assertThat(findSensorsByRoomAndMeasurement, hasSize(1));

		final Sensor sensor = findSensorsByRoom.stream().findFirst().orElse(mock(DHT22.class));

		final Temperature temperature = new Temperature(25);

		final Humidity humidity = new Humidity(80);

		final Reading reading = new Reading(sensor, List.of(temperature, humidity));
		this.readings.insert(reading);

		final List<Reading> all = this.readings.findAll();
		assertThat(all, hasSize(1));
		assertThat(all.get(0).getMeasurements(), hasSize(2));

		Temperature temperatureReading = (Temperature)all.get(0).getMeasurements().get(0);
		assertThat(temperatureReading.getClass().toString(), is(equalTo(Temperature.class.toString())));

		Humidity humidityReading = (Humidity)all.get(0).getMeasurements().get(1);
		assertThat(humidityReading.getClass().toString(), is(equalTo(Humidity.class.toString())));

		assertThat(temperatureReading.getValue(), is(equalTo(25.0)));
		assertThat(humidityReading.getValue(), is(equalTo(80.0)));
	}
}
