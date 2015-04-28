package com.rbp.workoutbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rbp.workoutbackend.dao.ExerciseDao;
import com.rbp.workoutbackend.dao.models.Exercise;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

	@Autowired
	ExerciseDao exerciseDao;
	
	@RequestMapping(value="/{exerciseId}", method = RequestMethod.GET)
	public Exercise getWorkout(@PathVariable String exerciseId) {
		Exercise exercise = exerciseDao.getExercise(exerciseId);
		return exercise;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Exercise saveExercise(@RequestBody Exercise exercise) {
		return exerciseDao.saveExercise(exercise);
	}

}
