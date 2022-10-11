package ru.itis.kahootflux.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import ru.itis.kahootflux.data.Question;

public interface QuestionRepository extends R2dbcRepository<Question, Long> {
    Flux<Question> getAllByQuizId(long quizId);
}
