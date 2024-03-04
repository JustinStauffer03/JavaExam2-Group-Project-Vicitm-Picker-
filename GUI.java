import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.stream.Collectors;
import java.util.Date;
//gui for handling user interface
public class GUI extends JFrame {
    private VictimPicker picker;
    private JComboBox<String> dropdown;
    private JComboBox<String> absentDropdown;
    private JTextField volunteerField;
    private JLabel victimInfoLabel;
    private JLabel countdownLabel;
    private Timer countdownTimer;
    private int countdownSeconds = 30;
    public GUI(VictimPicker picker) {
        this.picker = picker;
        initializeComponents();
        updateDropdown();
    }
    private void initializeComponents() {
        setTitle("Classroom Interaction System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        getContentPane().setBackground(new Color(240, 240, 240));
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Font labelFont = new Font("Arial", Font.BOLD, 12);
        Font buttonFont = new Font("Arial", Font.PLAIN, 12);
        dropdown = new JComboBox<>();
        dropdown.setPreferredSize(new Dimension(200, 25));
        add(dropdown);
        absentDropdown = new JComboBox<>();
        absentDropdown.setPreferredSize(new Dimension(200, 25));
        absentDropdown.addActionListener(e -> displayAbsenceInfo());
        add(absentDropdown);
        volunteerField = new JTextField(20);
        add(volunteerField);

        JButton volunteerButton = createButton("Add New Student", buttonFont);
        volunteerButton.addActionListener(this::addVolunteer);
        add(volunteerButton);

        JButton pickButton = createButton("Pick Victim", buttonFont);
        pickButton.addActionListener(e -> pickVictim());
        add(pickButton);

        JButton absentButton = createButton("Mark Absent", buttonFont);
        absentButton.addActionListener(e -> markAbsent());
        add(absentButton);

        JButton addButton = createButton("Score +1", buttonFont);
        addButton.addActionListener(e -> adjustScore(1));
        add(addButton);

        JButton subtractButton = createButton("Score -1", buttonFont);
        subtractButton.addActionListener(e -> adjustScore(-1));
        add(subtractButton);

        victimInfoLabel = new JLabel("Select a victim to see their info");
        victimInfoLabel.setFont(labelFont);
        add(victimInfoLabel);

        countdownLabel = new JLabel("Time to answer: --");
        countdownLabel.setFont(labelFont);
        add(countdownLabel);
    }
    private JButton createButton(String text, Font font) {
        JButton button = new JButton(text);
        button.setFont(font);
        return button;
    }
    private void updateDropdown() {
        dropdown.removeAllItems();
        for (Victim victim : picker.getVictims()) {
            if (!victim.isAbsent()) {
                dropdown.addItem(victim.getName());
            }
        }
        updateAbsentDropdown();
    }
    private void updateAbsentDropdown() {
        absentDropdown.removeAllItems();
        for (Victim victim : picker.getVictims()) {
            if (victim.isAbsent()) {
                absentDropdown.addItem(victim.getName());
            }
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
        dropdown.setSelectedItem(picked.getName());
        updateVictimInfo(picked.getName());
        // Reset and start the countdown timer
         if(countdownTimer != null) {
            countdownTimer.stop(); // Stops any countdown already made
        }
        countdownSeconds = 30; // sets and resets back to 30 secons
        countdownTimer = new Timer(1000, e -> {
            countdownSeconds--;
            countdownLabel.setText("Time to answer: " + countdownSeconds + "s");
            if (countdownSeconds <= 0) {
                ((Timer)e.getSource()).stop(); // This stops the timer when it reaches zero
                countdownLabel.setText("Time is up!");
            }
        });
        countdownTimer.start(); // Starts the countdown
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
    private void displayAbsenceInfo() {
        String selectedName = (String) absentDropdown.getSelectedItem();
        for (Victim victim : picker.getVictims()) {
            if (victim.getName().equals(selectedName) && victim.isAbsent()) {
                String absenceDates = victim.getAbsences().stream()
                        .map(Date::toString)
                        .collect(Collectors.joining(", "));
                victimInfoLabel.setText("Absent Victim: " + victim.getName() + ", Absence Dates: " + absenceDates);
                break;
            }
        }
    }
}
