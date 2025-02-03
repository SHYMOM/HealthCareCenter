package com.healthcarecenter.models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.healthcarecenter.utils.FileUtils;

public class PaymentHistory {
    public static void savePaymentHistory(String name, String username, String email, double amount, String method, String accountInfo, String transactionID, String date) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileUtils.getFile("/data/PaymentHistory/PaymentHistory.txt").getAbsolutePath(), true))) {
            writer.write("\n<<<Payment - Start>>>\n");
            writer.write("name=" + name + "\n");
            writer.write("username=" + username + "\n");
            writer.write("email=" + email + "\n");
            writer.write("amount=" + amount + "\n");
            writer.write("method=" + method + "\n");
            writer.write("accountInfo=" + accountInfo + "\n");
            writer.write("TransactionID=" + transactionID + "\n");
            writer.write("date=" + date + "\n");
            writer.write("<<<Payment - End>>>\n");
        }
    }
}
