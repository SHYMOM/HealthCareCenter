package com.healthcarecenter.frames;
import com.healthcarecenter.utils.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ForgetPasswordPage extends JFrame implements ActionListener {

    private final JButton changePass = new JButton("Change Password");
    private final JTextField username = new JTextField();
    private final JPasswordField password = new JPasswordField();

    private String userRole;

    public ForgetPasswordPage(String userRole) {
        this.userRole = userRole;
        initializeFrame();
    }

    private void initializeFrame() {
        //!<<<<<<<<<<<<<<<<<<<<<<<< Frame settings >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        ImageIcon appIcon = new ImageIcon(FileUtils.getFile("/Icons/appIcon.png").getAbsolutePath());

        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 500);
        this.setTitle("Health Care Center - Forget Password");
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(248, 249, 250));
        this.setLocationRelativeTo(null);

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
        panel.setBackground(new Color(69, 123, 157));

        ImagePanel imagePanel = new ImagePanel(FileUtils.getFile("/Images/signInBG.jpg").getAbsolutePath());
        imagePanel.setBounds(0, 0, 350, 500);
        imagePanel.setOpaque(false);
        imagePanel.setLayout(null);

        ImageIcon backToLogin = ImageCompressor.compressImage(FileUtils.getFile("/Icons/back.png").getAbsolutePath(), 25, 25);
        JLabel back = new JLabel(backToLogin);
        back.setBounds(20, 20, 25, 25);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new LoginPage("User");
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
        panel.setBackground(new Color(0x182838));

        // Title
        JLabel titleLabel = new JLabel("Forget Password");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(69, 123, 157)); // Matching left panel blue
        titleLabel.setBounds(150, 100, 300, 40);
        panel.add(titleLabel);

        // Subtitle
        JLabel subtitleLabel = new JLabel("Enter your username to reset your password");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setForeground(new Color(108, 117, 125)); // Soft gray
        subtitleLabel.setBounds(150, 140, 350, 30);
        panel.add(subtitleLabel);

        //!Username Panel-----------------------------------------
        JPanel usernamePanel = new JPanel();
        usernamePanel.setBounds(150, 200, 250, 50);
        usernamePanel.setBackground(new Color(240, 242, 245)); // Soft background
        usernamePanel.setLayout(new BorderLayout());
        usernamePanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(173, 181, 189), 1), // Soft border
            new EmptyBorder(0, 10, 0, 10)
        ));

        JLabel usernameIcon = new JLabel(new ImageIcon(FileUtils.getFile("/Icons/user.png").getAbsolutePath()));
        usernameIcon.setBorder(new EmptyBorder(0, 0, 0, 10));

        username.setFont(new Font("Arial", Font.PLAIN, 16));
        username.setBorder(null);
        username.setBackground(new Color(240, 242, 245));
        username.setForeground(new Color(33, 37, 41)); // Dark text

        usernamePanel.add(usernameIcon, BorderLayout.WEST);
        usernamePanel.add(username, BorderLayout.CENTER);
        panel.add(usernamePanel);

        // Change Password Button
        changePass.setBounds(150, 280, 250, 45);
        changePass.setFont(new Font("Arial", Font.BOLD, 16));
        changePass.setBackground(new Color(69, 123, 157)); // Matching blue
        changePass.setForeground(Color.WHITE);
        changePass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        changePass.setBorderPainted(false);
        changePass.setFocusPainted(false);
        
        // Hover effect
        changePass.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                changePass.setBackground(new Color(94, 148, 187)); // Lighter blue on hover
            }
            public void mouseExited(MouseEvent evt) {
                changePass.setBackground(new Color(69, 123, 157)); // Original blue
            }
        });
        
        changePass.addActionListener(this);
        panel.add(changePass);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changePass) {
            String usernameText = username.getText();
            if (usernameText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a username.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (userRole.equals("User")) { 
                if (!FileUtils.doesFileExist("/data/users/"+usernameText+".txt")) {
                    JOptionPane.showMessageDialog(null, "Can,t Find Your Account", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    this.dispose();
                    new UserSignUp("Edit",usernameText);
                }    
            }
            else if (userRole.equals("Admin")) { 
                if (!FileUtils.doesFileExist("/data/admins/"+usernameText+".txt")) {
                    JOptionPane.showMessageDialog(null, "Can,t Find Your Account", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    this.dispose();
                    new Super_AdminAddNewAdmins(null,"Edit",usernameText, "Admin");
                }    
            }
            else if (userRole.equals("Doctor")) { 
                if (!FileUtils.doesFileExist("/data/doctors/"+usernameText+".txt")) {
                    JOptionPane.showMessageDialog(null, "Can,t Find Your Account", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    this.dispose();
                    new Super_AdminAddNewDoctor(null,"Edit",usernameText, "Doctor");
                }    
            }
        }

    }

    public static void main(String[] args) {
        new ForgetPasswordPage("User");
    }
}