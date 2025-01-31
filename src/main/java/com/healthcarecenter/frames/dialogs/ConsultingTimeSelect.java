package com.healthcarecenter.frames.dialogs;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.ArrayList;

public class ConsultingTimeSelect {
    private static final Color PRIMARY_COLOR = new Color(51, 153, 255);
    private static final Color SECONDARY_COLOR = new Color(240, 245, 255);
    private static final Color TEXT_COLOR = new Color(51, 51, 51);
    private static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 16);
    private static final Font LABEL_FONT = new Font("Arial", Font.BOLD, 12);

    public static String setTimePickerDialog(JFrame parent) {
        String[] hours = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String[] minutes = {"00", "15", "30", "45"};
        String[] amPm = {"AM", "PM"};
        DefaultListModel<String> timeSlotsModel = new DefaultListModel<>();
        final String[] selectedTime = {""};

        //! Main dialog>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        JDialog dialog = new JDialog(parent, "Select Consulting Hours", true);
        dialog.setLayout(new BorderLayout(10, 10));
        dialog.getContentPane().setBackground(Color.WHITE);

        //! Title Panel>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(PRIMARY_COLOR);
        titlePanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        JLabel titleLabel = new JLabel("Set Consultation Time Slots");
        titleLabel.setFont(TITLE_FONT);
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        //! Time Selection Panel>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        JPanel timeSelectionPanel = new JPanel();
        timeSelectionPanel.setLayout(new GridBagLayout());
        timeSelectionPanel.setBackground(Color.WHITE);
        timeSelectionPanel.setBorder(new CompoundBorder(
                new EmptyBorder(10, 10, 10, 10),
                new LineBorder(SECONDARY_COLOR, 1, true)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel startLabel = new JLabel("Start Time");
        startLabel.setFont(LABEL_FONT);
        JComboBox<String> startHour = createStyledComboBox(hours);
        JComboBox<String> startMinute = createStyledComboBox(minutes);
        JComboBox<String> startAmPm = createStyledComboBox(amPm);

        JLabel endLabel = new JLabel("End Time");
        endLabel.setFont(LABEL_FONT);
        JComboBox<String> endHour = createStyledComboBox(hours);
        JComboBox<String> endMinute = createStyledComboBox(minutes);
        JComboBox<String> endAmPm = createStyledComboBox(amPm);

        //! Adding components with GridBagLayout........................................
        gbc.gridx = 0; gbc.gridy = 0;
        timeSelectionPanel.add(startLabel, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        timeSelectionPanel.add(createTimePanel(startHour, startMinute, startAmPm), gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        timeSelectionPanel.add(endLabel, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        timeSelectionPanel.add(createTimePanel(endHour, endMinute, endAmPm), gbc);

        JButton addSlotButton = createStyledButton("Add Time Slot");
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.insets = new Insets(15, 5, 5, 5);
        timeSelectionPanel.add(addSlotButton, gbc);

        JPanel selectedSlotsPanel = new JPanel(new BorderLayout());
        selectedSlotsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        selectedSlotsPanel.setBackground(Color.WHITE);

        JLabel slotsLabel = new JLabel("Selected Time Slots");
        slotsLabel.setFont(LABEL_FONT);
        selectedSlotsPanel.add(slotsLabel, BorderLayout.NORTH);

        JList<String> selectedHoursList = new JList<>(timeSlotsModel);
        selectedHoursList.setBackground(SECONDARY_COLOR);
        selectedHoursList.setBorder(new EmptyBorder(5, 5, 5, 5));
        JScrollPane scrollPane = new JScrollPane(selectedHoursList);
        scrollPane.setPreferredSize(new Dimension(300, 150));
        selectedSlotsPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.WHITE);
        JButton doneButton = createStyledButton("Done");
        buttonPanel.add(doneButton);

        dialog.add(titlePanel, BorderLayout.NORTH);
        
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        centerPanel.add(timeSelectionPanel, BorderLayout.NORTH);
        centerPanel.add(selectedSlotsPanel, BorderLayout.CENTER);
        
        dialog.add(centerPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        ArrayList<String> timeSlots = new ArrayList<>();

        addSlotButton.addActionListener(e -> {
            String startTime = startHour.getSelectedItem() + ":" + startMinute.getSelectedItem() + " " + startAmPm.getSelectedItem();
            String endTime = endHour.getSelectedItem() + ":" + endMinute.getSelectedItem() + " " + endAmPm.getSelectedItem();
            String timeSlot = startTime + " - " + endTime;
            if (!timeSlots.contains(timeSlot)) {
                timeSlots.add(timeSlot);
                timeSlotsModel.addElement(timeSlot);
            }
        });

        doneButton.addActionListener(e -> {
            if (!timeSlots.isEmpty()) {
                selectedTime[0] = String.join(", ", timeSlots);
            }
            dialog.dispose();
        });

        dialog.pack();
        dialog.setLocationRelativeTo(parent);
        dialog.setMinimumSize(new Dimension(400, 500));
        dialog.setVisible(true);

        return selectedTime[0];
    }

    private static JPanel createTimePanel(JComboBox<String> hour, JComboBox<String> minute, JComboBox<String> amPm) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panel.setBackground(Color.WHITE);
        panel.add(hour);
        panel.add(new JLabel(":"));
        panel.add(minute);
        panel.add(amPm);
        return panel;
    }

    private static JComboBox<String> createStyledComboBox(String[] items) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(TEXT_COLOR);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
        return comboBox;
    }

    private static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(PRIMARY_COLOR);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBorder(new EmptyBorder(8, 15, 8, 15));
        return button;
    }

    public static void main(String[] args) {
        String selectedTime = setTimePickerDialog(null);
        System.out.println("Selected Time Slots: " + selectedTime);
    }
}