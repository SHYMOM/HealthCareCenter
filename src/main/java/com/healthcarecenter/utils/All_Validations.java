package com.healthcarecenter.utils;
import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;
public class All_Validations {
    public static boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }
    public static boolean isValidPassword(String password) {
        return password.length() >= 6;
    }
    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z ]+");
    }
    public static boolean isValidAge(String age) {
        return age.matches("\\d+");
    }
    public static boolean isValidContactNumber(String contactNumber) {
        return contactNumber.matches("\\d+");
    }
    public static boolean isValidLicenseNumber(String licenseNumber) {
        return licenseNumber.matches("\\d+");
    }
    public static boolean isValidAmount(String amount) {
        try {
            BigDecimal value = new BigDecimal(amount);
            return value.compareTo(BigDecimal.ZERO) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }





public static boolean isEmailRegistered(String email, String filePath) {
        File directory = new File(FileUtils.getFile(filePath).getAbsolutePath());
        if (directory.exists() && directory.isDirectory()) {
            File[] userFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (userFiles != null) {
                for (File userFile : userFiles) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.contains("email=" + email)) {
                                return true;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            }
        }
        return false;
    }

    public static boolean isUserRegistered(String email, String password, String filePath) {
        File directory = new File(FileUtils.getFile(filePath).getAbsolutePath());
        if (directory.exists() && directory.isDirectory()) {
            File[] userFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (userFiles != null) {
                for (File userFile : userFiles) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
                        String line;
                        String fileEmail = null;
                        String filePassword = null;

                        while ((line = reader.readLine()) != null) {
                            if (line.startsWith("email=")) {
                                fileEmail = line.split("=")[1].trim();
                            }
                            if (line.startsWith("password=")) {
                                filePassword = line.split("=")[1].trim();
                            }
                            if (fileEmail != null && filePassword != null) {
                                if (fileEmail.equals(email) && filePassword.equals(password)) {
                                    return true;
                                }
                            }
                        }
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            }
        }
        return false;
    }

}