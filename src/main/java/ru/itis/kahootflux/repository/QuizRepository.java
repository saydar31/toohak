package ru.itis.kahootflux.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import ru.itis.kahootflux.data.Quiz;

public interface QuizRepository extends ReactiveCrudRepository<Quiz, String> {
    @Query(value = "{}", fields = "{_id: 1, name: 1, description: 1}")
    Flux<Quiz> findAllFlat();
}
