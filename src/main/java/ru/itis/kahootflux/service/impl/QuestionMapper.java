package ru.itis.kahootflux.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.itis.kahootflux.data.Question;
import ru.itis.kahootflux.dto.QuestionRequest;
import ru.itis.kahootflux.utils.StreamUtils;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionMapper {

    private final ModelMapper modelMapper;

    public QuestionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Question fromRequest(QuestionRequest questionRequest) {
        return modelMapper.map(questionRequest, Question.class);
    }

    public List<Question> mapList(long quizId, List<QuestionRequest> questions) {
        return StreamUtils.zipWithIndex(questions)
                .map(pair -> fromRequest(quizId, pair.getFirst(), pair.getSecond()))
                .collect(Collectors.toUnmodifiableList());
    }

    public Question fromRequest(long quizId, int orderNumber, QuestionRequest questionRequest) {
        return Question.builder()
                .text(questionRequest.getText())
                .orderNumber(orderNumber)
                .quizId(quizId)
                .withPrize(questionRequest.isWithPrize())
                .image(questionRequest.getImage())
                .secondsToThink(questionRequest.getSecondsToThink())
                .build();
    }
}
