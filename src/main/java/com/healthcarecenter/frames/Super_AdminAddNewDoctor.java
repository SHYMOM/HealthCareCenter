package com.healthcarecenter.frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.healthcarecenter.utils.*;
import com.healthcarecenter.models.Doctor;
import com.healthcarecenter.frames.dialogs.*;
import com.healthcarecenter.frames.LoginPage;

public class Super_AdminAddNewDoctor extends JFrame implements ActionListener {
    private final JButton registerButton = new JButton();
    private final JTextField name = new JTextField();
    private final JTextField username = new JTextField();
    private final JTextField age = new JTextField();
    private final JComboBox<String> genderComboBox = new JComboBox<>(new String[]{" Male", " Female", " Others"});
    private final JTextField number = new JTextField();
    private final String[] bloodGroupOptions = {"  A+", "  A-", "  B+", "  B-", " AB+", " AB-", "  O+", "  O-"};
    private final JComboBox<String> bloodComboBox = new JComboBox<>(bloodGroupOptions);
    private final JTextField email = new JTextField();
    private final JTextField password = new JTextField();
    private final JTextField address = new JTextField();
    private final JTextField specialization = new JTextField();
    private final JTextField qualification = new JTextField();
    private final JTextField licenseNumber = new JTextField();
    private final JTextField salary = new JTextField();
    private String daysAvailable = "";
    private String consultingTime = "";
    private final JTextField fee = new JTextField();
    private final JCheckBox termsAndConditionsCheckBox = new JCheckBox("I agree to the ");

    private String EditMode;
    private String editorRole;
    private JFrame parentFrame;

    private static final Color PRIMARY_COLOR = new Color(41, 128, 185);
    private static final Color SECONDARY_COLOR = new Color(52, 152, 219);
    private static final Color BACKGROUND_COLOR = new Color(236, 240, 241);
    private static final Color TEXT_COLOR = new Color(44, 62, 80);
    private static final Color ACCENT_COLOR = new Color(46, 204, 113);

    public Super_AdminAddNewDoctor(JFrame parentFrame, String EditMode, String username, String editorRole) {
        this.parentFrame = parentFrame;
        if (EditMode.equals("Edit")) {
            this.EditMode = EditMode;
            this.editorRole = editorRole;
            registerButton.setText("Save Changes");
            this.username.setEditable(false);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            loadDoctorData(username);
        }
        else if (EditMode.equals("Add")) {
            this.EditMode = EditMode;
            this.editorRole = editorRole;
            registerButton.setText("Register Doctor");
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        setupUI();
    }

    private void loadDoctorData(String username) {
        HashMap<String, String> doctorData = GetDoctorData.getDoctorDetails(username);
        name.setText(doctorData.get("fullName"));
        this.username.setText(doctorData.get("username"));
        age.setText(doctorData.get("age"));
        genderComboBox.setSelectedItem(doctorData.get("gender"));
        number.setText(doctorData.get("contactNumber"));
        bloodComboBox.setSelectedItem(doctorData.get("bloodGroup"));
        email.setText(doctorData.get("email"));
        password.setText(GetDoctorData.getFieldValue(username, "password"));
        address.setText(doctorData.get("address"));
        specialization.setText(doctorData.get("specialization"));
        qualification.setText(doctorData.get("qualifications"));
        licenseNumber.setText(doctorData.get("medicalLicenseNumber"));
        daysAvailable = doctorData.get("daysAvailable");
        consultingTime = doctorData.get("consultationHours");
        fee.setText(doctorData.get("consultationFee"));
        salary.setText(doctorData.get("salary"));
    }

    private void setupUI() {
        setTitle("Doctor Registration - Health Care Center");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);


        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth(), h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, PRIMARY_COLOR, w, h, SECONDARY_COLOR);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(createHeaderPanel(), BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(createFormPanel());
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setOpaque(false);
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Doctor Registration Form");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        return headerPanel;
    }

    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(BACKGROUND_COLOR);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formPanel.add(createPersonalInfoSection());
        formPanel.add(Box.createVerticalStrut(20));
        formPanel.add(createContactInfoSection());
        formPanel.add(Box.createVerticalStrut(20));
        formPanel.add(createProfessionalInfoSection());
        formPanel.add(Box.createVerticalStrut(20));
        formPanel.add(createAvailabilitySection());
        formPanel.add(Box.createVerticalStrut(20));
        formPanel.add(createSubmitSection());

        return formPanel;
    }

    private JPanel createFormSection(String title) {
        JPanel section = new JPanel();
        section.setLayout(new BoxLayout(section, BoxLayout.Y_AXIS));
        section.setBackground(Color.WHITE);
        section.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR, 1),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(PRIMARY_COLOR);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        section.add(titleLabel);
        section.add(Box.createVerticalStrut(10));

        return section;
    }

    private JPanel createPersonalInfoSection() {
        JPanel section = createFormSection("Personal Information");
        
        JPanel grid = new JPanel(new GridLayout(0, 2, 10, 10));
        grid.setOpaque(false);

        grid.add(createFormField("Full Name", name));
        grid.add(createFormField("Username", username));
        grid.add(createFormField("Age", age));
        grid.add(createFormField("Gender", genderComboBox));
        grid.add(createFormField("Blood Group", bloodComboBox));

        section.add(grid);
        return section;
    }

    private JPanel createContactInfoSection() {
        JPanel section = createFormSection("Contact Information");
        
        JPanel grid = new JPanel(new GridLayout(0, 2, 10, 10));
        grid.setOpaque(false);

        grid.add(createFormField("Phone Number", number));
        grid.add(createFormField("Email", email));
        grid.add(createFormField("Address", address));
        grid.add(createFormField("Password", password));

        section.add(grid);
        return section;
    }

    private JPanel createProfessionalInfoSection() {
        JPanel section = createFormSection("Professional Information");
        
        JPanel grid = new JPanel(new GridLayout(0, 2, 10, 10));
        grid.setOpaque(false);

        grid.add(createFormField("Specialization", specialization));
        grid.add(createFormField("Qualification", qualification));
        grid.add(createFormField("License Number", licenseNumber));
        grid.add(createFormField("Salary", salary));

        section.add(grid);
        return section;
    }

    private JPanel createAvailabilitySection() {
        JPanel section = createFormSection("Availability & Fees");
        
        JPanel grid = new JPanel(new GridLayout(0, 2, 10, 10));
        grid.setOpaque(false);

        // Create consulting hours button
        JButton consultingHoursBtn = createStyledButton("Select Consulting Hours");
        consultingHoursBtn.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(consultingHoursBtn);
            consultingTime = ConsultingTimeSelect.setTimePickerDialog(frame);
        });

        // Create days available button
        JButton daysAvailableBtn = createStyledButton("Select Available Days");
        daysAvailableBtn.addActionListener(new ActionListener() {
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

        grid.add(createFormField("Consulting Hours", consultingHoursBtn));
        grid.add(createFormField("Days Available", daysAvailableBtn));
        grid.add(createFormField("Consultation Fee", fee));

        section.add(grid);
        return section;
    }

    private JPanel createSubmitSection() {
        JPanel section = new JPanel();
        section.setLayout(new BoxLayout(section, BoxLayout.Y_AXIS));
        section.setBackground(Color.WHITE);
        section.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Terms and conditions panel
        JPanel termsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        termsPanel.setOpaque(false);
        
        termsAndConditionsCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        termsPanel.add(termsAndConditionsCheckBox);

        JLabel termsLabel = new JLabel("terms and conditions");
        termsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        termsLabel.setForeground(PRIMARY_COLOR);
        termsLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        termsLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new TermsAndConditionsFrame();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                termsLabel.setForeground(ACCENT_COLOR);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                termsLabel.setForeground(PRIMARY_COLOR);
            }
        });
        termsPanel.add(termsLabel);

        styleButton(registerButton);
        registerButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.add(registerButton);

        section.add(termsPanel);
        section.add(Box.createVerticalStrut(20));
        section.add(buttonPanel);

        return section;
    }

    private JPanel createFormField(String labelText, JComponent field) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setForeground(TEXT_COLOR);

        styleFormComponent(field);

        panel.add(label);
        panel.add(Box.createVerticalStrut(5));
        panel.add(field);

        return panel;
    }

    private void styleFormComponent(JComponent component) {
        component.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        if (component instanceof JTextField) {
            component.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(PRIMARY_COLOR),
                BorderFactory.createEmptyBorder(8, 10, 8, 10)
            ));
        } else if (component instanceof JComboBox) {
            component.setBackground(Color.WHITE);
            ((JComboBox<?>) component).setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, 
                        int index, boolean isSelected, boolean cellHasFocus) {
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                    return this;
                }
            });
        }
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        styleButton(button);
        return button;
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(ACCENT_COLOR);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(ACCENT_COLOR.darker());
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(ACCENT_COLOR);
            }
        });
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
                if(EditMode.equals("Add")){
                    Doctor doctor = new Doctor(name.getText(), username.getText(), age.getText(), email.getText(), number.getText(), address.getText(), password.getText(), genderComboBox.getSelectedItem().toString(), bloodComboBox.getSelectedItem().toString(), specialization.getText(), qualification.getText(), licenseNumber.getText(), consultingTime, daysAvailable, Double.parseDouble(fee.getText()), Double.parseDouble(salary.getText()));
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                    doctor.saveToFile(frame);
                }
                else if(EditMode.equals("Edit")){
                    Doctor.setName(username.getText(), name.getText());
                    Doctor.setAge(username.getText(), age.getText());
                    Doctor.setEmail(username.getText(), email.getText());
                    Doctor.setContactNumber(username.getText(), number.getText());
                    Doctor.setAddress(username.getText(), address.getText());
                    Doctor.setPassword(username.getText(), password.getText());
                    Doctor.setGender(username.getText(), genderComboBox.getSelectedItem().toString());
                    Doctor.setBloodGroup(username.getText(), bloodComboBox.getSelectedItem().toString());
                    Doctor.setSpecialization(username.getText(), specialization.getText());
                    Doctor.setQualifications(username.getText(), qualification.getText());
                    Doctor.setMedicalLicenseNumber(username.getText(), licenseNumber.getText());
                    Doctor.setConsultationHours(username.getText(), consultingTime);
                    Doctor.setDaysAvailable(username.getText(), daysAvailable);
                    Doctor.setConsultationFee(username.getText(), Double.parseDouble(fee.getText()));
                    Doctor.setSalary(username.getText(), Double.parseDouble(salary.getText()));
                    if (editorRole.equals("Super Admin") || editorRole.equals("Admin")) {
                        this.dispose();
                    } else if (editorRole.equals("Doctor")) {
                        new LoginPage("Doctor");
                        this.dispose();
                        if (parentFrame != null) {
                            parentFrame.dispose();
                        }
                    }
                }
                
            }
        }
    }

    public static void main(String[] args) {
        new Super_AdminAddNewDoctor(null,"Edit","Doctor2","Admin");
    }
}