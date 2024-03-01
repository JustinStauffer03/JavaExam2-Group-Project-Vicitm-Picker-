import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public GUI() {
        setTitle("Victim Picker");

        setLayout(new FlowLayout());

        JButton button1 = new JButton("Pick Victim");
        JButton button2 = new JButton("Score +1");
        JButton button3 = new JButton("Score -1");
        JButton button4 = new JButton("Mark Absent");

        add(button1);
        add(button2);
        add(button3);
        add(button4);

        String[] dropdownItems = {"Volunteer","Item 1", "Item 2", "Item 3", "Item 4"};
        JComboBox<String> dropdown = new JComboBox<>(dropdownItems);

        add(dropdown);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
    }

      public static void main(String[] args){
          SwingUtilities.invokeLater(new Runnable() {
              @Override
              public void run() {
                  GUI gui = new GUI();
                  gui.setVisible(true);
              }
          });
        }
}
