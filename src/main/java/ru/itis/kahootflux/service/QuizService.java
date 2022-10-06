package ru.itis.kahootflux.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itis.kahootflux.data.Quiz;

public interface QuizService {
    Flux<Quiz> getQuizzes();

    Mono<Quiz> getQuiz(long id);

    Mono<Quiz> saveQuiz(Quiz quiz);

    Mono<Quiz> update(long id, Quiz quiz);
}
