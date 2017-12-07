package com.codeseavers.homeserver.model;

import org.springframework.data.annotation.Id;

public class Room {

	@Id
	public String id;

	public String name;
	public String level;

	public long length;
	public long width;
	public long height;
	// Unit<Quantity<Q>> unit;

	public Room(String name, String level, long length, long width, long height) {
		this.name = name;
		this.level = level;
		this.length = length;
		this.width = width;
		this.height = height;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public long getLength() {
		return this.length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public long getWidth() {
		return this.width;
	}

	public void setWidth(long width) {
		this.width = width;
	}

	public long getHeight() {
		return this.height;
	}

	public void setHeight(long height) {
		this.height = height;
	}
}
