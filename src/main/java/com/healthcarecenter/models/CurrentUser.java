package com.healthcarecenter.models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

import com.healthcarecenter.utils.FileUtils;

public class CurrentUser {
    public CurrentUser() {}

    public static void saveCurrentUserToFile(String filePath, String email, String role) throws IOException {
        String username = FileUtils.getUsernameByEmail(email, "/data/" + role + "s/");
        if (username == null) {
            throw new IOException("No username found for the given email and role.");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileUtils.getFile(filePath).getAbsolutePath(), false))) {
            writer.write("<<<Current User>>>\n");
            writer.write("username=" + username + "\n");
            writer.write("email=" + email + "\n");
            writer.write("role=" + role + "\n");
            writer.write("<<<Current User - End>>>\n");
        }
    }

    public static void userLogout(String filePath) throws IOException {
    File file = FileUtils.getFile(filePath);
    if (file.exists()) {
        if (file.delete()) {
            JOptionPane.showMessageDialog(null, "Logged out successfully.");
        } else {
            throw new IOException("Failed to delete the current user file.");
        }
    } else {
        throw new IOException("No current user file found.");
    }
}

}
