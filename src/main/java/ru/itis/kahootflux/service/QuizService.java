package ru.itis.kahootflux.service;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itis.kahootflux.data.Quiz;
import ru.itis.kahootflux.dto.QuizDto;
import ru.itis.kahootflux.repository.QuizRepository;

import java.util.Collections;

@Component
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Mono<Quiz> createQuiz(QuizDto quizRequest) {
        return quizRepository.save(fromRequest(quizRequest));
    }

    private Quiz fromRequest(QuizDto quizDto){
        return new Quiz(null, quizDto.getName(), quizDto.getDescription(), Collections.emptyList());
    }

    public Mono<Quiz> update(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Mono<Quiz> find(String id) {
        return quizRepository.findById(id);
    }

    public Flux<Quiz> getAll() {
        return quizRepository.findAllFlat();
    }
}
