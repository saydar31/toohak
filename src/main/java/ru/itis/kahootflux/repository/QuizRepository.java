package ru.itis.kahootflux.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import ru.itis.kahootflux.data.Quiz;

public interface QuizRepository extends R2dbcRepository<Quiz, Long> {
}
