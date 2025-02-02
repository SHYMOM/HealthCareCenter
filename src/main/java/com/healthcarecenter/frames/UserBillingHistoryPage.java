package com.healthcarecenter.frames;
import com.healthcarecenter.utils.FileUtils;
import com.healthcarecenter.utils.GetPaymentHistory;
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
    
    public UserBillingHistoryPage(String username)
    {
        this.username = username;
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


        JLabel userlabel = new JLabel("User Name");
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

         //level for blood
         JLabel billingHistory = new JLabel();
         billingHistory.setText("Billing History");
         billingHistory.setForeground(Color.red);
         billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
         billingHistory.setBounds(400, 15, 80,  20);

          //level for bill
        JLabel bill = new JLabel();
        bill.setText("Pay Bill");
        bill.setForeground(new Color(000000));
        bill.setFont(new Font("SansSerif", Font.PLAIN, 15));
        bill.setBounds(505, 15, 50, 20);

         //level for log out
         JLabel log_out = new JLabel();
         log_out.setText("log_out");
         log_out.setForeground(new Color(000000));
         log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
         log_out.setBounds(580, 15, 50,20);
 
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
                SwingUtilities.getWindowAncestor(billingHistory).dispose();
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
                SwingUtilities.getWindowAncestor(billingHistory).dispose();  
                new UserMedicalHistoryPage(username);
            }
        });
        


        billingHistory .addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                billingHistory .setForeground(Color.red);
                billingHistory.setBounds(400, 15, 80,  20);
                billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                billingHistory .setForeground(Color.red);
                billingHistory.setBounds(400, 15, 80,  20);
                billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                //SwingUtilities.getWindowAncestor(blood).dispose(); 
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
            SwingUtilities.getWindowAncestor(billingHistory).dispose();  
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
            log_out.setBounds(580, 15, 50, 20);
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
          }
          @Override
          public void mouseClicked(MouseEvent e)
          {
            int result = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION)
             {
                System.out.println("Yes selected");
                SwingUtilities.getWindowAncestor(billingHistory).dispose();
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



        billingHistoryTable = new JTable(tableModel);
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
