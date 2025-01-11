import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class termsAndConditionsFrame extends JFrame implements ActionListener {
    private final JButton submit = new JButton("Submit");
    public termsAndConditionsFrame() {
        initializeUI();
    }

    private void initializeUI() {
        //!<<<<<<<<<<<<<<<<<<<<<<<< Frame settings >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        ImageIcon appIcon = new ImageIcon("HealthCareCenter/src/main/resources/icons/appIcon.png");//*Image.. 1 ............
        
        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,500);
        this.setTitle("Terms and Conditions Health Care Center");
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x123456));
        this.add(termsAndConditionsLabel());
        this.setVisible(true);
    }
    public JLabel termsAndConditionsLabel() {
        JLabel termsAndConditionsLabel = new JLabel("Terms and Conditions");
        termsAndConditionsLabel.setHorizontalAlignment(JLabel.CENTER);
        termsAndConditionsLabel.setForeground(new Color(0x00FF00));
        termsAndConditionsLabel.setFont(new Font("serif", Font.BOLD, 20));
        termsAndConditionsLabel.setBounds(50, 50, 400, 50);
        return termsAndConditionsLabel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            this.dispose();
        }
    }
}