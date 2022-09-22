package ru.itis;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    private static int less3(int i) {
        if (i <= 3) {
            return i;
        } else {
            throw new RuntimeException();
        }
    }

    private static Integer x;

    public static void main(String[] args) {
        Flux<Integer> integerMono = Flux.just(13);
        try (Stream<String> lines = Files.lines(Path.of("foo.txt"))) {
            Flux.fromStream(lines)
                    .map(Integer::parseInt)
                    .flatMap(i -> integerMono.map(j ->
                                    String.format("(%d, %d)",i,j)
                            )
                    ).subscribe(System.out::println, System.err::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
