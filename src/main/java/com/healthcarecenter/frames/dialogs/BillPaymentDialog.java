package com.healthcarecenter.frames.dialogs;

import com.healthcarecenter.utils.GetUserData;
import com.healthcarecenter.models.PaymentHistory;
import com.healthcarecenter.models.User;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.io.IOException;

public class BillPaymentDialog extends JFrame {
    private JLabel amountLabel;
    private JComboBox<String> paymentMethod;
    private JTextField accountInfo;
    private JButton payButton;
    private double billAmount;
    private String username;
    private String name;
    private String email;

    public BillPaymentDialog(String username, double billAmount) {
        this.billAmount = billAmount;
        this.username = username;
        try{
            this.name = GetUserData.getName(username);
            this.email = GetUserData.getEmail(username);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setTitle("Bill Payment Portal");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(240, 242, 245));

        mainPanel.add(createHeaderPanel());
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(createAmountPanel());
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(createPaymentMethodPanel());
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(createCardPanel());
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(createButtonPanel());

        this.add(mainPanel);
        this.setVisible(true);

        payButton.addActionListener(e -> validateAndProcess());
        paymentMethod.addActionListener(e -> updatePaymentField());
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(240, 242, 245));
        
        JLabel titleLabel = new JLabel("Payment Details");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(33, 37, 41));
        headerPanel.add(titleLabel);
        
        return headerPanel;
    }

    private JPanel createAmountPanel() {
        JPanel amountPanel = createStyledPanel();
        JLabel label = new JLabel("Total Amount:");
        label.setFont(new Font("Arial", Font.PLAIN, 14));

        amountLabel = new JLabel("$" + String.format("%.2f", billAmount));
        amountLabel.setFont(new Font("Arial", Font.BOLD, 32));
        amountLabel.setForeground(new Color(40, 167, 69));
        
        amountPanel.add(label);
        amountPanel.add(amountLabel);
        
        return amountPanel;
    }

    private JPanel createPaymentMethodPanel() {
        JPanel methodPanel = createStyledPanel();
        String[] methods = {"Credit Card", "Bank Transfer", "PayPal", "International Wire"};
        paymentMethod = new JComboBox<>(methods);
        paymentMethod.setPreferredSize(new Dimension(200, 35));
        paymentMethod.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JLabel label = new JLabel("Select Payment Method:");
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        
        methodPanel.add(label);
        methodPanel.add(paymentMethod);
        
        return methodPanel;
    }

    private JPanel createCardPanel() {
        JPanel cardPanel = createStyledPanel();
        accountInfo = new JTextField(20);
        accountInfo.setPreferredSize(new Dimension(200, 35));
        accountInfo.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JLabel label = new JLabel("Enter Payment Details:");
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        
        cardPanel.add(label);
        cardPanel.add(accountInfo);
        
        return cardPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = createStyledPanel();
        payButton = createStyledButton("Complete Payment");
        buttonPanel.add(payButton);
        return buttonPanel;
    }

    private JPanel createStyledPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            new EmptyBorder(5, 5, 5, 5),
            BorderFactory.createLineBorder(new Color(222, 226, 230), 1, true)
        ));
        return panel;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(200, 40));
        button.setBackground(new Color(0, 123, 255));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        
        //! Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 105, 217));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 123, 255));
            }
        });
        
        return button;
    }

    private void updatePaymentField() {
        String selected = (String) paymentMethod.getSelectedItem();
        String placeholder = "";
        switch(selected) {
            case "Credit Card":
                placeholder = "Enter 16-digit card number";
                break;
            case "PayPal":
                placeholder = "Enter PayPal email";
                break;
            case "Bank Transfer":
                placeholder = "Enter 10-12 digit account number";
                break;
            case "International Wire":
                placeholder = "Enter SWIFT/IBAN code";
                break;
        }
        accountInfo.setToolTipText(placeholder);
        accountInfo.setText("");
    }

    private boolean validateInput() {
        String input = accountInfo.getText().trim();
        String selectedMethod = (String) paymentMethod.getSelectedItem();

        if (input.isEmpty()) {
            showError("Payment Details Required", "Please enter your payment details.");
            return false;
        }

        switch (selectedMethod) {
            case "Credit Card":
                if (!input.matches("\\d{16}")) {
                    showError("Invalid Card Number", "Please enter a valid 16-digit card number.");
                    return false;
                }
                break;

            case "PayPal":
                if (!input.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
                    showError("Invalid Email", "Please enter a valid email address for PayPal.");
                    return false;
                }
                break;

            case "Bank Transfer":
                if (!input.matches("\\d{10,12}")) {
                    showError("Invalid Account Number", "Please enter a valid account number (10-12 digits).");
                    return false;
                }
                break;

            case "International Wire":
                if (!input.matches("[A-Z0-9]{8,11}")) {
                    showError("Invalid SWIFT/IBAN", "Please enter a valid SWIFT/IBAN code (8-11 characters).");
                    return false;
                }
                break;
        }

        return true;
    }

    private void validateAndProcess() {
        if (validateInput()) {
            processPayment();
        }
    }

    private void showError(String title, String message) {
        JOptionPane.showMessageDialog(null , message , title , JOptionPane.ERROR_MESSAGE);
    }


    private void processPayment() {
        try {
            String transactionId = "TXN" + System.currentTimeMillis();
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            JPanel confirmPanel = new JPanel();
            confirmPanel.setLayout(new BoxLayout(confirmPanel, BoxLayout.Y_AXIS));
            confirmPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Create success icon
            JLabel successIcon = new JLabel("✅");
            successIcon.setFont(new Font("Arial", Font.BOLD, 24));
            successIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel[] labels = {
                successIcon,
                new JLabel("Payment Successful!"),
                new JLabel(" "),
                new JLabel("Amount: $" + String.format("%.2f", billAmount)),
                new JLabel("Payment Method: " + paymentMethod.getSelectedItem()),
                new JLabel("Transaction ID: " + transactionId),
                new JLabel("Date: " + timestamp)
            };
            PaymentHistory.savePaymentHistory(name, username, email, billAmount, paymentMethod.getSelectedItem().toString(), accountInfo.getText(), transactionId, timestamp);
            HashMap<String, Double> paymentData = new HashMap<>();
            paymentData.put("appointmentCost", 0.00);
            paymentData.put("medicineCost", 0.00);
            paymentData.put("testCost", 0.00);
            paymentData.put("otherCost", 0.00);
            User.addBills(username, paymentData , true);

            for (JLabel label : labels) {
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                if (label == labels[1]) {
                    label.setFont(new Font("Arial", Font.BOLD, 16));
                    label.setForeground(new Color(40, 167, 69));
                }
                confirmPanel.add(label);
            }

            JOptionPane.showMessageDialog(
                this,
                confirmPanel,
                "Payment Confirmation",
                JOptionPane.PLAIN_MESSAGE
            );

            this.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BillPaymentDialog("emiko", 100.50);
    }
}