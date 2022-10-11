package ru.itis.kahootflux.service.impl;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import ru.itis.kahootflux.data.Game;
import ru.itis.kahootflux.repository.GameRepository;
import ru.itis.kahootflux.repository.QuizRepository;
import ru.itis.kahootflux.service.GameService;

import java.time.LocalDateTime;

@Component
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final QuizRepository quizRepository;
    private final RandomGenerator randomGenerator;


    public GameServiceImpl(GameRepository gameRepository, QuizRepository quizRepository, RandomGenerator randomGenerator) {
        this.gameRepository = gameRepository;
        this.quizRepository = quizRepository;
        this.randomGenerator = randomGenerator;
    }

    @Override
    public Mono<Game> startByQuizId(long id) {
        Mono<Integer> codeMono = randomGenerator.getRandomInt(100_000, 1_000_000, gameRepository::existsByJoinCodeAndFinishedIsNull);
        return quizRepository.findById(id)
                .flatMap(quiz ->
                        codeMono.map(code -> Game.builder()
                                .quizId(quiz.getId())
                                .started(LocalDateTime.now())
                                .joinCode(code)
                                .build()
                        )
                ).flatMap(gameRepository::save);
    }
}
