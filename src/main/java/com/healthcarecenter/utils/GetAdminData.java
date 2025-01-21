package com.healthcarecenter.utils;

import java.io.*;
import java.util.HashMap;

public class GetAdminData {

    // Method to get a specific admin detail by key
    public String getDetail(String username, String key) throws IOException {
        String filePath = "data/admin/"+username+".txt";
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
        return null; // Key not found
    }

    // Method to get all admin details in a HashMap
    public HashMap<String, String> getAllDetails(String username) throws IOException {
        String filePath = "data/admin/"+username+".txt";
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

    // Method to update a specific admin detail
    public void updateDetail(String username, String key, String newValue) throws IOException {
        String filePath = "data/admin/"+username+".txt";
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

