package ru.itis.kahootflux.dto;

import lombok.Value;

@Value
public class QuestionRequest {
    String text;
    String image;
    boolean withPrize;
    int secondsToThink;
}
