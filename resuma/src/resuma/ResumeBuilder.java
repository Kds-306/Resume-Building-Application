package resuma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterJob;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ResumeBuilder {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Resume Builder");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(350, 800); // Adjusted size for a more compact window

            // Set layout manager
            frame.getContentPane().setLayout(null);

            // Name
            JLabel nameLabel = new JLabel("Name:*");
            nameLabel.setFont(new Font("Tahoma", Font.BOLD, 10)); // Set to bold
            nameLabel.setBounds(10, 10, 100, 20);
            JTextField nameField = new JTextField();
            nameField.setBounds(120, 10, 200, 20);
            frame.getContentPane().add(nameLabel);
            frame.getContentPane().add(nameField);

            // Email
            JLabel emailLabel = new JLabel("Email:*");
            emailLabel.setFont(new Font("Tahoma", Font.BOLD, 10)); // Set to bold
            emailLabel.setBounds(10, 40, 100, 20);
            JTextField emailField = new JTextField();
            emailField.setBounds(120, 40, 200, 20);
            frame.getContentPane().add(emailLabel);
            frame.getContentPane().add(emailField);

            // Phone
            JLabel phoneLabel = new JLabel("Phone:*");
            phoneLabel.setFont(new Font("Tahoma", Font.BOLD, 10)); // Set to bold
            phoneLabel.setBounds(10, 70, 100, 20);
            JTextField phoneField = new JTextField();
            phoneField.setBounds(120, 70, 200, 20);
            frame.getContentPane().add(phoneLabel);
            frame.getContentPane().add(phoneField);

            // Address
            JLabel addressLabel = new JLabel("Address:*");
            addressLabel.setFont(new Font("Tahoma", Font.BOLD, 10)); // Set to bold
            addressLabel.setBounds(10, 100, 100, 20);
            JTextField addressField = new JTextField();
            addressField.setBounds(120, 100, 200, 20);
            frame.getContentPane().add(addressLabel);
            frame.getContentPane().add(addressField);

            // Education Level
            JLabel educationLabel = new JLabel("Education Level:*");
            educationLabel.setFont(new Font("Tahoma", Font.BOLD, 10)); // Set to bold
            educationLabel.setBounds(10, 130, 120, 20);
            String[] educationOptions = {"10th", "12th", "Undergraduate (UG)", "Postgraduate (PG)"};
            JComboBox<String> educationComboBox = new JComboBox<>(educationOptions);
            educationComboBox.setBounds(120, 130, 200, 20);
            frame.getContentPane().add(educationLabel);
            frame.getContentPane().add(educationComboBox);

            // Course
            JLabel courseLabel = new JLabel("Course:*");
            courseLabel.setFont(new Font("Tahoma", Font.BOLD, 10)); // Set to bold
            courseLabel.setBounds(10, 160, 100, 20);
            JTextField courseField = new JTextField();
            courseField.setBounds(120, 160, 200, 20);
            frame.getContentPane().add(courseLabel);
            frame.getContentPane().add(courseField);

            // University
            JLabel universityLabel = new JLabel("University:*");
            universityLabel.setFont(new Font("Tahoma", Font.BOLD, 10)); // Set to bold
            universityLabel.setBounds(10, 190, 100, 20);
            JTextField universityField = new JTextField();
            universityField.setBounds(120, 190, 200, 20);
            frame.getContentPane().add(universityLabel);
            frame.getContentPane().add(universityField);

            // Experience
            JLabel experienceLabel = new JLabel("Experience:*");
            experienceLabel.setFont(new Font("Tahoma", Font.BOLD, 10)); // Set to bold
            experienceLabel.setBounds(10, 220, 100, 20);
            JTextArea experienceArea = new JTextArea(4, 20);
            JScrollPane experienceScrollPane = new JScrollPane(experienceArea);
            experienceScrollPane.setBounds(120, 220, 200, 60);
            frame.getContentPane().add(experienceLabel);
            frame.getContentPane().add(experienceScrollPane);

            // Academic Project 1
            JLabel project1Label = new JLabel("Academic Project 1:*");
            project1Label.setFont(new Font("Tahoma", Font.BOLD, 10)); // Set to bold
            project1Label.setBounds(10, 290, 120, 20);
            JTextArea project1Area = new JTextArea(3, 20);
            JScrollPane project1ScrollPane = new JScrollPane(project1Area);
            project1ScrollPane.setBounds(120, 290, 200, 50);
            frame.getContentPane().add(project1Label);
            frame.getContentPane().add(project1ScrollPane);

            // Academic Project 2
            JLabel project2Label = new JLabel("Academic Project 2:");
            project2Label.setFont(new Font("Tahoma", Font.BOLD, 10)); // Set to bold
            project2Label.setBounds(10, 360, 120, 20);
            JTextArea project2Area = new JTextArea(3, 20);
            JScrollPane project2ScrollPane = new JScrollPane(project2Area);
            project2ScrollPane.setBounds(120, 360, 200, 50);
            frame.getContentPane().add(project2Label);
            frame.getContentPane().add(project2ScrollPane);

            // Photo (optional)
            JLabel photoLabel = new JLabel("Photo (Optional):");
            photoLabel.setFont(new Font("Tahoma", Font.BOLD, 10)); // Set to bold
            photoLabel.setBounds(10, 430, 120, 20);
            JButton photoButton = new JButton("Choose Photo");
            photoButton.setBounds(120, 430, 200, 20);
            frame.getContentPane().add(photoLabel);
            frame.getContentPane().add(photoButton);

            // JLabel to display the selected photo
            JLabel photoDisplayLabel = new JLabel();
            photoDisplayLabel.setBounds(120, 460, 100, 100); // Adjusted to smaller size
            frame.getContentPane().add(photoDisplayLabel);

            // Create a panel for the button
            JPanel buttonPanel = new JPanel();
            buttonPanel.setBounds(10, 600, 340, 50);
            buttonPanel.setLayout(new FlowLayout()); // Center the button
            JButton generateButton = new JButton("Generate Resume");
            JButton clearButton = new JButton("Clear Fields"); // Clear button
            buttonPanel.add(generateButton);
            buttonPanel.add(clearButton); // Add clear button to panel
            frame.getContentPane().add(buttonPanel); // Add the button panel to the frame

            // Action Listener for photo button
            photoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Select Photo");
                    fileChooser.setAcceptAllFileFilterUsed(false);
                    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg"));

                    int returnValue = fileChooser.showOpenDialog(frame);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                        Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Resize image
                        photoDisplayLabel.setIcon(new ImageIcon(image)); // Display the selected photo
                    }
                }
            });

            // Action Listener for the generate button
            generateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    String email = emailField.getText();
                    String phone = phoneField.getText();
                    String address = addressField.getText();
                    String education = (String) educationComboBox.getSelectedItem();
                    String course = courseField.getText();
                    String university = universityField.getText();
                    String experience = experienceArea.getText();
                    String project1 = project1Area.getText();
                    String project2 = project2Area.getText();

                    // Validation for compulsory fields
                    if (name.isEmpty() || email.isEmpty() || phone.isEmpty() ||
                        address.isEmpty() || education == null || course.isEmpty() ||
                        university.isEmpty() || experience.isEmpty() ||
                        project1.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please fill in all compulsory fields marked with *.", 
                                                      "Validation Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Create a new JFrame to display the resume
                    JFrame resumeFrame = new JFrame("Your Resume");
                    resumeFrame.setSize(350, 600); // Adjusted resume size
                    resumeFrame.setLocationRelativeTo(null); // Center on screen

                    // Create a panel with GridBagLayout for proper alignment
                    JPanel resumePanel = new JPanel();
                    resumePanel.setLayout(new GridBagLayout());
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.insets = new Insets(5, 5, 5, 5); // Add space between components

                    // Add photo if available
                    if (photoDisplayLabel.getIcon() != null) {
                        gbc.gridx = 0;
                        gbc.gridy = 0;
                        gbc.gridwidth = 2; // Make photo span across columns
                        resumePanel.add(photoDisplayLabel, gbc); // Display photo on the resume if chosen
                    }

                    // Add Name, Email, Phone, Address
                    gbc.gridwidth = 1; // Reset to default (1 column wide)
                    gbc.gridx = 0;
                    gbc.gridy = 1;
                    resumePanel.add(new JLabel("Name:"), gbc);
                    gbc.gridx = 1;
                    resumePanel.add(new JLabel(name), gbc);

                    gbc.gridx = 0;
                    gbc.gridy = 2;
                    resumePanel.add(new JLabel("Email:"), gbc);
                    gbc.gridx = 1;
                    resumePanel.add(new JLabel(email), gbc);

                    gbc.gridx = 0;
                    gbc.gridy = 3;
                    resumePanel.add(new JLabel("Phone:"), gbc);
                    gbc.gridx = 1;
                    resumePanel.add(new JLabel(phone), gbc);

                    gbc.gridx = 0;
                    gbc.gridy = 4;
                    resumePanel.add(new JLabel("Address:"), gbc);
                    gbc.gridx = 1;
                    resumePanel.add(new JLabel(address), gbc);

                    // Add remaining details
                    gbc.gridx = 0;
                    gbc.gridy = 5;
                    resumePanel.add(new JLabel("Education Level:"), gbc);
                    gbc.gridx = 1;
                    resumePanel.add(new JLabel(education), gbc);

                    gbc.gridx = 0;
                    gbc.gridy = 6;
                    resumePanel.add(new JLabel("Course:"), gbc);
                    gbc.gridx = 1;
                    resumePanel.add(new JLabel(course), gbc);

                    gbc.gridx = 0;
                    gbc.gridy = 7;
                    resumePanel.add(new JLabel("University:"), gbc);
                    gbc.gridx = 1;
                    resumePanel.add(new JLabel(university), gbc);

                    gbc.gridx = 0;
                    gbc.gridy = 8;
                    resumePanel.add(new JLabel("Experience:"), gbc);
                    gbc.gridx = 1;
                    resumePanel.add(new JLabel(experience), gbc);

                    gbc.gridx = 0;
                    gbc.gridy = 9;
                    resumePanel.add(new JLabel("Academic Project 1:"), gbc);
                    gbc.gridx = 1;
                    resumePanel.add(new JLabel(project1), gbc);

                    gbc.gridx = 0;
                    gbc.gridy = 10;
                    resumePanel.add(new JLabel("Academic Project 2:"), gbc);
                    gbc.gridx = 1;
                    resumePanel.add(new JLabel(project2), gbc);

                    // Add the resumePanel to the frame
                    resumeFrame.add(new JScrollPane(resumePanel));

                    // Add Print button to resume page
                    JButton printButton = new JButton("Print Resume");
                    printButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            PrinterJob job = PrinterJob.getPrinterJob();
                            if (job.printDialog()) {
                                try {
                                    job.print();
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(resumeFrame, "Error while printing: " + ex.getMessage());
                                }
                            }
                        }
                    });
                    resumeFrame.add(printButton, BorderLayout.SOUTH);

                    resumeFrame.setVisible(true);
                }
            });

            // Action Listener for the clear button
            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nameField.setText("");
                    emailField.setText("");
                    phoneField.setText("");
                    addressField.setText("");
                    educationComboBox.setSelectedIndex(0);
                    courseField.setText("");
                    universityField.setText("");
                    experienceArea.setText("");
                    project1Area.setText("");
                    project2Area.setText("");
                    photoDisplayLabel.setIcon(null); // Clear photo display
                }
            });

            frame.setVisible(true);
        });
    }
}
