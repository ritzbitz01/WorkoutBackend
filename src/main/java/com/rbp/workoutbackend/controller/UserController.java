package com.rbp.workoutbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rbp.workoutbackend.dao.UserDao;
import com.rbp.workoutbackend.dao.models.User;

@RestController
@RequestMapping("/users")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDao userDao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAllUsers() {
		logger.info("Getting all users");

		List<User> userList = userDao.getAllUsers();
		

		return userList;
	}

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public User saveUser(@RequestBody User user) {
		//UserDao userDao = new CassandraUserDao();
		return userDao.saveUser(user);
	}
	
	@RequestMapping(value="/{userId}/workouts", method=RequestMethod.POST)
	@ResponseBody
	public void addWorkout(@PathVariable String userId, @RequestParam String workoutId) {
		//UserDao userDao = new CassandraUserDao();
		userDao.addWorkout(userId, workoutId);
	}

}
