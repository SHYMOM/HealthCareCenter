package com.healthcarecenter.models;
import com.healthcarecenter.utils.FileUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Doctor {
    private String fullName;
    private String username;
    private String email;
    private String contactNumber;
    private String address;
    private String password;
    private String gender;
    private final String role = "Doctor";
    private String specialization;
    private String qualifications;
    private String medicalLicenseNumber;
    private String consultationHours;
    private String daysAvailable;
    private double consultationFee;

    // Constructor
    public Doctor(  String fullName, 
                    String username, 
                    String email, 
                    String contactNumber, 
                    String address,
                    String password, 
                    String gender, 
                    String specialization, 
                    String qualifications,
                    String medicalLicenseNumber, 
                    String consultationHours, 
                    String daysAvailable,
                    double consultationFee  
                ) 
    {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
        this.password = password;
        this.gender = gender;
        this.specialization = specialization;
        this.qualifications = qualifications;
        this.medicalLicenseNumber = medicalLicenseNumber;
        this.consultationHours = consultationHours;
        this.daysAvailable = daysAvailable;
        this.consultationFee = consultationFee;
    }

public void saveToFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("<<<Doctor-Start>>>\n");
            writer.write("fullName=" + fullName + "\n");
            writer.write("username=" + username + "\n");
            writer.write("email=" + email + "\n");
            writer.write("contactNumber=" + contactNumber + "\n");
            writer.write("address=" + address + "\n");
            writer.write("password=" + password + "\n");
            writer.write("gender=" + gender + "\n");
            writer.write("role=" + role + "\n");
            writer.write("specialization=" + specialization + "\n");
            writer.write("qualifications=" + qualifications + "\n");
            writer.write("medicalLicenseNumber=" + medicalLicenseNumber + "\n");
            writer.write("consultationHours=" + consultationHours + "\n");
            writer.write("daysAvailable=" + daysAvailable + "\n");
            writer.write("consultationFee=" + consultationFee + "\n");
            writer.write("<<<Doctor-End>>>\n");
            writer.write("\n[Appointments]\n");
        }
    }

    public void addAppointment(String filePath, String patientName, String patientUsername, String time, String date, String status) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("\n<<<Appoint-Start>>>\n");
            writer.write("patientName=" + patientName + "\n");
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
