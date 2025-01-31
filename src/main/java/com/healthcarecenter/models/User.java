package com.healthcarecenter.models;

import com.healthcarecenter.frames.UserSignUp;
import com.healthcarecenter.frames.UserHomePage;
import com.healthcarecenter.utils.FileUtils;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class User {
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

    public void saveToFile(String username) {
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


            JOptionPane.showMessageDialog(null, "Signup successful!");
            new UserSignUp(true);
            new UserHomePage(email, false);
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving user data: " + e.getMessage());
        }
    }

    public void addAppointment(String filePath, Map<String, String> appointmentDetails) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileUtils.getFile(filePath), true))) {
            writer.write("<<<Appoint-Start>>>\n");
            for (Map.Entry<String, String> entry : appointmentDetails.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }
            writer.write("<<<Appoint-End>>>\n\n");
        }
    }

    public void addHealthRecord(String filePath, Map<String, String> healthRecordDetails) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileUtils.getFile(filePath), true))) {
            writer.write("<<<HealthRecord-Start>>>\n");
            for (Map.Entry<String, String> entry : healthRecordDetails.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }
            writer.write("<<<HealthRecord-End>>>\n\n");
        }
    }
}
