package com.healthcarecenter.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GetDoctorData {

    public static String getFieldValue(String filePath, String fieldName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FileUtils.getFile(filePath).getAbsolutePath()))) {
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

    public static void updateField(String filePath, String fieldName, String newValue) {
        StringBuilder fileContent = new StringBuilder();
        boolean fieldFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FileUtils.getFile(filePath).getAbsolutePath()))) {
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

    public static HashMap<String, String> getDoctorDetails(String filePath) {
        HashMap<String, String> doctorDetails = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FileUtils.getFile(filePath).getAbsolutePath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("=") && !line.startsWith("password")) {
                    String[] parts = line.split("=", 2);
                    doctorDetails.put(parts[0].trim(), parts[1].trim());
                }
                if (line.equals("<<<Doctor-End>>>")) {
                    break; // Stop reading at the end of the doctor section
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doctorDetails;
    }

    public static ArrayList<HashMap<String, String>> getAppointments(String filePath) {
        ArrayList<HashMap<String, String>> appointments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FileUtils.getFile(filePath).getAbsolutePath()))) {
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
}
