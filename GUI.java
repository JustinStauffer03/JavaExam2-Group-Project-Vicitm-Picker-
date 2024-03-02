import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GUI extends JFrame {
    private VictimPicker picker;

    private JComboBox<String> dropdown;
    private JTextField volunteerField;
    private JLabel victimInfoLabel;

    public GUI(VictimPicker picker) {
        this.picker = picker;
        initializeComponents();
        updateDropdown();
    }

    private void initializeComponents() {
        setTitle("Classroom Interaction System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLayout(new FlowLayout());

        dropdown = new JComboBox<>();
        add(dropdown);

        volunteerField = new JTextField(20);
        add(volunteerField);

        JButton volunteerButton = new JButton("Add Volunteer");
        volunteerButton.addActionListener(this::addVolunteer);
        add(volunteerButton);

        JButton pickButton = new JButton("Pick Victim");
        pickButton.addActionListener(e -> pickVictim());
        add(pickButton);

        JButton absentButton = new JButton("Mark Absent");
        absentButton.addActionListener(e -> markAbsent());
        add(absentButton);

        JButton addButton = new JButton("Score +1");
        addButton.addActionListener(e -> adjustScore(1));
        add(addButton);

        JButton subtractButton = new JButton("Score -1");
        subtractButton.addActionListener(e -> adjustScore(-1));
        add(subtractButton);

        victimInfoLabel = new JLabel("Select a victim to see their info");
        add(victimInfoLabel);
    }

    private void updateDropdown() {
        dropdown.removeAllItems();
        for (Victim victim : picker.getVictims()) {
            dropdown.addItem(victim.getName());
        }
    }

    private void addVolunteer(ActionEvent e) {
        String volunteerName = volunteerField.getText();
        if (!volunteerName.isEmpty()) {
            picker.addVolunteer(volunteerName);
            updateDropdown();
            volunteerField.setText("");
        }
    }

    private void pickVictim() {
        Victim picked = picker.chooseOne();
        updateDropdown();
        updateVictimInfo(picked.getName());
    }

    private void markAbsent() {
        String selectedName = (String) dropdown.getSelectedItem();
        picker.markAbsentByName(selectedName);
        updateDropdown();
        victimInfoLabel.setText("Select a victim to see their info");
    }

    private void adjustScore(int adjustment) {
        String selectedName = (String) dropdown.getSelectedItem();
        picker.adjustScoreByName(selectedName, adjustment);
        updateVictimInfo(selectedName);
    }

    private void updateVictimInfo(String name) {
        for (Victim victim : picker.getVictims()) {
            if (victim.getName().equals(name)) {
                victimInfoLabel.setText("Victim: " + victim.getName() + ", Score: " + victim.getScore());
                break;
            }
        }
    }

    public static void main(String[] args) {
        VictimPicker picker = new VictimPicker();
        picker.loadList(Tester.createSampleVictims());

        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI(picker);
            gui.setVisible(true);
        });
    }
}
