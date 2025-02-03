package com.healthcarecenter.frames;
import com.healthcarecenter.utils.FileUtils;
import com.healthcarecenter.utils.FrameUtils;
import com.healthcarecenter.utils.GetPaymentHistory;
import com.healthcarecenter.utils.GetUserData;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
public class UserBillingHistoryPage extends JFrame implements ActionListener
{   
    private JTable billingHistoryTable;
    private DefaultTableModel tableModel;
    private String username;
    private String name;
    
    public UserBillingHistoryPage(String username)
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
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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
          bill.setForeground(new Color(000000));
          bill.setFont(new Font("SansSerif", Font.PLAIN, 15));
          bill.setBounds(570, 15, 50, 20);


         //level for billingHistory
         JLabel billingHistory = new JLabel();
         billingHistory.setText("Billing History");
         billingHistory.setForeground(new Color(255, 255, 255));
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
                SwingUtilities.getWindowAncestor(billingHistory).dispose();
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
                SwingUtilities.getWindowAncestor(billingHistory).dispose();
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
                SwingUtilities.getWindowAncestor(billingHistory).dispose();
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
                SwingUtilities.getWindowAncestor(billingHistory).dispose();  
                new UserMedicalHistoryPage(username);
            }
        });
        


        bill.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bill.setForeground(new Color(0x00FF00));
                bill.setBounds(570, 15, 50, 20);
                bill.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                bill.setForeground(new Color(000000));
                bill.setBounds(570, 15, 50, 20);
                bill.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
          @Override
          public void mouseClicked(MouseEvent e) {
            SwingUtilities.getWindowAncestor(billingHistory).dispose();  
            new UserPayBillPage(username);
          }
      });




        billingHistory .addMouseListener(new MouseAdapter() {
            @Override
        public void mouseEntered(MouseEvent e) {
            billingHistory .setForeground(new Color(255, 255, 255));
            billingHistory.setBounds(640, 15, 90, 20);
            billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
        }
        @Override
        public void mouseExited(MouseEvent e) {
            billingHistory .setForeground(new Color(255, 255, 255));
            billingHistory.setBounds(640, 15, 90, 20);
            billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
        }
            @Override
            public void mouseClicked(MouseEvent e) {
                
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
    
        tableModel = new DefaultTableModel(new String[]
             { "Date","Full Name", "Email" , "Amount", "Account Information", "Tranjection Id"}, 0) 
        {
            @Override
            public boolean isCellEditable(int row, int column)
             {
                return false;
             }
        };

         billingHistoryTable = new JTable(tableModel);
           
      
        

        loadBillingHistoryData();

         //! Style Of The Header
        JTableHeader header = billingHistoryTable.getTableHeader();
        header.setBackground(new Color(51, 102, 204));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("SansSerif", Font.BOLD, 12));

        billingHistoryTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, 
                        hasFocus, row, column);

                if (isSelected) {
                    comp.setBackground(new Color(70, 130, 230));
                    comp.setForeground(Color.WHITE);
                } else {
                    comp.setBackground(row % 2 == 0 ? new Color(240, 240, 255) : Color.WHITE);
                    comp.setForeground(Color.BLACK);
                }
                ((JLabel) comp).setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
                
                return comp;
            }
        });

        billingHistoryTable.getTableHeader().setReorderingAllowed(false);
        billingHistoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        billingHistoryTable.setRowHeight(30);
        billingHistoryTable.setFont(new Font("SansSerif", Font.PLAIN, 12));
        billingHistoryTable.setShowGrid(true);
        billingHistoryTable.setGridColor(new Color(230, 230, 230));

        JScrollPane scrollPane = new JScrollPane(billingHistoryTable);
        scrollPane.setBounds(2, 00, 880,300);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JPanel lower_panel = new JPanel();                                  
        lower_panel.setLayout(null);
        lower_panel.setBounds(0,200,900,500);
        lower_panel.setBackground(Color.white);
        lower_panel.add(scrollPane);
        
 
        return lower_panel;
    }
    
    private void loadBillingHistoryData()
    {

        try {
            ArrayList<HashMap<String, String>> PaymentHistory = GetPaymentHistory.getUserPaymentHistory(username);
            
            for (HashMap<String, String> payment : PaymentHistory)
            {
                tableModel.addRow(new Object[] {
                    payment.get("date"),
                    payment.get("name"),
                    payment.get("email"),
                    payment.get("amount"),
                    payment.get("accountInfo"),
                    payment.get("TransactionID")
                });
            }
        } catch (IOException ex) {
        }



    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // code to handle the action event
    }

    public static void main(String[] args) {
        new UserBillingHistoryPage("emiko");
    }

}
