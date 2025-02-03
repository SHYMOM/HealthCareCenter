package com.healthcarecenter.models;

import com.healthcarecenter.frames.*;
import com.healthcarecenter.utils.FileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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

    public static void setName(String username, String name) {
        updateField(username, "fullName", name);
    }
    public static void setUsername(String username, String newUsername) {
        updateField(username, "username", newUsername);
    }
    public static void setAge(String username, String age) {
        updateField(username, "age", age);
    }
    public static void setEmail(String username, String email) {
        updateField(username, "email", email);
    }
    public static void setContactNumber(String username, String contactNumber) {
        updateField(username, "contactNumber", contactNumber);
    }
    public static void setAddress(String username, String address) {
        updateField(username, "address", address);
    }
    public static void setPassword(String username, String password) {
        updateField(username, "password", password);
    }
    public static void setGender(String username, String gender) {
        updateField(username, "gender", gender);
    }
    public static void setBloodGroup(String username, String bloodGroup) {
        updateField(username, "bloodGroup", bloodGroup);
    }
    public static void setSpecialization(String username, String specialization) {
        updateField(username, "specialization", specialization);
    }
    public static void setQualifications(String username, String qualifications) {
        updateField(username, "qualifications", qualifications);
    }
    public static void setMedicalLicenseNumber(String username, String medicalLicenseNumber) {
        updateField(username, "medicalLicenseNumber", medicalLicenseNumber);
    }
    public static void setConsultationHours(String username, String consultationHours) {
        updateField(username, "consultationHours", consultationHours);
    }
    public static void setDaysAvailable(String username, String daysAvailable) {
        updateField(username, "daysAvailable", daysAvailable);
    }
    public static void setConsultationFee(String username, double consultationFee) {
        updateField(username, "consultationFee", String.valueOf(consultationFee));
    }
    public static void setSalary(String username, double salary) {
        updateField(username, "salary", String.valueOf(salary));
    }

    
    public static void updateField(String username, String fieldName, String newValue) {
        String filePath = "/data/doctors/" + username + ".txt";
        filePath = FileUtils.getFile(filePath).getAbsolutePath();
        StringBuilder fileContent = new StringBuilder();
        boolean fieldFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(fieldName + "=")) {
                    fileContent.append(fieldName).append("=").append(newValue).append("\n");
                    fieldFound = true;
                } else {
                    fileContent.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!fieldFound) {
            fileContent.append(fieldName).append("=").append(newValue).append("\n");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(fileContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public static void addAppointment(String doctorUsername, String patientName, String patientEmail, String patientUsername, String date, String status) {
    String filePath = "/data/doctors/"+doctorUsername+".txt";    
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileUtils.getFile(filePath).getAbsolutePath(), true))) {
            writer.write("\n<<<Appoint-Start>>>\n");
            writer.write("patientName=" + patientName + "\n");
            writer.write("patientEmail=" + patientEmail + "\n");
            writer.write("patientUsername=" + patientUsername + "\n");
            writer.write("date=" + date + "\n");
            writer.write("status=" + status + "\n");
            writer.write("<<<Appoint-End>>>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
