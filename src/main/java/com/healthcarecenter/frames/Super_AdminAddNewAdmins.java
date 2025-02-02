package com.healthcarecenter.frames;

import com.healthcarecenter.utils.FileUtils;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Super_AdminAddNewAdmins extends JFrame implements ActionListener {
    private final JPanel fullNamePanel = new JPanel();
    private final JPanel usernamePanel = new JPanel();
    private final JPanel agePanel = new JPanel();
    private final JPanel genderPanel = new JPanel();
    private final JPanel numberPanel = new JPanel();
    private final JPanel bloodPanel = new JPanel();
    private final JPanel emailPanel = new JPanel();
    private final JPanel passPanel = new JPanel();
    private final JPanel addressPanel = new JPanel();
    private final JPanel salaryPanel = new JPanel();
    private final JCheckBox termsAndConditionsCheckBox = new JCheckBox("I agree to the ");
    private final JButton signUp = new JButton();

    private static final Color PRIMARY_COLOR = new Color(41, 128, 185);
    private static final Color SECONDARY_COLOR = new Color(52, 152, 219);
    private static final Color BACKGROUND_COLOR = new Color(236, 240, 241);
    private static final Color TEXT_COLOR = new Color(44, 62, 80);
    private static final Color ACCENT_COLOR = new Color(46, 204, 113);

    public Super_AdminAddNewAdmins() {
        adminUI();
    }

    private void adminUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(createLeftPanel(), BorderLayout.WEST);
        mainPanel.add(createScrollableRightPanel(), BorderLayout.CENTER);

        ImageIcon appIcon = new ImageIcon(FileUtils.getFile("/Icons/appIcon.png").getAbsolutePath());
        
        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.setTitle("Healthcare Center - New Admin Registration");
        this.setMinimumSize(new Dimension(900, 600));
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
        this.setVisible(true);
    }

    private JPanel createLeftPanel() {
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setPreferredSize(new Dimension(350, 700));
        leftPanel.setBackground(PRIMARY_COLOR);

        JLabel welcomeLabel = new JLabel("Healthcare Center");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setBounds(25, 50, 300, 40);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        
        JLabel subLabel = new JLabel("Admin Registration Portal");
        subLabel.setHorizontalAlignment(JLabel.CENTER);
        subLabel.setBounds(25, 100, 300, 30);
        subLabel.setForeground(Color.WHITE);
        subLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        JPanel decorPanel = new JPanel();
        decorPanel.setBounds(50, 160, 250, 4);
        decorPanel.setBackground(ACCENT_COLOR);

        leftPanel.add(welcomeLabel);
        leftPanel.add(subLabel);
        leftPanel.add(decorPanel);
        return leftPanel;
    }

    private JScrollPane createScrollableRightPanel() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(BACKGROUND_COLOR);
        contentPanel.setPreferredSize(new Dimension(650, 900));

        JLabel headerLabel = new JLabel("Register New Admin");
        headerLabel.setHorizontalAlignment(JLabel.LEFT);
        headerLabel.setBounds(50, 30, 550, 40);
        headerLabel.setForeground(TEXT_COLOR);
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        contentPanel.add(headerLabel);

        contentPanel.add(createFormField("Full Name", new JTextField(), 100));
        contentPanel.add(createFormField("Username", new JTextField(), 175));
        contentPanel.add(createAgeGenderRow(250));
        contentPanel.add(createFormField("Phone Number", new JTextField(), 325));
        
        JComboBox<String> bloodGroupCombo = new JComboBox<>(
            new String[]{"Select Blood Group", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}
        );
        contentPanel.add(createFormField("Blood Group", bloodGroupCombo, 400));
        
        contentPanel.add(createFormField("Email Address", new JTextField(), 475));
        contentPanel.add(createFormField("Password", new JPasswordField(), 550));
        contentPanel.add(createFormField("Address", new JTextField(), 625));
        contentPanel.add(createFormField("Salary (Monthly)", new JTextField(), 700));

        JPanel termsPanel = new JPanel();
        termsPanel.setBounds(50, 775, 550, 30);
        termsPanel.setLayout(null);
        termsPanel.setBackground(BACKGROUND_COLOR);

        termsAndConditionsCheckBox.setBounds(0, 0, 115, 30);
        termsAndConditionsCheckBox.setForeground(TEXT_COLOR);
        termsAndConditionsCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        termsAndConditionsCheckBox.setBackground(BACKGROUND_COLOR);
        termsAndConditionsCheckBox.setFocusPainted(false);
        termsAndConditionsCheckBox.addActionListener(this);

        JLabel termsLabel = new JLabel("terms and conditions");
        termsLabel.setForeground(SECONDARY_COLOR);
        termsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        termsLabel.setBounds(116, 0, 400, 30);
        termsLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        termsPanel.add(termsAndConditionsCheckBox);
        termsPanel.add(termsLabel);

        signUp.setText("Register");
        signUp.setBounds(50, 825, 550, 40);
        signUp.addActionListener(this);
        signUp.setEnabled(false);
        styleButton(signUp);

        contentPanel.add(termsPanel);
        contentPanel.add(signUp);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        return scrollPane;
    }

    private JPanel createAgeGenderRow(int y) {
        JPanel rowPanel = new JPanel();
        rowPanel.setLayout(null);
        rowPanel.setBounds(50, y, 550, 65);
        rowPanel.setBackground(BACKGROUND_COLOR);

        JPanel agePanel = new JPanel();
        agePanel.setLayout(null);
        agePanel.setBounds(0, 0, 260, 65);
        agePanel.setBackground(BACKGROUND_COLOR);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(0, 0, 260, 25);
        ageLabel.setForeground(TEXT_COLOR);
        ageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JTextField ageField = new JTextField();
        ageField.setBounds(0, 30, 260, 35);
        styleTextField(ageField);

        agePanel.add(ageLabel);
        agePanel.add(ageField);

        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(null);
        genderPanel.setBounds(290, 0, 260, 65);
        genderPanel.setBackground(BACKGROUND_COLOR);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(0, 0, 260, 25);
        genderLabel.setForeground(TEXT_COLOR);
        genderLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JComboBox<String> genderComboBox = new JComboBox<>(
            new String[]{"Select Gender", "Male", "Female", "Other"}
        );
        genderComboBox.setBounds(0, 30, 260, 35);
        styleComboBox(genderComboBox);

        genderPanel.add(genderLabel);
        genderPanel.add(genderComboBox);

        rowPanel.add(agePanel);
        rowPanel.add(genderPanel);

        return rowPanel;
    }

    private JPanel createFormField(String labelText, JComponent field, int y) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(50, y, 550, 65);
        panel.setBackground(BACKGROUND_COLOR);
        panel.setBorder(BorderFactory.createEmptyBorder());

        JLabel label = new JLabel(labelText);
        label.setBounds(0, 0, 550, 25);
        label.setForeground(TEXT_COLOR);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        field.setBounds(0, 30, 550, 35);
        if (field instanceof JTextField) {
            styleTextField((JTextField) field);
        } else if (field instanceof JComboBox) {
            styleComboBox((JComboBox<?>) field);
        }

        panel.add(label);
        panel.add(field);
        return panel;
    }

    private void styleTextField(JTextField field) {
        field.setBackground(Color.WHITE);
        field.setForeground(TEXT_COLOR);
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(SECONDARY_COLOR, 1),
            BorderFactory.createEmptyBorder(0, 10, 0, 10)
        ));
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                field.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(PRIMARY_COLOR, 2),
                    BorderFactory.createEmptyBorder(0, 10, 0, 10)
                ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                field.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(SECONDARY_COLOR, 1),
                    BorderFactory.createEmptyBorder(0, 10, 0, 10)
                ));
            }
        });
    }

    private void styleComboBox(JComboBox<?> comboBox) {
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(TEXT_COLOR);
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboBox.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(SECONDARY_COLOR, 1),
            BorderFactory.createEmptyBorder(0, 5, 0, 5)
        ));
        
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, 
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setPreferredSize(new Dimension(260, 35));
                setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
                if (isSelected) {
                    setBackground(PRIMARY_COLOR);
                    setForeground(Color.WHITE);
                } else {
                    setBackground(Color.WHITE);
                    setForeground(TEXT_COLOR);
                }
                return this;
            }
        });
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
        if (e.getSource() == termsAndConditionsCheckBox) {
            signUp.setEnabled(termsAndConditionsCheckBox.isSelected());
        }
        else if (e.getSource() == signUp) {
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new Super_AdminAddNewAdmins();
    }
}