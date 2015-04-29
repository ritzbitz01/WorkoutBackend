package com.rbp.workoutbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rbp.workoutbackend.dao.WorkoutDao;
import com.rbp.workoutbackend.dao.models.Exercise;
import com.rbp.workoutbackend.dao.models.Workout;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
	
	@Autowired
	WorkoutDao workoutDao;
	
	@RequestMapping(value="/{workoutId}", method = RequestMethod.GET)
	public Workout getWorkout(@PathVariable String workoutId) {
		Workout workout = workoutDao.getWorkout(workoutId);
		return workout;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Workout saveWorkout(@RequestBody Workout workout) {
		return workoutDao.saveWorkout(workout);
	}
	
	@RequestMapping(value="/{workoutId}/exercises", method=RequestMethod.POST)
	@ResponseBody
	public Workout addExercise(@PathVariable String workoutId, @RequestBody Exercise exercise) {
		return workoutDao.addExercise(workoutId, exercise.getExerciseId());
	}

}
