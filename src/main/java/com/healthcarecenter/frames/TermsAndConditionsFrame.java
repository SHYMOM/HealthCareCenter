package com.healthcarecenter.frames;
import com.healthcarecenter.utils.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class TermsAndConditionsFrame extends JFrame implements ActionListener {
    private final JButton agreeButton = new JButton("I Agree and Continue");
    private final JButton disagreeButton = new JButton("I Disagree and Exit");
    private final Color primaryColor = new Color(0x2C3E50);
    private final Color accentColor = new Color(0x3498DB);
    private final Color textColor = new Color(0xECF0F1);
    private final Color successColor = new Color(0x2ECC71);
    private final Color dangerColor = new Color(0xE74C3C);
    private JCheckBox acknowledgeCheckbox;

    public TermsAndConditionsFrame() {
        initializeUI();
    }

    private void initializeUI() {
        ImageIcon appIcon = new ImageIcon(FileUtils.getFile("/Icons/appIcon.png").getAbsolutePath());
        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setTitle("Terms and Conditions - Health Care Center");
        this.setResizable(true);
        this.setMinimumSize(new Dimension(800, 500));
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBackground(primaryColor);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.setContentPane(mainPanel);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(primaryColor);
        headerPanel.add(createHeaderLabel(), BorderLayout.CENTER);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        mainPanel.add(createTermsPanel(), BorderLayout.CENTER);
        mainPanel.add(createButtonPanel(), BorderLayout.SOUTH);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private JLabel createHeaderLabel() {
        JLabel headerLabel = new JLabel("Terms and Conditions");
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerLabel.setForeground(textColor);
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        return headerLabel;
    }

    private JPanel createTermsPanel() {
        JPanel termsPanel = new JPanel(new BorderLayout());
        termsPanel.setBackground(primaryColor);
        
        String termsText = """
            By signing up and using this application, you agree to the following terms and conditions:
            
            1. Account Creation:
                - You must provide accurate and complete information during the sign-up process.
                - You are responsible for maintaining the confidentiality of your login credentials.

            2. Privacy Policy:
                - Your personal information, including medical records, is stored securely and will not be shared without your consent.

            3. Medical Information:
                - This application is not a substitute for professional medical advice or treatment.

            4. Appointments and Health Records:
                - Users are responsible for ensuring the accuracy of the information provided.

            5. Blood Bank:
                - By registering as a donor, you consent to your details being stored for operational purposes.

            6. User Conduct:
                - Misuse of the application or features is strictly prohibited.

            7. Data Security:
                - While we implement measures to protect your data, we cannot guarantee absolute security.

            8. Disclaimer:
                - The application is provided "as is" without any warranties.

            9. Termination of Account:
                - Your account may be terminated for violating these terms.

            10. Changes to Terms:
                - These terms may be updated periodically. Continued use constitutes acceptance.
            """;

        JTextArea termsTextArea = new JTextArea(termsText);
        termsTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        termsTextArea.setForeground(new Color(0x2C3E50));
        termsTextArea.setBackground(new Color(0xFFFFFF));
        termsTextArea.setEditable(false);
        termsTextArea.setLineWrap(true);
        termsTextArea.setWrapStyleWord(true);
        termsTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(termsTextArea);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
            new EmptyBorder(0, 0, 0, 0),
            BorderFactory.createLineBorder(accentColor)
        ));
        
        termsPanel.add(scrollPane, BorderLayout.CENTER);
        return termsPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(primaryColor);

        acknowledgeCheckbox = new JCheckBox("I have read and understand the terms and conditions");
        acknowledgeCheckbox.setForeground(textColor);
        acknowledgeCheckbox.setBackground(primaryColor);
        acknowledgeCheckbox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        acknowledgeCheckbox.addActionListener(e -> updateButtonStates());

        styleButton(agreeButton, successColor);
        styleButton(disagreeButton, dangerColor);
        agreeButton.setEnabled(false);

        agreeButton.addActionListener(this);
        disagreeButton.addActionListener(this);

        JPanel checkboxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        checkboxPanel.setBackground(primaryColor);
        checkboxPanel.add(acknowledgeCheckbox);

        buttonPanel.add(disagreeButton);
        buttonPanel.add(agreeButton);

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBackground(primaryColor);
        southPanel.add(checkboxPanel, BorderLayout.NORTH);
        southPanel.add(buttonPanel, BorderLayout.CENTER);

        return southPanel;
    }

    private void styleButton(JButton button, Color backgroundColor) {
        button.setPreferredSize(new Dimension(200, 40));
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //! Hover effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(backgroundColor.darker());
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(backgroundColor);
            }
        });
    }

    private void updateButtonStates() {
        agreeButton.setEnabled(acknowledgeCheckbox.isSelected());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agreeButton) {
            ImageIcon checkIcon = ImageCompressor.compressImage("HealthCareCenter/src/main/resources/icons/check.png", 25, 25);
            JOptionPane.showMessageDialog(
                this,
                "Thank you for accepting the Terms and Conditions.\nYou can now start using the application.",
                "Welcome!",
                JOptionPane.INFORMATION_MESSAGE,
                checkIcon
            );
            this.dispose();
        }
        if (e.getSource() == disagreeButton) {
            int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit? You won't be able to use the application without accepting the terms.",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new TermsAndConditionsFrame().setVisible(true);
    }
}