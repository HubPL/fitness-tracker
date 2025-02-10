-- Tworzenie tabeli użytkowników
CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Tworzenie tabeli ćwiczeń
CREATE TABLE exercises (
                           id BIGSERIAL PRIMARY KEY,
                           name VARCHAR(100) NOT NULL,
                           muscle_group VARCHAR(100) NOT NULL,
                           description TEXT,
                           created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Tworzenie tabeli pomiarów ciała
CREATE TABLE body_measurements (
                                   id BIGSERIAL PRIMARY KEY,
                                   user_id BIGINT NOT NULL,
                                   measurement_date DATE NOT NULL,
                                   weight DECIMAL(5,2),
                                   body_fat_percentage DECIMAL(5,2),
                                   chest DECIMAL(5,2),
                                   waist DECIMAL(5,2),
                                   hips DECIMAL(5,2),
                                   thigh DECIMAL(5,2),
                                   biceps DECIMAL(5,2),
                                   FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Tworzenie tabeli treningów
CREATE TABLE workouts (
                          id BIGSERIAL PRIMARY KEY,
                          user_id BIGINT NOT NULL,
                          workout_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          duration INTEGER,
                          FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Tworzenie tabeli pośredniej dla relacji wiele-do-wielu między treningami a ćwiczeniami
CREATE TABLE workout_exercises (
                                   workout_id BIGINT NOT NULL,
                                   exercise_id BIGINT NOT NULL,
                                   PRIMARY KEY (workout_id, exercise_id),
                                   FOREIGN KEY (workout_id) REFERENCES workouts(id),
                                   FOREIGN KEY (exercise_id) REFERENCES exercises(id)
);