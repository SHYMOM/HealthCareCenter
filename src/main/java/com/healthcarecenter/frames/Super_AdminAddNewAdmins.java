package com.healthcarecenter.frames;

import com.healthcarecenter.models.Admin;
import com.healthcarecenter.utils.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.*;

public class Super_AdminAddNewAdmins extends JFrame implements ActionListener {
    private final JTextField name = new JTextField();
    private final JTextField username = new JTextField();
    private final JTextField age = new JTextField();
    private final JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Select Gender", "Male", "Female", "Other"});
    private final JTextField number = new JTextField();
    private final JComboBox<String> bloodComboBox = new JComboBox<>(new String[]{"Select Blood Group", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"});
    private final JTextField email = new JTextField();
    private final JPasswordField password = new JPasswordField();
    private final JTextField address = new JTextField();
    private final JTextField salary = new JTextField();
    private final JCheckBox termsAndConditionsCheckBox = new JCheckBox("I agree to the ");
    private final JButton registerButton = new JButton("Register Admin");

    private String EditMode;

    private static final Color PRIMARY_COLOR = new Color(41, 128, 185);
    private static final Color SECONDARY_COLOR = new Color(52, 152, 219);
    private static final Color BACKGROUND_COLOR = new Color(236, 240, 241);
    private static final Color TEXT_COLOR = new Color(44, 62, 80);
    private static final Color ACCENT_COLOR = new Color(46, 204, 113);

    public Super_AdminAddNewAdmins(String EditMode, String username) {
        if (EditMode.equals("Edit")) {
            this.EditMode = EditMode;
            registerButton.setText("Save Changes");
            this.username.setEditable(false);
            loadAdminData(username);
        }
        else if (EditMode.equals("Add")) {
            registerButton.setText("Register Admin");
        }
        setupUI();
    }

    private void loadAdminData(String username) {
        try {
            HashMap<String, String> adminData = GetAdminData.getAdminDetails(username);
                name.setText(adminData.get("fullName"));
                this.username.setText(adminData.get("username"));
                age.setText(adminData.get("age"));
                genderComboBox.setSelectedItem(adminData.get("gender"));
                number.setText(adminData.get("contactNumber"));
                bloodComboBox.setSelectedItem(adminData.get("bloodGroup"));
                email.setText(adminData.get("email"));
                password.setText(GetAdminData.getFieldValue(username, "password"));
                address.setText(adminData.get("address"));
                salary.setText(adminData.get("salary"));
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private void setupUI() {
        setTitle("Admin Registration - Health Care Center");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JLabel titleLabel = new JLabel("Admin Registration Form");
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
        grid.add(createFormField("Password", password));
        grid.add(createFormField("Address", address));
        grid.add(createFormField("Salary", salary));

        section.add(grid);
        return section;
    }

    private JPanel createSubmitSection() {
        JPanel section = new JPanel();
        section.setLayout(new BoxLayout(section, BoxLayout.Y_AXIS));
        section.setBackground(Color.WHITE);
        section.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

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
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            All_Validations checkValidations = new All_Validations();
            if (name.getText().isEmpty() || username.getText().isEmpty() || age.getText().isEmpty() || 
                email.getText().isEmpty() || address.getText().isEmpty() || number.getText().isEmpty() || 
                password.getText().isEmpty() || salary.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Fill All The Credentials");
            }
            else if (!checkValidations.isValidName(name.getText())) {
                JOptionPane.showMessageDialog(null, "Name should not contain numbers or special characters", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (!checkValidations.isValidAge(age.getText())) {
                JOptionPane.showMessageDialog(null, "Age should be a positive number", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (!checkValidations.isValidContactNumber(number.getText())) {
                JOptionPane.showMessageDialog(null, "Contact number should be a digit number", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (!checkValidations.isValidEmail(email.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter a valid email address", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (!checkValidations.isValidPassword(password.getText())) {
                JOptionPane.showMessageDialog(null, "Password must be at least 6 characters long", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (!checkValidations.isValidAmount(salary.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter a valid salary amount", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (!termsAndConditionsCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please agree to the terms and conditions", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (genderComboBox.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Please select a gender", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (bloodComboBox.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Please select a blood group", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                if(EditMode.equals("Add")){
                    Admin admin = new Admin(
                    name.getText(),
                    username.getText(),
                    age.getText(),
                    address.getText(),
                    bloodComboBox.getSelectedItem().toString(),
                    email.getText(),
                    number.getText(), 
                    password.getText(),
                    genderComboBox.getSelectedItem().toString(),  
                    Double.parseDouble(salary.getText())
                );
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                    admin.saveToFile(frame);
                }
                else if(EditMode.equals("Edit")){
                    try {
                        Admin.setName(username.getText(), name.getText());
                        Admin.setAge(username.getText(), age.getText());
                        Admin.setAddress(username.getText(), address.getText());
                        Admin.setBloodGroup(username.getText(), bloodComboBox.getSelectedItem().toString());
                        Admin.setEmail(username.getText(), email.getText());
                        Admin.setContactNumber(username.getText(), number.getText());
                        Admin.setPassword(username.getText(), password.getText());
                        Admin.setGender(username.getText(), genderComboBox.getSelectedItem().toString());
                        Admin.setSalary(username.getText(), salary.getText());
                        
                        new LoginPage("Admin");
                        this.dispose();
                    } catch (IOException ex) {
                    }

                }
                }
            }
        }
    

    public static void main(String[] args) {
        new Super_AdminAddNewAdmins("Edit","Admin_UserName");
    }

}