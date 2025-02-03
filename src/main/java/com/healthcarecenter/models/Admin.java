package com.healthcarecenter.models;

import com.healthcarecenter.frames.LoginPage;
import com.healthcarecenter.utils.FileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class Admin {
    private String fullName;
    private String username;
    private String age;
    private String address;
    private String bloodGroup;
    private String email;
    private String contactNumber;
    private String password;
    private String gender;
    private final String role = "Admin";
    private double salary;

    public Admin(String fullName, String username, String age, String address, String bloodGroup, String email, String contactNumber, String password, String gender, double salary) {
        this.fullName = fullName;
        this.username = username;
        this.age = age;
        this.address = address;
        this.bloodGroup = bloodGroup;
        this.email = email;
        this.contactNumber = contactNumber;
        this.password = password;
        this.gender = gender;
        this.salary = salary;
    }

    public static void setName(String username, String name) throws IOException {
        updateDetail(username, "fullName", name);
    }
    public static void setUsername(String username, String newUsername) throws IOException {
        updateDetail(username, "username", newUsername);
    }
    public static void setAge(String username, String newAge) throws IOException {
        updateDetail(username, "age", newAge);
    }
    public static void setAddress(String username, String newAddress) throws IOException {
        updateDetail(username, "address", newAddress);
    }
    public static void setBloodGroup(String username, String newBloodGroup) throws IOException {
        updateDetail(username, "bloodGroup", newBloodGroup);
    }
    public static void setEmail(String username, String newEmail) throws IOException {
        updateDetail(username, "email", newEmail);
    }
    public static void setContactNumber(String username, String newContactNumber) throws IOException {
        updateDetail(username, "contactNumber", newContactNumber);
    }
    public static void setPassword(String username, String newPassword) throws IOException {
        updateDetail(username, "password", newPassword);
    }
    public static void setGender(String username, String newGender) throws IOException {
        updateDetail(username, "gender", newGender);
    }
    public static void setSalary(String username, String newSalary) throws IOException {
        updateDetail(username, "salary", newSalary);
    }

    public void saveToFile(JFrame frame){
        String filePath = "/data/admins/"+username+".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileUtils.getFile(filePath).getAbsolutePath()))) {
            writer.write("<<<Admin-Start>>>\n");
            writer.write("fullName=" + fullName + "\n");
            writer.write("username=" + username + "\n");
            writer.write("age=" + age + "\n");
            writer.write("address=" + address + "\n");
            writer.write("bloodGroup=" + bloodGroup + "\n");
            writer.write("email=" + email + "\n");
            writer.write("contactNumber=" + contactNumber + "\n");
            writer.write("password=" + password + "\n");
            writer.write("gender=" + gender + "\n");
            writer.write("salary=" + salary + "\n");
            writer.write("role=" + role + "\n");
            writer.write("<<<Admin-End>>>\n");

            JOptionPane.showMessageDialog(null, "Signup successful!");
            
            new  LoginPage("Admin");
            frame.dispose();
            
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void updateDetail(String username, String key, String newValue) throws IOException {
        String filePath = "/data/admins/"+username+".txt";
        File file = new File(FileUtils.getFile(filePath).getAbsolutePath());
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isAdminSection = false;
            while ((line = reader.readLine()) != null) {
                if (line.equals("<<<Admin-Start>>>")) {
                    isAdminSection = true;
                    fileContent.append(line).append("\n");
                } else if (line.equals("<<<Admin-End>>>")) {
                    isAdminSection = false;
                    fileContent.append(line).append("\n");
                } else if (isAdminSection && line.startsWith(key + "=")) {
                    fileContent.append(key).append("=").append(newValue).append("\n");
                } else {
                    fileContent.append(line).append("\n");
                }
            }
        }

        // Write the updated content back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(fileContent.toString());
        }
    }

}

