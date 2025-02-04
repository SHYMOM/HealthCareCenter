package com.healthcarecenter.frames;

import com.healthcarecenter.models.*;
import com.healthcarecenter.utils.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
public class UserHomePage extends JFrame implements ActionListener
{
    private String name;
    private String username;

    public UserHomePage(String value, boolean isUsername) {
        if (!isUsername) {
            try {
                username = FileUtils.getUsernameByEmail(value, "/data/users/");
               
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

        this.setTitle("Health Care Center");      
        this.setLayout(null);
        this.setSize(900, 600);                        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setResizable(false); 
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.add(panel);
   

    }

    private JPanel createUpperpanel()
    {
        JPanel upper_panel = new JPanel();                                  
        upper_panel.setLayout(null);
        upper_panel.setBounds(0,0,900,200);
        upper_panel.setBackground(new Color(0x3a8cdb));

        JLabel label = new JLabel("Health Care Center");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(100,10,600,50);
        label.setForeground(new Color(000000));
        label.setFont(new Font("MV Boli", Font.BOLD, 20));
        label.setLayout(null);
        upper_panel.add(label);

        
        ImageIcon settingIcon = ImageCompressor.compressImage(FileUtils.getFile("/Icons/settings.png").getAbsolutePath(), 25, 25);
        JLabel settings = new JLabel(settingIcon);
        settings.setBounds(850, 10, 25, 25);
        settings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        settings.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object[] options = {"Edit Profile", "Cancel","Delete Account"};
				int choice = JOptionPane.showOptionDialog(null,"Choose an option:","Custom Option Dialog",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
					if (choice == 0) {
						new UserSignUp("Edit", username);
					} else if (choice == 1) {
						
					} else if (choice == 2) {
                        String confirmText = JOptionPane.showInputDialog(null, "Write 'Confirm' to delete account");
                        if (confirmText != null && confirmText.equals("Confirm")) {
                            try {
                                FileUtils.deleteFile(username);
                                new WelcomePage();
                                dispose();
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "Error deleting account: " + ex.getMessage());
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "Confirmation text does not match.");
                        }
					}
            }
        });

       //create userpanel for upper_panel
        JPanel user_panel = new JPanel(); 
        user_panel.setLayout(null);
        user_panel.setBounds(5,5,200,40);
        user_panel.setBackground(new Color(0x3a8cdb));
        upper_panel.add(user_panel);


        JLabel userlabel = new JLabel(name);
        userlabel.setHorizontalAlignment(JLabel.CENTER);
        userlabel.setBounds(5,5,100,30);
        userlabel.setFont(new Font("SensSerif", Font.PLAIN, 15));
        user_panel.add(userlabel);
        upper_panel.add(settings);
        upper_panel.add(createMiddlepanel());

        

        return upper_panel;
    }

    private JPanel createMiddlepanel()
    {
        JPanel middle_panel = new JPanel();                                  
        middle_panel.setLayout(null);
        middle_panel.setBounds(0,150,900,50);
        middle_panel.setBackground(new Color(0x3a8cdb));


        //level for home
        JLabel home = new JLabel();
        home.setText("Home");
        home.setForeground(new Color(255, 255, 255));
        home.setFont(new Font("SansSerif", Font.PLAIN, 15));
        home.setBounds(15, 15, 50, 20);



         //level for appoinment
         JLabel appointment= new JLabel();
         appointment.setText("Book Appointment");
         appointment.setForeground(new Color(000000));
         appointment.setFont(new Font("SansSerif", Font.PLAIN, 15));
         appointment.setBounds(85, 15, 120, 20);

         //level for Appointment History
         JLabel appointmentHistory = new JLabel();
         appointmentHistory.setText("View Appointment History");
         appointmentHistory.setForeground(new Color(000000));
         appointmentHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
         appointmentHistory.setBounds(225, 15, 165, 20);

          //level for history
        JLabel History = new JLabel();
        History.setText("View Medicle History");
        History.setForeground(new Color(000000));
        History.setFont(new Font("SansSerif", Font.PLAIN, 15));
        History.setBounds(410, 15, 140, 20);

          //level for bill
          JLabel bill = new JLabel();
          bill.setText("Pay Bill");
          bill.setForeground(new Color(000000));
          bill.setFont(new Font("SansSerif", Font.PLAIN, 15));
          bill.setBounds(570, 15, 50, 20);


         //level for billingHistory
         JLabel billingHistory = new JLabel();
         billingHistory.setText("Billing History");
         billingHistory.setForeground(new Color(000000));
         billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
         billingHistory.setBounds(640, 15, 90, 20);


         //level for log out
         JLabel log_out = new JLabel();
         log_out.setText("LogOut");
         log_out.setForeground(new Color(000000));
         log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
         log_out.setBounds(750, 15, 50, 20);
 
          //add level in middle_panel
          middle_panel.add(home);
          middle_panel.add(appointment);
          middle_panel.add(appointmentHistory);
          middle_panel.add(History);
          middle_panel.add(bill);
          middle_panel.add(billingHistory);
          middle_panel.add(log_out);


        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               home.setForeground(new Color(255, 255, 255));
               home.setBounds(15, 15, 50, 20);
               home.setFont(new Font("SansSerif", Font.PLAIN, 15));
    
            }
            @Override
          public void mouseExited(MouseEvent e) {
                home.setForeground(new Color(255, 255, 255)); 
                home.setBounds(15, 15, 50, 20);
                home.setFont(new Font("SansSerif", Font.PLAIN, 15));
                 
            }
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });



        appointment.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                appointment.setForeground(new Color(0x00FF00));
                appointment.setBounds(80, 10, 135, 30);
                appointment.setFont(new Font("SansSerif", Font.PLAIN, 17));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                appointment.setForeground(new Color(000000));
                appointment.setBounds(85, 15, 120, 20);
                appointment.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(home).dispose();
                new UserBookAppointmentPage(username);
            }
        });


        appointmentHistory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                appointmentHistory.setForeground(new Color(0x00FF00));
                appointmentHistory.setBounds(220, 10, 180, 30);
                appointmentHistory.setFont(new Font("SansSerif", Font.PLAIN, 16));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                appointmentHistory.setForeground(new Color(000000));
                appointmentHistory.setBounds(225, 15, 165, 20);
                appointmentHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(home).dispose();
                new UserViewAppointmentHistoryPage(username);
            }
        });


        History.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                History.setForeground(new Color(0x00FF00));
                History.setBounds(405,10, 155, 30);
                History.setFont(new Font("SansSerif", Font.PLAIN,17));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                History.setForeground(new Color(000000));
                History.setBounds(410, 15, 140, 20);
                History.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(home).dispose();  
                new UserMedicalHistoryPage(username);
            }
        });
        

        bill.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bill.setForeground(new Color(0x00FF00));
                bill.setBounds(565, 10, 55, 30);
                bill.setFont(new Font("SansSerif", Font.PLAIN, 17));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                bill.setForeground(new Color(000000));
                bill.setBounds(570, 15, 50, 20);
                bill.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(home).dispose(); 
                new UserPayBillPage(username); 
            }
        });

        billingHistory .addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                billingHistory .setForeground(new Color(0x00FF00));
                billingHistory.setBounds(638, 10, 100,  30);
                billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 17));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                billingHistory .setForeground(new Color(000000));
                billingHistory.setBounds(640, 15, 90, 20);
                billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(home).dispose(); 
                new UserBillingHistoryPage(username);
            }
        });



    log_out.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            log_out.setForeground(new Color(0x00FF00));
            log_out.setBounds(748, 10, 60, 30);
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 17));
        }
        @Override
        public void mouseExited(MouseEvent e) {
            log_out.setForeground(new Color(000000));
            log_out.setBounds(750, 15, 50,20);
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(e.getComponent());
            FrameUtils.frameLogOut(frame);
        }
    });
 
        return middle_panel;
    }

    private ImagePanel createLowerpanel()
    {
        ImagePanel lower_panel = new ImagePanel(GetRandomImage.getRandomImage());

                                         
        lower_panel.setLayout(null);
        lower_panel.setBounds(0,130,900,500);
        lower_panel.setBackground(new Color(0xECF8FD));
       

        JLabel welcome= new JLabel("Welcome "+name);
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setBounds(300,380,300,30);
        welcome.setForeground(new Color(205,194,245));
        welcome.setFont(new Font("SensSerif", Font.PLAIN, 20));

        HealthTips healthTips = new HealthTips();
        JLabel health_tips= new JLabel(healthTips.getRandomHealthTip());
        health_tips.setHorizontalAlignment(JLabel.CENTER);
        health_tips.setBounds(0,350,900,30);
        health_tips.setForeground(new Color(229,222,207));
        health_tips.setFont(new Font("SensSerif", Font.PLAIN, 15));


        lower_panel.add(welcome);
        lower_panel.add(health_tips);

        return lower_panel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // code to handle the action event
    }

     public static void main(String[] args) {
        new UserHomePage("emiko@gmail.com", false);
    }

}
