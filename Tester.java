import javax.swing.SwingUtilities;
import java.util.ArrayList;
//tests our victim picker
public class Tester {
    public static void main(String[] args) {
        VictimPicker picker = new VictimPicker();
        ArrayList<Victim> chosenOnes = createSampleVictims();
        picker.loadList(chosenOnes);
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI(picker);
            gui.setVisible(true);
        });
    }
    // creates sample victins
    public static ArrayList<Victim> createSampleVictims() {
        ArrayList<Victim> chosenOnes = new ArrayList<>();
        chosenOnes.add(new Victim("Justin Stauffer"));
        chosenOnes.add(new Victim("Jessie Stauffer"));
        chosenOnes.add(new Victim("Braylon Bailey"));
        chosenOnes.add(new Victim("Jim Smith"));
        chosenOnes.add(new Victim("Knewt Caraway"));
        return chosenOnes;
    }
}
