package com.rbp.workoutbackend.dao.cassandra;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.rbp.workoutbackend.dao.ExerciseDao;
import com.rbp.workoutbackend.dao.models.Exercise;

@Repository
public class CassandraExerciseDao implements ExerciseDao {

	private final CassandraOperations cassandraTemplate;
	
	private final String getAllExercisesQuery = "select * from exercises";
	
	@Autowired
	CassandraExerciseDao(CassandraOperations cassandraTemplate) {
		this.cassandraTemplate = cassandraTemplate;
	}

	@Override
	public Exercise saveExercise(Exercise exercise) {
		String exerciseId = UUID.randomUUID().toString();
		exercise.setExerciseId(exerciseId);
		cassandraTemplate.insert(exercise);
		return exercise;
		
	}

	@Override
	public Exercise getExercise(String exerciseId) {
		return cassandraTemplate.selectOneById(Exercise.class, exerciseId);
	}

	@Override
	public List<Exercise> getAllExercises() {
		return cassandraTemplate.select(getAllExercisesQuery, Exercise.class);
	}

}
