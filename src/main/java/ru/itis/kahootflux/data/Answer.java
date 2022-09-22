package ru.itis.kahootflux.data;

import lombok.Value;

@Value
public class Answer {
    String text;
    boolean correct;
    Integer count;
}
