import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        try {
            // File writers for each text field
            PrintWriter sleepWriter = new PrintWriter(new FileWriter("sleep.csv", true));
            PrintWriter moodWriter = new PrintWriter(new FileWriter("mood.csv", true));
            PrintWriter commentsWriter = new PrintWriter(new FileWriter("comments.csv", true));

            // Create the frame
            JFrame frame = new JFrame("Journal");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setLayout(new GridLayout(3, 2, 5, 5));

            // Create labels and text fields
            JLabel sleepLabel = new JLabel("Sleep:");
            JTextField sleepField = new JTextField(10);

            JLabel moodLabel = new JLabel("Mood:");
            JTextField moodField = new JTextField(10);

            JLabel commentsLabel = new JLabel("Comments:");
            JTextField commentsField = new JTextField(10);

            // Add action listeners to each text field
            sleepField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sleepWriter.println(sleepField.getText());
                    sleepWriter.flush();  // Flush to ensure data is written
                    sleepField.setText(""); // Clear the text field after submission
                }
            });

            moodField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    moodWriter.println(moodField.getText());
                    moodWriter.flush();  // Flush to ensure data is written
                    moodField.setText(""); // Clear the text field after submission
                }
            });

            commentsField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    commentsWriter.println(commentsField.getText());
                    commentsWriter.flush();  // Flush to ensure data is written
                    commentsField.setText(""); // Clear the text field after submission
                }
            });

            // Add components to the frame
            frame.add(sleepLabel);
            frame.add(sleepField);
            frame.add(moodLabel);
            frame.add(moodField);
            frame.add(commentsLabel);
            frame.add(commentsField);

            // Display the frame
            frame.setVisible(true);

            // Close writers when the frame is closed
            frame.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    sleepWriter.close();
                    moodWriter.close();
                    commentsWriter.close();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error creating file writers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}