package lesson1;

import java.util.ArrayList;
import java.util.Random;

public class Course {
    public ArrayList<Integer> obstacles;

    Course() {
        this.obstacles = new ArrayList<Integer>();
        makeObstacles();
    }

    private void makeObstacles() {
        Random rand = new Random();
        int size = rand.nextInt(10);
        for (int i = 0; i < size; i++) {
            int obstacle = rand.nextInt(10);
            this.obstacles.add(obstacle);
        }
    }

    private boolean passObstacles(Integer strength) {
        for (int i = 0; i < this.obstacles.size(); i++) {
            if (strength < this.obstacles.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void doIt(Team team) {
        System.out.println("Team: " + team.participants);
        System.out.println("Obstacles: " + this.obstacles);
        Random rand = new Random();
        for (int i = 0; i < team.participants.size(); i++) {
            int strength = rand.nextInt(10);
            System.out.println(team.participants.get(i) + " has strength " + strength);
            if (this.passObstacles(strength)) {
                team.winners.add(team.participants.get(i));
            }
        }
    }
}
