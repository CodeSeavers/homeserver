package com.codeseavers.homeserver.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.codeseavers.homeserver.config.MongoDbTestConfiguration;
import com.codeseavers.homeserver.repositories.ReadingRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(MongoDbTestConfiguration.class)
public class ReadingRepositoryTest {

	@Autowired
	ReadingRepository readings;
	
	@Test
	public void repository_exists() {
		assertThat(readings, is(notNullValue()));
	}
}
