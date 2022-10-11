package ru.itis.kahootflux.data;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Value
@Table("game")
@Builder
public class Game {
    @Id
    Long id;
    long quizId;
    @Transient
    Quiz quiz;
    LocalDateTime started;
    LocalDateTime finished;
    int joinCode;
}
