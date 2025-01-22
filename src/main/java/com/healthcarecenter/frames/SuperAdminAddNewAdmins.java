package com.healthcarecenter.frames;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SuperAdminAddNewAdmins extends JFrame implements ActionListener 
{

    private final  JPanel fullNamePanel = new JPanel();
    private final  JPanel usernamePanel = new JPanel();
    private final  JPanel agePanel = new JPanel();
    private final  JPanel genderPanel = new JPanel();
    private final  JPanel numberPanel = new JPanel();
    private final  JPanel bloodPanel = new JPanel();
    private final  JPanel emailPanel = new JPanel();
    private final  JPanel passPanel = new JPanel();
    private final  JPanel addressPanel = new JPanel();
    private final   JCheckBox termsAndConditionsCheckBox = new JCheckBox("I agree to the ");

    private final  JButton signUp= new JButton();

    public SuperAdminAddNewAdmins()
    {
        adminUI();
    }

    private void adminUI()
    {
        JPanel panel = new JPanel();                                  
        panel.setBounds(0,0,900,600);
        panel.setBackground(Color.red);
        panel.setLayout(null);

        panel.add(createLeftpanel());
        panel.add(createRightpanel());

        ImageIcon appIcon = new ImageIcon("HealthCareCenter/src/main/resources/Icons/appIcon.png");//*Image.. 2 ............
        
        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setTitle("Sign Up Health Care Center");
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setVisible(true);

        this.add(panel);
    }

    public JPanel createLeftpanel()
    {
        JPanel left_panel = new JPanel();
        left_panel.setLayout(null);
        left_panel.setBounds(0,0,300,600);
        left_panel.setBackground(new Color(0,0,33,150));

        return left_panel;

    }
    public JPanel createRightpanel()
    {
        JPanel right_panel = new JPanel();
        right_panel.setLayout(null);
        right_panel.setOpaque(false);
        right_panel.setBounds(300,0,630,600);
        right_panel.setBackground(new Color(0,0,33,100));

        JLabel label = new JLabel("Registration For A New Doctor");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(100,10,400,50);
        label.setForeground(new Color(0x00FF00));
        label.setFont(new Font("MV Boli", Font.BOLD, 20));
        label.setLayout(null);
        

        JLabel labelform = new JLabel("Fill The Form Below");
        labelform.setHorizontalAlignment(JLabel.CENTER);
        labelform.setBounds(150,60,300,50);
        labelform.setForeground(new Color(0x00FF00));
        labelform.setFont(new Font("MV Boli", Font.BOLD, 20));
        labelform.setLayout(null);


         //!Full Name Panel-----------------------------------------
       
         fullNamePanel.setBounds(150, 140, 300, 30);
         fullNamePanel.setBackground(new Color(0x1A75FF));
         fullNamePanel.setLayout(null);
     
         JLabel nameLabel = new JLabel("Full Name");
         nameLabel.setBounds(10, 0, 70, 30);
         nameLabel.setForeground(new Color(0xFFFFFF));
     
         JTextField name = new JTextField();
         name.setBounds(80, 0, 220, 30);
         name.setForeground(new Color(0x000000));
         name.setFont(new Font("Arial", Font.PLAIN, 15));

         fullNamePanel.add(nameLabel);
         fullNamePanel.add(name);
        

         //!Username Panel-------------------------------------------
       
        usernamePanel.setBounds(150, 180, 300, 30);
        usernamePanel.setBackground(new Color(0x1A75FF));
        usernamePanel.setLayout(null);
    
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 0, 70, 30);
        usernameLabel.setForeground(new Color(0xFFFFFF));
    
        JTextField username = new JTextField();
        username.setBounds(80, 0, 220, 30);
        username.setForeground(new Color(0x000000));
        username.setFont(new Font("Arial", Font.PLAIN, 15));
    
        usernamePanel.add(usernameLabel);
        usernamePanel.add(username);


        //!Age Panel-------------------------------------------
       
        agePanel.setBounds(50, 220, 250, 30);
        agePanel.setBackground(new Color(0x1A75FF));
        agePanel.setLayout(null);
    
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(10, 0, 70, 30);
        ageLabel.setForeground(new Color(0xFFFFFF));
    
        JTextField age = new JTextField();
        age.setBounds(80, 0, 170, 30);
        age.setForeground(new Color(0x000000));
        age.setFont(new Font("Arial", Font.PLAIN, 15));
    
        agePanel.add(ageLabel);
        agePanel.add(age);
    
        //!Gender Panel-------------------------------------------
        
        genderPanel.setBounds(350, 220, 180, 30);
        genderPanel.setBackground(new Color(0x1A75FF));
        genderPanel.setLayout(null);
    
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(10, 0, 70, 30);
        genderLabel.setForeground(new Color(0xFFFFFF));
    
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{" Male", " Female", " Others"});
        genderComboBox.setBounds(80, 0, 100, 30);
        genderComboBox.setForeground(new Color(0x000000));
        genderComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
    
        genderPanel.add(genderLabel);
        genderPanel.add(genderComboBox);

        //!Number Panel-------------------------------------------
        
        numberPanel.setBounds(50, 260, 250, 30);
        numberPanel.setBackground(new Color(0x1A75FF));
        numberPanel.setLayout(null);
    
        JLabel numberLabel = new JLabel("Phone ");
        numberLabel.setBounds(10, 0, 70, 30);
        numberLabel.setForeground(new Color(0xFFFFFF));
    
        JTextField number = new JTextField();
        number.setBounds(80, 0, 170, 30);
        number.setForeground(new Color(0x000000));
        number.setFont(new Font("Arial", Font.PLAIN, 15));
    
        numberPanel.add(numberLabel);
        numberPanel.add(number);

        //!Blood Group Panel Panel-------------------------------------------
       
        bloodPanel.setBounds(350, 260, 180, 30);
        bloodPanel.setBackground(new Color(0x1A75FF));
        bloodPanel.setLayout(null);
    
        JLabel bloodLabel = new JLabel("Blood Group");
        bloodLabel.setBounds(10, 0, 100, 30);
        bloodLabel.setForeground(new Color(0xFFFFFF));


        String[] bloodGroupOptions = {"  A+", "  A-", "  B+", "  B-", " AB+", " AB-", "  O+", "  O-"};
        JComboBox<String> bloodComboBox = new JComboBox<>(bloodGroupOptions);
        bloodComboBox.setBounds(110, 0, 70, 30);
        bloodComboBox.setForeground(new Color(0x000000));
        bloodComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
    
        bloodPanel.add(bloodLabel);
        bloodPanel.add(bloodComboBox);


         //!Email Panel-------------------------------------------
         emailPanel.setBounds(150, 300, 300, 30);
         emailPanel.setBackground(new Color(0x1A75FF));
         emailPanel.setLayout(null);
     
         JLabel emailLabel = new JLabel("E-mail");
         emailLabel.setBounds(10, 0, 70, 30);
         emailLabel.setForeground(new Color(0xFFFFFF));
     
         JTextField email = new JTextField();
         email.setBounds(80, 0, 220, 30);
         email.setForeground(new Color(0x000000));
         email.setFont(new Font("Arial", Font.PLAIN, 15));
     
         emailPanel.add(emailLabel);
         emailPanel.add(email);
     
         //!Password Panel-------------------------------------------
         
         passPanel.setBounds(150, 340, 300, 30); // Place this panel far down to force scrolling
         passPanel.setBackground(new Color(0x1A75FF));
         passPanel.setLayout(null);
     
         JLabel passLabel = new JLabel("Password");
         passLabel.setBounds(10, 0, 70, 30);
         passLabel.setForeground(new Color(0xFFFFFF));
     
         JTextField pass = new JTextField();
         pass.setBounds(80, 0, 220, 30);
         pass.setForeground(new Color(0x000000));
         pass.setFont(new Font("Arial", Font.PLAIN, 15));
     
         passPanel.add(passLabel);
         passPanel.add(pass);
 
         //!Address Panel-------------------------------------------
        
         addressPanel.setBounds(100, 380, 400, 30); // Place this panel far down to force scrolling
         addressPanel.setBackground(new Color(0x1A75FF));
         addressPanel.setLayout(null);
     
         JLabel addressLabel = new JLabel("Address");
         addressLabel.setBounds(10, 0, 70, 30);
         addressLabel.setForeground(new Color(0xFFFFFF));
     
         JTextField address = new JTextField();
         address.setBounds(80, 0, 320, 30);
         address.setForeground(new Color(0x000000));
         address.setFont(new Font("Arial", Font.PLAIN, 15));
     
         addressPanel.add(addressLabel);
         addressPanel.add(address);


         //!Terms And Conditions Checkbox-----------------------------------------

        
        termsAndConditionsCheckBox.setBounds(100, 420, 150, 30);
        termsAndConditionsCheckBox.setForeground(new Color(200, 117, 100));
        termsAndConditionsCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        termsAndConditionsCheckBox.setFocusable(false);
        termsAndConditionsCheckBox.setOpaque(false);
        termsAndConditionsCheckBox.addActionListener(this);

        JLabel termsAndConditionsLabel = new JLabel("terms and conditions");
        termsAndConditionsLabel.setForeground(new Color(200, 120, 150));
        termsAndConditionsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        termsAndConditionsLabel.setBounds(250, 420, 400, 30);

        termsAndConditionsLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                termsAndConditionsLabel.setForeground(new Color(0x00FF00));
                termsAndConditionsLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                termsAndConditionsLabel.setForeground(new Color(200, 120, 150));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                new TermsAndConditionsFrame();
            }
        });

          //!Button---------------------------------------------------
       
        signUp.setText("Register");
        signUp.setForeground(new Color(25, 117, 255));
        signUp.setFont(new Font("MV Boli", Font.BOLD, 20));
        signUp.setBounds(250, 460, 100, 30);
        signUp.setFocusable(false);
        signUp.addActionListener(this);
        signUp.setBackground(new Color(0x182838));
        signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signUp.setBorder(BorderFactory.createLineBorder(new Color(25, 117, 255), 2, true));
        signUp.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                signUp.setBorder(BorderFactory.createLineBorder(new Color(0x00FF00), 2, true));
                signUp.setBounds(248, 462, 105, 30);
                signUp.setForeground(new Color(0x00FF00));
                signUp.setBackground(new Color(0x182838));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                signUp.setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 2, true));
                signUp.setBounds(250, 460, 100, 30);
                signUp.setForeground(new Color(25, 117, 255));
                signUp.setBackground(new Color(0x182838));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
              SwingUtilities.getWindowAncestor(signUp).dispose();
              new LoginPage("Admin");
            }
        });
    
        
         right_panel.add(label);
         right_panel.add(label);
         right_panel.add(labelform);
         right_panel.add(fullNamePanel);
         right_panel.add(usernamePanel);
         right_panel.add(agePanel);
         right_panel.add(genderPanel);
         right_panel.add(numberPanel);
         right_panel.add(bloodPanel);
         right_panel.add(emailPanel);
         right_panel.add(passPanel);
         right_panel.add(addressPanel);
         right_panel.add(signUp);
         right_panel.add(termsAndConditionsCheckBox);
         right_panel.add(termsAndConditionsLabel);
    


        
        return right_panel;

    }





    @Override
    public void actionPerformed(ActionEvent e)
    {
        // code to handle the action event
    }

    public static void main(String[] args) 
    {
        new SuperAdminAddNewAdmins();
    }
    
}
