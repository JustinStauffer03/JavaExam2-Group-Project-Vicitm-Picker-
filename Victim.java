import java.util.ArrayList;
import java.util.Date;

public class Victim {
    private String name;
    private int score;
    private boolean isAbsent;
    private ArrayList<Date> absences;

    public Victim(String name) {
        this.name = name;
        this.score = 0; // Initialize score to 0
        this.isAbsent = false; // Initialize as not absent
        this.absences = new ArrayList<>(); // Initialize absences list
    }

    // Getters and setters for name, score, and absence status
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isAbsent() {
        return isAbsent;
    }

    public void setAbsent(boolean absent) {
        isAbsent = absent;
    }

    // Method to add an absence date
    public void addAbsence(Date date) {
        absences.add(date);
    }

    // Additional methods for manipulating absences, if needed

    @Override
    public String toString() {
        return "Victim{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", isAbsent=" + isAbsent +
                ", absences=" + absences +
                '}';
    }
}
