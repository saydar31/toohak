package ru.itis.kahootflux.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.itis.kahootflux.data.Question;
import ru.itis.kahootflux.dto.QuestionRequest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QuestionMapperTest {

    @Autowired
    private QuestionMapper questionMapper;


    @Test
    public void test() {
        String text = "who?";
        Question question = questionMapper.fromRequest(new QuestionRequest(text));
        assertEquals(text, question.getText());
    }
}