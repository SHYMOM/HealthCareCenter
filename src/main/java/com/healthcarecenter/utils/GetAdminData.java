package com.healthcarecenter.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class GetAdminData {

    public static String getName(String username) throws IOException {
        return getFieldValue(username, "fullName");
    }
    public static String getEmail(String username) throws IOException {
        return getFieldValue(username, "email");
    }

    public static String getDetail(String username, String key) throws IOException {
        String filePath = "/data/admins/"+username+".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(FileUtils.getFile(filePath).getAbsolutePath()))) {
            String line;
            boolean isAdminSection = false;
            while ((line = reader.readLine()) != null) {
                if (line.equals("<<<Admin-Start>>>")) {
                    isAdminSection = true;
                } else if (line.equals("<<<Admin-End>>>")) {
                    isAdminSection = false;
                } else if (isAdminSection && line.startsWith(key + "=")) {
                    return line.split("=")[1];
                }
            }
        }
        return null; //! Key not found
    }

    public static HashMap<String, String> getAdminDetails(String username) throws IOException {
        String filePath = "/data/admins/"+username+".txt";
        HashMap<String, String> adminDetails = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FileUtils.getFile(filePath).getAbsolutePath()))) {
            String line;
            boolean isAdminSection = false;
            while ((line = reader.readLine()) != null) {
                if (line.equals("<<<Admin-Start>>>")) {
                    isAdminSection = true;
                } else if (line.equals("<<<Admin-End>>>")) {
                    isAdminSection = false;
                } else if (isAdminSection) {
                    String[] parts = line.split("=", 2);
                    if (parts.length == 2) {
                        adminDetails.put(parts[0], parts[1]);
                    }
                }
            }
        }
        return adminDetails;
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


    public static ArrayList<HashMap<String, String>> getAllAdminsDetails() {
        ArrayList<HashMap<String, String>> allAdmins = new ArrayList<>();
        String directoryPath = null;

        try {
            directoryPath = FileUtils.getFile("/data/admins/").getAbsolutePath();
            File directory = new File(directoryPath);
            if (!directory.exists() || !directory.isDirectory()) {
                JOptionPane.showMessageDialog(null, "Admins directory not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return allAdmins;
            }
            File[] AdminFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));
            System.out.println(AdminFiles.length);
            if (AdminFiles == null || AdminFiles.length == 0) {
                JOptionPane.showMessageDialog(null, "No Admin profiles found in the directory.", "Information", JOptionPane.INFORMATION_MESSAGE);
                return allAdmins;
            }

            for (File AdminFile : AdminFiles) {
                String username = AdminFile.getName().replace(".txt", "");
                try {
                    HashMap<String, String> AdminDetails = getAdminDetails(username);
                    if (!AdminDetails.isEmpty()) {
                        allAdmins.add(AdminDetails);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error reading file: " + AdminFile.getName() + "\n" + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred.\n" + e.getMessage(), "Unexpected Error", JOptionPane.ERROR_MESSAGE);
        }

        return allAdmins;
    }

    public static String getFieldValue(String username, String fieldName) {
        String filePath = "/data/admins/" + username + ".txt";
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
}

