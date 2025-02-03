package com.healthcarecenter.frames;

import com.healthcarecenter.models.CurrentUser;
import com.healthcarecenter.utils.FileUtils;
import com.healthcarecenter.utils.FrameUtils;
import com.healthcarecenter.utils.GetUserData;
import com.healthcarecenter.utils.HealthTips;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
public class DoctorHomePage extends JFrame implements ActionListener
{
    private String name;
    private String username;


    public DoctorHomePage(String value, boolean isUsername) {
        if (!isUsername) {
            try {
                username = FileUtils.getUsernameByEmail(value, "/data/doctors/");
               
                if (username == null) {
                        JOptionPane.showMessageDialog(null, "No user found with the given email."+value);
                        new WelcomePage();
                        this.dispose();
                        return;
                    }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Error fetching user data: " + e.getMessage());
                new WelcomePage();
                this.dispose();
                return;
            }
        } else {
            this.username = value;
        }

        if (this.username == null || this.username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid username detected.");
            new WelcomePage();
            this.dispose();
            return;
        }

        try {
            this.name = GetUserData.getName(username);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error fetching user data: " + e.getMessage());
            new WelcomePage();
            this.dispose();
            return;
        }

        try {
            CurrentUser.saveCurrentUserToFile("/data/CurrentUser/CurrentUser.txt", GetUserData.getEmail(username), "user");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving current user data: " + e.getMessage());
        }

        UserUI();
    }

    private void UserUI()
    {
        JPanel panel = new JPanel();                                  
        panel.setBounds(0,0,900,600);
        panel.setBackground(Color.red);
        panel.setLayout(null);


        panel.add(createUpperpanel());
        panel.add(createLowerpanel());
        
        ImageIcon appIcon = new ImageIcon(FileUtils.getFile("/Icons/appIcon.png").getAbsolutePath());
        this.setIconImage(appIcon.getImage());

        this.setTitle("HealthCareCenter.DoctorPage");      
        this.setLayout(null);
        this.setSize(900, 600);                       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          
        this.getContentPane().setBackground(Color.BLUE);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        this.setVisible(true);

        this.add(panel);
   

    }

    private JPanel createUpperpanel()
    {
        JPanel upper_panel = new JPanel();                                  
        upper_panel.setLayout(null);
        upper_panel.setBounds(0,0,900,180);
        upper_panel.setBackground(Color.gray);
		upper_panel.setBackground(new Color(0x3a8cdb));
		

        JLabel label = new JLabel("Health Care Center");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(100,10,600,50);
        label.setForeground(new Color(000000));
        label.setFont(new Font("MV Boli", Font.BOLD, 20));
        label.setLayout(null);
        upper_panel.add(label);

        
        

       //create userpanel for upper_panel
        JPanel user_panel = new JPanel(); 
        user_panel.setLayout(null);
        user_panel.setBounds(5,5,200,40);
        //user_panel.setBackground(Color.yellow);
		user_panel.setBackground(new Color(0x3a8cdb));
		
        upper_panel.add(user_panel);


        JLabel userlabel = new JLabel(name);
        userlabel.setHorizontalAlignment(JLabel.CENTER);
        userlabel.setBounds(5,5,100,30);
        userlabel.setFont(new Font("SensSerif", Font.PLAIN, 15));
        user_panel.add(userlabel);
        upper_panel.add(createMiddlepanel());

        

        return upper_panel;
    }

    private JPanel createMiddlepanel()
    {
        JPanel middle_panel = new JPanel();                                  
        middle_panel.setLayout(null);
        middle_panel.setBounds(0,130,900,50);
        middle_panel.setBackground(new Color(10, 10, 10));
		middle_panel.setBackground(new Color(0x3a8cdb));
		
		
		//level for home 
		JLabel home= new JLabel();
         home.setText("Home");
         home.setForeground(Color.white);
         home.setFont(new Font("SansSerif", Font.PLAIN, 15));
         home.setBounds(25, 15, 42, 20);


        //level for appoinment
         JLabel appoinment= new JLabel();
         appoinment.setText("View Appoinment");
         appoinment.setForeground(new Color(000000));
         appoinment.setFont(new Font("SansSerif", Font.PLAIN, 15));
         appoinment.setBounds(110, 15, 120, 20);

          //level for records
        JLabel records = new JLabel();
        records.setText("Access patient Records");
        records.setForeground(new Color(000000));
        records.setFont(new Font("SansSerif", Font.PLAIN, 15));
        records.setBounds(275, 15, 165, 20);

         //level for prescripitions
         JLabel prescripitions = new JLabel();
         prescripitions.setText("Add prescripitions");
         prescripitions.setForeground(new Color(000000));
         prescripitions.setFont(new Font("SansSerif", Font.PLAIN, 15));
         prescripitions.setBounds(500, 15, 125, 20);

         //level for logout
         JLabel log_out = new JLabel();
         log_out.setText("Log out");
         log_out.setForeground(new Color(000000));
         log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
         log_out.setBounds(650, 15, 60, 20);
 
 
          //add level in middle_panel
		  middle_panel.add(home);
          middle_panel.add(appoinment);
          middle_panel.add(records);
          middle_panel.add(prescripitions);
		  middle_panel.add(log_out);
        
  
          


            appoinment.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                appoinment.setForeground(new Color(0x00FF00));
                appoinment.setFont(new Font("SansSerif", Font.PLAIN, 17));
				appoinment.setBounds(105, 10, 130, 30);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                appoinment.setForeground(new Color(0, 0, 0));
                appoinment.setFont(new Font("SansSerif", Font.PLAIN, 15));
				appoinment.setBounds(110, 15, 120, 20);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(appoinment).dispose();
				 new DoctorViewAppoinmentsPage(username);
                
            }
        });

        records.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                records.setForeground(new Color(0x00FF00));
                records.setFont(new Font("SansSerif", Font.PLAIN, 17));
				records.setBounds(270, 10, 180, 30);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                records.setForeground(new Color(0, 0, 0));
                records.setFont(new Font("SansSerif", Font.PLAIN, 15));
				records.setBounds(275, 15, 165, 20);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
				SwingUtilities.getWindowAncestor(records).dispose();
				new DoctorPatientRecordsPage(username);
                
            }
        });
        


        prescripitions.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                prescripitions .setForeground(new Color(0x00FF00));
                prescripitions.setFont(new Font("SansSerif", Font.PLAIN, 17));
				prescripitions.setBounds(495, 10, 170, 30);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                prescripitions.setForeground(new Color(0, 0, 0));
                prescripitions.setFont(new Font("SansSerif", Font.PLAIN, 15));
		        prescripitions.setBounds(500, 15, 125, 20);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
				 SwingUtilities.getWindowAncestor(prescripitions).dispose();
				new DoctorAddPrescripitionsPage(username);
                
            }
        });



         log_out.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
            log_out.setForeground(new Color(0x00FF00));
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 17));
			log_out.setBounds(648, 12, 66, 25);
			
          }
          @Override
        public void mouseExited(MouseEvent e) {
            log_out.setForeground(new Color(0, 0, 0));
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
			log_out.setBounds(650, 15, 60, 20);
			
          }
         @Override
         public void mouseClicked(MouseEvent e)  
         {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(e.getComponent());
         FrameUtils.frameLogOut(frame);
     }
 });






        return middle_panel;
    }

    private JPanel createLowerpanel()
    {
        JPanel lower_panel = new JPanel();                                  
        lower_panel.setLayout(null);
        lower_panel.setBounds(0,180,900,500);
        lower_panel.setBackground(new Color(0xECF8FD));
        

        JLabel welcome= new JLabel("Welcome "+name);
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setBounds(300,330,300,30);
        welcome.setFont(new Font("SensSerif", Font.PLAIN, 20));

        HealthTips healthTips = new HealthTips();
        JLabel health_tips= new JLabel(healthTips.getRandomHealthTip());
        health_tips.setHorizontalAlignment(JLabel.CENTER);
        health_tips.setBounds(0,300,900,30);
        health_tips.setFont(new Font("SensSerif", Font.PLAIN, 15));


        lower_panel.add(welcome);
        lower_panel.add(health_tips, BorderLayout.CENTER);

        return lower_panel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // code to handle the action event
    }

    public static void main(String[] args) {
        new DoctorHomePage("emiko",true);
    }

}

