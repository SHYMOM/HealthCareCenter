package com.healthcarecenter.frames;

import com.healthcarecenter.utils.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener {

    private final JButton login = new JButton();
    private final JButton signUp = new JButton();
    private final JTextField email = new JTextField();
    private final JPasswordField password = new JPasswordField();
    private String userRole;

    public LoginPage(String userRole) {
        this.userRole = userRole;
        initializeFrame();
    }

    private void initializeFrame() {

        //!<<<<<<<<<<<<<<<<<<<<<<<< Frame settings >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        ImageIcon appIcon = new ImageIcon("HealthCareCenter/src/main/resources/icons/appIcon.png"); //*Image.. 1 ............

        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,500);
        this.setTitle("Login Health Care Center");
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x123456));

        //!<<<<<<<<<<<<<<<<<<<<<<<< Background >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        ImagePanel background = new ImagePanel("HealthCareCenter/src/main/resources/images/signInBG.jpg");//*Image.. 2 ............
        background.setBounds(0, 0, 900, 500);
        background.setLayout(null);
        background.setOpaque(false);

        //!<<<<<<<<<<<<<<<<<<<<<<<< Left Panel >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        JPanel leftPanel = createLeftPanel();
        background.add(leftPanel);

        //!<<<<<<<<<<<<<<<<<<<<<<<< Right Panel >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        JPanel rightPanel = createRightPanel();
        background.add(rightPanel);

        this.add(background);
        this.setVisible(true);
    }

//!<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Creating Left Panel >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    private JPanel createLeftPanel() {

        //!Panel Settings
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setOpaque(true);
        leftPanel.setBounds(0, 0, 350, 500);
        leftPanel.setBackground(new Color(0, 33, 0, 150));

        if (userRole.equals("User")) {
            //!Left Inside Panel
            JPanel leftInsidePanel = new JPanel();
            leftInsidePanel.setBounds(50, 80, 250, 300);
            leftInsidePanel.setLayout(null);
            Color transparentColor = new Color(0, 33, 0, 80);
            leftInsidePanel.setBackground(transparentColor);
            leftInsidePanel.setBorder(BorderFactory.createLineBorder(new Color(0x00FF00), 1));
            leftInsidePanel.setOpaque(true);

            //!Welcome Title-----------------------------------------
            JLabel welTitle1 = new JLabel();
            welTitle1.setText("Have");
            welTitle1.setForeground(new Color(0x00FF00));
            welTitle1.setFont(new Font("MV Boli", Font.BOLD, 20));
            welTitle1.setBounds(15, 10, 250, 50);
            JLabel welTitle2 = new JLabel();
            welTitle2.setText("An Account ?");
            welTitle2.setForeground(new Color(0x00FF00));
            welTitle2.setFont(new Font("MV Boli", Font.BOLD, 20));
            welTitle2.setBounds(45, 50, 250, 50);
            //?Panel
            JPanel welTitlePanel = new JPanel();
            welTitlePanel.setBounds(0, 0, 250, 150);
            welTitlePanel.setLayout(null);
            welTitlePanel.add(welTitle1);
            welTitlePanel.add(welTitle2);
            welTitlePanel.setOpaque(false);
            //?Message1
            JLabel message1 = new JLabel();
            message1.setText("Create One Instead.");
            message1.setForeground(new Color(0x00FF00));
            message1.setFont(new Font("SansSerif", Font.PLAIN, 15));
            message1.setBounds(10, 0, 250, 20);
            //?Message2
            JLabel message2 = new JLabel();
            message2.setText("Click Sign Up Below.");
            message2.setForeground(new Color(0x00FF00));
            message2.setFont(new Font("SansSerif", Font.PLAIN, 15));
            message2.setBounds(60, 20, 250, 20);
            //?Message3
            JLabel message3 = new JLabel();
            message3.setText("It's Free.");
            message3.setForeground(new Color(0x00FF00));
            message3.setFont(new Font("SansSerif", Font.PLAIN, 15));
            message3.setBounds(140, 40, 250, 20);

            //!Message Panel
            JPanel messagePanel = new JPanel();
            messagePanel.setBounds(0, 130, 250, 70);
            messagePanel.setLayout(null);
            messagePanel.setOpaque(false);
            messagePanel.add(message1);
            messagePanel.add(message2);
            messagePanel.add(message3);
            //!----------------------------------------------------

            //!Sign Up Button
            signUp.setText("Sign Up");
            signUp.setForeground(new Color(18, 28, 38));
            signUp.setFont(new Font("SansSerif", Font.PLAIN, 15));
            signUp.setBounds(75, 230, 100, 30);
            signUp.setFocusable(false);
            signUp.addActionListener(this);

            //!Adding Components To Left Inside/Left Panel-------------------------
            leftInsidePanel.add(welTitlePanel);
            leftInsidePanel.add(messagePanel);
            leftInsidePanel.add(signUp);
            leftPanel.add(leftInsidePanel);
        }

        return leftPanel;
    }

//!<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Creating Right Panel >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    private JPanel createRightPanel() {

        //!Panel Settings
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setOpaque(true);
        rightPanel.setBounds(350, 0, 550, 500);
        rightPanel.setBackground(new Color(0, 100, 0, 80));

        //!Title Settings
        JLabel title = new JLabel();
        title.setText("Login");
        title.setForeground(new Color(0x00FF00));
        title.setFont(new Font("MV Boli", Font.BOLD, 20));
        title.setBounds(50, 50, 550, 50);

        //!Sign In Text
        JLabel loginText = new JLabel();
        loginText.setText("Welcome Back User");
        loginText.setForeground(new Color(0x00FF00));
        loginText.setFont(new Font("MV Boli", Font.BOLD, 15));
        loginText.setBounds(70, 100, 550, 50);
        //?Message2
        JLabel loginText2 = new JLabel();
        loginText2.setText("Please Fill The Credentials");
        loginText2.setForeground(new Color(0x00FF00));
        loginText2.setFont(new Font("Arial", Font.PLAIN, 15));
        loginText2.setBounds(150, 130, 550, 50);

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

        //!Password Panel-----------------------------------------
        JPanel passwordPanel = new JPanel();
        passwordPanel.setBounds(150, 250, 250, 30);
        passwordPanel.setBackground(new Color(0x156456));
        passwordPanel.setLayout(null);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 0, 70, 30);
        passwordLabel.setForeground(new Color(0xFFFFFF));

        password.setBounds(80, 0, 170, 30);
        password.setForeground(new Color(0x000000));
        password.setFont(new Font("Arial", Font.PLAIN, 15));
        
        passwordPanel.add(passwordLabel);
        passwordPanel.add(password);
        //!---------------------------------------------------------

        //!Forgot Password text-------------------------------------
        JLabel forgotPassword = new JLabel();
        forgotPassword.setText("Forgot Password?");
        forgotPassword.setForeground(new Color(0x00FF00));
        forgotPassword.setFont(new Font("SansSerif", Font.BOLD, 15));
        forgotPassword.setBounds(150, 300, 250, 30);
        forgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgotPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new ForgetPasswordPage();
            }
        });

        //!---------------------------------------------------------

        //!Login Button
        login.setText("Login");
        login.setForeground(new Color(0x00FF00));
        login.setFont(new Font("MV Boli", Font.BOLD, 20));
        login.setBounds(225, 330, 100, 30);
        login.setFocusable(false);
        login.addActionListener(this);

        //!Adding Components To The Right Panel---------------------
        rightPanel.add(title);
        rightPanel.add(loginText);
        rightPanel.add(loginText2);
        rightPanel.add(emailPanel);
        rightPanel.add(passwordPanel);
        rightPanel.add(forgotPassword);
        rightPanel.add(login);

        return rightPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            All_Validations checkValidations = new All_Validations();
            if(this.email.getText().isEmpty() || this.password.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Please Fill The Credentials");
            }
            else if(!checkValidations.isValidEmail(email.getText())){
                JOptionPane.showMessageDialog(null, "Invalid email format", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(!checkValidations.isValidPassword(password.getText())){
                JOptionPane.showMessageDialog(null, "Password must be at least 6 characters long", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                if(email.getText().equals("super.admin@healthcarecenter.com")&& password.getText().equals("@super.admin")){
                    new superadminHomePage();
                    this.dispose();
                }
                else{
                    if(userRole.equals("User")){
                        if(!checkValidations.isEmailRegistered(email.getText(),"/data/users/")){
                            JOptionPane.showMessageDialog(null, "Email Not Registered", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            if(checkValidations.isUserRegistered(email.getText(), password.getText(), "/data/users/")){
                                this.dispose();
                                new UserHomePage(email.getText(), false);
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    else if(userRole.equals("Admin")){
                        if(!checkValidations.isEmailRegistered(email.getText(),"" )){
                            JOptionPane.showMessageDialog(null, "Email Not Registered", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            if(checkValidations.isUserRegistered(email.getText(), password.getText(), "")){
                                this.dispose();
                                new AdminHomePage();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    else if(userRole.equals("Doctor")){
                        if(!checkValidations.isEmailRegistered(email.getText(),"" )){
                            JOptionPane.showMessageDialog(null, "Email Not Registered", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            if(checkValidations.isUserRegistered(email.getText(), password.getText(), "")){
                                this.dispose();
                                new DoctorHomePage();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            }
    }
        else if(e.getSource() == signUp){
            new UserSignUp();
            this.dispose();
        }
    }
    public static void main(String[] args) {
        new LoginPage("User");
    }
}