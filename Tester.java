import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        // Initialize the VictimPicker
        VictimPicker picker = new VictimPicker();

        // Create sample victims
        ArrayList<Victim> sampleVictims = createSampleVictims();

        // Load the sample victims into the VictimPicker
        picker.loadList(sampleVictims);

        // Optionally mark a victim as absent to test that functionality
        // picker.markAbsentByName("Jim Smith");

        // Launch the GUI
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI(picker);
            gui.setVisible(true);
        });
    }

    // Method to create sample victims
    public static ArrayList<Victim> createSampleVictims() {
        ArrayList<Victim> sampleVictims = new ArrayList<>();
        sampleVictims.add(new Victim("Justin Stauffer"));
        sampleVictims.add(new Victim("Jessie Stauffer"));
        sampleVictims.add(new Victim("Braylon Bailey"));
        sampleVictims.add(new Victim("Jim Smith"));
        sampleVictims.add(new Victim("Knewt Caraway"));
        return sampleVictims;
    }
}
