package ru.itis.kahootflux.data;

import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Value
@Document("quiz")
public class Quiz {
    @Id
    String id;
    String name;
    String description;
    List<Question> questions;
}
