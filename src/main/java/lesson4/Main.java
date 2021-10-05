package lesson4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        System.out.println("=============== Task 1 ===============");
        ArrayList<String> words = Init();
        HashSet<String> uniqueWords = new HashSet<String>(words);
        for (String word : uniqueWords) {
            System.out.println(word + ": " + Collections.frequency(words, word));
        }

        System.out.println("=============== Task 2 ===============");

        PhoneBook book = new PhoneBook();
        book.add("Ivanov","123-123-123");
        book.add("Ivanov","321-321-312"); 
        book.add("Petrov","321-321-312"); 
        book.add("Sidorov","111-222-312"); 
        book.add("Sidorov","321-222-312"); 
        book.add("Petrov","333-321-312"); 
        
        System.out.println(book.get("Ivanov"));
        System.out.println(book.get("Petrov"));
        System.out.println(book.get("Sidorov"));
        System.out.println(book.get("Putin"));

    }

    private static ArrayList<String> Init() {
        ArrayList<String> words = new ArrayList<>();
        words.add("One");
        words.add("Two");
        words.add("Three");
        words.add("Four");
        words.add("Five");
        words.add("Six");
        words.add("Two");
        words.add("Four");
        words.add("Six");
        words.add("Nine");
        words.add("Ten");
        words.add("Seven");
        words.add("Two");
        words.add("One");
        words.add("Four");
        words.add("Eleven");
        return words;
    }
}
