package com.rbp.workoutbackend.dao.models;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Workout {

	@PrimaryKey
	private String workoutId;
}
