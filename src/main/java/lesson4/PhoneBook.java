package lesson4;

import java.util.HashMap;
import java.util.ArrayList;

public class PhoneBook {

    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<String, ArrayList<String>>();

    public PhoneBook() {}

    public void add(String name, String number) {
        ArrayList<String> tmp = new ArrayList<String>();
        if (this.phoneBook.containsKey(name)) {
            tmp = this.phoneBook.get(name);
            tmp.add(number);
            this.phoneBook.put(name, new ArrayList<String>(tmp));
        } else {
            tmp.add(number);
            this.phoneBook.put(name, tmp);
        }
    }

    public String get(String name) {
        if (this.phoneBook.containsKey(name)) {
        return "Found pnoes for " + name + ": " + String.join(", ", this.phoneBook.get(name));
        } else {
            return name + ": Phone not found";
        }
    }

}
