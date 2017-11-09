package com.codeseavers.homeserver.config;

import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.github.fakemongo.Fongo;
import com.mongodb.MongoClient;

public class MongoDbTestConfiguration extends AbstractMongoConfiguration {

	@Override
	public MongoClient mongoClient() {
		return new Fongo("mongo-test").getMongo();
	}

	@Override
	protected String getDatabaseName() {
		return "mongo-test";
	}

}
