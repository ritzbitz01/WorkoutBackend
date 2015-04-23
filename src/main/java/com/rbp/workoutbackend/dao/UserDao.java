package com.rbp.workoutbackend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.repository.NoRepositoryBean;

import com.rbp.workoutbackend.dao.models.User;

@NoRepositoryBean
public interface UserDao {


	public List<User> getAllUsers();
	public User saveUser(User user);
	public User findById(String userId);

}
