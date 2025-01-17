package com.healthcarecenter.models;
import com.healthcarecenter.utils.FileUtils;
import java.io.*;
import java.util.*;

public class GetUserData {
    private final String filePath;

    public GetUserData(String filePath) {
        this.filePath = FileUtils.getFile(filePath).getAbsolutePath();
    }

    public String getName() throws IOException {
        return getField("name");
    }

    public void setName(String newName) throws IOException {
        setField("name", newName);
    }

    public String getUsername() throws IOException {
        return getField("username");
    }

    public int getAge() throws IOException {
        return Integer.parseInt(getField("age"));
    }

    public void setAge(int newAge) throws IOException {
        setField("age", String.valueOf(newAge));
    }

    public String getEmail() throws IOException {    
        return getField("email");
    }

    public void setEmail(String newEmail) throws IOException {
        setField("email", newEmail);
    }

    public String getAddress() throws IOException {
        return getField("address");
    }

    public void setAddress(String newAddress) throws IOException {
        setField("address", newAddress);
    }

    public String getPassword() throws IOException {
        return getField("password");
    }

    public void setPassword(String newPassword) throws IOException {
        setField("password", newPassword);
    }

    public String getContactNumber() throws IOException {
        return getField("contactNumber");
    }

    public void setContactNumber(String newContactNumber) throws IOException {
        setField("contactNumber", newContactNumber);    
    }
    public boolean isDonor() throws IOException {
        return Boolean.parseBoolean(getField("isDonor"));
    }
    public void setDonor(boolean isDonor) throws IOException {
        setField("isDonor", String.valueOf(isDonor));
    }

    public HashMap<String, String> getUserDetails() throws IOException {
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
        }
        return userDetails;
    }

    public ArrayList<HashMap<String, String>> getAppointments() throws IOException {
        return getSectionData("[Appointments]", "<<<Appoint-Start>>>", "<<<Appoint-End>>>");
    }

    public ArrayList<HashMap<String, String>> getHealthRecords() throws IOException {
        return getSectionData("[HealthRecords]", "<<<HealthRecord-Start>>>", "<<<HealthRecord-End>>>");
    }

    private ArrayList<HashMap<String, String>> getSectionData(String sectionHeader, String startMarker, String endMarker) throws IOException {
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
        }
        return dataList;
    }

    private String getField(String fieldName) throws IOException {
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
        }
        return null;
    }

    private void setField(String fieldName, String newValue) throws IOException {
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
        }
        tempFile.renameTo(new File(filePath));
    }
}
