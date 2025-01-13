import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class termsAndConditionsFrame extends JFrame implements ActionListener {
    private final JButton agreeButton = new JButton("Agree and Continue");
    private final JButton disagreeButton = new JButton("Disagree and Exit");

    public termsAndConditionsFrame() {
        initializeUI();
    }

    private void initializeUI() {
        //!<<<<<<<<<<<<<<<<<<<<<<<< Frame settings >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        ImageIcon appIcon = new ImageIcon("/HealthCareCenter/src/main/resources/icons/appIcon.png");
        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 500);
        this.setTitle("Terms and Conditions - Health Care Center");
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x123456));

        this.add(termsAndConditionsLabel());
        this.add(termsAndConditionsTextArea());
        this.add(agreeButton());
        this.add(disagreeButton());

        this.setVisible(true);
    }

    private JLabel termsAndConditionsLabel() {
        JLabel termsAndConditionsLabel = new JLabel("Terms and Conditions");
        termsAndConditionsLabel.setHorizontalAlignment(JLabel.CENTER);
        termsAndConditionsLabel.setForeground(new Color(0x00FF00));
        termsAndConditionsLabel.setFont(new Font("Serif", Font.BOLD, 20));
        termsAndConditionsLabel.setBounds(250, 10, 400, 50);
        return termsAndConditionsLabel;
    }

    private JScrollPane termsAndConditionsTextArea() {
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
        termsTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        termsTextArea.setEditable(false);
        termsTextArea.setLineWrap(true);
        termsTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(termsTextArea);
        scrollPane.setBounds(50, 70, 800, 300);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return scrollPane;
    }

    private JButton agreeButton() {
        agreeButton.setBounds(650, 400, 200, 40);
        agreeButton.setFont(new Font("Arial", Font.BOLD, 16));
        agreeButton.setBackground(new Color(0x00FF00));
        agreeButton.setForeground(Color.BLACK);
        agreeButton.addActionListener(this);
        return agreeButton;
    }
    
    private JButton disagreeButton() {
        disagreeButton.setBounds(50, 400, 200, 40);
        disagreeButton.setFont(new Font("Arial", Font.BOLD, 16));
        disagreeButton.setBackground(new Color(0xFF0000));
        disagreeButton.setForeground(Color.BLACK);
        disagreeButton.addActionListener(this);
        return disagreeButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agreeButton) {
            ImageIcon checkIcon = ImageCompressor.compressImage("HealthCareCenter/src/main/resources/icons/check.png",25,25);
            JOptionPane.showMessageDialog(null, "Thank you for accepting the Terms and Conditions.You can now start using the application.", "Acceptance Message", JOptionPane.INFORMATION_MESSAGE, checkIcon);
            this.dispose();
        }
        if (e.getSource() == disagreeButton) {
            System.exit(0);
        }
    }
}