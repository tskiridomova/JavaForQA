package lesson1;

import java.util.ArrayList;

public class Team {
    public String name;
    public ArrayList<String> participants;
    public ArrayList<String> winners;

    public Team(String name, ArrayList<String> participants) {
        this.name = name;
        this.participants = participants;
        this.winners = new ArrayList<String>();
    }

    public void info() {
        System.out.println(this.participants);
    }

    public void showResults() {
        System.out.println("Winners: " + this.winners);
    }

}
