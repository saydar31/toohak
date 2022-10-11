package ru.itis.kahootflux.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.itis.kahootflux.data.Question;
import ru.itis.kahootflux.dto.QuestionRequest;
@Component
public class QuestionMapper {

    private final ModelMapper modelMapper;

    public QuestionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Question fromRequest(QuestionRequest questionRequest) {
        return modelMapper.map(questionRequest, Question.class);
    }
}
