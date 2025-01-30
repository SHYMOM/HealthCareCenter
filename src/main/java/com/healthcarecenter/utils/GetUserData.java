package com.healthcarecenter.utils;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class GetUserData {

    public static String getName(String username) throws IOException {
        return getField(username, "name");
    }

    public static void setName(String username, String newName) throws IOException {
        setField(username, "name", newName);
    }

    public static String getPassword(String username) throws IOException {
        return getField(username, "password");
    }

    public static void setPassword(String username, String newPassword) throws IOException {
        setField(username, "password", newPassword);
    }

    public static boolean isDonor(String username) throws IOException {
        return Boolean.parseBoolean(getField(username, "isDonor"));
    }
    public static void setDonor(String username, boolean isDonor) throws IOException {
        setField(username, "isDonor", String.valueOf(isDonor));
    }

    public static HashMap<String, String> getUserDetails(String username) throws IOException {
        String filePath = "/data/users/" + username + ".txt";
        filePath = FileUtils.getFile(filePath).getAbsolutePath();
        HashMap<String, String> userDetails = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean userSection = false;

            while ((line = reader.readLine()) != null) {
                if (line.equals("<<<User-Start>>>")) {
                    userSection = true;
                    continue;
                }
                if (line.equals("<<<User-End>>>")) {
                    break;
                }
                if (userSection && line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    if (!parts[0].equals("password") && !parts[0].equals("username")) {
                        userDetails.put(parts[0], parts[1]);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }
        return userDetails;
    }

    public static ArrayList<HashMap<String, String>> getAppointments(String username) throws IOException {
        String filePath = "/data/users/" + username + ".txt";
        filePath = FileUtils.getFile(filePath).getAbsolutePath();
        return getSectionData(filePath, "[Appointments]", "<<<Appoint-Start>>>", "<<<Appoint-End>>>");
    }

    public static ArrayList<HashMap<String, String>> getHealthRecords(String username) throws IOException {
        String filePath = "/data/users/" + username + ".txt";
        filePath = FileUtils.getFile(filePath).getAbsolutePath();
        return getSectionData(filePath, "[HealthRecords]", "<<<HealthRecord-Start>>>", "<<<HealthRecord-End>>>");
    }

    private static ArrayList<HashMap<String, String>> getSectionData(String username, String sectionHeader, String startMarker, String endMarker) throws IOException {
        String filePath = "/data/users/" + username + ".txt";
        filePath = FileUtils.getFile(filePath).getAbsolutePath();
        ArrayList<HashMap<String, String>> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean section = false;
            HashMap<String, String> data = null;

            while ((line = reader.readLine()) != null) {
                if (line.equals(sectionHeader)) {
                    section = true;
                    continue;
                }
                if (section) {
                    if (line.equals(startMarker)) {
                        data = new HashMap<>();
                        continue;
                    }
                    if (line.equals(endMarker)) {
                        if (data != null) {
                            dataList.add(data);
                        }
                        data = null;
                        continue;
                    }
                    if (data != null && line.contains("=")) {
                        String[] parts = line.split("=", 2);
                        data.put(parts[0], parts[1]);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }
        return dataList;
    }

    private static String getField(String username, String fieldName) throws IOException {
        String filePath = "/data/users/" + username + ".txt";
        filePath = FileUtils.getFile(filePath).getAbsolutePath();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean userSection = false;

            while ((line = reader.readLine()) != null) {
                if (line.equals("<<<User-Start>>>")) {
                    userSection = true;
                    continue;
                }
                if (line.equals("<<<User-End>>>")) {
                    break;
                }
                if (userSection && line.startsWith(fieldName + "=")) {
                    return line.split("=", 2)[1];
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }
        return null;
    }

    private static void setField(String username, String fieldName, String newValue) throws IOException {
        String filePath = "/data/users/" + username + ".txt";
        filePath = FileUtils.getFile(filePath).getAbsolutePath();
        File tempFile = new File(filePath + ".tmp");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean userSection = false;

            while ((line = reader.readLine()) != null) {
                if (line.equals("<<<User-Start>>>")) {
                    userSection = true;
                    writer.write(line + "\n");
                    continue;
                }
                if (line.equals("<<<User-End>>>")) {
                    userSection = false;
                    writer.write(line + "\n");
                    continue;
                }
                if (userSection && line.startsWith(fieldName + "=")) {
                    writer.write(fieldName + "=" + newValue + "\n");
                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }
        tempFile.renameTo(new File(filePath));
    }

    public static ArrayList<HashMap<String, String>> getAllUsersDetails() {
        ArrayList<HashMap<String, String>> allUsers = new ArrayList<>();
        String directoryPath = null;

        try {
            directoryPath = FileUtils.getFile("/data/users/").getAbsolutePath();
            File directory = new File(directoryPath);

            if (!directory.exists() || !directory.isDirectory()) {
                JOptionPane.showMessageDialog(null, "Users directory not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return allUsers;
            }

            File[] userFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (userFiles == null || userFiles.length == 0) {
                JOptionPane.showMessageDialog(null, "No user profiles found in the directory.", "Information", JOptionPane.INFORMATION_MESSAGE);
                return allUsers;
            }

            for (File userFile : userFiles) {
                String username = userFile.getName().replace(".txt", "");
                try {
                    HashMap<String, String> userDetails = getUserDetails(username);
                    if (!userDetails.isEmpty()) {
                        allUsers.add(userDetails);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error reading file: " + userFile.getName() + "\n" + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred.\n" + e.getMessage(), "Unexpected Error", JOptionPane.ERROR_MESSAGE);
        }

        return allUsers;
    }

}
