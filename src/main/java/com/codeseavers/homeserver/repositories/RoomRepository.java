package com.codeseavers.homeserver.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.codeseavers.homeserver.model.Room;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {

	public List<Room> findByLevel(String level);
	public Room findByName(String name);
}
