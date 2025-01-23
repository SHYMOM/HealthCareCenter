package com.healthcarecenter.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class GetCurrentUserData {
    public GetCurrentUserData() {}

    public static String getCurrentUserRole(String filePath) {
        File file = FileUtils.getFile(filePath);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("role=")) {
                        return line.split("=")[1].trim();
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        return null;
    }

    public static String getCurrentUserUserName(String filePath) {
        File file = FileUtils.getFile(filePath);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("username=")) {
                        return line.split("=")[1].trim();
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        return null;
    }
}
