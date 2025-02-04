package com.healthcarecenter.utils;

import java.io.*;

import javax.swing.JOptionPane;

import com.healthcarecenter.frames.WelcomePage;

public class FileUtils {


    public static File getFile(String filePath) {
        String projectBasePath = System.getProperty("user.dir");
        File file = new File(projectBasePath + "/HealthCareCenter/src/main/resources" + filePath).getAbsoluteFile();
        return file;
    }

    public static boolean doesFileExist(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return false;
        }
        else{
            File file = new File(getFile(filePath).getAbsolutePath());
            return file.exists();
        }
    }

    public static String getUsernameByEmail(String email, String filePath) {
        File directory = new File(FileUtils.getFile(filePath).getAbsolutePath());
        if (directory.exists() && directory.isDirectory()) {
            File[] userFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (userFiles != null) {
                for (File userFile : userFiles) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
                        String line;
                        String fileEmail = null;
                        String username = null;

                        while ((line = reader.readLine()) != null) {
                            if (line.startsWith("email=")) {
                                fileEmail = line.split("=")[1].trim();
                            }
                            if (line.startsWith("username=")) {
                                username = line.split("=")[1].trim();
                            }
                            if (fileEmail != null && username != null) {
                                if (fileEmail.equals(email)) {
                                    return username;
                                }
                            }
                        }
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            }
        }
        return null;
    }

    public static boolean hasAllNeededFolders() {
        String[] requiredFolders = {
            "/data", 
            "/data/users", 
            "/data/admins", 
            "/data/doctors", 
            "/data/SuperAdmins",
            "/data/CurrentUser",
            "/data/PaymentHistory"
        };

        for (String folderPath : requiredFolders) {
            File directory = new File(getFile(folderPath).getAbsolutePath());
            
            if (!directory.exists() || !directory.isDirectory()) {
                if (!directory.mkdirs()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void deleteFile(String username) throws IOException {
        String filePath = FileUtils.getFile("/data/users/" + username + ".txt").getAbsolutePath();
        File file = new File(filePath);
        if (file.exists()) {
            if (!file.delete()) {
                throw new IOException("Failed to delete the file: " + filePath);
            } else {
                JOptionPane.showMessageDialog(null, "Account deleted successfully");
                new WelcomePage();
            }
        } else {
            throw new IOException("File not found: " + filePath);
        }
    }
}
