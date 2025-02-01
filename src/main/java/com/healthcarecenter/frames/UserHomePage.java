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
        label.setForeground(new Color(0x00FF00));
        label.setFont(new Font("MV Boli", Font.BOLD, 20));
        label.setLayout(null);
        upper_panel.add(label);

        
        

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
        home.setForeground(Color.red);
        home.setFont(new Font("SansSerif", Font.PLAIN, 15));
        home.setBounds(15, 15, 50, 20);



         //level for appoinment
         JLabel appoinment= new JLabel();
         appoinment.setText("Book Appoinment");
         appoinment.setForeground(new Color(000000));
         appoinment.setFont(new Font("SansSerif", Font.PLAIN, 15));
         appoinment.setBounds(90, 15, 120, 20);

          //level for history
        JLabel History = new JLabel();
        History.setText("View Medicle History");
        History.setForeground(new Color(000000));
        History.setFont(new Font("SansSerif", Font.PLAIN, 15));
        History.setBounds(235, 15, 140, 20);

         //level for billingHistory
         JLabel billingHistory = new JLabel();
         billingHistory.setText("Billing History");
         billingHistory.setForeground(new Color(000000));
         billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
         billingHistory.setBounds(400, 15, 80, 20);

          //level for bill
        JLabel bill = new JLabel();
        bill.setText("Pay Bill");
        bill.setForeground(new Color(000000));
        bill.setFont(new Font("SansSerif", Font.PLAIN, 15));
        bill.setBounds(505, 15, 50, 20);

         //level for log out
         JLabel log_out = new JLabel();
         log_out.setText("LogOut");
         log_out.setForeground(new Color(000000));
         log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
         log_out.setBounds(580, 15, 50, 20);
 
          //add level in middle_panel
          middle_panel.add(home);
          middle_panel.add(appoinment);
          middle_panel.add(History);
          middle_panel.add(billingHistory);
          middle_panel.add(bill);
          middle_panel.add(log_out);


        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               home.setForeground(Color.red);
               home.setBounds(15, 15, 50, 20);
               home.setFont(new Font("SansSerif", Font.PLAIN, 15));
    
            }
            @Override
          public void mouseExited(MouseEvent e) {
                home.setForeground(Color.red); 
                home.setBounds(15, 15, 50, 20);
                home.setFont(new Font("SansSerif", Font.PLAIN, 15));
                 
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                //SwingUtilities.getWindowAncestor(home).dispose();
            }
        });



        appoinment.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                appoinment.setForeground(new Color(0x00FF00));
                appoinment.setBounds(85, 10, 130, 30);
                appoinment.setFont(new Font("SansSerif", Font.PLAIN, 17));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                appoinment.setForeground(new Color(000000));
                appoinment.setBounds(90, 15, 120, 20);
                appoinment.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(home).dispose();
                new UserBookAppointmentPage(username);
            }
        });

        History.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                History.setForeground(new Color(0x00FF00));
                History.setBounds(230,10, 155, 30);
                History.setFont(new Font("SansSerif", Font.PLAIN,17));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                History.setForeground(new Color(000000));
                History.setBounds(235, 15, 140, 20);
                History.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(home).dispose();  
                new UserMedicalHistoryPage(username);
            }
        });
        


        billingHistory .addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                billingHistory .setForeground(new Color(0x00FF00));
                billingHistory.setBounds(398, 10, 85,  30);
                billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 17));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                billingHistory .setForeground(new Color(000000));
                billingHistory.setBounds(400, 15, 80,   20);
                billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(home).dispose(); 
                new UserBillingHistoryPage(username);
            }
        });



        bill.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bill.setForeground(new Color(0x00FF00));
                bill.setBounds(503, 10, 55, 30);
                bill.setFont(new Font("SansSerif", Font.PLAIN, 17));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                bill.setForeground(new Color(000000));
                bill.setBounds(505, 15, 50, 20);
                bill.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(home).dispose(); 
                new UserPayBillPage(username); 
            }
        });


    log_out.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            log_out.setForeground(new Color(0x00FF00));
            log_out.setBounds(578, 10, 60, 30);
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 17));
        }
        @Override
        public void mouseExited(MouseEvent e) {
            log_out.setForeground(new Color(000000));
            log_out.setBounds(580, 15, 50,20);
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

    private JPanel createLowerpanel()
    {
        JPanel lower_panel = new JPanel();                                  
        lower_panel.setLayout(null);
        lower_panel.setBounds(0,200,900,500);
        lower_panel.setBackground(Color.white);
        
        ImagePanel image_panel = new ImagePanel("HealthCareCenter/src/main/resources/Images/signUpBG1.jpg");
        image_panel.setBounds(0,0,900,300);
        image_panel.setLayout(null);
        image_panel.setOpaque(false);
        lower_panel.add(image_panel);

        JLabel welcome= new JLabel("Welcome "+ name);
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setBounds(300,330,300,30);
        welcome.setFont(new Font("SensSerif", Font.PLAIN, 20));

        HealthTips healthTips = new HealthTips();
        JLabel health_tips= new JLabel(healthTips.getRandomHealthTip());
        health_tips.setHorizontalAlignment(JLabel.CENTER);
        health_tips.setBounds(0,300,900,30);
        health_tips.setFont(new Font("SensSerif", Font.PLAIN, 15));


        health_tips.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
              health_tips.setForeground(new Color(0x00FF00));
              health_tips.setBounds(0,300,900,30);
              health_tips.setFont(new Font("SensSerif", Font.PLAIN, 15));
            }
            @Override
          public void mouseExited(MouseEvent e) {
              health_tips.setForeground(Color.black);
              health_tips.setBounds(0,300,900,30);
              health_tips.setFont(new Font("SensSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
              //SwingUtilities.getWindowAncestor(health_tips).dispose();
            }
        });


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
        new UserHomePage("emiko@gmail.com", false);
    }

}
