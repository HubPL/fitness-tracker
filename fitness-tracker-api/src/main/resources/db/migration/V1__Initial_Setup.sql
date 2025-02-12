-- Users table
CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Body Parts table (already exists but included for completeness)
CREATE TABLE body_parts (
                            id BIGSERIAL PRIMARY KEY,
                            name VARCHAR(50) NOT NULL UNIQUE,
                            active BOOLEAN NOT NULL DEFAULT true
);

INSERT INTO body_parts (name, active) VALUES
                                          ('back', true),
                                          ('cardio', true),
                                          ('chest', true),
                                          ('lower arms', true),
                                          ('lower legs', true),
                                          ('neck', true),
                                          ('shoulders', true),
                                          ('upper arms', true),
                                          ('upper legs', true),
                                          ('waist', true);

-- Exercises table (modified to match entity)
CREATE TABLE exercises (
                           id VARCHAR(10) PRIMARY KEY,
                           name VARCHAR(100) NOT NULL,
                           body_part VARCHAR(50) NOT NULL,
                           equipment VARCHAR(50) NOT NULL,
                           gif_url VARCHAR(255),
                           target_muscle VARCHAR(50),
                           created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           external_source VARCHAR(50)
);

-- Exercise Instructions table (already exists but included for completeness)
CREATE TABLE exercise_instructions (
                                       exercise_id VARCHAR(10) NOT NULL,
                                       instruction_step TEXT NOT NULL,
                                       step_order INTEGER NOT NULL,
                                       PRIMARY KEY (exercise_id, step_order),
                                       FOREIGN KEY (exercise_id) REFERENCES exercises(id)
);

-- Exercise Secondary Muscles table (already exists but included for completeness)
CREATE TABLE exercise_secondary_muscles (
                                            exercise_id VARCHAR(10) NOT NULL,
                                            muscle_name VARCHAR(50) NOT NULL,
                                            PRIMARY KEY (exercise_id, muscle_name),
                                            FOREIGN KEY (exercise_id) REFERENCES exercises(id)
);

-- Workouts table
CREATE TABLE workouts (
                          id BIGSERIAL PRIMARY KEY,
                          user_id BIGINT NOT NULL,
                          workout_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          duration INTEGER,
                          FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Workout Exercises table (already exists but included for completeness)
CREATE TABLE workout_exercises (
                                   workout_id BIGINT NOT NULL,
                                   exercise_id VARCHAR(10) NOT NULL,
                                   PRIMARY KEY (workout_id, exercise_id),
                                   FOREIGN KEY (workout_id) REFERENCES workouts(id),
                                   FOREIGN KEY (exercise_id) REFERENCES exercises(id)
);

-- Body Measurements table
CREATE TABLE body_measurements (
                                   id BIGSERIAL PRIMARY KEY,
                                   user_id BIGINT NOT NULL,
                                   measurement_date DATE NOT NULL,
                                   weight DECIMAL(5,2),
                                   body_fat_percentage DECIMAL(5,2),
                                   chest DECIMAL(5,2),
                                   biceps DECIMAL(5,2),
                                   waist DECIMAL(5,2),
                                   hips DECIMAL(5,2),
                                   thigh DECIMAL(5,2),
                                   FOREIGN KEY (user_id) REFERENCES users(id)
);