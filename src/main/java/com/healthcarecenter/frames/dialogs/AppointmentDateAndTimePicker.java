package com.healthcarecenter.frames.dialogs;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AppointmentDateAndTimePicker {
    private static JDialog dialog;
    private static Calendar calendar;
    private static JPanel calendarPanel;
    private static JLabel monthLabel;
    private static JSpinner timeSpinner;
    private static Date selectedDateTime;
    private static boolean wasCancelled = true;
    private static JLabel selectedDateLabel;
    private static final Color HIGHLIGHT_COLOR = new Color(51, 153, 255);
    private static String selectedDate;

    public static String setAppointmentDateAndTimePicker(JFrame parent) {
        dialog = new JDialog(parent, "Select Date and Time", true);
        dialog.setLayout(new BorderLayout(0, 0));
        calendar = Calendar.getInstance();

        JPanel headerPanel = createHeaderPanel();
        calendarPanel = new JPanel(new GridLayout(0, 7, 5, 5));
        updateCalendar();

        JPanel timePanel = createTimePanel();
        JPanel selectedPanel = createSelectedPanel();
        JPanel buttonPanel = createButtonPanel();

        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(calendarPanel, BorderLayout.CENTER);
        contentPanel.add(timePanel, BorderLayout.SOUTH);

        dialog.add(contentPanel, BorderLayout.CENTER);
        dialog.add(selectedPanel, BorderLayout.NORTH);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.pack();
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true); // Ensure the dialog is displayed before returning the result.

        return wasCancelled ? null : formatSelectedDateTime();
    }

    private static JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.WHITE);

        JButton prevMonth = new JButton("←");
        styleNavigationButton(prevMonth);
        prevMonth.addActionListener(e -> {
            calendar.add(Calendar.MONTH, -1);
            updateCalendar();
        });

        monthLabel = new JLabel("", SwingConstants.CENTER);
        monthLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        monthLabel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

        JButton nextMonth = new JButton("→");
        styleNavigationButton(nextMonth);
        nextMonth.addActionListener(e -> {
            calendar.add(Calendar.MONTH, 1);
            updateCalendar();
        });

        headerPanel.add(prevMonth);
        headerPanel.add(monthLabel);
        headerPanel.add(nextMonth);
        return headerPanel;
    }

    private static void styleNavigationButton(JButton button) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setForeground(HIGHLIGHT_COLOR);
        button.setBackground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private static JPanel createTimePanel() {
        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        timePanel.setBackground(Color.WHITE);

        SpinnerDateModel timeModel = new SpinnerDateModel(new Date(), null, null, Calendar.HOUR);
        timeSpinner = new JSpinner(timeModel);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "hh:mm a");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setPreferredSize(new Dimension(120, 30));

        ((JSpinner.DefaultEditor) timeSpinner.getEditor()).getTextField().setFont(
            new Font("Segoe UI", Font.PLAIN, 14)
        );

        timePanel.add(new JLabel("Time: "));
        timePanel.add(timeSpinner);
        return timePanel;
    }


    private static JPanel createSelectedPanel() {
        JPanel selectedPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        selectedPanel.setBackground(HIGHLIGHT_COLOR);
        selectedPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        selectedDateLabel = new JLabel("Select a date", SwingConstants.CENTER);
        selectedDateLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        selectedDateLabel.setForeground(Color.WHITE);

        selectedPanel.add(selectedDateLabel);
        return selectedPanel;
    }

    private static JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(Color.WHITE);

        JButton okButton = new JButton("Confirm");
        JButton cancelButton = new JButton("Cancel");

        styleButton(okButton);
        styleButton(cancelButton);

        okButton.addActionListener(e -> {
            wasCancelled = false;
            Calendar selectedTime = Calendar.getInstance();
            selectedTime.setTime((Date) timeSpinner.getValue());

            calendar.set(Calendar.HOUR_OF_DAY, selectedTime.get(Calendar.HOUR_OF_DAY));
            calendar.set(Calendar.MINUTE, selectedTime.get(Calendar.MINUTE));

            selectedDateTime = calendar.getTime();
            if (selectedDateTime.before(new Date())) {
                selectedDateTime = null;
                JOptionPane.showMessageDialog(null, "Selected date and time is in the past.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
            dialog.dispose();
            }
        });

        cancelButton.addActionListener(e -> {
            wasCancelled = true;
            dialog.dispose();
        });

        buttonPanel.add(cancelButton);
        buttonPanel.add(okButton);
        return buttonPanel;
    }

    private static void updateCalendar() {
        calendarPanel.removeAll();
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM yyyy");
        monthLabel.setText(monthFormat.format(calendar.getTime()));

        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : daysOfWeek) {
            JLabel label = new JLabel(day, SwingConstants.CENTER);
            label.setFont(new Font("Segoe UI", Font.BOLD, 12));
            calendarPanel.add(label);
        }

        Calendar temp = (Calendar) calendar.clone();
        temp.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfWeek = temp.get(Calendar.DAY_OF_WEEK) - 1;
        int maxDays = temp.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 0; i < firstDayOfWeek; i++) {
            calendarPanel.add(new JLabel(""));
        }

        for (int day = 1; day <= maxDays; day++) {
            JButton dayButton = new JButton(String.valueOf(day));
            dayButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            dayButton.setFocusPainted(false);
            dayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            if (day == calendar.get(Calendar.DAY_OF_MONTH)) {
                    dayButton.setBackground(HIGHLIGHT_COLOR);
                    dayButton.setForeground(Color.WHITE);
            } else {
                    dayButton.setBackground(Color.WHITE);
                    dayButton.setForeground(Color.BLACK);
            }

            int selectedDay = day;
            dayButton.addActionListener(e -> {
                calendar.set(Calendar.DAY_OF_MONTH, selectedDay);
                updateSelectedDateLabel();
                updateCalendar();
            });

            calendarPanel.add(dayButton);
        }

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    private static void updateSelectedDateLabel() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        selectedDate = sdf.format(calendar.getTime());
        selectedDateLabel.setText(selectedDate);
    }

    private static String formatSelectedDateTime() {
        if (selectedDateTime == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
        return sdf.format(selectedDateTime);
    }

    private static void styleButton(JButton button) {
        button.setBackground(new Color(51, 153, 255));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 123, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(51, 153, 255));
            }
        });
    }

    public static void main(String[] args) {
        String selectedDateTime = setAppointmentDateAndTimePicker(null);
        System.out.println("Selected Date and Time: " + selectedDateTime);
    }
}
