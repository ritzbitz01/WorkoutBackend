package com.rbp.workoutbackend.dao.cassandra;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.rbp.workoutbackend.dao.WorkoutDao;
import com.rbp.workoutbackend.dao.models.Workout;

@Repository
public class CassandraWorkoutDao implements WorkoutDao {

	private final CassandraOperations cassandraTemplate;
	
	private final String getAllWorkoutsQuery = "select * from workouts";
	
	@Autowired
	CassandraWorkoutDao(CassandraOperations cassandraTemplate) {
		this.cassandraTemplate = cassandraTemplate;
	}

	@Override
	public Workout saveWorkout(Workout workout) {
		String workoutId = UUID.randomUUID().toString();
		workout.setWorkoutId(workoutId);
		cassandraTemplate.insert(workout);
		return workout;
		
	}

	@Override
	public Workout getWorkout(String workoutId) {
		return cassandraTemplate.selectOneById(Workout.class, workoutId);
	}

	@Override
	public List<Workout> getAllWorkouts() {
		return cassandraTemplate.select(getAllWorkoutsQuery, Workout.class);
	}

	@Override
	public Workout addExercise(String workoutId, String exerciseId) {
		Workout workout = getWorkout(workoutId);
		workout.getExercises().add(exerciseId);
		return workout;
	}
}
