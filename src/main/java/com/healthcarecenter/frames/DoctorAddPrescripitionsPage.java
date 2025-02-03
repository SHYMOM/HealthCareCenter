package com.healthcarecenter.frames;
import com.healthcarecenter.utils.FileUtils;
import com.healthcarecenter.utils.FrameUtils;
import com.healthcarecenter.utils.GetDoctorData;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import javax.swing.*;
public class DoctorAddPrescripitionsPage extends JFrame implements ActionListener
{

    private JTextField testField = new JTextField();
    private JTextField testCostField = new JTextField();
    private JTextField medicineField = new JTextField();
    private JTextField medicineCostField = new JTextField();
    private JTextField diseaseField = new JTextField();
    private JTextArea noteArea = new JTextArea();
    private JButton addPrescriptionButton = new JButton("Add Prescription");
    private String username;
    private String name;
    private String patientUsername;

    
    public DoctorAddPrescripitionsPage(String username, String patientUserName)
    {
        this.username = username;
        this.patientUsername = patientUserName;

        try {
            this.name = GetDoctorData.getName(username);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error fetching user data: " + e.getMessage());
            new WelcomePage();
            this.dispose();
            return;
        }

        UserUI();

    }


    private void UserUI()
    {
        JPanel panel = new JPanel();                                  
        panel.setBounds(0,0,900,600);
        panel.setBackground(Color.red);
        panel.setLayout(null);


        panel.add(createUpperpanel());
        panel.add(createLowerpanel());
        
        ImageIcon appIcon = new ImageIcon(FileUtils.getFile("/Icons/appIcon.png").getAbsolutePath());
        this.setIconImage(appIcon.getImage());

        this.setTitle("HealthCareCenter.Doctor.AddPrescripitionsPage");      
        this.setLayout(null);
        this.setSize(900, 600);                       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          
        this.getContentPane().setBackground(Color.BLUE);
        this.setResizable(false); 
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.add(panel);
   

    }

    private JPanel createUpperpanel()
    {
        JPanel upper_panel = new JPanel();                                  
        upper_panel.setLayout(null);
        upper_panel.setBounds(0,0,900,180);
        upper_panel.setBackground(Color.gray);
		upper_panel.setBackground(new Color(0x3a8cdb));
		

        JLabel label = new JLabel("Health Care Center");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(100,10,600,50);
        label.setForeground(new Color(000000));
        label.setFont(new Font("MV Boli", Font.BOLD, 20));
        label.setLayout(null);
        upper_panel.add(label);

        
        

       //create userpanel for upper_panel
        JPanel user_panel = new JPanel(); 
        user_panel.setLayout(null);
        user_panel.setBounds(5,5,200,40);
        //user_panel.setBackground(Color.yellow);
		user_panel.setBackground(new Color(0x3a8cdb));
		
        upper_panel.add(user_panel);


        JLabel userlabel = new JLabel("Emiko");
        userlabel.setHorizontalAlignment(JLabel.CENTER);
        userlabel.setBounds(5,5,100,30);
        userlabel.setFont(new Font("SensSerif", Font.PLAIN, 15));
        user_panel.add(userlabel);
        upper_panel.add(createMiddlepanel());

        

        return upper_panel;
    }

    private JPanel createMiddlepanel()
    {
        JPanel middle_panel = new JPanel();                                  
        middle_panel.setLayout(null);
        middle_panel.setBounds(0,130,900,50);
        middle_panel.setBackground(new Color(10, 10, 10));
		middle_panel.setBackground(new Color(0x3a8cdb));
		
		//level for home 
		 JLabel home= new JLabel();
         home.setText("Home");
         home.setForeground(new Color(000000));
         home.setFont(new Font("SansSerif", Font.PLAIN, 15));
		 home.setForeground(new Color(000000));
         home.setBounds(25, 15, 42, 20);


        //level for appoinment
         JLabel appoinment= new JLabel();
         appoinment.setText("View Appoinment");
         appoinment.setForeground(new Color(000000));
         appoinment.setFont(new Font("SansSerif", Font.PLAIN, 15));
         appoinment.setBounds(110, 15, 120, 20);

          //level for records
        JLabel records = new JLabel();
        records.setText("Access patient Records");
        records.setForeground(new Color(000000));
        records.setFont(new Font("SansSerif", Font.PLAIN, 15));
        records.setBounds(275, 15, 165, 20);

         //level for prescripitions
         JLabel prescripitions = new JLabel();
         prescripitions.setText("Add prescripitions");
         prescripitions.setForeground(new Color(000000));
         prescripitions.setFont(new Font("SansSerif", Font.PLAIN, 15));
		 prescripitions.setForeground(Color.white);
         prescripitions.setBounds(500, 15, 125, 20);
         
         //level for log out
         JLabel log_out = new JLabel();
         log_out.setText("Log out");
         log_out.setForeground(new Color(000000));
         log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
         log_out.setBounds(650, 15, 60, 20);
 
          //add level in middle_panel
		  middle_panel.add(home);
          middle_panel.add(appoinment);
          middle_panel.add(records);
          middle_panel.add(prescripitions);
          middle_panel.add(log_out);
		  
		  home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
				home.setForeground(Color.RED);
                home.setForeground(new Color(0x00FF00));
                home.setFont(new Font("SansSerif", Font.PLAIN, 17));
				home.setBounds(23, 10, 48, 30);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                home.setForeground(new Color(000000));
                home.setFont(new Font("SansSerif", Font.PLAIN, 15));
				home.setBounds(25, 15, 42, 20);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(home).dispose();
				new DoctorHomePage(username,true);
                
            }
        });
          
          


            appoinment.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                appoinment.setForeground(new Color(0x00FF00));
                appoinment.setFont(new Font("SansSerif", Font.PLAIN, 17));
				appoinment.setBounds(105, 10, 130, 30);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                appoinment.setForeground(new Color(0, 0, 0));
                appoinment.setFont(new Font("SansSerif", Font.PLAIN, 15));
				appoinment.setBounds(110, 15, 120, 20);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(appoinment).dispose();
                new DoctorViewAppoinmentsPage(username);
            }
        });

        records.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                records.setForeground(new Color(0x00FF00));
                records.setFont(new Font("SansSerif", Font.PLAIN, 17));
				records.setBounds(270, 10, 180, 30);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                records.setForeground(new Color(0, 0, 0));
                records.setFont(new Font("SansSerif", Font.PLAIN, 15));
				records.setBounds(275, 15, 165, 20);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
             SwingUtilities.getWindowAncestor(records).dispose();
             new DoctorPatientRecordsPage(username);			 
            }
        });
        


        /*  prescripitions.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                prescripitions.setForeground(Color.white);
                prescripitions.setFont(new Font("SansSerif", Font.PLAIN, 17));
				prescripitions.setBounds(495, 10, 170, 30);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                prescripitions.setForeground(Color.white);
                prescripitions.setFont(new Font("SansSerif", Font.PLAIN, 15));
		        prescripitions.setBounds(500, 15, 125, 20);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
        });*/ 

        log_out.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
            log_out.setForeground(new Color(0x00FF00));
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 17));
			log_out.setBounds(648, 12, 66, 25);
			
          }
          @Override
        public void mouseExited(MouseEvent e) {
            log_out.setForeground(new Color(0, 0, 0));
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
			log_out.setBounds(650, 15, 60, 20);
			
          }
         @Override
         public void mouseClicked(MouseEvent e)  
         {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(e.getComponent());
         FrameUtils.frameLogOut(frame);
     }
 });

        return middle_panel;
    }

private JPanel createLowerpanel() {
        JPanel lower_panel = new JPanel();
        lower_panel.setBounds(0, 180, 900, 500);
        lower_panel.setBackground(new Color(0xECF8FD));
        lower_panel.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(0xECF8FD));
        mainPanel.setLayout(null);
        
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font textFont = new Font("Arial", Font.PLAIN, 14);
        Color labelColor = new Color(0x2C3E50);
        Color borderColor = new Color(0x3498DB);
        Color buttonColor = new Color(0x3498DB);
        
        //! Measurements
        int startX = 80;          //? Starting X position
        int startY = 50;          //? Starting Y position
        int labelWidth = 120;     //? Width of labels
        int fieldWidth = 200;     //? Width of text fields
        int height = 30;          //? Height of components
        int verticalGap = 60;     //? Gap between rows
        int horizontalGap = 80;   //? Gap between label-field pairs

        //! Row 1: Disease
        JLabel diseaseLabel = new JLabel("Disease:");
        diseaseLabel.setBounds(startX, startY, labelWidth, height);
        diseaseLabel.setFont(labelFont);
        diseaseLabel.setForeground(labelColor);

        diseaseField.setBounds(startX + labelWidth, startY, fieldWidth * 2 + horizontalGap + labelWidth, height);
        diseaseField.setFont(textFont);
        styleTextField(diseaseField, borderColor);
        
        //! Row 2: Test and Test Cost (moved down)
        int row2Y = startY + verticalGap;
        
        JLabel testLabel = new JLabel("Medical Test:");
        testLabel.setBounds(startX, row2Y, labelWidth, height);
        testLabel.setFont(labelFont);
        testLabel.setForeground(labelColor);

        testField.setBounds(startX + labelWidth, row2Y, fieldWidth, height);
        testField.setFont(textFont);
        styleTextField(testField, borderColor);

        JLabel testCostLabel = new JLabel("Test Cost:");
        testCostLabel.setBounds(startX + labelWidth + fieldWidth + horizontalGap, row2Y, labelWidth, height);
        testCostLabel.setFont(labelFont);
        testCostLabel.setForeground(labelColor);

        testCostField.setBounds(startX + 2*labelWidth + fieldWidth + horizontalGap, row2Y, fieldWidth, height);
        testCostField.setFont(textFont);
        styleTextField(testCostField, borderColor);

        //! Row 3: Medicine and Medicine Cost
        int row3Y = row2Y + verticalGap;
        
        JLabel medicineLabel = new JLabel("Medicine:");
        medicineLabel.setBounds(startX, row3Y, labelWidth, height);
        medicineLabel.setFont(labelFont);
        medicineLabel.setForeground(labelColor);

        medicineField.setBounds(startX + labelWidth, row3Y, fieldWidth, height);
        medicineField.setFont(textFont);
        styleTextField(medicineField, borderColor);

        JLabel medicineCostLabel = new JLabel("Medicine Cost:");
        medicineCostLabel.setBounds(startX + labelWidth + fieldWidth + horizontalGap, row3Y, labelWidth, height);
        medicineCostLabel.setFont(labelFont);
        medicineCostLabel.setForeground(labelColor);

        medicineCostField.setBounds(startX + 2*labelWidth + fieldWidth + horizontalGap, row3Y, fieldWidth, height);
        medicineCostField.setFont(textFont);
        styleTextField(medicineCostField, borderColor);

        //! Row 4: Doctor's Note
        int row4Y = row3Y + verticalGap;
        
        JLabel noteLabel = new JLabel("Doctor's Note:");
        noteLabel.setBounds(startX, row4Y, labelWidth, height);
        noteLabel.setFont(labelFont);
        noteLabel.setForeground(labelColor);

        noteArea.setFont(textFont);
        noteArea.setLineWrap(true);
        noteArea.setWrapStyleWord(true);

        JScrollPane noteScrollPane = new JScrollPane(noteArea);
        noteScrollPane.setBounds(startX + labelWidth, row4Y, fieldWidth * 2 + horizontalGap + labelWidth, height * 3);
        styleScrollPane(noteScrollPane, borderColor);

        //! Add Prescription Button
        int buttonY = row4Y + (height * 3) + 20;
        addPrescriptionButton.setBounds(startX + (3*labelWidth)-50, buttonY , 150, height);
        addPrescriptionButton.setFont(labelFont);
        addPrescriptionButton.setBackground(buttonColor);
        addPrescriptionButton.setForeground(Color.WHITE);
        addPrescriptionButton.setFocusPainted(false);
        addPrescriptionButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        addPrescriptionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addPrescriptionButton.addActionListener(this);

        //! Add hover effect
        addPrescriptionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addPrescriptionButton.setBackground(buttonColor.darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                addPrescriptionButton.setBackground(buttonColor);
            }
        });

        mainPanel.add(diseaseLabel);
        mainPanel.add(diseaseField);
        mainPanel.add(testLabel);
        mainPanel.add(testField);
        mainPanel.add(testCostLabel);
        mainPanel.add(testCostField);
        mainPanel.add(medicineLabel);
        mainPanel.add(medicineField);
        mainPanel.add(medicineCostLabel);
        mainPanel.add(medicineCostField);
        mainPanel.add(noteLabel);
        mainPanel.add(noteScrollPane);
        mainPanel.add(addPrescriptionButton);

        lower_panel.add(mainPanel, BorderLayout.CENTER);
        
        return lower_panel;
    }

        private void styleTextField(JTextField field, Color borderColor) {
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(borderColor),
            BorderFactory.createEmptyBorder(2, 5, 2, 5)
        ));
    }

    private void styleScrollPane(JScrollPane scrollPane, Color borderColor) {
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(borderColor),
            BorderFactory.createEmptyBorder(2, 5, 2, 5)
        ));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == addPrescriptionButton) {
            String disease = diseaseField.getText();
            String testName = testField.getText();
            String testCost = testCostField.getText();
            String medicine = medicineField.getText();
            String medicineCost = medicineCostField.getText();
            String note = noteArea.getText();

            if (disease.isEmpty() || testName.isEmpty() || testCost.isEmpty() || medicine.isEmpty() || medicineCost.isEmpty() || note.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
                return;
            }

            try {
                double testCostDouble = Double.parseDouble(testCost);
                double medicineCostDouble = Double.parseDouble(medicineCost);

                if (testCostDouble <= 0 || medicineCostDouble <= 0) {
                    throw new NumberFormatException();
                }

                HashMap<String, String> healthRecord = new HashMap<>();
                healthRecord.put("Date", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                healthRecord.put("doctorName", name);
                healthRecord.put("tests", testName);
                healthRecord.put("diseases", disease);
                healthRecord.put("medicine", medicine);
                healthRecord.put("doctorNote", note);

                try {
                    User.addHealthRecord("/data/users/" + patientUsername + ".txt", healthRecord);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                HashMap<String, Double> bills = new HashMap<>();
                bills.put("testCost", Double.parseDouble(testCost));
                bills.put("medicineCost", Double.parseDouble(medicineCost));
                try {
                    User.addBills(patientUsername, bills, false);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Prescription added successfully.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for test cost and medicine cost.");
            }
        }
    }

    public static void main(String[] args) {
        new DoctorAddPrescripitionsPage("Doctor2", "emiko");
    }

}
