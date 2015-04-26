package com.rbp.workoutbackend.dao.cassandra;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.rbp.workoutbackend.dao.UserDao;
import com.rbp.workoutbackend.dao.models.User;
import com.rbp.workoutbackend.dao.models.Workout;

@Repository
public class CassandraUserDao implements UserDao {
	
	//@Autowired
	private final CassandraOperations cassandraTemplate;
	
	private String getAllUsersQuery = "select * from user";
	private String getWorkoutTemplate = "select * from workout where workoutId = ?";
	
	@Autowired
	CassandraUserDao(CassandraOperations cassandraTemplate) {
		this.cassandraTemplate = cassandraTemplate;
	}

	@Override
	public List<User> getAllUsers() {
		
		List<User> userList = cassandraTemplate.select(getAllUsersQuery, User.class);
		return userList;
	}
	
	
	@Override
	public User saveUser(User user) {
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		cassandraTemplate.insert(user);
		return user;
	}

	@Override
	public User findById(String userId) {
		
		return cassandraTemplate.selectOneById(User.class, userId);
	}

	@Override
	public void addWorkout(String userId, String workoutTemplateId) {
		
		Workout workout = cassandraTemplate.selectOneById(Workout.class, workoutTemplateId);
		workout.setWorkoutId(UUID.randomUUID().toString());
		
	}
}
