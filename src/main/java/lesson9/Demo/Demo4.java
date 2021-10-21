package lesson9.Demo;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

// Презентация "Stream API". Источники стримов
public class Demo4 {

    public static void main(String[] args) {

        // Из произвольных данных
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);

        // Стримы для классов-оберток
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6);
        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        LongStream longStream = LongStream.of(1L, 2L, 3L, 4L, 5L, 6L);

        // Из массивов
        Integer[] ints = new Integer[] {1, 2, 3};
        Stream<Integer> stream = Arrays.stream(ints);

        // Диапазоны [0, 11)
        IntStream.range(0, 11)
            .mapToObj(x -> "It's a string! " + x)
            .forEach(System.out::println);

        // Диапазоны [0, 10]
        IntStream.rangeClosed(0, 10);

        // Бесконечная последовательность с шагом в 5, взять первые 100
        Stream.iterate(5, x -> x + 5)
            .limit(100)
            .collect(Collectors.toList());


    }
}
