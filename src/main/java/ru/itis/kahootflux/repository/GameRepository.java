package ru.itis.kahootflux.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;
import ru.itis.kahootflux.data.Game;

public interface GameRepository extends R2dbcRepository<Game, Long> {
    Mono<Boolean> existsByJoinCodeAndFinishedIsNull(int joinCode);
}
