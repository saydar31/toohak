package ru.itis.kahootflux.service;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Collector;

@Component
public class FieldGenerator {
    private final Random random;

    public FieldGenerator(Random random) {
        this.random = random;
    }

    public int randomInt(int origin, int bound) {
        int n = bound - origin;
        return random.nextInt(n) + origin;
    }

    public String randomLatinString(int length) {
        return random.ints('a', 'z')
                .limit(length)
                .mapToObj(n -> (char) n)
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString));
    }
}
