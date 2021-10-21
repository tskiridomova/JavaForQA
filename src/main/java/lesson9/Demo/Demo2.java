package lesson9.Demo;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

// Демонстрация лямбды
public class Demo2 {

    /*
    Из предыдущего примера свернуть анонимный класс в лямбду

    Лямбды = Анонимные функции
    1. Указывать тип можно, но компилятор приводит к нужному типу самостоятельно
    2. Если выражение в одну строку, не обязательно писать return и ставить {}

    Продемонстрировать лямбды на остальных примерах
    */

    public static void main(String[] args) {

        /*
        UnaryOperator<Integer> getCube =
            new UnaryOperator<Integer>() {
                @Override
                public Integer apply(Integer integer) {
                    return integer * integer * integer;
                }
            };
         */

        UnaryOperator<Integer> getCube =
            (Integer integer) -> {
                return integer * integer * integer;
            };

        System.out.println(getCube.apply(10));

        Consumer<Object> printObject = it -> System.out.println(it);
        //Consumer<Object> printObject = System.out::println;

        printObject.accept(new Object());
    }


}
