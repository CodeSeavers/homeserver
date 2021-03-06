package com.codeseavers.homeserver.config;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class MongoDbConfiguration extends AbstractMongoConfiguration {

	@Override
	public MongoClient mongoClient() {
		return new MongoClient(
					Collections.singletonList(new ServerAddress("192.168.2.11", 27017)),
				Collections.singletonList(
						MongoCredential.createCredential("admin", "admin", "".toCharArray())));
	}

	@Override
	protected String getDatabaseName() {
		return "homeserver";
	}
}
