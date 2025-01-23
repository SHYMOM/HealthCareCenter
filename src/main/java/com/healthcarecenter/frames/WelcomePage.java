package com.healthcarecenter.frames;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.healthcarecenter.utils.FileUtils;
public class WelcomePage extends JFrame implements ActionListener
{
    JLabel label,title;
    JButton patient,doctor,admin;

    public WelcomePage()
    {
        //!Labels
        label = new JLabel("Welcome To Health Care Center");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0, 0, 400, 50);
        label.setForeground(new Color(0x00FF00));
        label.setFont(new Font("MV Boli", Font.BOLD, 20));

        //?Title
        title = new JLabel("Who Are You ?");
        title.setHorizontalAlignment(JLabel.LEFT);
        title.setBounds(50, 50, 400, 100);
        title.setForeground(new Color(0x00FF00));
        title.setFont(new Font("SansSerif", Font.ITALIC, 15));

        
        //!Buttons
        //?Patient
        patient = new JButton("I Am A Patient");
        patient.setBounds(100, 150, 200, 50);
        patient.setFocusable(false);
        patient.addActionListener(this);
        
        //?Doctor
        doctor = new JButton("I Am A Doctor");
        doctor.setBounds(100, 250, 200,50);
        doctor.setFocusable(false);
        doctor.addActionListener(this);

        //?Admin
        admin = new JButton("I Am An Admin");
        admin.setBounds(100, 350, 200, 50);
        admin.setFocusable(false);
        admin.addActionListener(this);


        //!! main frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 550);
        ImageIcon appIcon = new ImageIcon(FileUtils.getFile("/Icons/appIcon.png").getAbsolutePath());
        this.setIconImage(appIcon.getImage());
        this.setVisible(true);
        this.setTitle("Health Care Center");
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x123456));
        
        //? Adding components
        this.add(label);
        this.add(title);
        this.add(patient);
        this.add(doctor);
        this.add(admin);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == patient)
        {
            this.dispose();
            new LoginPage("User");
        }
        else if(e.getSource() == doctor)
        {
            new LoginPage("Doctor");
            this.dispose();
        }
        else if(e.getSource() == admin)
        {
            new LoginPage("Admin");
            this.dispose();
        }
    }
}