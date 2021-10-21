package lesson9.Demo;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

// Слайд "Функциональные интерфейсы"
public class Demo1 {

    static class Person {
        int age;

        public Person(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        unaryOperatorGetCube();
    }

    // Демонстрация предиката
    private static void verifyUserToBeerPub() {
        // Анонимный класс
        Predicate<Person> personPredicate = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.age >= 18;
            }
        };

        Person valid = new Person(19);
        Person tooYoung = new Person(14);

        System.out.println(personPredicate.test(valid));
        System.out.println(personPredicate.test(tooYoung));
    }

    // Демонстрация функции
    private static void functionExample() {
        Function<String, Integer> strToInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                try {
                    return Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        };

        System.out.println(strToInt.apply("5"));
        System.out.println(strToInt.apply("5s"));
    }

    // Демонстрация unaryoperator, функция, вычисляющая куб
    private static void unaryOperatorGetCube() {
        UnaryOperator<Integer> getCube =
            new UnaryOperator<Integer>() {
                @Override
                public Integer apply(Integer integer) {
                    return integer * integer * integer;
                }
            };

        System.out.println(getCube.apply(10));
    }
}
