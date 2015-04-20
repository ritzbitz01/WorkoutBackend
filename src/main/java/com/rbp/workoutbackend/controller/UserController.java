package com.rbp.workoutbackend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rbp.workoutbackend.HomeController;
import com.rbp.workoutbackend.dao.UserDao;
import com.rbp.workoutbackend.dao.models.User;
import com.rbp.workoutbackend.dao.mongodb.MongoUserDao;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getAllUsers(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		List<User> userList = new ArrayList<>();
		
		return userList;
	}
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	@ResponseBody
	public User saveUser(@RequestBody User user) {
		UserDao userDao = new MongoUserDao();
		return userDao.save(user);
	}

}
