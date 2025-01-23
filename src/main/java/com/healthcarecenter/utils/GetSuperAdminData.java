//* From This File We Are Trying To Make Only One File For Every Users Taking Small Steps Like Making Sections For Each User Type */

package com.healthcarecenter.utils;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GetSuperAdminData {

    public static Map<String, String> getSuperAdminData() {
        Map<String, String> superAdminData = new HashMap<>();
        File file = FileUtils.getFile("/data/SuperAdmins/SuperAdmins.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                boolean isSuperAdminSection = false;

                while ((line = reader.readLine()) != null) {
                    if (line.equals("<<<Super Admins>>>")) {
                        isSuperAdminSection = true;
                    } else if (line.equals("<<<Super Admins - End>>>")) {
                        isSuperAdminSection = false;
                    } else if (isSuperAdminSection) {
                        if (line.startsWith("email=")) {
                            String email = line.split("=")[1].trim();
                            String passwordLine = reader.readLine();
                            if (passwordLine != null && passwordLine.startsWith("password=")) {
                                String password = passwordLine.split("=")[1].trim();
                                superAdminData.put(email, password);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "File not found at: " + file.getAbsolutePath(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return superAdminData;
    }

    public static boolean isSuperAdminEmail(String email) {
        Map<String, String> superAdminData = getSuperAdminData();
        return superAdminData.containsKey(email);
    }

    public static String getSuperAdminPassword(String email) {
        Map<String, String> superAdminData = getSuperAdminData();
        return superAdminData.getOrDefault(email, null);
    }
}
