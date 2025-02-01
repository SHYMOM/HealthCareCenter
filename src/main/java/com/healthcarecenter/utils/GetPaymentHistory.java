package com.healthcarecenter.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GetPaymentHistory {

    private static final String PAYMENT_FILE_PATH = "/data/PaymentHistory/PaymentHistory.txt";

    public static ArrayList<HashMap<String, String>> getAllPaymentHistory() throws IOException {
        return getPaymentData(null);
    }

    public static ArrayList<HashMap<String, String>> getUserPaymentHistory(String username) throws IOException {
        return getPaymentData(username);
    }

    private static ArrayList<HashMap<String, String>> getPaymentData(String username) throws IOException {
        ArrayList<HashMap<String, String>> paymentList = new ArrayList<>();
        File file = FileUtils.getFile(PAYMENT_FILE_PATH);

        if (!file.exists()) {
            throw new FileNotFoundException("Payment history file not found: " + PAYMENT_FILE_PATH);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isReadingPayment = false;
            HashMap<String, String> paymentData = null;

            while ((line = reader.readLine()) != null) {
                if (line.equals("<<<Payment - Start>>>")) {
                    isReadingPayment = true;
                    paymentData = new HashMap<>();
                    continue;
                }
                if (isReadingPayment) {
                    if (line.equals("<<<Payment - End>>>")) {
                        if (paymentData != null && (username == null || username.equals(paymentData.get("username")))) {
                            paymentList.add(paymentData);
                        }
                        isReadingPayment = false;
                        paymentData = null;
                        continue;
                    }
                    if (paymentData != null && line.contains("=")) {
                        String[] parts = line.split("=", 2);
                        paymentData.put(parts[0], parts[1]);
                    }
                }
            }
        }
        return paymentList;
    }
}

