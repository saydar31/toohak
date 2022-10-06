package ru.itis.kahootflux.data;

import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Table("quiz")
public class Quiz {
    @Id
    Long id;
    String name;
    String description;
    LocalDateTime created;
    @Transient
    List<Question> questions;
}
