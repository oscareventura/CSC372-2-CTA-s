import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class MenuDemo extends JFrame {
    private JTextArea textArea;

    public MenuDemo() {
        setTitle("Menu Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem printDateTimeItem = new JMenuItem("Print Date & Time");
        JMenuItem writeToLogFileItem = new JMenuItem("Write to log.txt");
        JMenuItem changeBgColorItem = new JMenuItem("Change Background Color");
        JMenuItem exitItem = new JMenuItem("Exit");

        printDateTimeItem.addActionListener(e -> printDateTime());
        writeToLogFileItem.addActionListener(e -> writeToLogFile());
        changeBgColorItem.addActionListener(e -> changeBgColor());
        exitItem.addActionListener(e -> exitProgram());

        menu.add(printDateTimeItem);
        menu.add(writeToLogFileItem);
        menu.add(changeBgColorItem);
        menu.addSeparator();
        menu.add(exitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void printDateTime() {
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        textArea.append("Date & Time: " + formattedDateTime + "\n");
    }

    private void writeToLogFile() {
        String content = textArea.getText();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
            writer.write(content);
            JOptionPane.showMessageDialog(this, "Contents written to log.txt", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to write to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void changeBgColor() {
        Random random = new Random();
        float hue = random.nextFloat() * 360;
        Color color = Color.getHSBColor(hue / 360, 1.0f, 1.0f);
        textArea.setBackground(color);
    }

    private void exitProgram() {
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuDemo menuDemo = new MenuDemo();
            menuDemo.setVisible(true);
        });
    }
}