package com.rbp.workoutbackend.dao;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.rbp.workoutbackend.dao.models.Exercise;

@NoRepositoryBean
public interface ExerciseDao {

	public Exercise saveExercise(Exercise workout);
	
	public Exercise getExercise(String exerciseId);
	
	public List<Exercise> getAllExercises();
}
