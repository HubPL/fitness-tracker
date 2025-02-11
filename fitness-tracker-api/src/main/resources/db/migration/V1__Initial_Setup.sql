
-- Utwórz nową tabelę exercises
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

-- Tabela dla instrukcji ćwiczeń
CREATE TABLE exercise_instructions (
                                       exercise_id VARCHAR(10) NOT NULL,
                                       instruction_step TEXT NOT NULL,
                                       step_order INTEGER NOT NULL,
                                       PRIMARY KEY (exercise_id, step_order),
                                       FOREIGN KEY (exercise_id) REFERENCES exercises(id)
);

-- Tabela dla mięśni drugorzędnych
CREATE TABLE exercise_secondary_muscles (
                                            exercise_id VARCHAR(10) NOT NULL,
                                            muscle_name VARCHAR(50) NOT NULL,
                                            PRIMARY KEY (exercise_id, muscle_name),
                                            FOREIGN KEY (exercise_id) REFERENCES exercises(id)
);

-- Odtwórz tabelę workout_exercises z nowym typem klucza
CREATE TABLE workout_exercises (
                                   workout_id BIGINT NOT NULL,
                                   exercise_id VARCHAR(10) NOT NULL,
                                   PRIMARY KEY (workout_id, exercise_id),
                                   FOREIGN KEY (workout_id) REFERENCES workouts(id),
                                   FOREIGN KEY (exercise_id) REFERENCES exercises(id)
);
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