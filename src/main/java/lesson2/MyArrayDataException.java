package lesson2;

public class MyArrayDataException extends NumberFormatException {
    MyArrayDataException(int i, int j) {
        super("Problem in element [" + i + "][" + j + "]");
    }
}
