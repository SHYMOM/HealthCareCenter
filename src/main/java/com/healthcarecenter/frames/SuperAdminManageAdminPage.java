package com.healthcarecenter.frames;
import com.healthcarecenter.utils.FileUtils;
import com.healthcarecenter.utils.FrameUtils;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import com.healthcarecenter.utils.GetAdminData;
 

public class SuperAdminManageAdminPage extends JFrame implements ActionListener
{
    JButton Add_Admin,Remove_Admin,Modify_Admin,getDetails;
    private JTable ManageAdminTable;
    private DefaultTableModel tableModel;

    public SuperAdminManageAdminPage()
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

          //level forupd_bloo
         JLabel upd_bloo = new JLabel();
         upd_bloo.setText("Update Blood Stock");
         upd_bloo.setForeground(new Color(000000));
         upd_bloo.setFont(new Font("SansSerif", Font.PLAIN, 15));
         upd_bloo.setBounds(225, 15, 160, 20);
		 
		 //level for manage admin
         JLabel Mang_Admin = new JLabel();
         Mang_Admin.setText("Manage Admin");
         Mang_Admin.setForeground(new Color(000000));
		 Mang_Admin.setForeground(Color.RED );
         Mang_Admin.setFont(new Font("SansSerif", Font.PLAIN, 15));
         Mang_Admin.setBounds(410, 15, 120, 20);

         //level for paySalary 
         JLabel paySalary = new JLabel();
         paySalary .setText("Pay Salary");
         paySalary .setForeground(new Color(000000));
         paySalary .setFont(new Font("SansSerif", Font.PLAIN, 15));
         paySalary .setBounds(560, 15, 120, 20);

         //level for log out
         JLabel log_out = new JLabel();
         log_out.setText("Log out");
         log_out.setForeground(new Color(000000));
         log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
         log_out.setBounds(700, 15, 130, 20);
 
          //add level in middle_panel
          middle_panel.add(home);
          middle_panel.add(Mang_Doc);
          middle_panel.add(upd_bloo);
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

       upd_bloo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               upd_bloo.setForeground(new Color(0x00FF00));
               upd_bloo.setFont(new Font("SansSerif", Font.PLAIN, 18));
			   upd_bloo.setBounds(215, 10, 170, 30);
			  
            }
            @Override
            public void mouseExited(MouseEvent e) {
               upd_bloo.setForeground(new Color(0, 0, 0));
               upd_bloo.setFont(new Font("SansSerif", Font.PLAIN, 15));
			   upd_bloo.setBounds(225, 15, 160, 20);
			  
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
			   Mang_Admin.setForeground(Color.RED );
               Mang_Admin.setFont(new Font("SansSerif", Font.PLAIN, 18));
			   Mang_Admin.setBounds(400, 10, 130, 30);
			  
            }
            @Override
            public void mouseExited(MouseEvent e) {
               Mang_Admin.setForeground(new Color(0, 0, 0));
			   Mang_Admin.setForeground(Color.RED );
               Mang_Admin.setFont(new Font("SansSerif", Font.PLAIN, 15));
			   Mang_Admin.setBounds(410, 15, 120, 20);
			  
            }
            @Override
            public void mouseClicked(MouseEvent e) { 
			
			}
        });
        


        paySalary  .addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                paySalary .setForeground(new Color(0x00FF00));
                paySalary .setFont(new Font("SansSerif", Font.PLAIN, 18));
				paySalary .setBounds(550, 10, 130, 30);
				
            }
            @Override
            public void mouseExited(MouseEvent e) {
                paySalary .setForeground(new Color(0, 0, 0));
                paySalary .setFont(new Font("SansSerif", Font.PLAIN, 15));
				paySalary .setBounds(560, 15, 120, 20);
				
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                Object[] options = {"Pay Admin Salary", "Pay Doctor Salary", "Cancel"};
				int choice = JOptionPane.showOptionDialog(null,"Choose an option:","Custom Option Dialog",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
					if (choice == 0) {
						new SuperAdminPayAdminSalaryPage();
                        SwingUtilities.getWindowAncestor(home).dispose();
					} else if (choice == 1) {
						new SuperAdminPayDoctorSalary();
                        SwingUtilities.getWindowAncestor(home).dispose();
					} else {
						
					}
            }			
                
            
        });



         log_out.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
            log_out.setForeground(new Color(0x00FF00));
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 18));
			log_out.setBounds(693, 10, 100, 30);
			
          }
          @Override
         public void mouseExited(MouseEvent e) {
            log_out.setForeground(new Color(0, 0, 0));
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
			log_out.setBounds(700, 15, 130, 20);
			
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

        Modify_Admin = new JButton("Modify Admin");
        Modify_Admin.setBounds(280, 380, 120, 30);
        Modify_Admin.setFocusable(false);
        Modify_Admin.addActionListener(this);

        Add_Admin = new JButton("Add Admin");
        Add_Admin.setBounds(410, 380, 120, 30);
        Add_Admin.setFocusable(false);
        Add_Admin.addActionListener(this);
        
        Remove_Admin = new JButton("Remove Admin");
        Remove_Admin.setBounds(540, 380, 120,30);
        Remove_Admin.setFocusable(false);
        Remove_Admin.addActionListener(this);

        getDetails = new JButton("Get Details");
        getDetails.setBounds(410, 340, 120, 30);
        getDetails.setFocusable(false);
        getDetails.addActionListener(this);

        getDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // printSelectedDoctorDetails();
            }
        });

        tableModel = new DefaultTableModel(new String[]{
            "Full Name", "Email", "Contact Number", "Gender","Salary"}, 0);

            loadAdminData();

            ManageAdminTable = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(ManageAdminTable);
            scrollPane.setBounds(0, 50, 900, 280);
            
            


        lower_panel.add(Modify_Admin);
        lower_panel.add(Add_Admin);  
        lower_panel.add(Remove_Admin);
        lower_panel.add(getDetails);
        lower_panel.add(scrollPane);
       

        return lower_panel;
    }

     private void loadAdminData() {
            // Get all doctors' details
            ArrayList<HashMap<String, String>> allAdmins = GetAdminData.getAllAdminsDetails();
    
            // Add each doctor's details as a row in the table
            for (HashMap<String, String> admin : allAdmins) {
                System.out.println(admin);
                tableModel.addRow(new Object[]{
                        admin.get("fullName"),
                        admin.get("email"),
                        admin.get("contractNumber"),
                        admin.get("gender"),
                        admin.get("salary")
                });
            }
        }






    @Override
    public void actionPerformed(ActionEvent e)
    {
        // code to handle the action event
    }

    public static void main(String[] args) {
        new SuperAdminManageAdminPage();
    }

}