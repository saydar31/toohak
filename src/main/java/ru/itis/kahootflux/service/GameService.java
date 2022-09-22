package ru.itis.kahootflux.service;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import ru.itis.kahootflux.data.Game;
import ru.itis.kahootflux.data.Quiz;
import ru.itis.kahootflux.dto.PlayerResponse;
import ru.itis.kahootflux.repository.GameRepositoryImpl;
import ru.itis.kahootflux.repository.QuizRepository;

import java.time.LocalDateTime;
import java.util.Collections;

import static reactor.core.publisher.Mono.just;

@Component
public class GameService {

    private final GameRepositoryImpl gameRepository;
    private final QuizRepository quizRepository;
    private final FieldGenerator fieldGenerator;

    public GameService(GameRepositoryImpl gameRepository, QuizRepository quizRepository, FieldGenerator fieldGenerator) {
        this.gameRepository = gameRepository;
        this.quizRepository = quizRepository;
        this.fieldGenerator = fieldGenerator;
    }

    public Mono<Game> start(String quizId) {
        Mono<Quiz> quizMono = quizRepository.findById(quizId);
        Mono<Integer> pinMono = generatePin();
        return quizMono.zipWith(pinMono, this::startGame)
                .flatMap(gameRepository::save);
    }

    private Mono<Integer> generatePin() {
        int pin = fieldGenerator.randomInt(100_000, 999_999);
        return gameRepository.existsByPin(pin)
                .flatMap(exists -> exists ? generatePin() : just(pin));
    }

    private Game startGame(Quiz quiz, int pin) {
        return new Game(null, quiz, pin, LocalDateTime.now(), null, Collections.emptyMap(), Collections.emptyMap());
    }

    public Mono<PlayerResponse> enroll(String id, String name) {
        Mono<String> userIdMono = generatePlayerId(id);
        return userIdMono.flatMap(playerId ->
                gameRepository.addPlayer(id, playerId, name).map(player ->
                        new PlayerResponse(playerId, player)
                )
        );
    }

    private Mono<String> generatePlayerId(String gameId) {
        String userId = fieldGenerator.randomLatinString(6);
        return gameRepository.existsByIdAndPlayerId(gameId, userId)
                .flatMap(exists -> exists ? generatePlayerId(gameId) : just(userId));
    }

    public Mono<Void> startQuestion(String id, String questionId) {
        return gameRepository.markQuestionStarted(id, questionId);
    }
}
