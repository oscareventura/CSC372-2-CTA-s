import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AgeCalculatorApp extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton calculateButton;
    private JLabel ageLabel;
    private JTextField birthDateField;

    public AgeCalculatorApp() {
        setTitle("Age Calculator");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        birthDateField = new JTextField();
        birthDateField.setPreferredSize(new Dimension(200, 30));
        mainPanel.add(birthDateField, BorderLayout.NORTH);

        calculateButton = new JButton("Calculate Age");
        calculateButton.addActionListener(this);
        mainPanel.add(calculateButton, BorderLayout.CENTER);

        ageLabel = new JLabel();
        mainPanel.add(ageLabel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            String birthDateString = birthDateField.getText();
            LocalDate birthDate = LocalDate.parse(birthDateString);
            LocalDate currentDate = LocalDate.now();
            int age = Period.between(birthDate, currentDate).getYears();
            ageLabel.setText("Your age is: " + age);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AgeCalculatorApp::new);
    }
}