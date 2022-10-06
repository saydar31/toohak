package ru.itis.kahootflux.service.impl;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itis.kahootflux.data.Quiz;
import ru.itis.kahootflux.exceptions.BadRequestException;
import ru.itis.kahootflux.repository.QuizRepository;
import ru.itis.kahootflux.service.QuizService;

@Component
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Flux<Quiz> getQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public Mono<Quiz> getQuiz(long id) {
        return quizRepository.findById(id);
    }

    @Override
    public Mono<Quiz> saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Mono<Quiz> update(long id, Quiz quiz) {
        if (quiz.getId() != null && id != quiz.getId()) {
            throw new BadRequestException("id in param '%d' and id in body '%d' doesn't match", id, quiz.getId());
        }
        return quizRepository.save(quiz);
    }
}
