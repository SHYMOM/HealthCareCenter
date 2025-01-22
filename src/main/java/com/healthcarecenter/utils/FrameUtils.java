package com.healthcarecenter.utils;

import java.io.IOException;
import javax.swing.*;

import com.healthcarecenter.frames.*;
import com.healthcarecenter.models.*;

public class FrameUtils {

    private static final String CURRENT_USER_FILE = "/data/CurrentUser/CurrentUser.txt";

    public static void defaultFrame(){
        try {
            if (!FileUtils.doesFileExist(CURRENT_USER_FILE)) {
                new WelcomePage();
            } 
            else {
                String role = GetCurrentUserData.getCurrentUserRole(CURRENT_USER_FILE);
                String username = GetCurrentUserData.getCurrentUserUserName(CURRENT_USER_FILE);

                if (role != null && username != null) {
                    if (role.equals("user")) {
                        new UserHomePage(username, true);
                    }
                    else if (role.equals("doctor")) {
                        new DoctorHomePage();
                    }
                    else if (role.equals("admin")) {
                        new AdminHomePage();
                    }
                    else if (role.equals("superadmin")) {
                        new SuperAdminHomePage();
                    }
                } 
                else {
                    JOptionPane.showMessageDialog(
                        null, 
                        "Failed to retrieve current user data. Redirecting to Main screen.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE
                    );
                    new WelcomePage();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null, 
                "An unexpected error occurred: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE
            );
            new WelcomePage();
        }
    }



    public static void frameLogOut(JFrame parentFrame) {
        int result = JOptionPane.showConfirmDialog(parentFrame, "Do you want to log out?", "Confirm Logout", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            try {
                CurrentUser.userLogout("/data/CurrentUser/CurrentUser.txt");
                parentFrame.dispose();
                new WelcomePage();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parentFrame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (result == JOptionPane.NO_OPTION) {

        }
    }
}
