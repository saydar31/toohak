package ru.itis.kahootflux.dto;

import lombok.Value;
import ru.itis.kahootflux.data.Player;

import java.math.BigDecimal;

@Value
public class PlayerResponse {
    String id;
    String name;
    BigDecimal score;

    public PlayerResponse(String id, Player player){
        this.id = id;
        this.name = player.getName();
        this.score = player.getScore();
    }
}
