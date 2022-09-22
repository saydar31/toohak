package ru.itis.kahootflux.data;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Player {
    String name;
    BigDecimal score;
}
