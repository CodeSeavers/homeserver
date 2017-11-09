package com.codeseavers.homeserver.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.codeseavers.homeserver.config.MongoDbTestConfiguration;
import com.codeseavers.homeserver.model.Room;
import com.codeseavers.homeserver.repositories.RoomRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(MongoDbTestConfiguration.class)
public class RoomRepositoryTest {

	@Autowired
	RoomRepository roomRepository;
	
	@Test
	public void repository_existing() {
		assertThat(roomRepository, is(notNullValue()));
	}
	
	@Test
	public void create_new_room() {
		Room wohnzimmer = new Room("Wohnzimmer", "EG",  750l, 450l, 235l);
		roomRepository.insert(wohnzimmer);
		
		List<Room> findByLevel = roomRepository.findByLevel("EG");
		assertThat(findByLevel, hasSize(1));
		
		Room byName = roomRepository.findByName("foo");
		assertThat(byName, is(nullValue()));
	}
}
