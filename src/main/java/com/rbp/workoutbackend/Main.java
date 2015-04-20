package com.rbp.workoutbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.rbp.workoutbackend.config.AppConfig;
import com.rbp.workoutbackend.dao.UserDao;

@SpringBootApplication
public class Main {

	@Autowired
	private UserDao repository;

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	    MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
	    
		SpringApplication.run(Main.class, args);
	}
}
