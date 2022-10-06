package ru.itis.kahootflux.data;

import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Value
@Table("answer")
public class Answer {
    @Id
    Long id;
    String text;
    boolean correct;
    long questionId;
    @Transient
    Question question;
}
