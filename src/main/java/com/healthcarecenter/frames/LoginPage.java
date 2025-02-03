package com.healthcarecenter.frames;

import com.healthcarecenter.utils.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class LoginPage extends JFrame implements ActionListener {

    private final JButton login;
    private final JButton signUp;
    private final JTextField email;
    private final JPasswordField password;
    private final String userRole;
    private static final Color PRIMARY_COLOR = new Color(0, 128, 128); // Teal
    private static final Color ACCENT_COLOR = new Color(144, 238, 144); // Light green
    private static final Color TEXT_COLOR = new Color(248, 248, 255); // White smoke
    private static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 28);
    private static final Font REGULAR_FONT = new Font("Segoe UI", Font.PLAIN, 14);

    public LoginPage(String userRole) {
        this.userRole = userRole;
        
        login = createStyledButton("Login", PRIMARY_COLOR, TEXT_COLOR);
        signUp = createStyledButton("Sign Up", ACCENT_COLOR, PRIMARY_COLOR);
        email = createStyledTextField();
        password = createStyledPasswordField();
        
        initializeFrame();
    }

    private void initializeFrame() {
        ImageIcon appIcon = new ImageIcon(FileUtils.getFile("/Icons/appIcon.png").getAbsolutePath());
        setIconImage(appIcon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setTitle("Healthcare Center - Login");
        setResizable(false);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gradient = new GradientPaint(0, 0, PRIMARY_COLOR, getWidth(), getHeight(), ACCENT_COLOR.darker());
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(new GridBagLayout());

        JPanel contentPanel = createContentPanel();
        mainPanel.add(contentPanel);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createContentPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255, 240));
        panel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(255, 255, 255, 100), 1),
            BorderFactory.createEmptyBorder(30, 40, 30, 40)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 15, 0);

        //! Welcome message
        JLabel welcomeLabel = new JLabel("Welcome to Healthcare Center", SwingConstants.CENTER);
        welcomeLabel.setFont(TITLE_FONT);
        welcomeLabel.setForeground(PRIMARY_COLOR);
        panel.add(welcomeLabel, gbc);

        //! Role indicator
        JLabel roleLabel = new JLabel("Login as " + userRole, SwingConstants.CENTER);
        roleLabel.setFont(REGULAR_FONT);
        roleLabel.setForeground(PRIMARY_COLOR.darker());
        panel.add(roleLabel, gbc);

        //! Add some spacing
        gbc.insets = new Insets(20, 0, 5, 0);

        //! Email field with icon
        JPanel emailPanel = createInputPanel("Email", email, "/Icons/email_icon.png");
        panel.add(emailPanel, gbc);

        //! Password field with icon
        JPanel passwordPanel = createInputPanel("Password", password, "/Icons/password_icon.png");
        panel.add(passwordPanel, gbc);

        //! Forgot password link
        JLabel forgotPassword = createClickableLabel("Forgot Password?");
        forgotPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new ForgetPasswordPage(userRole);
            }
        });
        gbc.insets = new Insets(5, 0, 20, 0);
        panel.add(forgotPassword, gbc);

        //! Buttons panel
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setOpaque(false);
        
        if (userRole.equals("User")) {
            buttonsPanel.add(signUp);
        }
        buttonsPanel.add(login);
        
        gbc.fill = GridBagConstraints.NONE;
        panel.add(buttonsPanel, gbc);

        return panel;
    }

    private JPanel createInputPanel(String labelText, JComponent input, String iconPath) {
        JPanel panel = new JPanel(new BorderLayout(10, 0));
        panel.setOpaque(false);
        
        if (iconPath != null) {
            try {
                ImageIcon icon = new ImageIcon(FileUtils.getFile(iconPath).getAbsolutePath());
                Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                JLabel iconLabel = new JLabel(new ImageIcon(img));
                iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
                panel.add(iconLabel, BorderLayout.WEST);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        JLabel label = new JLabel(labelText);
        label.setFont(REGULAR_FONT);
        label.setForeground(PRIMARY_COLOR);
        
        JPanel inputWrapper = new JPanel(new BorderLayout());
        inputWrapper.setOpaque(false);
        inputWrapper.add(label, BorderLayout.NORTH);
        inputWrapper.add(input, BorderLayout.CENTER);
        
        panel.add(inputWrapper, BorderLayout.CENTER);
        return panel;
    }

    private JButton createStyledButton(String text, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(fgColor);
        button.setBackground(bgColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(120, 40));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(this);
        
        //! Hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(bgColor.darker());
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });
        
        return button;
    }

    private JTextField createStyledTextField() {
        JTextField field = new JTextField();
        field.setFont(REGULAR_FONT);
        field.setPreferredSize(new Dimension(250, 30));
        field.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(PRIMARY_COLOR.brighter(), 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return field;
    }

    private JPasswordField createStyledPasswordField() {
        JPasswordField field = new JPasswordField();
        field.setFont(REGULAR_FONT);
        field.setPreferredSize(new Dimension(250, 30));
        field.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(PRIMARY_COLOR.brighter(), 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return field;
    }

    private JLabel createClickableLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(REGULAR_FONT);
        label.setForeground(PRIMARY_COLOR);
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //! Hover effect
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setForeground(PRIMARY_COLOR.darker());
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(PRIMARY_COLOR);
            }
        });
        
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            handleLogin();
        } else if (e.getSource() == signUp) {
            new UserSignUp("Add","");
            this.dispose();
        }
    }

    private void handleLogin() {
        All_Validations checkValidations = new All_Validations();
        String emailText = email.getText();
        String passwordText = new String(password.getPassword());

        if (emailText.isEmpty() || passwordText.isEmpty()) {
            showError("Please fill in all fields");
        }
        else if (!checkValidations.isValidEmail(emailText)) {
            showError("Invalid email format");
        }
        else if (!checkValidations.isValidPassword(passwordText)) {
            showError("Password must be at least 6 characters long");
        }
        else{
            if(GetSuperAdminData.isSuperAdminEmail(email.getText()) && GetSuperAdminData.getSuperAdminPassword(email.getText()).equals(password.getText())){
                new SuperAdminHomePage("email");
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
                    if(!checkValidations.isEmailRegistered(email.getText(),"/data/admins/" )){
                        JOptionPane.showMessageDialog(null, "Email Not Registered", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        if(checkValidations.isUserRegistered(email.getText(), password.getText(), "/data/admins/")){
                            this.dispose();
                            new AdminHomePage(email.getText(), false);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                else if(userRole.equals("Doctor")){
                    if(!checkValidations.isEmailRegistered(email.getText(),"/data/doctors/" )){
                        JOptionPane.showMessageDialog(null, "Email Not Registered", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        if(checkValidations.isUserRegistered(email.getText(), password.getText(), "/data/doctors/")){
                            this.dispose();
                            new DoctorHomePage(email.getText(), false);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(
            this,
            message,
            "Error",
            JOptionPane.ERROR_MESSAGE
        );
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new LoginPage("User"));
    }
}