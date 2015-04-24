package com.rbp.workoutbackend.dao;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.rbp.workoutbackend.dao.models.Workout;

@NoRepositoryBean
public interface WorkoutDao {

	public Workout saveWorkout(Workout workout);
	
	public Workout getWorkout(String workoutId);
	
	public List<Workout> getAllWorkouts();
}
