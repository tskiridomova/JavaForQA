package lesson1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> avangers = new ArrayList<String>();
        avangers.add("Tor"); 
        avangers.add("Iron Man");
        avangers.add("Halk");
        avangers.add("Hawk Eye");
        Course c = new Course(); // Создаем полосу препятствий
        Team team = new Team("Avengers", avangers); // Создаем команду
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
    }

}
