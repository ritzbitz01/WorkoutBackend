create keyspace if not exists workout WITH replication = { 'class' : 'SimpleStrategy', 'replication_factor' : 1};

CREATE TABLE IF NOT EXISTS workout.user (
	userId text,
	firstname text,
	lastname text,
	email text,
	PRIMARY KEY (userId)
);

CREATE TABLE IF NOT EXISTS workout.workout (
	workoutId text,
	name text,
	description text,
	type text,
	exercises text,
	PRIMARY KEY (workoutId)
);