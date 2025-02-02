package com.healthcarecenter.models;

import com.healthcarecenter.frames.UserSignUp;
import com.healthcarecenter.frames.UserHomePage;
import com.healthcarecenter.frames.LoginPage;
import com.healthcarecenter.utils.FileUtils;
import com.healthcarecenter.utils.GetUserData;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class User extends GetUserData {
    private String name;
    private String username;
    private int age;
    private String email;
    private String address;
    private String contactNumber;
    private String password;
    private String bloodGroup;
    private String gender;
    private boolean isDonor = false;
    private final String role = "User";

    private final Map<String, Double> bills = new HashMap<>();

    public User(String name, String username, int age, String email, String address, String contactNumber, String password, String bloodGroup, String gender) {
        this.name = name;
        this.username = username;
        this.age = age;
        this.email = email;
        this.address = address;
        this.contactNumber = contactNumber;
        this.password = password;
        this.bloodGroup = bloodGroup;
        this.gender = gender;

        bills.put("appointmentCost", 0.0);
        bills.put("medicineCost", 0.0);
        bills.put("testCost", 0.0);
        bills.put("otherCost", 0.0);
    }

    public void saveToFile(JFrame frame) {
    
    String filePath = "/data/users/"+username+".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileUtils.getFile(filePath)))) {
            writer.write("<<<User-Start>>>\n");
            writer.write("[User]\n");
            writer.write("name=" + name + "\n");
            writer.write("username=" + username + "\n");
            writer.write("age=" + age + "\n");
            writer.write("email=" + email + "\n");
            writer.write("address=" + address + "\n");
            writer.write("contactNumber=" + contactNumber + "\n");
            writer.write("password=" + password + "\n");
            writer.write("bloodGroup=" + bloodGroup + "\n");
            writer.write("gender=" + gender + "\n");
            writer.write("role=" + role + "\n");
            writer.write("isDonor=" + isDonor + "\n");
            writer.write("<<<User-End>>>\n\n");

            writer.write("[Bills]\n");
            for (Map.Entry<String, Double> entry : bills.entrySet()) {
                writer.write(entry.getKey() + "=" + String.format("%.2f", entry.getValue()) + "\n");
            }
            writer.write("\n");

            writer.write("[Appointments]\n\n");
            writer.write("[HealthRecords]\n\n");
            writer.close();

            JOptionPane.showMessageDialog(null, "Signup successful!");
            if(FileUtils.getFile(filePath).exists()){
                //new LoginPage("User");
                new UserHomePage(email,false);
                frame.dispose();
            }
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving user data: " + e.getMessage());
        }
    }

    public static void addHealthRecord(String filePath, Map<String, String> healthRecordDetails) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileUtils.getFile(filePath), true))) {
            writer.write("<<<HealthRecord-Start>>>\n");
            for (Map.Entry<String, String> entry : healthRecordDetails.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }
            writer.write("<<<HealthRecord-End>>>\n\n");
        }
    }

    public static void addAppointment(String filePath, Map<String, String> appointmentDetails) throws IOException {
        File file = FileUtils.getFile(filePath);
        List<String> lines = new ArrayList<>();
        boolean insideAppointmentsSection = false;
        boolean appointmentInserted = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);

                if (line.equals("[Appointments]")) {
                    insideAppointmentsSection = true;
                } else if (insideAppointmentsSection && line.startsWith("[")) {
                    //! If another section starts, insert the appointment before it
                    if (!appointmentInserted) {
                        insertAppointmentData(lines, appointmentDetails);
                        appointmentInserted = true;
                    }
                    insideAppointmentsSection = false;
                }
            }
        }

        if (insideAppointmentsSection && !appointmentInserted) {
            insertAppointmentData(lines, appointmentDetails);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String l : lines) {
                writer.write(l + "\n");
            }
        }
    }

    //! Helper method to insert appointment details
    private static void insertAppointmentData(List<String> lines, Map<String, String> appointmentDetails) {
        lines.add("<<<Appoint-Start>>>");
        for (Map.Entry<String, String> entry : appointmentDetails.entrySet()) {
            lines.add(entry.getKey() + "=" + entry.getValue());
        }
        lines.add("<<<Appoint-End>>>");
        lines.add("");
    }


    public static void addBills(String username, HashMap<String, Double> newBills, boolean reset) throws IOException {
    String filePath = FileUtils.getFile("/data/users/" + username + ".txt").getAbsolutePath();
    File originalFile = new File(filePath);
    File tempFile = new File(filePath + ".tmp");
    
    // Get and update existing bills
    HashMap<String, Double> existingBills = GetUserData.getBills(username);
    for (String key : existingBills.keySet()) {
        double newValue = reset ? 0.00 : existingBills.get(key) + newBills.getOrDefault(key, 0.00);
        existingBills.put(key, newValue);
    }
    
    try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
        
        String line;
        boolean inBillsSection = false;
        
        while ((line = reader.readLine()) != null) {
            if (line.equals("[Bills]")) {
                writer.write(line + "\n");
                // Write all bills immediately after the [Bills] section
                for (Map.Entry<String, Double> entry : existingBills.entrySet()) {
                    writer.write(entry.getKey() + "=" + String.format("%.2f", entry.getValue()) + "\n");
                }
                inBillsSection = true;
                continue;
            }
            
            // Skip existing bill lines but keep writing once we hit a new section
            if (inBillsSection && (line.trim().isEmpty() || line.startsWith("["))) {
                inBillsSection = false;
            }
            
            if (!inBillsSection) {
                writer.write(line + "\n");
            }
        }
    } catch (IOException e) {
        throw new IOException("Error updating bills: " + e.getMessage());
    }
    
    // Replace original file with temp file
    if (!tempFile.renameTo(originalFile)) {
        Files.copy(tempFile.toPath(), originalFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        tempFile.delete();
    }
}
}
