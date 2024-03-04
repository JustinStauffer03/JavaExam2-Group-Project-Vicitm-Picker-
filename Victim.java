import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//Victim class
public class Victim {
    private String name;
    private int score;
    private boolean isAbsent;
    private ArrayList<Date> absences;

    public Victim(String name) {
        this.name = name;
        this.score = 0;
        this.isAbsent = false;
        this.absences = new ArrayList<>();
    }
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

    public void addAbsence(Date date) {
        absences.add(date);
        this.setAbsent(true);
    }

    public List<Date> getAbsences() {
        return absences;
    }

    public String toString() {
        return "Victim{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", isAbsent=" + isAbsent +
                ", absences=" + absences +
                '}';
    }
}
