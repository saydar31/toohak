package ru.itis.kahootflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ru.itis.kahootflux.data.Game;

public interface GameRepository extends ReactiveMongoRepository<Game, String> {
    Mono<Boolean> existsByPin(int pin);

}
