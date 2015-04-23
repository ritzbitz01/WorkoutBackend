package com.rbp.workoutbackend.dao.cassandra;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.rbp.workoutbackend.dao.UserDao;
import com.rbp.workoutbackend.dao.models.User;

@Repository
public class CassandraUserDao implements UserDao {
	
	//@Autowired
	private final CassandraOperations cassandraTemplate;
	
	private String getAllUsersQuery = "select * from user";
	
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


//	@Override
//	public long count() {
//		return 0;
//	}
//
//
//	@Override
//	public void delete(MapId arg0) {
//		template.delete(arg0);
//		
//	}
//
//
//	@Override
//	public void delete(User arg0) {
//		template.delete(arg0);
//	}
//
//
//	@Override
//	public void delete(Iterable<? extends User> arg0) {
//		template.delete(arg0);
//	}
//
//
//	@Override
//	public void deleteAll() {
//		template.delete(User.class);
//	}
//
//
//	@Override
//	public boolean exists(MapId arg0) {
//		return template.exists(User.class, arg0);
//	}
//
//
//	@Override
//	public Iterable<User> findAll() {
//		return template.select(getAllUsersQuery, User.class);
//	}
//
//
//	@Override
//	public Iterable<User> findAll(Iterable<MapId> arg0) {
//		return template.select(getAllUsersQuery, User.class);
//	}
//
//
//	@Override
//	public User findOne(MapId arg0) {
//		return template.selectOne(getAllUsersQuery, User.class);
//	}
//
//
//	@Override
//	public <S extends User> S save(S arg0) {
//		template.insert(arg0);
//		return arg0;
//	}
//
//
//	@Override
//	public <S extends User> Iterable<S> save(Iterable<S> arg0) {
//		template.insert(arg0);
//		return arg0;
//	}

}
