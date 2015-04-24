package com.rbp.workoutbackend.dao.models;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Exercise {

	@PrimaryKey
	private String exerciseId;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private int numReps;
	
	@Column 
	private int weight;
	
	@Column
	private int numSets;
	
	public Exercise() {
		
	}
	
	public Exercise(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(String exerciseId) {
		this.exerciseId = exerciseId;
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

	public int getNumReps() {
		return numReps;
	}

	public void setNumReps(int numReps) {
		this.numReps = numReps;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getNumSets() {
		return numSets;
	}

	public void setNumSets(int numSets) {
		this.numSets = numSets;
	}

}
