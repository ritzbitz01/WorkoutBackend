package com.rbp.workoutbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rbp.workoutbackend.dao.cassandra.CassandraDao;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		//CassandraDao dao = new CassandraDao();
		//dao.setupDatabase();

		SpringApplication.run(Main.class, args);
	}

}
