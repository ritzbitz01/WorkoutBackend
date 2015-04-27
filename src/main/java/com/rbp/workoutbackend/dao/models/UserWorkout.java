package com.rbp.workoutbackend.dao.models;

public class UserWorkout extends Workout {
	
	private String userId;
	
	public UserWorkout() {
		
	}
	
	public UserWorkout(String workoutId, String userId, String name, String description, WorkoutType type) {
		super(name, description, type);
		this.userId = userId;
		this.workoutId = workoutId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
