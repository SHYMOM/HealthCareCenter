package com.healthcarecenter.models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.healthcarecenter.utils.FileUtils;

public class PaymentHistory {
    public static void savePaymentHistory(String name, String email, double amount, String payedBy, String details) throws IOException {
        String username = FileUtils.getUsernameByEmail(email, "/data/users/");
        if (username == null) {
            throw new IOException("No username found for email: " + email);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileUtils.getFile("/data/PaymentHistory/PaymentHistory.txt").getAbsolutePath(), true))) {
            writer.write("<<<Payment - Start>>>\n");
            writer.write("name=" + name + "\n");
            writer.write("username=" + username + "\n");
            writer.write("email=" + email + "\n");
            writer.write("amount=" + amount + "\n");
            writer.write("payedBy=" + payedBy + "\n");
            writer.write("details=" + details + "\n");
            writer.write("<<<Payment - End>>>\n");
        }
    }
}
