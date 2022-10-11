package ru.itis.kahootflux.service;

import reactor.core.publisher.Mono;
import ru.itis.kahootflux.data.Game;

public interface GameService {
    Mono<Game> startByQuizId(long id);
}
