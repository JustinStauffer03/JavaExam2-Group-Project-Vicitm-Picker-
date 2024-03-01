//Justin Stauffer
import java.util.ArrayList;
import java.util.Date;

public class Victim {
    private String name;
    private final int section;
    private int score;
    private Date lastPicked;
    private ArrayList<Date> absences;
    private boolean isAbsent; // used for conditional of what to output in toString.
    private int numberOfPicks;
    public int getNumberOfPicks() {
        return numberOfPicks;
    }

    public void setNumberOfPicks(int numberOfPicks) {
        this.numberOfPicks = numberOfPicks;
    }


    public Victim(String name, int section){
        this.name = name;
        this.section = section;
        this.absences = new ArrayList<>();

    }
    public void setName() {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getSection() {
        return section;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public Date getLastPicked() {
        return lastPicked;
    }
    public void setLastPicked(Date lastPicked) {
        this.lastPicked = lastPicked;
    }
    public void setAbsent(boolean absent){
        absent = true;
        this.isAbsent = absent;
    }
    public boolean getAbsent(){return isAbsent;}
    public void setAbsences(ArrayList<Date> absences) {
        this.absences = absences;
    }
    public ArrayList<Date> getAbsences() {
        return absences;
    }

    public String toString() {
        //conditional for what to display depending on wether they are absent or not.
        if (!isAbsent) {
            return "Victim is...." + getName() + " from section " + getSection() + "! Their score is now " + score + "." + " They were last picked on " + lastPicked;

        } else {
            return "Victim, " + getName() + " from section " + getSection() + ", is absent," + "their current score is " + score + ". Their abscence list follows: " + absences;
        }
    }

}
