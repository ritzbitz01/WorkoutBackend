package com.rbp.workoutbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		//CassandraDao dao = new CassandraDao();
		//dao.setupDatabase();

		SpringApplication.run(Main.class, args);
	}

}
