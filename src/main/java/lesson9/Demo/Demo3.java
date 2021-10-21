package lesson9.Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Презентация "Stream API". Разбор примера из методички
public class Demo3 {

    static class Person {
        enum Position {
            ENGINEER, DIRECTOR, MANAGER;
        }

        private String name;
        private int age;
        private Position position;

        public Person(String name, int age, Position position) {
            this.name = name;
            this.age = age;
            this.position = position;
        }

        public int getAge() {
            return age;
        }
    }

    private static void streamSimpleTask() {
        List<Person> persons = new ArrayList<>(Arrays.asList(
            new Person("Bob1", 35, Person.Position.MANAGER),
            new Person("Bob2", 44, Person.Position.DIRECTOR),
            new Person("Bob3", 25, Person.Position.ENGINEER),
            new Person("Bob4", 42, Person.Position.ENGINEER),
            new Person("Bob5", 55, Person.Position.MANAGER),
            new Person("Bob6", 19, Person.Position.MANAGER),
            new Person("Bob7", 33, Person.Position.ENGINEER),
            new Person("Bob8", 37, Person.Position.MANAGER)
        ));

        ArrayList<String> listNames = new ArrayList<>();

        for (Person person : persons) {
            if (person.position == Person.Position.ENGINEER) {
                listNames.add(person.name);
            }
        }


        List<String> engineersNames = persons.stream()
            .filter(person -> person.position == Person.Position.ENGINEER)
            .map((Function<Person, String>) person -> person.name)
            .collect(Collectors.toList());
        System.out.println(engineersNames);
    }


    public static void main(String[] args) {
        streamSimpleTask();
    }

}
