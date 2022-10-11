package ru.itis.kahootflux.utils;

import lombok.experimental.UtilityClass;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamUtils {
    public static <T> Stream<Pair<Integer, T>> zipWithIndex(List<T> list){
        return IntStream.range(0, list.size())
                .mapToObj(i -> Pair.of(i, list.get(i)));
    }
}
