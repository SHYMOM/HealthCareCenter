package com.healthcarecenter.frames;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.healthcarecenter.frames.dialogs.DoctorDetailsDialog;
import com.healthcarecenter.utils.FileUtils;
import com.healthcarecenter.utils.FrameUtils;
import com.healthcarecenter.utils.GetAdminData;
import com.healthcarecenter.utils.GetDoctorData;
import com.healthcarecenter.utils.GetUserData;

import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.*;
public class AdminManageDoctorPage extends JFrame implements ActionListener
{

    JButton Add_Doctor,Remove_Doctor,Modify_Doctor,getDetails;
    private JTable ManageDoctorsTable;
    private DefaultTableModel tableModel;
   
    private String username;
    private String name;
    public AdminManageDoctorPage(String username)
    {
        this.username = username;
        try {
            this.name = GetAdminData.getName(username);
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
        user_panel.setBounds(5,5,200,40);
		upper_panel.setBackground(new Color(0x3a8cdb));
        upper_panel.add(user_panel);


        JLabel userlabel = new JLabel(name);
        userlabel.setHorizontalAlignment(JLabel.LEFT);
        userlabel.setBounds(5,5,250,30);
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
		 Mang_Doc.setForeground(new Color(255,255,255)  );
         Mang_Doc.setFont(new Font("SansSerif", Font.PLAIN, 15));
         Mang_Doc.setBounds(80, 15, 140, 20);

          //level forbillingHistory
         JLabel billingHistory = new JLabel();
         billingHistory.setText("Billing History");
         billingHistory.setForeground(new Color(000000));
         billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
         billingHistory.setBounds(225, 15, 160, 20);
		 


         //level for log out
         JLabel log_out = new JLabel();
         log_out.setText("Log out");
         log_out.setForeground(new Color(000000));
         log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
         log_out.setBounds(350, 15, 90, 20);
 
          //add level in middle_panel
          middle_panel.add(home);
          middle_panel.add(Mang_Doc);
          middle_panel.add(billingHistory);
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
				new AdminHomePage(username, true);
            }
        });



       billingHistory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               billingHistory.setForeground(new Color(0x00FF00));
               billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 18));
			   billingHistory.setBounds(215, 10, 120, 30);
			  
            }
            @Override
            public void mouseExited(MouseEvent e) {
               billingHistory.setForeground(new Color(0, 0, 0));
               billingHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
			   billingHistory.setBounds(225, 15, 110, 20);
			  
            }
            @Override
            public void mouseClicked(MouseEvent e) {
				SwingUtilities.getWindowAncestor(home).dispose();
				new AdminBillingHistoryPage(username);
                
            }
        });
		
         log_out.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
            log_out.setForeground(new Color(0x00FF00));
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 18));
			log_out.setBounds(343, 10, 100, 30);
			
          }
          @Override
         public void mouseExited(MouseEvent e) {
            log_out.setForeground(new Color(0, 0, 0));
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
			log_out.setBounds(350, 15, 90, 20);
			
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

        Modify_Doctor = new JButton("Modify Doctor");
        Modify_Doctor.setBounds(280, 380, 120, 30);
        Modify_Doctor.setFocusable(false);
        Modify_Doctor.addActionListener(this);

        Modify_Doctor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = ManageDoctorsTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please select an admin to modify.");
                }else {
                    new Super_AdminAddNewDoctor(null,"Edit", getSelectedDoctorUsername(), "Admin");
                }
            }
        });

        Add_Doctor= new JButton("Add Doctor");
        Add_Doctor.setBounds(410, 380, 120, 30);
        Add_Doctor.setFocusable(false);
        

        Add_Doctor.addMouseListener(new MouseAdapter() {
            @Override
        public void mouseClicked(MouseEvent e) {
            SwingUtilities.getWindowAncestor(Add_Doctor).dispose();
            new Super_AdminAddNewDoctor(null,"Add","","Admin");
            
        }
    });
        
        Remove_Doctor = new JButton("Remove Doctor");
        Remove_Doctor.setBounds(540, 380, 130,30);
        Remove_Doctor.setFocusable(false);
        Remove_Doctor.addActionListener(this);

        Remove_Doctor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = ManageDoctorsTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please select an doctor to remove.");
                }else {
                    String selectedUsername = getSelectedDoctorUsername();
                    if (selectedUsername != null) {
                        String confirmText = JOptionPane.showInputDialog(null, "Write 'Confirm' to delete account");
                        if (confirmText != null && confirmText.equals("Confirm")) {
                            try {
                                FileUtils.deleteFile(selectedUsername);
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
            }
        });

        getDetails = new JButton("Get Details");
        getDetails.setBounds(410, 340, 120, 30);
        getDetails.setFocusable(false);
        getDetails.addActionListener(this);


        getDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedUsername = getSelectedDoctorUsername();
                if (selectedUsername != null) {
                    HashMap<String, String> doctorDetails = GetDoctorData.getDoctorDetails(selectedUsername);
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component)e.getSource());
                    DoctorDetailsDialog.showDoctorDetails(frame, doctorDetails,"Admin");
                }
                else {
                    JOptionPane.showMessageDialog(null, "No doctor selected.");
                }
            }
        });

        lower_panel.add(Modify_Doctor);
        lower_panel.add(Add_Doctor);  
        lower_panel.add(Remove_Doctor);
        lower_panel.add(getDetails);
        

        tableModel = new DefaultTableModel(new String[]{
            "Full Name", "Email", "Contact Number", "Gender", "Salary"},0) 
            {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        loadDoctorData();

        ManageDoctorsTable = new JTable(tableModel);
        ManageDoctorsTable.getTableHeader().setReorderingAllowed(false);
        ManageDoctorsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ManageDoctorsTable.setRowHeight(30);
        ManageDoctorsTable.setFont(new Font("SansSerif", Font.PLAIN, 12));
        ManageDoctorsTable.setShowGrid(true);
        ManageDoctorsTable.setGridColor(new Color(230, 230, 230));

        //! Style Of The Header
        JTableHeader header = ManageDoctorsTable.getTableHeader();
        header.setBackground(new Color(51, 102, 204));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("SansSerif", Font.BOLD, 12));


        ManageDoctorsTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

        JScrollPane scrollPane = new JScrollPane(ManageDoctorsTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        scrollPane.setBounds(0, 50, 900, 280);

        lower_panel.add(scrollPane);
            
        return lower_panel;
    }

     private void loadDoctorData() {
            ArrayList<HashMap<String, String>> allDoctors = GetDoctorData.getAllDoctorsDetails();
            for (HashMap<String, String> doctor : allDoctors) {
                tableModel.addRow(new Object[]{
                        doctor.get("fullName"),
                        doctor.get("email"),
                        doctor.get("contactNumber"),
                        doctor.get("gender"),
                        doctor.get("salary")
                });
            }
        }

        private String getSelectedDoctorUsername() {
            int selectedRow = ManageDoctorsTable.getSelectedRow();
            if (selectedRow == -1) {
                return null;
            }
            return FileUtils.getUsernameByEmail(tableModel.getValueAt(selectedRow, 1).toString(),"/data/doctors/");
        }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        // code to handle the action event
    }

    public static void main(String[] args) {
        new AdminManageDoctorPage("alice_admin");
    }

}