package ru.itis.kahootflux.service;

import reactor.core.publisher.Flux;
import ru.itis.kahootflux.data.Question;
import ru.itis.kahootflux.dto.QuestionRequest;

import java.util.List;

public interface QuestionService {
    Flux<Question> setQuestions(long quizId, List<QuestionRequest> questions);
}
