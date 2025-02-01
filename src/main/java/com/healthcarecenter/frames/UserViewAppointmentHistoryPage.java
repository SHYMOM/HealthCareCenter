package com.healthcarecenter.frames;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import com.healthcarecenter.utils.FileUtils;
import com.healthcarecenter.utils.GetUserData;
public class UserViewAppointmentHistoryPage extends JFrame implements ActionListener
{
    String username;
    String name;

    public UserViewAppointmentHistoryPage()
    {
        try {
            this.name = GetUserData.getName(username);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error fetching user data: " + e.getMessage());
            new WelcomePage();
            this.dispose();
            return;
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
        home.setForeground(new Color(000000));
        home.setFont(new Font("SansSerif", Font.PLAIN, 15));
        home.setBounds(15, 15, 50, 20);
        home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        home.setToolTipText("Home");



         //level for appointment
         JLabel appointment= new JLabel();
         appointment.setText("See appointment History");
         appointment.setForeground(Color.red);
         appointment.setFont(new Font("SansSerif", Font.PLAIN, 15));
         appointment.setBounds(90, 15, 120, 20);
         appointment.setToolTipText("See appointment History");

          //level for history
        JLabel History = new JLabel();
        History.setText("View Medicle History");
        History.setForeground(new Color(000000));
        History.setFont(new Font("SansSerif", Font.PLAIN, 15));
        History.setBounds(235, 15, 140,20);
        History.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        History.setToolTipText("View Medicle History");

         //level for blood
         JLabel blood = new JLabel();
         blood.setText("Blood Bank");
         blood.setForeground(new Color(000000));
         blood.setFont(new Font("SansSerif", Font.PLAIN, 15));
         blood.setBounds(400, 15, 80,  20);
         blood.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
         blood.setToolTipText("Blood Bank");

          //level for bill
        JLabel bill = new JLabel();
        bill.setText("Pay Bill");
        bill.setForeground(new Color(000000));
        bill.setFont(new Font("SansSerif", Font.PLAIN, 15));
        bill.setBounds(505, 15, 50, 20);
        bill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bill.setToolTipText("Pay Bill");

         //level for log out
         JLabel log_out = new JLabel();
         log_out.setText("Log Out");
         log_out.setForeground(new Color(000000));
         log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
         log_out.setBounds(580, 15, 80, 20);
         log_out.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
         log_out.setToolTipText("Log Out");
 
          //add level in middle_panel
          middle_panel.add(home);
          middle_panel.add(appointment);
          middle_panel.add(History);
          middle_panel.add(blood);
          middle_panel.add(bill);
          middle_panel.add(log_out);


        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               home.setForeground(new Color(0x00FF00));
               home.setBounds(13, 10, 60, 30);
               home.setFont(new Font("SansSerif", Font.PLAIN, 17));
    
            }
            @Override
          public void mouseExited(MouseEvent e) {
                home.setForeground(new Color(000000)); 
                home.setBounds(15, 15, 50, 20);
                home.setFont(new Font("SansSerif", Font.PLAIN, 15));
                 
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(appointment).dispose();
                //new userHomePage();
            }
        });



        appointment.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                appointment.setForeground(Color.red);
                appointment.setBounds(90, 15, 120, 20);
                appointment.setFont(new Font("SansSerif", Font.PLAIN, 15));

            }
            @Override
            public void mouseExited(MouseEvent e) {
                appointment.setForeground(Color.red);
                appointment.setBounds(90, 15, 120, 20);
                appointment.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
               // SwingUtilities.getWindowAncestor(appointment).dispose();
                
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
                SwingUtilities.getWindowAncestor(appointment).dispose();
                new UserBillingHistoryPage(username);  
            }
        });
        


        blood .addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                blood .setForeground(new Color(0x00FF00));
                blood.setBounds(398, 10, 85, 30);
                blood.setFont(new Font("SansSerif", Font.PLAIN, 17));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                blood .setForeground(new Color(000000));
                blood.setBounds(400, 15, 80, 20);
                blood.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(appointment).dispose(); 
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
            SwingUtilities.getWindowAncestor(appointment).dispose(); 
            new UserBillingHistoryPage(username);
          }
      });


      log_out.addMouseListener(new MouseAdapter() 
     {
          @Override
          public void mouseEntered(MouseEvent e) {
            log_out.setForeground(new Color(0x00FF00));
            log_out.setBounds(578, 10, 60, 30);
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 17));
          }
          @Override
        public void mouseExited(MouseEvent e) {
            log_out.setForeground(new Color(000000));
            log_out.setBounds(580, 15, 55, 20);
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
          }
          @Override
          public void mouseClicked(MouseEvent e) 
          {
            int result = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION)
             {
                System.out.println("Yes selected");
                SwingUtilities.getWindowAncestor(appointment).dispose();
                //new loginFrame();
            }  
            else if (result == JOptionPane.NO_OPTION)
            {
                System.out.println("No selected");
            } 
            else if (result == JOptionPane.CANCEL_OPTION) 
            {
                System.out.println("Cancel selected");
            }
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
        

        return lower_panel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // code to handle the action event
    }

    public static void main(String[] args)
    {
        new UserViewAppointmentHistoryPage();
    }
}