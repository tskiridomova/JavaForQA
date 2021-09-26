package lesson3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Object[] nazvanieMassiva = {"pervayaStroka", "vtorayaStroka", "tretyaStroka"};
        System.out.println("Исходный массив: " + Arrays.toString(nazvanieMassiva));
        swapObj(nazvanieMassiva, 1,0);
        System.out.println("Конечный массив: " + Arrays.toString(nazvanieMassiva));

        task2();
    }



    /**
     * 1. Написать метод, который меняет два элемента массива местами.
     * (массив может быть любого ссылочного типа);
     */

    static void swapObj(Object[] array, int chtoMenyaem_replacement, int naChtoMenyaem_replacer) {
        if (array.length -1 < chtoMenyaem_replacement || array.length -1 < naChtoMenyaem_replacer) {
            System.out.println("Индекс больше длины массива");
            return;
        }
        Object tmpValue = array[chtoMenyaem_replacement];
        array[chtoMenyaem_replacement] = array[naChtoMenyaem_replacer];
        array[naChtoMenyaem_replacer] = tmpValue;
    }

    private static void task2() {
        Box<Orange> or = new Box<>();
        Box<Orange> or1 = new Box<>();
        Box<Apple> ap = new Box<>();
        Box<Apple> ap1 = new Box<>();
        System.out.println("Задача про ящики");
        System.out.println("'g' - addFruit: ");
        or.addFruit(new Orange(),5);
        or1.addFruit(new Orange(),10);
        ap.addFruit(new Apple(),15);
        ap1.addFruit(new Apple(),20);
        System.out.println("Box 1: "+or.getWeight());
        System.out.println("Box 2: "+or1.getWeight());
        System.out.println("Box 3: "+ap.getWeight());
        System.out.println("Box 4: "+ap1.getWeight());
        System.out.println("'e' - compare(): ");
        System.out.println("Box 1 equals box 3: "+or.compare(ap));
        System.out.println("Box 2 equals box 4: "+or1.compare(ap1));
        System.out.println("'f' - pourTo(): ");
        or.pourTo(or1);
        ap.pourTo(ap1);
        System.out.println("'d' - getWeight(): ");
        System.out.println("Box 1: "+or.getWeight());
        System.out.println("Box 2: "+or1.getWeight());
        System.out.println("Box 3: "+ap.getWeight());
        System.out.println("Box 4: "+ap1.getWeight());

    }

}
