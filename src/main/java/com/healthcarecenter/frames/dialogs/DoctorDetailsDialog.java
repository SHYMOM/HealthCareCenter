package com.healthcarecenter.frames.dialogs;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsDialog {
    private static JPanel mainPanel;
    private static JDialog dialog;
    private static final Color PRIMARY_COLOR = new Color(51, 153, 255);
    private static final Color SECONDARY_COLOR = new Color(240, 240, 240);
    private static final Font HEADER_FONT = new Font("Arial", Font.BOLD, 16);
    private static final Font LABEL_FONT = new Font("Arial", Font.BOLD, 12);
    private static final Font VALUE_FONT = new Font("Arial", Font.PLAIN, 12);

    private static void initializeDialog(JFrame parentFrame) {
        dialog = new JDialog(parentFrame, "Doctor Details", true);
        dialog.setSize(600, 500);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setResizable(false);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        dialog.setContentPane(mainPanel);
    }

    public static void showDoctorDetails(JFrame parentFrame, HashMap<String, String> doctorData, String viewerType) {
        if (dialog == null || !dialog.isDisplayable()) {
            initializeDialog(parentFrame);
        }
        
        mainPanel.removeAll();

        JPanel headerPanel = createHeaderPanel(doctorData.get("fullName"));
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
        contentPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);

        //! Personal Information section................................................
        addSection(contentPanel, gbc, "Personal Information", new String[][]{
            {"Full Name:", doctorData.get("fullName")},
            {"Email:", doctorData.get("email")},
            {"Contact Number:", doctorData.get("contactNumber")},
            {"Gender:", doctorData.get("gender")},
            {"Address:", doctorData.get("address")}
        });
        
        //! Professional Information section................................
        List<String[]> professionalDetails = new ArrayList<>();
        if (viewerType.equals("Admin")) {
            professionalDetails.add(new String[]{"Role:", doctorData.get("role")});
        }
        professionalDetails.add(new String[]{"Specialization:", doctorData.get("specialization")});
        professionalDetails.add(new String[]{"Qualifications:", doctorData.get("qualifications")});
        professionalDetails.add(new String[]{"Medical License:", doctorData.get("medicalLicenseNumber")});
        
        addSection(contentPanel, gbc, "Professional Information", 
            professionalDetails.toArray(new String[0][])
        );
        
        //! Work Details section
        List<String[]> workDetails = new ArrayList<>();
        workDetails.add(new String[]{"Consultation Hours:", doctorData.get("consultationHours")});
        workDetails.add(new String[]{"Days Available:", doctorData.get("daysAvailable")});
        workDetails.add(new String[]{"Consultation Fee:", "$" + doctorData.get("consultationFee")});
        if (viewerType.equals("Admin")) {
            workDetails.add(new String[]{"Salary:", "$" + doctorData.get("salary")});
        }
        
        addSection(contentPanel, gbc, "Work Details", 
            workDetails.toArray(new String[0][])
        );
        
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        JPanel footerPanel = createFooterPanel();
        mainPanel.add(footerPanel, BorderLayout.SOUTH);
        
        dialog.setVisible(true);
    }

    private static JPanel createHeaderPanel(String doctorName) {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(PRIMARY_COLOR);
        headerPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel nameLabel = new JLabel(doctorName);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setForeground(Color.WHITE);
        headerPanel.add(nameLabel, BorderLayout.CENTER);

        return headerPanel;
    }

    private static void addSection(JPanel panel, GridBagConstraints gbc, String title, String[][] details) {
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        
        JLabel sectionTitle = new JLabel(title);
        sectionTitle.setFont(HEADER_FONT);
        sectionTitle.setForeground(PRIMARY_COLOR);
        sectionTitle.setBorder(new CompoundBorder(
            new MatteBorder(1, 0, 1, 0, PRIMARY_COLOR),
            new EmptyBorder(5, 0, 5, 0)
        ));
        panel.add(sectionTitle, gbc);

        gbc.gridwidth = 1;
        for (String[] detail : details) {
            gbc.gridy++;
            
            gbc.gridx = 0;
            gbc.weightx = 0.3;
            JLabel label = new JLabel(detail[0]);
            label.setFont(LABEL_FONT);
            panel.add(label, gbc);

            gbc.gridx = 1;
            gbc.weightx = 0.7;
            JLabel value = new JLabel(detail[1]);
            value.setFont(VALUE_FONT);
            panel.add(value, gbc);
        }
        
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(Box.createVerticalStrut(20), gbc);
    }

    private static JPanel createFooterPanel() {
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footerPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        JButton closeButton = new JButton("Close");
        closeButton.setPreferredSize(new Dimension(100, 30));
        closeButton.setBackground(PRIMARY_COLOR);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(e -> dialog.dispose());

        footerPanel.add(closeButton);
        return footerPanel;
    }
}