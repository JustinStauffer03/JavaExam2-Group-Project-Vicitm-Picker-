import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Victim {
    private String name;
    private int score;
    private boolean isAbsent;
    private ArrayList<Date> absences; // Store the dates of absence

    public Victim(String name) {
        this.name = name;
        this.score = 0; // Initialize score to 0
        this.isAbsent = false; // Initialize as not absent
        this.absences = new ArrayList<>(); // Initialize the list of absences
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
        this.setAbsent(true); // Automatically mark as absent when an absence date is added
    }

    // Method to get the list of absences
    public List<Date> getAbsences() {
        return absences;
    }

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
