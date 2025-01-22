package com.healthcarecenter.utils;

import java.io.*;

import javax.swing.JOptionPane;

public class FileUtils {

    public static File getFile(String filePath) {
        String absolutePath = new File("HealthCareCenter/src/main/resources", filePath).getAbsolutePath();
        return new File(absolutePath);
    }

    public static boolean doesFileExist(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return false;
        }
        String basePath = "HealthCareCenter/src/main/resources";
        File file = new File(basePath, filePath).getAbsoluteFile();
        return file.exists();
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

}
