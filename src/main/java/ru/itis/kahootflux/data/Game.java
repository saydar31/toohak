package ru.itis.kahootflux.data;

import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "games")
@Value
public class Game {
    @Id
    String id;
    @DBRef(lazy = true)
    Quiz quiz;
    int pin;
    LocalDateTime date;
    LocalDateTime finished;
    Map<String, Player> players;
}
