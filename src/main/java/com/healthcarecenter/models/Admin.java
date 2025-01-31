package com.healthcarecenter.models;

import com.healthcarecenter.frames.LoginPage;
import com.healthcarecenter.utils.FileUtils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class Admin {
    private String fullName;
    private String username;
    private String email;
    private String contactNumber;
    private String password;
    private String gender;
    private final String role = "Admin";
    private double salary;

    public Admin(String fullName, String username, String email, String contactNumber, String password, String gender, double salary) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.contactNumber = contactNumber;
        this.password = password;
        this.gender = gender;
        this.salary = salary;
    }


    public void saveToFile(JFrame frame, String username){
        String filePath = "/data/admins/"+username+".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileUtils.getFile(filePath).getAbsolutePath()))) {
            writer.write("<<<Admin-Start>>>\n");
            writer.write("fullName=" + fullName + "\n");
            writer.write("username=" + username + "\n");
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
}

