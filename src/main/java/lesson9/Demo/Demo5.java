package lesson9.Demo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

// Методы стримов
public class Demo5 {

    static List<Demo3.Person> persons = new ArrayList<>(Arrays.asList(
        new Demo3.Person("Bob1", 35, Demo3.Person.Position.MANAGER),
        new Demo3.Person("Bob2", 44, Demo3.Person.Position.DIRECTOR),
        new Demo3.Person("Bob3", 25, Demo3.Person.Position.ENGINEER),
        new Demo3.Person("Bob3", 25, Demo3.Person.Position.ENGINEER),
        new Demo3.Person("Bob4", 42, Demo3.Person.Position.ENGINEER),
        new Demo3.Person("Bob5", 55, Demo3.Person.Position.MANAGER),
        new Demo3.Person("Bob6", 19, Demo3.Person.Position.MANAGER),
        new Demo3.Person("Bob7", 33, Demo3.Person.Position.ENGINEER),
        new Demo3.Person("Bob8", 37, Demo3.Person.Position.MANAGER)
    ));

    public static void main(String[] args) {

        // Демонстрация дефолтной сортировки
        persons.stream()
            .map(it -> it.getAge())
            .sorted()
            .forEach(System.out::println);

        System.out.println("-----");

        // Демонстрация кастомной сортировки
        persons.stream()
            .map(it -> it.getAge())
            .sorted(Collections.reverseOrder())
            .forEach(System.out::println);

        System.out.println("-----");

        // Демонстрация редьюсера, класс Optional
        Optional<Integer> optionalResult = persons.stream()
            .map(it -> it.getAge())
            .sorted(Collections.reverseOrder())
            .reduce(Integer::sum);

        Integer result = optionalResult.orElse(null);

        System.out.println(result);

        System.out.println("-----");

        // Демонстрация distinct
        Stream.of("123", "123", "456", "789", "000")
            .distinct()
            .forEach(System.out::println);

        System.out.println("-----");

        // Демонстрация skip
        Stream.of("123", "123", "456", "789", "000")
            .skip(4)
            .forEach(System.out::println);

        System.out.println("-----");

        // Демонстрация flatMap
        Integer[][] arr = new Integer[][] {{1,2,3,4,5},{10,20,30,40,50},{100,200,300,400,500}};
        Stream.of(arr)
            .flatMap(Stream::of)
            .forEach(System.out::println);
    }
}
