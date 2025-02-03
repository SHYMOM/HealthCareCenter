package com.healthcarecenter.frames;
import com.healthcarecenter.utils.FileUtils;
import com.healthcarecenter.utils.FrameUtils;
import com.healthcarecenter.utils.GetAdminData;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
public class SuperAdminPayAdminSalaryPage extends JFrame implements ActionListener

{
     JButton getDetails;
    private JTable ManageAdminTable;
    private DefaultTableModel tableModel;


    JButton pay_AdminSalary = new JButton("Pay Admin Salary");
    private String email;
    
    public SuperAdminPayAdminSalaryPage(String email) {
       this.email = email;
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
        upper_panel.setBounds(0,0,900,180);
        upper_panel.setBackground(Color.gray);

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
        user_panel.setBounds(5,5,250,40);
		upper_panel.setBackground(new Color(0x3a8cdb));
        upper_panel.add(user_panel);


        JLabel userlabel = new JLabel(email);
        userlabel.setHorizontalAlignment(JLabel.LEFT);
        userlabel.setBounds(5,5,400,30);
		user_panel.setBackground(new Color(0x3a8cdb));
        userlabel.setFont(new Font("SensSerif", Font.PLAIN, 14));
        user_panel.add(userlabel);
        upper_panel.add(createMiddlepanel());

        

        return upper_panel;
    }

    private JPanel createMiddlepanel()
    {
         JPanel middle_panel = new JPanel();                                  
         middle_panel.setLayout(null);
         middle_panel.setBounds(0,130,900,50);
         middle_panel.setBackground(new Color(0x3a8cdb));


         //level for home
         JLabel home = new JLabel();
         home.setText("Home");
         home.setForeground(new Color(000000));
         home.setFont(new Font("SansSerif", Font.PLAIN, 15));
         home.setBounds(20, 15, 60, 20);



         //level for Manage Doctors
         JLabel Mang_Doc= new JLabel();
         Mang_Doc.setText("Manage Doctors");
         Mang_Doc.setForeground(new Color(000000));
         Mang_Doc.setFont(new Font("SansSerif", Font.PLAIN, 15));
         Mang_Doc.setBounds(105, 15, 140, 20);

          //level forbillingHistory
         JLabel billingHistory = new JLabel();
         billingHistory.setText("Billing History");
         billingHistory.setForeground(new Color(000000));
         billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
         billingHistory.setBounds(260, 15, 160, 20);
		 
		 //level for manage admin
         JLabel Mang_Admin = new JLabel();
         Mang_Admin.setText("Manage Admin");
         Mang_Admin.setForeground(new Color(000000));
         Mang_Admin.setFont(new Font("SansSerif", Font.PLAIN, 15));
         Mang_Admin.setBounds(410, 15, 120, 20);

         //level for paySalary 
         JLabel paySalary = new JLabel();
         paySalary .setText("Pay Admin Salary");
         paySalary .setForeground(new Color(000000));
		 paySalary .setForeground(new Color(255,255,255));
         paySalary .setFont(new Font("SansSerif", Font.PLAIN, 15));
         paySalary .setBounds(560, 15, 120, 20);

         //level for log out
         JLabel log_out = new JLabel();
         log_out.setText("Log out");
         log_out.setForeground(new Color(000000));
         log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
         log_out.setBounds(715, 15, 50, 20);
 
          //add level in middle_panel
          middle_panel.add(home);
          middle_panel.add(Mang_Doc);
          middle_panel.add(billingHistory);
          middle_panel.add(paySalary );
		  middle_panel.add(Mang_Admin);
          middle_panel.add(log_out);


        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               home.setForeground(new Color(0x00FF00));
               home.setBounds(15, 10, 70, 30);
               home.setFont(new Font("SansSerif", Font.PLAIN, 18));
    
            }
            @Override
          public void mouseExited(MouseEvent e) {
                home.setForeground(new Color(0, 0, 0)); 
                home.setBounds(20, 15, 60, 20);
                home.setFont(new Font("SansSerif", Font.PLAIN, 15));
                 
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(home).dispose();
				new SuperAdminHomePage(email);
            }
        });



        Mang_Doc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Mang_Doc.setForeground(new Color(0x00FF00));
                Mang_Doc.setFont(new Font("SansSerif", Font.PLAIN, 18));
				Mang_Doc.setBounds(95, 10, 150, 30);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Mang_Doc.setForeground(new Color(0, 0, 0));
                Mang_Doc.setFont(new Font("SansSerif", Font.PLAIN, 15));
				Mang_Doc.setBounds(105, 15, 140, 20);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(home).dispose();
				new SuperAdminManageDoctorPage(email);
                
            }
        });

       billingHistory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               billingHistory.setForeground(new Color(0x00FF00));
               billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 18));
               billingHistory.setBounds(250, 10, 130, 30);
			  
            }
            @Override
            public void mouseExited(MouseEvent e) {
               billingHistory.setForeground(new Color(0, 0, 0));
               billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
			   billingHistory.setBounds(260, 15, 120, 20);
			  
            }
            @Override
            public void mouseClicked(MouseEvent e) {
				SwingUtilities.getWindowAncestor(home).dispose();
				new SuperAdminBillingHistory(email);
                
            }
        });
		
		Mang_Admin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               Mang_Admin.setForeground(new Color(0x00FF00));
               Mang_Admin.setFont(new Font("SansSerif", Font.PLAIN, 18));
			   Mang_Admin.setBounds(400, 10, 130, 30);
			  
            }
            @Override
            public void mouseExited(MouseEvent e) {
               Mang_Admin.setForeground(new Color(0, 0, 0));
               Mang_Admin.setFont(new Font("SansSerif", Font.PLAIN, 15));
			   Mang_Admin.setBounds(410, 15, 120, 20);
			  
            }
            @Override
            public void mouseClicked(MouseEvent e) {
				SwingUtilities.getWindowAncestor(home).dispose();
				new SuperAdminManageAdminPage(email);
                
            }
        });
        


        paySalary  .addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                paySalary .setForeground(new Color(0x00FF00));
                paySalary .setFont(new Font("SansSerif", Font.PLAIN, 17));
				paySalary .setBounds(553, 10, 135, 30);
				paySalary .setForeground(new Color(255,255,255));
				
            }
            @Override
            public void mouseExited(MouseEvent e) {
                paySalary .setForeground(new Color(0, 0, 0));
                paySalary .setFont(new Font("SansSerif", Font.PLAIN, 15));
				paySalary .setBounds(560, 15, 120, 20);
				paySalary .setForeground(new Color(255,255,255));
				
            }
            @Override
            public void mouseClicked(MouseEvent e) {
           
                }
        });



      log_out.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
            log_out.setForeground(new Color(0x00FF00));
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 18));
			log_out.setBounds(710, 10, 60, 30);
			
          }
          @Override
        public void mouseExited(MouseEvent e) {
            log_out.setForeground(new Color(0, 0, 0));
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
			log_out.setBounds(715, 15, 50, 20);
			
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
        lower_panel.setBounds(0,130,900,500);
        lower_panel.setBackground(new Color(0xECF8FD));

        
        pay_AdminSalary.setBounds(350, 500, 200, 50);
        pay_AdminSalary.setFocusable(false);
        pay_AdminSalary.addActionListener(this);
        this.add(pay_AdminSalary);

        pay_AdminSalary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedUsername = getSelectedAdminUsername();
                if (selectedUsername != null) {
                     if(e.getSource() ==pay_AdminSalary )
            {

                if(e.getSource() ==pay_AdminSalary )
                {
                    
                    try {
                        String salaryInput = JOptionPane.showInputDialog("Enter salary for Admin " + GetAdminData.getName(getSelectedAdminUsername()) + ":");
                       double salary = Double.parseDouble(salaryInput);
                       JOptionPane.showMessageDialog(null, "Pay Salary: " + salary + " to Admin " + GetAdminData.getName(getSelectedAdminUsername()));
                   } catch (IOException ex) {
                       JOptionPane.showMessageDialog(null, "Invalid salary entered. Please enter a valid number.");
                   }
                 }
                 else {
                   JOptionPane.showMessageDialog(null, "No admin name entered. Operation cancelled.");
                }
              


             }
             else {
               JOptionPane.showMessageDialog(null, "No admin name entered. Operation cancelled.");
            }
                    
                    
                }
                else {
                    JOptionPane.showMessageDialog(null, "No admin selected.");
                }
            }
        });
    



        getDetails = new JButton("Get Details");
        getDetails.setBounds(400, 335, 120, 30);
        getDetails.setFocusable(false);
        getDetails.addActionListener(this);

          getDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedUsername = getSelectedAdminUsername();
                if (selectedUsername != null) {
                    try {
                        HashMap<String, String> adminDetails = GetAdminData.getAdminDetails(selectedUsername);
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component)e.getSource());
                        //AdminDetailsDialog.showAdminDetails(frame, adminDetails,"Admin");
                        System.out.println(adminDetails);
                    } catch (IOException ex) {
                    }
                    
                }
                else {
                    JOptionPane.showMessageDialog(null, "No admin selected.");
                }
            }
        });

        
        lower_panel.add(getDetails);




        tableModel = new DefaultTableModel(new String[]{
            "Full Name", "Email", "Contact Number", "Gender", "Salary"},0) 
            {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        loadAdminData();

        ManageAdminTable = new JTable(tableModel);
        ManageAdminTable.getTableHeader().setReorderingAllowed(false);
        ManageAdminTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ManageAdminTable.setRowHeight(30);
        ManageAdminTable.setFont(new Font("SansSerif", Font.PLAIN, 12));
        ManageAdminTable.setShowGrid(true);
        ManageAdminTable.setGridColor(new Color(230, 230, 230));

        //! Style Of The Header
        JTableHeader header = ManageAdminTable.getTableHeader();
        header.setBackground(new Color(51, 102, 204));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("SansSerif", Font.BOLD, 12));


        ManageAdminTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

        JScrollPane scrollPane = new JScrollPane(ManageAdminTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        scrollPane.setBounds(0, 50, 900, 280);

        lower_panel.add(scrollPane);
            
        return lower_panel;
    }

    private void loadAdminData() {
        ArrayList<HashMap<String, String>> allAdmins = GetAdminData.getAllAdminsDetails();
        for (HashMap<String, String> admin : allAdmins) {
            tableModel.addRow(new Object[]{
                    admin.get("fullName"),
                    admin.get("email"),
                    admin.get("contactNumber"),
                    admin.get("gender"),
                    admin.get("salary")
            });
        }
    }

    private String getSelectedAdminUsername() {
        int selectedRow = ManageAdminTable.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }
        return FileUtils.getUsernameByEmail(tableModel.getValueAt(selectedRow, 1).toString(),"/data/admins/");
    }

     
    
      @Override
        public void actionPerformed(ActionEvent e)
        {
            
        }

    
        public static void main(String[] args) {
            new SuperAdminPayAdminSalaryPage("shymom@healthcarecenter.com");
        } 

    }
        
    
      

