package com.rbp.workoutbackend.dao.models;

import java.util.List;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Workout {

	@PrimaryKey
	private String workoutId;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private WorkoutType type;
	
	@Column 
	private List<Exercise> exercises;
	
	public Workout() {
		
	}
	
	public Workout(String name, String description, WorkoutType type) {
		this.name = name;
		this.description = description;
		this.type = type;
	}

	public String getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(String workoutId) {
		this.workoutId = workoutId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WorkoutType getType() {
		return type;
	}

	public void setType(WorkoutType type) {
		this.type = type;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
}
