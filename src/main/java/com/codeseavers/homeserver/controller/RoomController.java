package com.codeseavers.homeserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeseavers.homeserver.repositories.RoomRepository;

@RestController
@EnableAutoConfiguration
public class RoomController {

	@Autowired
	RoomRepository rooms;
	
	@RequestMapping("/rooms")
	String rooms() {
		return "rooms";
	}
}
