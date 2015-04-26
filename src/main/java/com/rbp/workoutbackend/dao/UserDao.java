package com.rbp.workoutbackend.dao;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.rbp.workoutbackend.dao.models.User;
import com.rbp.workoutbackend.dao.models.Workout;

@NoRepositoryBean
public interface UserDao {


	public List<User> getAllUsers();
	public User saveUser(User user);
	public User findById(String userId);
	public void addWorkout(String userId, String workoutId);
	

}
