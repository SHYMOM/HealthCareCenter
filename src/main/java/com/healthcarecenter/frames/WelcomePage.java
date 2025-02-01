package com.healthcarecenter.frames;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import com.healthcarecenter.utils.FileUtils;

public class WelcomePage extends JFrame implements ActionListener {
    private static final Color PRIMARY_COLOR = new Color(41, 128, 185);
    private static final Color SECONDARY_COLOR = new Color(236, 240, 241);
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    private static final Color TEXT_COLOR = new Color(44, 62, 80);
    
    private JLabel label, title;
    private JButton patient, doctor, admin;
    private JPanel mainPanel, buttonPanel;

    public WelcomePage() {
        setupFrame();
        initializeComponents();
        layoutComponents();
    }

    private void setupFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Health Care Center");
        this.setResizable(false);
        ImageIcon appIcon = new ImageIcon(FileUtils.getFile("/Icons/appIcon.png").getAbsolutePath());
        this.setIconImage(appIcon.getImage());
        this.getContentPane().setBackground(BACKGROUND_COLOR);
    }

    private void initializeComponents() {
        //! Main Panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(30, 40, 30, 40));

        //! Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(PRIMARY_COLOR);
        headerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        //! Welcome Label
        label = new JLabel("Welcome To Health Care Center");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        headerPanel.add(label, BorderLayout.CENTER);

        //! Title
        title = new JLabel("Please select your role");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(TEXT_COLOR);
        title.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        
        //! Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 0, 20));
        buttonPanel.setBackground(BACKGROUND_COLOR);
        buttonPanel.setBorder(new EmptyBorder(20, 40, 20, 40));

        //! Buttons
        patient = createStyledButton("I Am A Patient", new ImageIcon(FileUtils.getFile("/Icons/patient.png").getAbsolutePath()));
        doctor = createStyledButton("I Am A Doctor", new ImageIcon(FileUtils.getFile("/Icons/doctor.png").getAbsolutePath()));
        admin = createStyledButton("I Am An Admin", new ImageIcon(FileUtils.getFile("/Icons/admin.png").getAbsolutePath()));

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(title, BorderLayout.CENTER);
    }

    private JButton createStyledButton(String text, ImageIcon icon) {
        JButton button = new JButton(text);
        if (icon != null) {
            Image img = icon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(img));
        }
        button.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button.setForeground(TEXT_COLOR);
        button.setBackground(SECONDARY_COLOR);
        button.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(PRIMARY_COLOR, 1, true),
            new EmptyBorder(10, 15, 10, 15)
        ));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //! Hover effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(PRIMARY_COLOR);
                button.setForeground(Color.WHITE);
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(SECONDARY_COLOR);
                button.setForeground(TEXT_COLOR);
            }
        });
        
        button.addActionListener(this);
        return button;
    }

    private void layoutComponents() {
        buttonPanel.add(patient);
        buttonPanel.add(doctor);
        buttonPanel.add(admin);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == patient) {
            this.dispose();
            new LoginPage("User");
        }
        else if(e.getSource() == doctor) {
            new LoginPage("Doctor");
            this.dispose();
        }
        else if(e.getSource() == admin) {
            new LoginPage("Admin");
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new WelcomePage();
    }
}