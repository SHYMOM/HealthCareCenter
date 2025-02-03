package com.healthcarecenter.frames;
import com.healthcarecenter.utils.FileUtils;
import com.healthcarecenter.utils.FrameUtils;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SuperAdminPayDoctorSalary extends JFrame implements ActionListener

{
    JButton pay_DoctorsSalary = new JButton("Pay Doctors Salary");

    private String email;
    
    public SuperAdminPayDoctorSalary(String email) {
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

         //level for pay_Do_Salary 
         JLabel pay_Do_Salary = new JLabel();
         pay_Do_Salary .setText("Pay Doctors Salary");
         pay_Do_Salary .setForeground(new Color(000000));
		 pay_Do_Salary .setForeground(new Color(255,255,255));
         pay_Do_Salary .setFont(new Font("SansSerif", Font.PLAIN, 15));
         pay_Do_Salary .setBounds(560, 15, 130, 20);

         //level for log out
         JLabel log_out = new JLabel();
         log_out.setText("Log out");
         log_out.setForeground(new Color(000000));
         log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
         log_out.setBounds(720, 15, 60, 20);
 
          //add level in middle_panel
          middle_panel.add(home);
          middle_panel.add(Mang_Doc);
          middle_panel.add(billingHistory);
          middle_panel.add(pay_Do_Salary );
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
        


        pay_Do_Salary  .addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                pay_Do_Salary .setForeground(new Color(0x00FF00));
                pay_Do_Salary .setFont(new Font("SansSerif", Font.PLAIN, 17));
				pay_Do_Salary .setBounds(551, 10, 155, 30);
				pay_Do_Salary .setForeground(new Color(255,255,255));
				
            }
            @Override
            public void mouseExited(MouseEvent e) {
                pay_Do_Salary .setForeground(new Color(0, 0, 0));
                pay_Do_Salary .setFont(new Font("SansSerif", Font.PLAIN, 15));
				pay_Do_Salary .setBounds(560, 15, 130, 20);
				pay_Do_Salary .setForeground(new Color(255,255,255));
				
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
			log_out.setBounds(715, 10, 70, 30);
			
          }
          @Override
        public void mouseExited(MouseEvent e) {
            log_out.setForeground(new Color(0, 0, 0));
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
			log_out.setBounds(720, 15, 60, 20);
			
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

        pay_DoctorsSalary.setBounds(350, 500, 200, 50);
        pay_DoctorsSalary.setFocusable(false);
        pay_DoctorsSalary.addActionListener(this);
        this.add(pay_DoctorsSalary);
       

      
        return lower_panel;
    }

    @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() ==pay_DoctorsSalary )
            {
                String doctorname = JOptionPane.showInputDialog("Enter Doctor Username:");
                if (doctorname != null && !doctorname.trim().isEmpty()) {
                String salaryInput = JOptionPane.showInputDialog("Enter salary for Doctor " + doctorname + ":");
                try {
                   double salary = Double.parseDouble(salaryInput);
                   JOptionPane.showMessageDialog(null, "Pay Salary: " + salary + " to Doctor " + doctorname);
               } catch (NumberFormatException ex) {
                   JOptionPane.showMessageDialog(null, "Invalid salary entered. Please enter a valid number.");
               }
             }
             else {
               JOptionPane.showMessageDialog(null, "No doctor name entered. Operation cancelled.");
            }
        }
    }

   
    public static void main(String[] args) {
        new SuperAdminPayDoctorSalary("shymom@helthcarecenter.com");
    }

}