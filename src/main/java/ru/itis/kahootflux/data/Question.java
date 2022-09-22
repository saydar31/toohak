package ru.itis.kahootflux.data;

import lombok.Value;

import java.util.List;

@Value
public class Question {
    String text;
    boolean hasPrize;
    List<Answer> answers;
}
