package com.healthcarecenter.frames;
import com.healthcarecenter.utils.FileUtils;
import com.healthcarecenter.utils.FrameUtils;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SuperAdminPayAdminSalaryPage extends JFrame implements ActionListener

{
    JButton pay_AdminSalary = new JButton("Pay Admin Salary");

    public SuperAdminPayAdminSalaryPage ()
    {
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
        label.setForeground(new Color(0x00FF00));
        label.setFont(new Font("MV Boli", Font.BOLD, 20));
        label.setLayout(null);
        upper_panel.add(label);

        
        

       //create userpanel for upper_panel
        JPanel user_panel = new JPanel(); 
        user_panel.setLayout(null);
        user_panel.setBounds(5,5,200,40);
		upper_panel.setBackground(new Color(0x3a8cdb));
        upper_panel.add(user_panel);


        JLabel userlabel = new JLabel("User Name");
        userlabel.setHorizontalAlignment(JLabel.CENTER);
        userlabel.setBounds(5,5,100,30);
		user_panel.setBackground(new Color(0x3a8cdb));
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
         Mang_Doc.setBounds(80, 15, 140, 20);

          //level forbillingHistory
         JLabel billingHistory = new JLabel();
         billingHistory.setText("Billing History");
         billingHistory.setForeground(new Color(000000));
         billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
         billingHistory.setBounds(225, 15, 160, 20);
		 
		 //level for manage admin
         JLabel Mang_Admin = new JLabel();
         Mang_Admin.setText("Manage Admin");
         Mang_Admin.setForeground(new Color(000000));
         Mang_Admin.setFont(new Font("SansSerif", Font.PLAIN, 15));
         Mang_Admin.setBounds(390, 15, 120, 20);

         //level for paySalary 
         JLabel paySalary = new JLabel();
         paySalary .setText("Pay Admin Salary");
         paySalary .setForeground(new Color(000000));
		 paySalary .setForeground(Color.RED );
         paySalary .setFont(new Font("SansSerif", Font.PLAIN, 15));
         paySalary .setBounds(540, 15, 160, 20);

         //level for log out
         JLabel log_out = new JLabel();
         log_out.setText("Log out");
         log_out.setForeground(new Color(000000));
         log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
         log_out.setBounds(750, 15, 250, 20);
 
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
				new SuperAdminHomePage();
            }
        });



        Mang_Doc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Mang_Doc.setForeground(new Color(0x00FF00));
                Mang_Doc.setFont(new Font("SansSerif", Font.PLAIN, 18));
				Mang_Doc.setBounds(70, 10, 150, 30);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Mang_Doc.setForeground(new Color(0, 0, 0));
                Mang_Doc.setFont(new Font("SansSerif", Font.PLAIN, 15));
				Mang_Doc.setBounds(80, 15, 140, 20);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(home).dispose();
				new SuperAdminManageDoctorPage();
                
            }
        });

       billingHistory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               billingHistory.setForeground(new Color(0x00FF00));
               billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 18));
			   billingHistory.setBounds(215, 10, 170, 30);
			  
            }
            @Override
            public void mouseExited(MouseEvent e) {
               billingHistory.setForeground(new Color(0, 0, 0));
               billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
			   billingHistory.setBounds(225, 15, 160, 20);
			  
            }
            @Override
            public void mouseClicked(MouseEvent e) {
				SwingUtilities.getWindowAncestor(home).dispose();
				new SuperAdminUpdateBloodStockPage();
                
            }
        });
		
		Mang_Admin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               Mang_Admin.setForeground(new Color(0x00FF00));
               Mang_Admin.setFont(new Font("SansSerif", Font.PLAIN, 18));
			   Mang_Admin.setBounds(380, 10, 130, 30);
			  
            }
            @Override
            public void mouseExited(MouseEvent e) {
               Mang_Admin.setForeground(new Color(0, 0, 0));
               Mang_Admin.setFont(new Font("SansSerif", Font.PLAIN, 15));
			   Mang_Admin.setBounds(390, 15, 120, 20);
			  
            }
            @Override
            public void mouseClicked(MouseEvent e) {
				SwingUtilities.getWindowAncestor(home).dispose();
				new SuperAdminManageAdminPage();
                
            }
        });
        


        paySalary  .addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                paySalary .setForeground(new Color(0x00FF00));
                paySalary .setFont(new Font("SansSerif", Font.PLAIN, 18));
				paySalary .setBounds(530, 10, 170, 30);
				paySalary .setForeground(Color.RED );
				
            }
            @Override
            public void mouseExited(MouseEvent e) {
                paySalary .setForeground(new Color(0, 0, 0));
                paySalary .setFont(new Font("SansSerif", Font.PLAIN, 15));
				paySalary .setBounds(540, 15, 160, 20);
				paySalary .setForeground(Color.RED );
				
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
			log_out.setBounds(740, 10, 200, 30);
			
          }
          @Override
        public void mouseExited(MouseEvent e) {
            log_out.setForeground(new Color(0, 0, 0));
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
			log_out.setBounds(750, 15, 250, 20);
			
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

        
        pay_AdminSalary.setBounds(350, 450, 200, 50);
        pay_AdminSalary.setFocusable(false);
        pay_AdminSalary.addActionListener(this);
        this.add(pay_AdminSalary);

        return lower_panel;
    }
    
      @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() ==pay_AdminSalary )
            {
                String adminName = JOptionPane.showInputDialog("Enter Admin Username:");
                if (adminName != null && !adminName.trim().isEmpty()) {
                String salaryInput = JOptionPane.showInputDialog("Enter salary for Admin " + adminName + ":");
                try {
                   double salary = Double.parseDouble(salaryInput);
                   JOptionPane.showMessageDialog(null, "Pay Salary: " + salary + " to Admin " + adminName);
               } catch (NumberFormatException ex) {
                   JOptionPane.showMessageDialog(null, "Invalid salary entered. Please enter a valid number.");
               }
             }
             else {
               JOptionPane.showMessageDialog(null, "No admin name entered. Operation cancelled.");
            }
        }
    }
    
        public static void main(String[] args) {
            new SuperAdminPayAdminSalaryPage();
        } 

    }
        
    
      

