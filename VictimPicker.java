import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class VictimPicker {
    private ArrayList<Victim> victims;
    private Random random;

    public VictimPicker() {
        victims = new ArrayList<>();
        random = new Random();
    }

    // Method to choose a random victim
    public Victim chooseOne() {
        if (victims.isEmpty()) {
            throw new IllegalStateException("No victims available.");
        }
        int index = random.nextInt(victims.size());
        return victims.get(index);
    }

    // Method to mark a victim as absent
    public void markAbsentByName(String name) {
        for (Victim victim : victims) {
            if (victim.getName().equals(name)) {
                victim.setAbsent(true);
                // Optionally, you can record the date of absence
                victim.addAbsence(new Date());
                return;
            }
        }
        throw new IllegalArgumentException("Victim with name " + name + " not found.");
    }

    // Method to adjust the score of a victim by name
    public void adjustScoreByName(String name, int adjustment) {
        for (Victim victim : victims) {
            if (victim.getName().equals(name)) {
                victim.setScore(victim.getScore() + adjustment);
                break;
            }
        }
    }

    // Method to add a volunteer to the list of victims
    public void addVolunteer(String volunteerName) {
        victims.add(new Victim(volunteerName));
    }

    // Other methods for managing the list of victims, such as loading victims, getting victim list, etc.

    // Getter for the list of victims
    public ArrayList<Victim> getVictims() {
        return victims;
    }

    // Method to load a list of victims into the picker
    public void loadList(ArrayList<Victim> victimList) {
        victims.addAll(victimList);
    }
}
