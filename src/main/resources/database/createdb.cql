create keyspace if not exists workout WITH replication = { 'class' : 'SimpleStrategy', 'replication_factor' : 1};

CREATE TABLE IF NOT EXISTS workout.user (
	userId text,
	firstname text,
	lastname text,
	email text,
	PRIMARY KEY (userId)
);

CREATE TABLE IF NOT EXISTS workout.userworkout (
	workoutid text,
	userid text,
	name text,
	description text,
	type text,
	date timestamp,
	exercises list<text>,
	PRIMARY KEY (workoutid, userid)
);

CREATE TABLE IF NOT EXISTS workout.workout (
	workoutId text,
	name text,
	description text,
	type text,
	exercises list<text>,
	PRIMARY KEY (workoutId)
);

CREATE TABLE IF NOT EXISTS workout.exercise (
	exerciseId text,
	name text,
	description text,
	numReps int,
	numSets int,
	weight int,
	PRIMARY KEY (exerciseId)
);

CREATE TABLE IF NOT EXISTS workout.userworkoutexercise (
	exerciseId text,
	workoutId text,
	name text,
	description text,
	numReps int,
	numSets int,
	weight int,
	PRIMARY KEY (exerciseId, workoutId)
);


