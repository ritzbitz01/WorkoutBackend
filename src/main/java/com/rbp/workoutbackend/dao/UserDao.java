package com.rbp.workoutbackend.dao;

import java.util.List;

import com.rbp.workoutbackend.dao.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User, String> {

	public User findByFirstName(String firstName);
	public List<User> findByLastName(String lastName);
}
