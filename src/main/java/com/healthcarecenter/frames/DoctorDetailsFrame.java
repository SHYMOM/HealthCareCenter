package com.healthcarecenter.frames;

import com.healthcarecenter.utils.GetDoctorData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsFrame extends JFrame {

    private JTable doctorsTable;
    private DefaultTableModel tableModel;

    public DoctorDetailsFrame() {
        // Set up the JFrame
        setTitle("Doctor Details");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel for the table and button
        JPanel panel = new JPanel(new BorderLayout());

        // Table model for displaying doctor details
        tableModel = new DefaultTableModel(new String[]{
                "Full Name", "Username", "Specialization", "Contact Number", "Consultation Fee"
        }, 0);

        // Load doctor data into the table
        loadDoctorData();

        // Create the table and add it to a scroll pane
        doctorsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(doctorsTable);

        // Add scroll pane to the panel
        panel.add(scrollPane, BorderLayout.CENTER);

        // Create a button to get selected doctor details
        JButton getDetailsButton = new JButton("Get Details");
        getDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printSelectedDoctorDetails();
            }
        });

        // Add button to the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(getDetailsButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add panel to the frame
        add(panel);

        setVisible(true);
    }

    private void loadDoctorData() {
        // Get all doctors' details
        ArrayList<HashMap<String, String>> allDoctors = GetDoctorData.getAllDoctorsDetails();

        // Add each doctor's details as a row in the table
        for (HashMap<String, String> doctor : allDoctors) {
            System.out.println(doctor);
            tableModel.addRow(new Object[]{
                    doctor.get("fullName"),
                    doctor.get("username"),
                    doctor.get("specialization"),
                    doctor.get("contactNumber"),
                    doctor.get("consultationFee")
            });
        }
    }

    private void printSelectedDoctorDetails() {
        int selectedRow = doctorsTable.getSelectedRow();

        if (selectedRow >= 0) {
            StringBuilder doctorDetails = new StringBuilder("Doctor Details:\n");
            for (int col = 0; col < doctorsTable.getColumnCount(); col++) {
                String columnName = doctorsTable.getColumnName(col);
                Object value = doctorsTable.getValueAt(selectedRow, col);
                doctorDetails.append(columnName).append(": ").append(value).append("\n");
            }
            // Print the selected doctor's details
            System.out.println(doctorDetails);
            JOptionPane.showMessageDialog(this, doctorDetails.toString(), "Doctor Details", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a doctor from the table!", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new DoctorDetailsFrame();
    }
}
