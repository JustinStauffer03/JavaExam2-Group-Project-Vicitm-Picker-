import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
//victimpicker class
public class VictimPicker {
    private ArrayList<Victim> victims;
    private Random random;
    public VictimPicker() {
        victims = new ArrayList<>();
        random = new Random();
    }
    public Victim chooseOne() {
        if (victims.isEmpty()) {
            throw new IllegalStateException("No victims available.");
        }
        int index = random.nextInt(victims.size());
        return victims.get(index);
    }
    public void markAbsentByName(String name) {
        for (Victim victim : victims) {
            if (victim.getName().equals(name)) {
                victim.setAbsent(true);
                victim.addAbsence(new Date());
                return;
            }
        }
        throw new IllegalArgumentException("Victim with name " + name + " not found.");
    }
    public void adjustScoreByName(String name, int adjustment) {
        for (Victim victim : victims) {
            if (victim.getName().equals(name)) {
                victim.setScore(victim.getScore() + adjustment);
                break;
            }
        }
    }
    public void addVolunteer(String volunteerName) {
        victims.add(new Victim(volunteerName));
    }
    public ArrayList<Victim> getVictims() {
        return victims;
    }
    public void loadList(ArrayList<Victim> victimList) {
        victims.addAll(victimList);
    }
}
