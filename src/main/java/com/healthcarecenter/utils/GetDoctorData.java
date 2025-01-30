package com.healthcarecenter.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class GetDoctorData {

    public static String getFieldValue(String username, String fieldName) {
        String filePath = "/data/doctors/" + username + ".txt";
        filePath = FileUtils.getFile(filePath).getAbsolutePath();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(fieldName + "=")) {
                    return line.split("=", 2)[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileUtils.getFile(filePath).getAbsolutePath()))) {
            writer.write(fileContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, String> getDoctorDetails(String username) {
        String filePath = FileUtils.getFile("/data/doctors/" + username + ".txt").getAbsolutePath();
        HashMap<String, String> doctorDetails = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean doctorSection = false;

            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Remove extra spaces
                if (line.equals("<<<Doctor-Start>>>")) {
                    doctorSection = true;
                    continue;
                }
                if (line.equals("<<<Doctor-End>>>")) {
                    break;
                }
                if (doctorSection && line.contains("=")) {
                    String[] parts = line.split("=", 2); // Split only into two parts
                    if (parts.length == 2 && !parts[0].isEmpty() && !parts[1].isEmpty()) {
                        String key = parts[0].trim();
                        String value = parts[1].trim();
                        if (!key.equalsIgnoreCase("password") && !key.equalsIgnoreCase("username")) {
                            doctorDetails.put(key, value);
                        }
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading doctor details: " + username + "\n" + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }

        return doctorDetails;
    }


    public static ArrayList<HashMap<String, String>> getAppointments(String username) {
        String filePath = "/data/doctors/" + username + ".txt";
        filePath = FileUtils.getFile(filePath).getAbsolutePath();
        ArrayList<HashMap<String, String>> appointments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            HashMap<String, String> appointment = null;
            while ((line = reader.readLine()) != null) {
                if (line.equals("<<<Appoint-Start>>>")) {
                    appointment = new HashMap<>();
                } else if (line.equals("<<<Appoint-End>>>")) {
                    if (appointment != null) {
                        appointments.add(appointment);
                    }
                } else if (line.contains("=") && appointment != null) {
                    String[] parts = line.split("=", 2);
                    appointment.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public static ArrayList<HashMap<String, String>> getAllDoctorsDetails() {
        ArrayList<HashMap<String, String>> allDoctors = new ArrayList<>();
        String directoryPath = null;

        try {
            directoryPath = FileUtils.getFile("/data/doctors/").getAbsolutePath();
            File directory = new File(directoryPath);
            if (!directory.exists() || !directory.isDirectory()) {
                JOptionPane.showMessageDialog(null, "Doctors directory not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return allDoctors;
            }
            File[] doctorFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));
            System.out.println(doctorFiles.length);
            if (doctorFiles == null || doctorFiles.length == 0) {
                JOptionPane.showMessageDialog(null, "No doctor profiles found in the directory.", "Information", JOptionPane.INFORMATION_MESSAGE);
                return allDoctors;
            }

            for (File doctorFile : doctorFiles) {
                String username = doctorFile.getName().replace(".txt", "");
                try {
                    HashMap<String, String> doctorDetails = getDoctorDetails(username);
                    if (!doctorDetails.isEmpty()) {
                        allDoctors.add(doctorDetails);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error reading file: " + doctorFile.getName() + "\n" + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred.\n" + e.getMessage(), "Unexpected Error", JOptionPane.ERROR_MESSAGE);
        }

        return allDoctors;
    }

}
