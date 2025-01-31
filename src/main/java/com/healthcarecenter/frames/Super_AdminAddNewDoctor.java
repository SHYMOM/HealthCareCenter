package com.healthcarecenter.frames;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

import com.healthcarecenter.utils.All_Validations;
import com.healthcarecenter.utils.FileUtils;
import com.healthcarecenter.utils.GetDoctorData;
import com.healthcarecenter.models.Doctor;
import com.healthcarecenter.frames.dialogs.*;

public class Super_AdminAddNewDoctor extends JFrame implements ActionListener {

    private final  JButton registerButton = new JButton();
    private final  JTextField name = new JTextField();
    private final  JTextField username = new JTextField();
    private final  JTextField age = new JTextField();
    private final  JComboBox<String> genderComboBox = new JComboBox<>(new String[]{" Male", " Female", " Others"});
    private final  JTextField number = new JTextField();
    private final  String[] bloodGroupOptions = {"  A+", "  A-", "  B+", "  B-", " AB+", " AB-", "  O+", "  O-"};
    private final  JComboBox<String> bloodComboBox = new JComboBox<>(bloodGroupOptions);
    private final  JTextField email = new JTextField();
    private final  JTextField password = new JTextField();
    private final  JTextField address = new JTextField();
    private final  JTextField specialization = new JTextField();
    private final  JTextField qualification = new JTextField();
    private final  JTextField licenseNumber = new JTextField();
    private String daysAvailable = "";
    private String consultingTime = "";
    private final  JTextField fee = new JTextField();
    private final  JCheckBox termsAndConditionsCheckBox = new JCheckBox("I agree to the ");



    public Super_AdminAddNewDoctor (String EditMode, String username)
    {
        if (EditMode.equals("Edit"))
        {
            HashMap<String, String> doctorData = GetDoctorData.getDoctorDetails(username);
            this.name.setText(doctorData.get("fullName"));
            this.username.setText(doctorData.get("username"));
            this.age.setText(doctorData.get("age"));
            this.genderComboBox.setSelectedItem(doctorData.get("gender"));
            this.number.setText(doctorData.get("contactNumber"));
            this.bloodComboBox.setSelectedItem(doctorData.get("bloodGroup"));
            this.email.setText(doctorData.get("email"));
            this.password.setText(GetDoctorData.getFieldValue(username, "password"));
            this.address.setText(doctorData.get("address"));
            this.specialization.setText(doctorData.get("specialization"));
            this.qualification.setText(doctorData.get("qualifications"));
            this.licenseNumber.setText(doctorData.get("medicalLicenseNumber"));
            this.daysAvailable = doctorData.get("daysAvailable");
            this.consultingTime = doctorData.get("consultationHours");
            this.fee.setText(doctorData.get("consultationFee"));
            //this.salary.setText(doctorData.get("salary"));
            doctorUI();
        } 
        else if (EditMode.equals("Add"))
        {
            doctorUI();
        }
    }

    private void doctorUI()
    {

        JPanel panel = new JPanel();                                  
        panel.setBounds(0,0,900,600);
        panel.setBackground(Color.red);
        panel.setLayout(null);

        panel.add(createLeftpanel());
        panel.add(createRightpanel());

        ImageIcon appIcon = new ImageIcon(FileUtils.getFile("/Icons/appIcon.png").getAbsolutePath());
        
        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setTitle("Add New Doctor - Health Care Center");
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.add(panel);

    }

    public JPanel createLeftpanel()
    {
      JPanel left_panel = new JPanel();
        left_panel.setLayout(null);
        left_panel.setBounds(0,0,300,600);
       // left_panel.setBackground(new Color(0,0,33,150));


        return left_panel;

    }

    public JPanel createRightpanel()
    {
      JPanel right_panel = new JPanel();
        right_panel.setLayout(null);
        right_panel.setBounds(300,0,630,600);
        right_panel.setBackground(new Color(0,0,33,100)); 
        right_panel.add(scrollPane());

        JLabel label = new JLabel("Registration For A New Doctor");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(100,10,400,50);
        label.setForeground(new Color(0x00FF00));
        label.setFont(new Font("MV Boli", Font.BOLD, 20));
        label.setLayout(null);
        right_panel.add(label);

        JLabel labelform = new JLabel("Fill The Form Below");
        labelform.setHorizontalAlignment(JLabel.CENTER);
        labelform.setBounds(150,60,300,50);
        labelform.setForeground(new Color(0x00FF00));
        labelform.setFont(new Font("MV Boli", Font.BOLD, 20));
        labelform.setLayout(null);


        right_panel.add(label);
        right_panel.add(labelform);

        


        return right_panel;
    }

    private JScrollPane scrollPane() {

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 120, 585, 600);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    
        //!Full Name Panel-----------------------------------------
        JPanel fullNamePanel = new JPanel();
        fullNamePanel.setBounds(150, 20, 300, 30);
        fullNamePanel.setBackground(new Color(0x1A75FF));
        fullNamePanel.setLayout(null);
    
        JLabel nameLabel = new JLabel("Full Name");
        nameLabel.setBounds(10, 0, 70, 30);
        nameLabel.setForeground(new Color(0xFFFFFF));
    
        
        name.setBounds(80, 0, 220, 30);
        name.setForeground(new Color(0x000000));
        name.setFont(new Font("Arial", Font.PLAIN, 15));
    
        fullNamePanel.add(nameLabel);
        fullNamePanel.add(name);
    
        //!Username Panel-------------------------------------------
        JPanel usernamePanel = new JPanel();
        usernamePanel.setBounds(150, 60, 300, 30);
        usernamePanel.setBackground(new Color(0x1A75FF));
        usernamePanel.setLayout(null);
    
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 0, 70, 30);
        usernameLabel.setForeground(new Color(0xFFFFFF));
    
        
        username.setBounds(80, 0, 220, 30);
        username.setForeground(new Color(0x000000));
        username.setFont(new Font("Arial", Font.PLAIN, 15));
    
        usernamePanel.add(usernameLabel);
        usernamePanel.add(username);
    
        //!Age Panel-------------------------------------------
        JPanel agePanel = new JPanel();
        agePanel.setBounds(50, 100, 250, 30);
        agePanel.setBackground(new Color(0x1A75FF));
        agePanel.setLayout(null);
    
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(10, 0, 70, 30);
        ageLabel.setForeground(new Color(0xFFFFFF));
    
        
        age.setBounds(80, 0, 170, 30);
        age.setForeground(new Color(0x000000));
        age.setFont(new Font("Arial", Font.PLAIN, 15));
    
        agePanel.add(ageLabel);
        agePanel.add(age);
    
        //!Gender Panel-------------------------------------------
        JPanel genderPanel = new JPanel();
        genderPanel.setBounds(350, 100, 180, 30);
        genderPanel.setBackground(new Color(0x1A75FF));
        genderPanel.setLayout(null);
    
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(10, 0, 70, 30);
        genderLabel.setForeground(new Color(0xFFFFFF));
    
        
        genderComboBox.setBounds(80, 0, 100, 30);
        genderComboBox.setForeground(new Color(0x000000));
        genderComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
    
        genderPanel.add(genderLabel);
        genderPanel.add(genderComboBox);

        //!Number Panel-------------------------------------------
        JPanel numberPanel = new JPanel();
        numberPanel.setBounds(50, 140, 250, 30);
        numberPanel.setBackground(new Color(0x1A75FF));
        numberPanel.setLayout(null);
    
        JLabel numberLabel = new JLabel("Phone ");
        numberLabel.setBounds(10, 0, 70, 30);
        numberLabel.setForeground(new Color(0xFFFFFF));
    
        
        number.setBounds(80, 0, 170, 30);
        number.setForeground(new Color(0x000000));
        number.setFont(new Font("Arial", Font.PLAIN, 15));
    
        numberPanel.add(numberLabel);
        numberPanel.add(number);

        //!Blood Group Panel Panel-------------------------------------------
        JPanel bloodPanel = new JPanel();
        bloodPanel.setBounds(350, 140, 180, 30);
        bloodPanel.setBackground(new Color(0x1A75FF));
        bloodPanel.setLayout(null);
    
        JLabel bloodLabel = new JLabel("Blood Group");
        bloodLabel.setBounds(10, 0, 100, 30);
        bloodLabel.setForeground(new Color(0xFFFFFF));


        
        bloodComboBox.setBounds(110, 0, 70, 30);
        bloodComboBox.setForeground(new Color(0x000000));
        bloodComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
    
        bloodPanel.add(bloodLabel);
        bloodPanel.add(bloodComboBox);


    
        //!Email Panel-------------------------------------------
        JPanel emailPanel = new JPanel();
        emailPanel.setBounds(150, 180, 300, 30);
        emailPanel.setBackground(new Color(0x1A75FF));
        emailPanel.setLayout(null);
    
        JLabel emailLabel = new JLabel("E-mail");
        emailLabel.setBounds(10, 0, 70, 30);
        emailLabel.setForeground(new Color(0xFFFFFF));
    
        
        email.setBounds(80, 0, 220, 30);
        email.setForeground(new Color(0x000000));
        email.setFont(new Font("Arial", Font.PLAIN, 15));
    
        emailPanel.add(emailLabel);
        emailPanel.add(email);
    
        //!Password Panel-------------------------------------------
        JPanel passPanel = new JPanel();
        passPanel.setBounds(150, 220, 300, 30); // Place this panel far down to force scrolling
        passPanel.setBackground(new Color(0x1A75FF));
        passPanel.setLayout(null);
    
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(10, 0, 70, 30);
        passLabel.setForeground(new Color(0xFFFFFF));
    
        
        password.setBounds(80, 0, 220, 30);
        password.setForeground(new Color(0x000000));
        password.setFont(new Font("Arial", Font.PLAIN, 15));
    
        passPanel.add(passLabel);
        passPanel.add(password);

        //!Address Panel-------------------------------------------
        JPanel addressPanel = new JPanel();
        addressPanel.setBounds(100, 260, 400, 30); // Place this panel far down to force scrolling
        addressPanel.setBackground(new Color(0x1A75FF));
        addressPanel.setLayout(null);
    
        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(10, 0, 70, 30);
        addressLabel.setForeground(new Color(0xFFFFFF));
    
        
        address.setBounds(80, 0, 320, 30);
        address.setForeground(new Color(0x000000));
        address.setFont(new Font("Arial", Font.PLAIN, 15));
    
        addressPanel.add(addressLabel);
        addressPanel.add(address);


      //!specialization Panel-------------------------------------------
        JPanel specializationPanel = new JPanel();
        specializationPanel.setBounds(100, 300, 400, 30); // Place this panel far down to force scrolling
        specializationPanel.setBackground(new Color(0x1A75FF));
        specializationPanel.setLayout(null);
    
        JLabel specializationLabel = new JLabel("specialization");
        specializationLabel.setBounds(10, 0, 90, 30);
        specializationLabel.setForeground(new Color(0xFFFFFF));
    
        
        specialization.setBounds(100, 0, 300, 30);
        specialization.setForeground(new Color(0x000000));
        specialization.setFont(new Font("Arial", Font.PLAIN, 15));
    
        specializationPanel.add(specializationLabel);
        specializationPanel.add(specialization);


      //!Qualification Panel-------------------------------------------
        JPanel qualificationPanel = new JPanel();
        qualificationPanel.setBounds(100, 340, 400, 30); // Place this panel far down to force scrolling
        qualificationPanel.setBackground(new Color(0x1A75FF));
        qualificationPanel.setLayout(null);
  
      JLabel qualificationLabel = new JLabel("Qualification");
      qualificationLabel.setBounds(10, 0, 90, 30);
      qualificationLabel.setForeground(new Color(0xFFFFFF));
  
      
      qualification.setBounds(100, 0, 300, 30);
      qualification.setForeground(new Color(0x000000));
      qualification.setFont(new Font("Arial", Font.PLAIN, 15));
  
      qualificationPanel.add(qualificationLabel);
      qualificationPanel.add(qualification);

      //!licenseNumber Panel-------------------------------------------
      JPanel licenseNumberPanel = new JPanel();
      licenseNumberPanel.setBounds(150, 380, 320, 30); // Place this panel far down to force scrolling
      licenseNumberPanel.setBackground(new Color(0x1A75FF));
      licenseNumberPanel.setLayout(null);
  
      JLabel licenseNumberLabel = new JLabel("License Number");
      licenseNumberLabel.setBounds(10, 0, 110, 30);
      licenseNumberLabel.setForeground(new Color(0xFFFFFF));
  
      
      licenseNumber.setBounds(120, 0, 200, 30);
      licenseNumber.setForeground(new Color(0x000000));
      licenseNumber.setFont(new Font("Arial", Font.PLAIN, 15));
  
      licenseNumberPanel.add(licenseNumberLabel);
      licenseNumberPanel.add(licenseNumber);

      //!consultingHours Panel-------------------------------------------
      JPanel consultingHoursPanel = new JPanel();
      consultingHoursPanel.setBounds(320, 420, 220, 30); // Place this panel far down to force scrolling
      consultingHoursPanel.setBackground(new Color(0x1A75FF));
      consultingHoursPanel.setLayout(null);
  
      JLabel consultingHoursLabel = new JLabel("Consulting Hours");
      consultingHoursLabel.setBounds(0, 0, 100, 30);
      consultingHoursLabel.setForeground(new Color(0xFFFFFF));
  
      
      JButton consultingHours = new JButton("Select Time");
      consultingHours.setBounds(100, 0, 100, 30);
      consultingHours.setForeground(new Color(0x000000));
      consultingHours.setFont(new Font("Arial", Font.PLAIN, 15));
      consultingHours.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component)e.getSource());
                consultingTime = ConsultingTimeSelect.setTimePickerDialog(frame);
            }
        });
  
      consultingHoursPanel.add(consultingHoursLabel);
      consultingHoursPanel.add(consultingHours);

      //!available Panel-------------------------------------------
      JPanel availablePanel = new JPanel();
      availablePanel.setBounds(50, 420, 190, 30);
      availablePanel.setBackground(new Color(0x1A75FF));
      availablePanel.setLayout(null);
  
      JLabel availableLabel = new JLabel("Day's Available");
      availableLabel.setBounds(10, 0, 90, 30);
      availableLabel.setForeground(new Color(0xFFFFFF));
      
      JButton available = new JButton("Select");
      available.setBounds(100, 0, 100, 30);
      available.setForeground(new Color(0x000000));
      available.setFont(new Font("Arial", Font.PLAIN, 15));
      available.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
                JCheckBox[] checkBoxes = new JCheckBox[days.length];

                JPanel panel = new JPanel(new GridLayout(0, 1));
                for (int i = 0; i < days.length; i++) {
                    checkBoxes[i] = new JCheckBox(days[i]);
                    panel.add(checkBoxes[i]);
                }
                JLabel label = new JLabel("Selected Days: " + daysAvailable);
                panel.add(label);

                int result = JOptionPane.showConfirmDialog(null, panel, "Select Available Days", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    ArrayList<String> selectedDays = new ArrayList<>();
                    for (JCheckBox checkBox : checkBoxes) {
                        if (checkBox.isSelected()) {
                            selectedDays.add(checkBox.getText());
                        }
                    }
                    if (selectedDays.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please select at least one day", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        daysAvailable = String.join(", ", selectedDays);
                    }
                }
            }
        });
  
      availablePanel.add(availableLabel);
      availablePanel.add(available);


      //!fee Panel-------------------------------------------
      JPanel feePanel = new JPanel();
      feePanel.setBounds(150, 460, 230, 30); // Place this panel far down to force scrolling
      feePanel.setBackground(new Color(0x1A75FF));
      feePanel.setLayout(null);
  
      JLabel feeLabel = new JLabel("Consultation Fee");
      feeLabel.setBounds(10, 0, 120, 30);
      feeLabel.setForeground(new Color(0xFFFFFF));
  
      
      fee.setBounds(130, 0, 100, 30);
      fee.setForeground(new Color(0x000000));
      fee.setFont(new Font("Arial", Font.PLAIN, 15));
  
      feePanel.add(feeLabel);
      feePanel.add(fee);

      //!Terms And Conditions Checkbox-----------------------------------------

        
      termsAndConditionsCheckBox.setBounds(100, 500, 150, 30);
      termsAndConditionsCheckBox.setForeground(new Color(200, 117, 100));
      termsAndConditionsCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 20));
      termsAndConditionsCheckBox.setFocusable(false);
      termsAndConditionsCheckBox.setOpaque(false);
      termsAndConditionsCheckBox.addActionListener(this);

      JLabel termsAndConditionsLabel = new JLabel("terms and conditions");
      termsAndConditionsLabel.setForeground(new Color(200, 120, 150));
      termsAndConditionsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
      termsAndConditionsLabel.setBounds(250, 500, 400, 30);

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
       
        registerButton.setText("Register");
        registerButton.setForeground(new Color(25, 117, 255));
        registerButton.setFont(new Font("MV Boli", Font.BOLD, 20));
        registerButton.setBounds(250, 540, 100, 30);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);
        registerButton.setBackground(new Color(0x182838));
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setBorder(BorderFactory.createLineBorder(new Color(25, 117, 255), 2, true));
        registerButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                registerButton.setBorder(BorderFactory.createLineBorder(new Color(0x00FF00), 2, true));
                registerButton.setBounds(248, 542, 105, 30);
                registerButton.setForeground(new Color(0x00FF00));
                registerButton.setBackground(new Color(0x182838));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                registerButton.setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 2, true));
                registerButton.setBounds(250, 540, 100, 30);
                registerButton.setForeground(new Color(25, 117, 255));
                registerButton.setBackground(new Color(0x182838));
            }
        });

    
        //!Scrollable Content--------------------------------------
        JPanel scroll = new JPanel();
        scroll.setLayout(null);
        scroll.add(fullNamePanel);
        scroll.add(usernamePanel);
        scroll.add(agePanel);
        scroll.add(genderPanel);
        scroll.add(numberPanel);
        scroll.add(bloodPanel);
        scroll.add(emailPanel);
        scroll.add(passPanel);
        scroll.add(addressPanel);
        scroll.add(specializationPanel);
        scroll.add(qualificationPanel);
        scroll.add(licenseNumberPanel);
        scroll.add(consultingHoursPanel);
        scroll.add(availablePanel);
        scroll.add(feePanel);
        scroll.add(registerButton);
        scroll.add(termsAndConditionsCheckBox);
        scroll.add(termsAndConditionsLabel);
    
        scroll.setPreferredSize(new Dimension(585, 750));
        scrollPane.setViewportView(scroll);

        return scrollPane;
    }
    
    


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == registerButton)
        {
            All_Validations checkValidations = new All_Validations();
            if(name.getText().equals("") || username.getText().equals("") || age.getText().equals("") || email.getText().equals("") || address.getText().equals("") || number.getText().equals("") || password.getText().equals("") || specialization.getText().equals("") || qualification.getText().equals("") || licenseNumber.getText().equals("") || consultingTime.equals("") || specialization.getText().equals("") || daysAvailable.equals("") || fee.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Fill The Credentials");
            }
            else if(!checkValidations.isValidName(name.getText()))
            {
                JOptionPane.showMessageDialog(null, "Name should not contain numbers or special characters", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(!checkValidations.isValidAge(age.getText()))
            {
                JOptionPane.showMessageDialog(null, "Age should be a positive number", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(!checkValidations.isValidContactNumber(number.getText()))
            {
                JOptionPane.showMessageDialog(null, "Contact number should be a digit number", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(!checkValidations.isValidEmail(email.getText()))
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid email address", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(!checkValidations.isValidLicenseNumber(licenseNumber.getText()))
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid license number", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(!checkValidations.isValidPassword(password.getText()))
            {
                JOptionPane.showMessageDialog(null, "Password must be at least 6 characters long", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(!checkValidations.isValidAmount(fee.getText())){
                JOptionPane.showMessageDialog(null, "Please enter a valid fee", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(!termsAndConditionsCheckBox.isSelected())
            {
                JOptionPane.showMessageDialog(null, "Please agree to the terms and conditions", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                Doctor doctor = new Doctor(name.getText(), username.getText(), age.getText(), email.getText(), number.getText(), address.getText(), password.getText(), genderComboBox.getSelectedItem().toString(), bloodComboBox.getSelectedItem().toString(), specialization.getText(), qualification.getText(), licenseNumber.getText(), consultingTime, daysAvailable, Double.parseDouble(fee.getText()), 0);
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                doctor.saveToFile(frame, username.getText());
            }
        }
    }



    public static void main(String[] args)
    {
        new Super_AdminAddNewDoctor("Edit", "Alice_Doctor");
    }

} 