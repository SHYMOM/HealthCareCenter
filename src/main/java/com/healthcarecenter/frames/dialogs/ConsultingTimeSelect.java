package com.healthcarecenter.frames.dialogs;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class ConsultingTimeSelect {
    public static String setTimePickerDialog(JFrame parent) {
        String[] hours = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String[] minutes = {"00", "15", "30", "45"};
        String[] amPm = {"AM", "PM"};
        DefaultListModel<String> timeSlotsModel = new DefaultListModel<>();

        final String[] selectedTime = {""};

        JPanel panel = new JPanel(new GridLayout(0, 4));

        JComboBox<String> startHour = new JComboBox<>(hours);
        JComboBox<String> startMinute = new JComboBox<>(minutes);
        JComboBox<String> startAmPm = new JComboBox<>(amPm);
        JComboBox<String> endHour = new JComboBox<>(hours);
        JComboBox<String> endMinute = new JComboBox<>(minutes);
        JComboBox<String> endAmPm = new JComboBox<>(amPm);

        JButton addSlotButton = new JButton("Add Slot");

        panel.add(new JLabel("Start:"));
        panel.add(startHour);
        panel.add(startMinute);
        panel.add(startAmPm);

        panel.add(new JLabel("End:"));
        panel.add(endHour);
        panel.add(endMinute);
        panel.add(endAmPm);

        panel.add(addSlotButton);

        JDialog dialog = new JDialog(parent, "Select Consulting Hours", true);
        dialog.setLayout(new BorderLayout());
        dialog.add(panel, BorderLayout.CENTER);
        JList<String> selectedHoursList = new JList<>(timeSlotsModel);
        JScrollPane scrollPane = new JScrollPane(selectedHoursList);
        scrollPane.setPreferredSize(new Dimension(300, 100));
        dialog.add(scrollPane, BorderLayout.NORTH);
        JButton doneButton = new JButton("Done");
        dialog.add(doneButton, BorderLayout.SOUTH);
        dialog.pack();
        dialog.setLocationRelativeTo(parent);

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

        dialog.setVisible(true);
        return selectedTime[0];
    }

    public static void main(String[] args) {
        System.out.println(ConsultingTimeSelect.setTimePickerDialog(null));
    }
}
