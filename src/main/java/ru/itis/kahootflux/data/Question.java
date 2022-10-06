package ru.itis.kahootflux.data;

import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Value
@Table("question")
public class Question {
    @Id
    Long id;
    String text;
    String image;
    boolean withPrize;
    long quizId;
    int orderNumber;
    int secondsToThink;
    @Transient
    Quiz quiz;
    @Transient
    List<Answer> answers;
}
