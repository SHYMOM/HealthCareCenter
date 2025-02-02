package com.healthcarecenter.models;

import com.healthcarecenter.frames.*;
import com.healthcarecenter.utils.FileUtils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class Doctor {
    private String fullName;
    private String username;
    private String age;
    private String email;
    private String contactNumber;
    private String address;
    private String password;
    private String gender;
    private String bloodGroup;
    private final String role = "Doctor";
    private String specialization;
    private String qualifications;
    private String medicalLicenseNumber;
    private String consultationHours;
    private String daysAvailable;
    private double consultationFee;
    private double salary;

    // Constructor
    public Doctor(  String fullName, 
                    String username, 
                    String age,
                    String email, 
                    String contactNumber, 
                    String address,
                    String password, 
                    String gender, 
                    String bloodGroup,
                    String specialization, 
                    String qualifications,
                    String medicalLicenseNumber, 
                    String consultationHours, 
                    String daysAvailable,
                    double consultationFee, 
                    double salary
                ) 
    {
        this.fullName = fullName;
        this.username = username;
        this.age = age;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
        this.password = password;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.specialization = specialization;
        this.qualifications = qualifications;
        this.medicalLicenseNumber = medicalLicenseNumber;
        this.consultationHours = consultationHours;
        this.daysAvailable = daysAvailable;
        this.consultationFee = consultationFee;
        this.salary = salary;
    }

public void saveToFile(JFrame frame){
    String filePath = "/data/doctors/"+username+".txt";
  
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileUtils.getFile(filePath).getAbsolutePath()))) {
            writer.write("<<<Doctor-Start>>>\n");
            writer.write("fullName=" + fullName + "\n");
            writer.write("username=" + username + "\n");
            writer.write("age=" + age + "\n");
            writer.write("email=" + email + "\n");
            writer.write("contactNumber=" + contactNumber + "\n");
            writer.write("address=" + address + "\n");
            writer.write("password=" + password + "\n");
            writer.write("gender=" + gender + "\n");
            writer.write("bloodGroup=" + bloodGroup + "\n");
            writer.write("role=" + role + "\n");
            writer.write("specialization=" + specialization + "\n");
            writer.write("qualifications=" + qualifications + "\n");
            writer.write("medicalLicenseNumber=" + medicalLicenseNumber + "\n");
            writer.write("consultationHours=" + consultationHours + "\n");
            writer.write("daysAvailable=" + daysAvailable + "\n");
            writer.write("consultationFee=" + consultationFee + "\n");
            writer.write("salary=" + salary + "\n");
            writer.write("<<<Doctor-End>>>\n");
            writer.write("\n[Appointments]\n");

            JOptionPane.showMessageDialog(null, "Signup successful!");
            
            new  LoginPage("Doctor");
            frame.dispose();

        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving user data: " + e.getMessage());
        }
}

public void addAppointment(String doctorUsername, String patientName, String patientEmail, String patientUsername, String time, String date, String status) {
    String filePath = "/data/doctors/"+doctorUsername+".txt";    
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileUtils.getFile(filePath).getAbsolutePath(), true))) {
            writer.write("\n<<<Appoint-Start>>>\n");
            writer.write("patientName=" + patientName + "\n");
            writer.write("patientEmail=" + patientEmail + "\n");
            writer.write("patientUsername=" + patientUsername + "\n");
            writer.write("time=" + time + "\n");
            writer.write("date=" + date + "\n");
            writer.write("status=" + status + "\n");
            writer.write("<<<Appoint-End>>>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
