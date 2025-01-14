import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class userSignUp extends JFrame implements ActionListener{

    private final ImagePanel background = new ImagePanel("HealthCareCenter/src/main/resources/Images/signUpBG1.jpg");//*Image.. 1 ............
    
    private final JButton signUp = new JButton();
    private final JButton signIn = new JButton();
    private final JTextField name = new JTextField();
    private final JTextField age = new JTextField();
    private final JTextField username = new JTextField();
    private final JTextField email = new JTextField();
    private final JTextField contactNumber = new JTextField();
    private final JTextField address = new JTextField();
    private final JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Others"});
    private final String[] bloodGroupOptions = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
    private final JComboBox<String> bloodGroupComboBox = new JComboBox<>(bloodGroupOptions);
    private final JPasswordField password = new JPasswordField();
    private final JCheckBox termsAndConditionsCheckBox = new JCheckBox("I agree to the ");
    //!File path
    private final File file = new  File("HealthCareCenter/src/main/Files/Database/User_Database/user_details.json");

    public userSignUp() {
            initializeUI();
    }

    private void initializeUI() {
        //!<<<<<<<<<<<<<<<<<<<<<<<< Frame settings >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        ImageIcon appIcon = new ImageIcon("HealthCareCenter/src/main/resources/Icons/appIcon.png");//*Image.. 2 ............
        
        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,500);
        this.setTitle("Sign Up Health Care Center");
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x123456));

        //!<<<<<<<<<<<<<<<<<<<<<<<< Background >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
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
        leftPanel.setBackground(new Color(0, 0, 33, 150));
        //!Left Inside Panel
        JPanel leftInsidePanel = new JPanel();
        leftInsidePanel.setBounds(50, 80, 250, 300);
        leftInsidePanel.setLayout(null);
        Color transparentColor = new Color(0, 0, 33, 80);
        leftInsidePanel.setBackground(transparentColor);
        leftInsidePanel.setBorder(BorderFactory.createLineBorder(Color.CYAN, 1));
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
        message1.setText("Login Instead.");
        message1.setForeground(new Color(0x00FF00));
        message1.setFont(new Font("SansSerif", Font.PLAIN, 15));
        message1.setBounds(10, 0, 250, 20);
        //?Message2
        JLabel message2 = new JLabel();
        message2.setText("Click Sign In Below.");
        message2.setForeground(new Color(0x00FF00));
        message2.setFont(new Font("SansSerif", Font.PLAIN, 15));
        message2.setBounds(60, 20, 250, 20);
        //?Message3
        JLabel message3 = new JLabel();
        message3.setText("Quick & Easy.");
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

        //!Sign In Button
        signIn.setText("Sign In");
        signIn.setForeground(new Color(18, 28, 38));
        signIn.setFont(new Font("SansSerif", Font.PLAIN, 15));
        signIn.setBounds(75, 230, 100, 30);
        signIn.setFocusable(false);
        signIn.addActionListener(this);
        //!Adding Components To Left Inside/Left Panel-------------------------
        leftInsidePanel.add(welTitlePanel);
        leftInsidePanel.add(messagePanel);
        leftInsidePanel.add(signIn);
        leftPanel.add(leftInsidePanel);

        return leftPanel;
    }

//!<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Creating Right Panel >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    private JPanel createRightPanel() {
        //!Panel Settings
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setOpaque(false);
        rightPanel.setBounds(350, 0, 550, 500);
        rightPanel.setBackground(new Color(0, 0, 33, 50));
        //!Title Settings
        JLabel title = new JLabel();
        title.setText("Sign Up");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("MV Boli", Font.BOLD, 20));
        title.setBounds(10, 10, 500, 25);
        //!Sign Up Text
        JLabel signUpText = new JLabel();
        signUpText.setText("Please Fill This Form.");
        signUpText.setForeground(new Color(255, 255, 255));
        signUpText.setFont(new Font("Arial", Font.PLAIN, 15));
        signUpText.setBounds(50, 40, 400, 20);

        //!Full Name Panel-----------------------------------------
        JPanel fullNamePanel = new JPanel();
        fullNamePanel.setBounds(10, 80, 250, 30);
        fullNamePanel.setBackground(new Color(0x1A75FF));
        fullNamePanel.setLayout(null);

        JLabel nameLabel = new JLabel("Full Name");
        nameLabel.setBounds(10, 0, 70, 30);
        nameLabel.setForeground(new Color(0xFFFFFF));

        name.setBounds(80, 0, 170, 30);
        name.setForeground(new Color(0x000000));
        name.setFont(new Font("Arial", Font.PLAIN, 15));

        fullNamePanel.add(nameLabel);
        fullNamePanel.add(name);
        //!---------------------------------------------------------

        //!Username Panel-------------------------------------------
        JPanel usernamePanel = new JPanel();
        usernamePanel.setBounds(280, 80, 250, 30);
        usernamePanel.setBackground(new Color(0x1A75FF));
        usernamePanel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 0, 70, 30);
        usernameLabel.setForeground(new Color(0xFFFFFF));

        username.setBounds(80, 0, 170, 30);
        username.setForeground(new Color(0x000000));
        username.setFont(new Font("Arial", Font.PLAIN, 15));

        usernamePanel.add(usernameLabel);
        usernamePanel.add(username);
        //!---------------------------------------------------------

        //!Age Panel------------------------------------------------
        JPanel agePanel = new JPanel();
        agePanel.setBounds(10, 130, 180, 30);
        agePanel.setBackground(new Color(0x1A75FF));
        agePanel.setLayout(null);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(35, 0, 70, 30);
        ageLabel.setForeground(new Color(0xFFFFFF));

        age.setBounds(80, 0, 100, 30);
        age.setForeground(new Color(0x000000));
        age.setFont(new Font("Arial", Font.PLAIN, 15));

        agePanel.add(ageLabel);
        agePanel.add(age);
        //!---------------------------------------------------------

        //!Email Panel----------------------------------------------
        JPanel emailPanel = new JPanel();
        emailPanel.setBounds(210, 130, 320, 30);
        emailPanel.setBackground(new Color(0x1A75FF));
        emailPanel.setLayout(null);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(20, 0, 70, 30);
        emailLabel.setForeground(new Color(0xFFFFFF));

        email.setBounds(80, 0, 240, 30);
        email.setForeground(new Color(0x000000));
        email.setFont(new Font("Arial", Font.PLAIN, 15));

        emailPanel.add(emailLabel);
        emailPanel.add(email);
        //!---------------------------------------------------------

        //!Contact Number Panel-------------------------------------
        JPanel contactNumberPanel = new JPanel();
        contactNumberPanel.setBounds(10, 180, 190, 30);
        contactNumberPanel.setBackground(new Color(0x1A75FF));
        contactNumberPanel.setLayout(null);

        JLabel contactNumberLabel = new JLabel("Phone");
        contactNumberLabel.setBounds(15, 0, 70, 30);
        contactNumberLabel.setForeground(new Color(0xFFFFFF));

        contactNumber.setBounds(70, 0, 120, 30);
        contactNumber.setForeground(new Color(0x000000));
        contactNumber.setFont(new Font("Arial", Font.PLAIN, 15));

        contactNumberPanel.add(contactNumberLabel);
        contactNumberPanel.add(contactNumber);
        //!---------------------------------------------------------

        //!Gender Panel---------------------------------------------
        JPanel genderPanel = new JPanel();
        genderPanel.setBounds(215, 180, 150, 30);
        genderPanel.setBackground(new Color(0x1A75FF));
        genderPanel.setLayout(null);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(5, 0, 70, 30);
        genderLabel.setForeground(new Color(0xFFFFFF));

        genderComboBox.setBounds(70, 0, 80, 30);
        genderComboBox.setForeground(new Color(0x000000));
        genderComboBox.setFont(new Font("Arial", Font.PLAIN, 15));

        genderPanel.add(genderLabel);
        genderPanel.add(genderComboBox);
        //!---------------------------------------------------------

        //!Blood Group Panel---------------------------------------------
        JPanel bloodGroupPanel = new JPanel();
        bloodGroupPanel.setBounds(380, 180, 150, 30);
        bloodGroupPanel.setBackground(new Color(0x1A75FF));
        bloodGroupPanel.setLayout(null);

        JLabel bloodGroupLabel = new JLabel("Blood Group");
        bloodGroupLabel.setBounds(5, 0, 70, 30);
        bloodGroupLabel.setForeground(new Color(0xFFFFFF));

        bloodGroupComboBox.setBounds(95, 0, 55, 30);
        bloodGroupComboBox.setForeground(new Color(0x000000));
        bloodGroupComboBox.setFont(new Font("Arial", Font.PLAIN, 15));

        bloodGroupPanel.add(bloodGroupLabel);
        bloodGroupPanel.add(bloodGroupComboBox);
        //!---------------------------------------------------------
        
        //!Email Panel----------------------------------------------
        JPanel addressPanel = new JPanel();
        addressPanel.setBounds(50, 230, 450, 30);
        addressPanel.setBackground(new Color(0x1A75FF));
        addressPanel.setLayout(null);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(20, 0, 70, 30);
        addressLabel.setForeground(new Color(0xFFFFFF));

        address.setBounds(80, 0, 370, 30);
        address.setForeground(new Color(0x000000));
        address.setFont(new Font("Arial", Font.PLAIN, 15));

        addressPanel.add(addressLabel);
        addressPanel.add(address);
        //!---------------------------------------------------------

        //!Password Panel-----------------------------------------
        JPanel passwordPanel = new JPanel();
        passwordPanel.setBounds(150, 280, 250, 30);
        passwordPanel.setBackground(new Color(0x1A75FF));
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

        //!Terms And Conditions Checkbox-----------------------------------------
        termsAndConditionsCheckBox.setBounds(100, 330, 150, 30);
        termsAndConditionsCheckBox.setForeground(new Color(200, 117, 100));
        termsAndConditionsCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        termsAndConditionsCheckBox.setFocusable(false);
        termsAndConditionsCheckBox.setOpaque(false);
        termsAndConditionsCheckBox.addActionListener(this);
        JLabel termsAndConditionsLabel = new JLabel("terms and conditions");
        termsAndConditionsLabel.setForeground(new Color(200, 120, 150));
        termsAndConditionsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        termsAndConditionsLabel.setBounds(250, 330, 400, 30);

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
                new termsAndConditionsFrame();
            }
        });

        //!---------------------------------------------------------

        //!Button---------------------------------------------------
        signUp.setText("Sign Up");
        signUp.setForeground(new Color(25, 117, 255));
        signUp.setFont(new Font("MV Boli", Font.BOLD, 20));
        signUp.setBounds(210, 380, 130, 30);
        signUp.setFocusable(false);
        signUp.addActionListener(this);
        signUp.setBackground(new Color(0x182838));
        signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signUp.setBorder(BorderFactory.createLineBorder(new Color(25, 117, 255), 2, true));
        signUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                signUp.setBorder(BorderFactory.createLineBorder(new Color(0x00FF00), 2, true));
                signUp.setBounds(208, 378, 135, 35);
                signUp.setForeground(new Color(0x00FF00));
                signUp.setBackground(new Color(0x182838));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                signUp.setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 2, true));
                signUp.setBounds(210, 380, 130, 30);
                signUp.setForeground(new Color(25, 117, 255));
                signUp.setBackground(new Color(0x182838));
            }
        });
        
        //!Adding Components To The Right Panel---------------------
        rightPanel.add(title);
        rightPanel.add(signUpText);
        rightPanel.add(fullNamePanel);
        rightPanel.add(usernamePanel);
        rightPanel.add(agePanel);
        rightPanel.add(emailPanel);
        rightPanel.add(contactNumberPanel);
        rightPanel.add(genderPanel);
        rightPanel.add(bloodGroupPanel);
        rightPanel.add(addressPanel);
        rightPanel.add(passwordPanel);
        rightPanel.add(termsAndConditionsCheckBox);
        rightPanel.add(termsAndConditionsLabel);
        rightPanel.add(signUp);

        return rightPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedBloodGroup = (String) bloodGroupComboBox.getSelectedItem();
        String selectedGender = (String) genderComboBox.getSelectedItem();
        if(e.getSource() == signIn){
            this.dispose();
            new loginFrame();
        }
        else if (e.getSource() == signUp) {
            allValidations checkValidations = new allValidations();
            if (name.getText().equals("") || username.getText().equals("") || age.getText().equals("") || email.getText().equals("") || address.getText().equals("") || contactNumber.getText().equals("") || password.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please Fill The Credentials");
            } 
            else if(!checkValidations.isValidName(name.getText())) {
                JOptionPane.showMessageDialog(null, "Name should not contain numbers or special characters", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(!checkValidations.isValidAge(age.getText())) {
                JOptionPane.showMessageDialog(null, "Age should be a positive number", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(!checkValidations.isValidContactNumber(contactNumber.getText())) {
                JOptionPane.showMessageDialog(null, "Contact number should be a digit number", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (!checkValidations.isValidEmail(email.getText())) {
                JOptionPane.showMessageDialog(null, "Invalid email format", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (!checkValidations.isValidPassword(password.getText())) {
                JOptionPane.showMessageDialog(null, "Password must be at least 6 characters long", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (!termsAndConditionsCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please agree to the terms and conditions", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (checkValidations.isEmailRegistered(email.getText(), file)) {
                JOptionPane.showMessageDialog(null, "Email is already registered", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                try {
                    //? For Understanding.. condition ? expressionIfTrue : expressionIfFalse;
                    String bloodGroup = selectedBloodGroup != null ? selectedBloodGroup : "A+";
                    String gender = selectedGender != null ? selectedGender : "Male";
                    int ageValue = Integer.parseInt(age.getText());

                    User user = new User(
                            name.getText(),
                            username.getText(),
                            ageValue,
                            email.getText(),
                            address.getText(),
                            contactNumber.getText(),
                            password.getText(),
                            bloodGroup,
                            gender
                    );

                    try {
                            //!Reading existing data from file
                            StringBuilder jsonData = new StringBuilder();
                            try {
                                if (file.exists()) {
                                    BufferedReader reader = new BufferedReader(new FileReader(file));
                                    String line;
                                    while ((line = reader.readLine()) != null) {
                                        jsonData.append(line);
                                    }
                                    reader.close();
                                }
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }

                            //! If the file is not empty
                            String jsonContent = jsonData.toString().trim();
                            if (!jsonContent.isEmpty()) {
                                jsonContent = jsonContent.substring(0, jsonContent.length() - 1) + ",";
                            } else {
                                jsonContent = "[";//!Create a JSON array
                            }
                            jsonContent += "\n" + user.toJSON() + "\n]"; //! Close the JSON array
                            try (FileWriter fileWriter = new FileWriter(file, false)) {
                                fileWriter.write(jsonContent);
                            }
                            //? After Registration
                            JOptionPane.showMessageDialog(null, "User registered successfully!");
                            this.dispose();
                            new userHomePage();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "An error occurred. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error Occured", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}