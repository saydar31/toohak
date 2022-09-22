package ru.itis.kahootflux.data;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Value
public class Question {
    String text;
    boolean hasPrize;
    Map<String, Answer> answers;
    LocalDateTime started;
}
