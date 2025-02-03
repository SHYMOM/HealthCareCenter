package com.healthcarecenter.frames;
import com.healthcarecenter.frames.dialogs.BillPaymentDialog;
import com.healthcarecenter.utils.FileUtils;
import com.healthcarecenter.utils.FrameUtils;
import com.healthcarecenter.utils.GetUserData;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.*;
public class UserPayBillPage extends JFrame implements ActionListener
{
    private String username;
    private String name;
    private double totalAmount = 0.0;
    public UserPayBillPage(String username)
    {
        this.username = username;
        

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
        label.setForeground(new Color(000000));
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



         //level for appointment
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
          bill.setForeground(new Color(255, 255, 255));
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
                SwingUtilities.getWindowAncestor(bill).dispose();
                new UserHomePage(username, true);
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
                SwingUtilities.getWindowAncestor(bill).dispose();
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
                SwingUtilities.getWindowAncestor(bill).dispose();
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
                SwingUtilities.getWindowAncestor(bill).dispose();  
                new UserMedicalHistoryPage(username);
            }
        });
        


        bill.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bill.setForeground(new Color(255, 255, 255));
                bill.setBounds(570, 15, 50, 20);
                bill.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                bill.setForeground(new Color(255, 255, 255));
                bill.setBounds(570, 15, 50, 20);
                bill.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
          @Override
          public void mouseClicked(MouseEvent e) {
            //SwingUtilities.getWindowAncestor(bill).dispose();  
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
            SwingUtilities.getWindowAncestor(bill).dispose();
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

    private JPanel createLowerpanel()
    {
        JPanel lower_panel = new JPanel();                                  
        lower_panel.setLayout(null);
        lower_panel.setBounds(0,200,900,500);
        lower_panel.setBackground(Color.white);
        

         //level for Pay Bill
         JLabel payBill = new JLabel();
         payBill.setText("Pay Bill");
         payBill.setForeground(new Color(000000));
         payBill.setFont(new Font("SansSerif", Font.PLAIN, 20));
         payBill.setBounds(415,25,80,30);


        
          //level Appointment cost
          JLabel level1 = new JLabel();
          level1.setText("Appointment cost  =");
          level1.setForeground(new Color(000000));
          level1.setFont(new Font("SansSerif", Font.PLAIN, 15));
          level1.setBounds(350,85,150,20);

          JLabel appontmentCost = new JLabel(); 
          appontmentCost.setText("00.00");      
          appontmentCost.setForeground(new Color(000000));
          appontmentCost.setFont(new Font("SansSerif", Font.PLAIN, 15));
          appontmentCost.setBounds(505,85,150,20);
         
          //level Medicle cost
          JLabel level2 = new JLabel();
          level2.setText("Medical cost          =");
          level2.setForeground(new Color(000000));
          level2.setFont(new Font("SansSerif", Font.PLAIN, 15));
          level2.setBounds(350,105,150,20);

          JLabel medicalCost = new JLabel();
          medicalCost.setText("00.00");
          medicalCost.setForeground(new Color(000000));
          medicalCost.setFont(new Font("SansSerif", Font.PLAIN, 15));
          medicalCost.setBounds(505,105,150,20);

          //level Test cost
          JLabel level3 = new JLabel();
          level3.setText("Test cost               =");
          level3.setForeground(new Color(000000));
          level3.setFont(new Font("SansSerif", Font.PLAIN, 15));
          level3.setBounds(350,125,150,20);

          JLabel testCost = new JLabel();
          testCost.setText("00.00");
          testCost.setForeground(new Color(000000));
          testCost.setFont(new Font("SansSerif", Font.PLAIN, 15));
          testCost.setBounds(505,125,150,20);


            //level Others cost
            JLabel level4 = new JLabel();
            level4.setText("Others cost           =");
            level4.setForeground(new Color(000000));
            level4.setFont(new Font("SansSerif", Font.PLAIN, 15));
            level4.setBounds(350,145,150,20);
  
            JLabel otherCost = new JLabel();
            otherCost.setText("00.00");
            otherCost.setForeground(new Color(000000));
            otherCost.setFont(new Font("SansSerif", Font.PLAIN, 15));
            otherCost.setBounds(505,145,150,20);


            JLabel level5 = new JLabel();
            level5.setText("-------------------------------------------------------------------");
            level5.setForeground(new Color(000000));
            level5.setFont(new Font("SansSerif", Font.PLAIN, 15));
            level5.setBounds(290,165,350,5);


            //level Total cost
            JLabel level6 = new JLabel();
            level6.setText("Total cost              =");
            level6.setForeground(new Color(000000));
            level6.setFont(new Font("SansSerif", Font.PLAIN, 15));
            level6.setBounds(350,180,150,20);
            JLabel totalCost = new JLabel();
            totalCost.setText(String.valueOf(totalAmount));
            totalCost.setForeground(new Color(000000));
            totalCost.setFont(new Font("SansSerif", Font.PLAIN, 15));
            totalCost.setBounds(505,180,150,20);

            try {
                HashMap<String, Double> bills = GetUserData.getBills(username);
                appontmentCost.setText(bills.get("appointmentCost").toString());
                medicalCost.setText(bills.get("medicineCost").toString());
                testCost.setText(bills.get("testCost").toString());
                otherCost.setText(bills.get("otherCost").toString());
                totalAmount = bills.get("appointmentCost") + bills.get("medicineCost") + bills.get("testCost") + bills.get("otherCost");
                totalCost.setText(String.valueOf(totalAmount));
            } catch (IOException ex) 
            {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Button Total cost
            JButton payButton = new JButton("Pay");
            payButton.setFont(new Font("SansSerif", Font.BOLD, 20));
            payButton.setBounds(415,280,70,40);
            payButton.setFocusable(false);
            payButton.setBackground(new Color(0x182838));
            payButton.setForeground(new Color(25, 117, 255));

            payButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                payButton.setBorder(BorderFactory.createLineBorder(new Color(0x00FF00), 2, true));
                payButton.setForeground(new Color(0x00FF00));
                payButton.setFont(new Font("SansSerif", Font.BOLD, 20));
                payButton.setBounds(415,280,70,40);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                payButton.setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 2, true));
                payButton.setForeground(new Color(25, 117, 255));
                payButton.setFont(new Font("SansSerif", Font.BOLD, 20));
                payButton.setBounds(415,280,70,40);
                payButton.setBackground(new Color(0x182838));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
              
              new BillPaymentDialog(username, totalAmount);
            }
        });




     
         
        lower_panel.add(payBill);
        lower_panel.add(level1);
        lower_panel.add(appontmentCost);
        lower_panel.add(level2);
        lower_panel.add(medicalCost);
        lower_panel.add(level3);
        lower_panel.add(testCost);
        lower_panel.add(level4);
        lower_panel.add(otherCost);
        lower_panel.add(level5);
        lower_panel.add(level6);
        lower_panel.add(totalCost);
        lower_panel.add(payButton);

        

      
        return lower_panel;
    }




    @Override
    public void actionPerformed(ActionEvent e)
    {
        // code to handle the action event
    }

    public static void main(String[] args) {
        new UserPayBillPage("emiko");
    }
}