import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class forgetPassword extends JFrame implements ActionListener {

    private final JButton  changePass = new JButton("Change Password");
    private final JTextField email = new JTextField();
    private final JTextField username = new JTextField();
    private final JPasswordField password = new JPasswordField();

    public forgetPassword() {
        initializeFrame();
    }

    private void initializeFrame() {

        //!<<<<<<<<<<<<<<<<<<<<<<<< Frame settings >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        ImageIcon appIcon = new ImageIcon("HealthCareCenter/src/main/resources/icons/appIcon.png"); //*Image.. 1 ............

        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,500);
        this.setTitle("Forget Password - Health Care Center");
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x123456));

        //!<<<<<<<<<<<<<<<<<<<<<<<< Background >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        JPanel background = new JPanel();
        background.setBounds(0, 0, 900, 500);
        background.setLayout(null);
        background.setOpaque(false);

        //!<<<<<<<<<<<<<<<<<<<<<<<< Left Panel >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        background.add(createLeftPanel());

        //!<<<<<<<<<<<<<<<<<<<<<<<< Right Panel >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        background.add(createRightPanel());

        this.add(background);
        this.setVisible(true);
    }

//!<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Creating Left Panel >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    private JPanel createLeftPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(true);
        panel.setBounds(0, 0, 350, 500);
        panel.setBackground(new Color(0x123456));

        ImagePanel imagePanel = new ImagePanel("HealthCareCenter/src/main/resources/images/forgetPassword.jpg");
        imagePanel.setBounds(0, 0, 350, 500);
        imagePanel.setOpaque(false);
        imagePanel.setLayout(null);

        ImageIcon backToLogin = ImageCompressor.compressImage("HealthCareCenter/src/main/resources/icons/close.png", 40, 40);
        JLabel back = new JLabel(backToLogin);
        back.setBounds(20, 20, 40, 40);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new loginFrame();
            }
        });

        imagePanel.add(back);
        panel.add(imagePanel);

        return panel;
    }

//!<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Creating Right Panel >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    private JPanel createRightPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(true);
        panel.setBounds(350, 0, 550, 500);
        panel.setBackground(new Color(0, 100, 0, 80));

        //!Email Panel-----------------------------------------
        JPanel emailPanel = new JPanel();
        emailPanel.setBounds(150, 200, 250, 30);
        emailPanel.setBackground(new Color(0x156456));
        emailPanel.setLayout(null);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 0, 70, 30);
        emailLabel.setForeground(new Color(0xFFFFFF));

        email.setBounds(80, 0, 170, 30);
        email.setForeground(new Color(0x000000));
        email.setFont(new Font("Arial", Font.PLAIN, 15));

        emailPanel.add(emailLabel);
        emailPanel.add(email);
        //!---------------------------------------------------------
        
        JPanel usernamePanel = new JPanel();



        panel.add(emailPanel);
        return panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    public static void main(String[] args) {
        new forgetPassword();
    }
}