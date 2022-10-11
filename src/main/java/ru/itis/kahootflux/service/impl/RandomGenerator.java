package ru.itis.kahootflux.service.impl;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Random;
import java.util.function.Function;

@Component
public class RandomGenerator {

    private final Random random;

    public RandomGenerator(Random random) {
        this.random = random;
    }

    public Mono<Integer> getRandomInt(int fromInclusive, int toExclusive, Function<Integer, Mono<Boolean>> checkFunction) {
        int n = fromInclusive + random.nextInt(toExclusive);
        Mono<Boolean> checkResultMono = checkFunction.apply(n);
        return checkResultMono.flatMap(result -> result ? getRandomInt(fromInclusive, toExclusive, checkFunction) : Mono.just(n));
    }
}
