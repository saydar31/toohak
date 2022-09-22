package ru.itis.kahootflux.data;

import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Value
@Document("quiz")
public class Quiz {
    @Id
    String id;
    String name;
    String description;
    Map<Integer, Question> questions;
}
