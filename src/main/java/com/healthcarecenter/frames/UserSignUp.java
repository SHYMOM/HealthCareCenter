package com.healthcarecenter.frames;

import com.healthcarecenter.models.*;
import com.healthcarecenter.utils.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.*;

public class UserSignUp extends JFrame implements ActionListener {
    private static final Color PRIMARY_COLOR = new Color(41, 128, 185);
    private static final Color SECONDARY_COLOR = new Color(52, 152, 219);
    private static final Color ACCENT_COLOR = new Color(46, 204, 113);
    private static final Color TEXT_COLOR = new Color(236, 240, 241);
    private static final Color BACKGROUND_COLOR = new Color(44, 62, 80, 240);
    private static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 24);
    private static final Font REGULAR_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    
    private final JButton signUp;
    private final JButton signIn;
    private final JTextField name;
    private final JTextField age;
    private final JTextField username;
    private final JTextField email;
    private final JTextField contactNumber;
    private final JTextField address;

    private String EditMode;

    private final JComboBox<String> genderComboBox;
    private final JComboBox<String> bloodGroupComboBox;
    private final JPasswordField password;
    private final JCheckBox termsAndConditionsCheckBox;

    public UserSignUp(String EditMode, String username) {
        this.signUp = createStyledButton("Sign Up", ACCENT_COLOR);
        this.signIn = createStyledButton("Sign In", PRIMARY_COLOR);
        this.name = createStyledTextField();
        this.age = createStyledTextField();
        this.username = createStyledTextField();
        this.email = createStyledTextField();
        this.contactNumber = createStyledTextField();
        this.address = createStyledTextField();
        this.genderComboBox = createStyledComboBox(new String[]{"Male", "Female", "Others"});
        this.bloodGroupComboBox = createStyledComboBox(new String[]{"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"});
        this.password = createStyledPasswordField();
        this.termsAndConditionsCheckBox = createStyledCheckBox("I agree to the ");
        

        if (EditMode.equals("Edit")) {
            this.EditMode = EditMode;
            this.signUp.setText("Save Changes");
            this.username.setEditable(false);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            loadUserData(username);
        }
        else if (EditMode.equals("Add")) {
            this.EditMode = EditMode;
            this.signUp.setText("Register");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        

        initializeUI();
    }


    private void loadUserData(String username) {
        try {
            HashMap<String, String> userData = GetUserData.getUserDetails(username);
            this.name.setText(userData.get("name"));
            this.age.setText(userData.get("age"));
            this.username.setText(userData.get("username"));
            this.email.setText(userData.get("email"));
            this.contactNumber.setText(userData.get("contactNumber"));
            this.address.setText(userData.get("address"));
            this.password.setText(userData.get("password"));
            this.genderComboBox.setSelectedItem(userData.get("gender"));
            this.bloodGroupComboBox.setSelectedItem(userData.get("bloodGroup"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeUI() {
        //! Frame settings
        this.setTitle("Healthcare Center - Sign Up");
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        ImageIcon appIcon = new ImageIcon(FileUtils.getFile("/Icons/appIcon.png").getAbsolutePath());    
        this.setIconImage(appIcon.getImage());

        //! Main panel
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gradient = new GradientPaint(0, 0, new Color(44, 62, 80),
                        getWidth(), getHeight(), new Color(52, 152, 219));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(new GridBagLayout());

        JPanel contentPanel = createContentPanel();
        mainPanel.add(contentPanel);
        this.add(mainPanel);
        this.setVisible(true);
    }

    private JPanel createContentPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255, 240));
        panel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(255, 255, 255, 100), 1),
                BorderFactory.createEmptyBorder(30, 40, 30, 40)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 15, 0);

        //! Header section
        JLabel titleLabel = new JLabel("Create Your Account", SwingConstants.CENTER);
        titleLabel.setFont(TITLE_FONT);
        titleLabel.setForeground(PRIMARY_COLOR);
        panel.add(titleLabel, gbc);

        //! Form sections
        panel.add(createFormSection(), gbc);

        //! Terms and conditions
        JPanel termsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        termsPanel.setOpaque(false);
        termsPanel.add(termsAndConditionsCheckBox);
        
        JLabel termsLink = createClickableLabel("terms and conditions");
        termsLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new TermsAndConditionsFrame();
            }
        });
        termsPanel.add(termsLink);
        
        panel.add(termsPanel, gbc);

        //! Buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(signUp);
        buttonsPanel.add(signIn);
        
        gbc.insets = new Insets(20, 0, 0, 0);
        panel.add(buttonsPanel, gbc);

        return panel;
    }

    private JPanel createFormSection() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        //! First row
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        formPanel.add(createInputPanel("Full Name", name), gbc);

        gbc.gridx = 1;
        formPanel.add(createInputPanel("Username", username), gbc);

        //! Second row
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(createInputPanel("Age", age), gbc);

        gbc.gridx = 1;
        formPanel.add(createInputPanel("Email", email), gbc);

        //! Third row
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(createInputPanel("Contact Number", contactNumber), gbc);

        gbc.gridx = 1;
        JPanel selectionPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        selectionPanel.setOpaque(false);
        selectionPanel.add(createInputPanel("Gender", genderComboBox));
        selectionPanel.add(createInputPanel("Blood Group", bloodGroupComboBox));
        formPanel.add(selectionPanel, gbc);

        //! Fourth row
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        formPanel.add(createInputPanel("Address", address), gbc);

        //! Fifth row
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        formPanel.add(createInputPanel("Password", password), gbc);

        return formPanel;
    }

    private JPanel createInputPanel(String labelText, JComponent input) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setOpaque(false);

        JLabel label = new JLabel(labelText);
        label.setFont(REGULAR_FONT);
        label.setForeground(PRIMARY_COLOR);
        
        panel.add(label, BorderLayout.NORTH);
        panel.add(input, BorderLayout.CENTER);
        
        return panel;
    }

    private JTextField createStyledTextField() {
        JTextField field = new JTextField();
        field.setFont(REGULAR_FONT);
        field.setPreferredSize(new Dimension(200, 35));
        field.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(PRIMARY_COLOR.brighter(), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        return field;
    }

    private JPasswordField createStyledPasswordField() {
        JPasswordField field = new JPasswordField();
        field.setFont(REGULAR_FONT);
        field.setPreferredSize(new Dimension(200, 35));
        field.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(PRIMARY_COLOR.brighter(), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        return field;
    }

    private JComboBox<String> createStyledComboBox(String[] items) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setFont(REGULAR_FONT);
        comboBox.setPreferredSize(new Dimension(200, 35));
        comboBox.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR.brighter(), 1));
        return comboBox;
    }

    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(TEXT_COLOR);
        button.setBackground(color);
        button.setPreferredSize(new Dimension(120, 40));
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(this);

        //! Hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(color.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(color);
            }
        });

        return button;
    }

    private JCheckBox createStyledCheckBox(String text) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(REGULAR_FONT);
        checkBox.setForeground(PRIMARY_COLOR);
        checkBox.setOpaque(false);
        checkBox.setFocusPainted(false);
        return checkBox;
    }

    private JLabel createClickableLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(REGULAR_FONT);
        label.setForeground(ACCENT_COLOR);
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //! Hover effect
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setForeground(ACCENT_COLOR.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(ACCENT_COLOR);
            }
        });

        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedBloodGroup = (String) bloodGroupComboBox.getSelectedItem();
        String selectedGender = (String) genderComboBox.getSelectedItem();
        if(e.getSource() == signIn){
            this.dispose();
            new LoginPage("User");
        }
        else if (e.getSource() == signUp) {
            All_Validations checkValidations = new All_Validations();
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
            
            } 
            else if (!checkValidations.isValidPassword(password.getText())) {
                JOptionPane.showMessageDialog(null, "Password must be at least 6 characters long", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (!termsAndConditionsCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please agree to the terms and conditions", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                if(EditMode.equals("Add")){
                    if (checkValidations.isEmailRegistered(email.getText(), "/data/users/")) {
                        JOptionPane.showMessageDialog(null, "Email Already Registered", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if (FileUtils.doesFileExist("/data/users/"+username.getText()+".txt")) {
                        JOptionPane.showMessageDialog(null, "Username Already Registered", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        User user = new User(name.getText(), username.getText(), Integer.parseInt(age.getText()), email.getText(), address.getText(), contactNumber.getText(), password.getText(), selectedBloodGroup, selectedGender);
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                        user.saveToFile(frame);
                    }
                }
                else if(EditMode.equals("Edit")){
                try{
                  User.setName(username.getText(), name.getText());
                  User.setAge(username.getText(),age.getText());
                  User.setEmail(username.getText(), email.getText());
                  User.setAddress(username.getText(), address.getText());
                  User.setContactNumber(username.getText(), contactNumber.getText());
                  User.setPassword(username.getText(), password.getText()); 
                  User.setBloodGroup(username.getText(), selectedBloodGroup);
                  User.setGender(username.getText(), selectedGender);
                 
                  new LoginPage("User");
                  this.dispose();

                }catch(Exception ex){
                    
                }   
                }
            }
        }
    }

    public static void main(String[] args) {
        new UserSignUp("Edit","emiko");
    }
}