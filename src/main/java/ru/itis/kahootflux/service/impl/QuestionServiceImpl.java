package ru.itis.kahootflux.service.impl;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import ru.itis.kahootflux.data.Question;
import ru.itis.kahootflux.dto.QuestionRequest;
import ru.itis.kahootflux.repository.QuestionRepository;
import ru.itis.kahootflux.service.QuestionService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionServiceImpl implements QuestionService {

    private final QuestionMapper questionMapper;
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionMapper questionMapper, QuestionRepository questionRepository) {
        this.questionMapper = questionMapper;
        this.questionRepository = questionRepository;
    }

    @Override
    public Flux<Question> setQuestions(long quizId, List<QuestionRequest> questions) {
        return questionRepository.saveAll(questionMapper.mapList(quizId, questions));
    }

    @Override
    public Flux<Question> getQuestions(long quizId) {
        return questionRepository.getAllByQuizId(quizId);
    }

}
