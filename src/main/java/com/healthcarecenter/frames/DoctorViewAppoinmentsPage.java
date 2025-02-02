package com.healthcarecenter.frames;
import com.healthcarecenter.utils.FileUtils;
import com.healthcarecenter.utils.GetDoctorData;
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
public class DoctorViewAppoinmentsPage extends JFrame implements ActionListener
{

    private JTable viewappoinmentTable;
    private DefaultTableModel tableModel;
    private String username;
    private String name;

    
    public DoctorViewAppoinmentsPage(String username)
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

        this.setTitle("HealthCareCenter.Doctor.ViewAppointmentsPage");      
        this.setLayout(null);
        this.setSize(900, 600);                       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          
        this.getContentPane().setBackground(Color.BLUE);
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
        //user_panel.setBackground(Color.yellow);
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
        middle_panel.setBounds(0,130,900,50);
        //middle_panel.setBackground(new Color(10, 10, 10));
		middle_panel.setBackground(new Color(0x3a8cdb));
		
		//level for home 
		JLabel home= new JLabel();
         home.setText("Home");
         home.setForeground(Color.black);
         home.setFont(new Font("SansSerif", Font.PLAIN, 15));
		 home.setForeground(Color.black);
         home.setBounds(25, 15, 42, 20);
		 
		 //level for appoinment
         JLabel appoinment= new JLabel();
         appoinment.setText("View Appoinment");
         appoinment.setForeground(new Color(0, 0, 0));
         appoinment.setFont(new Font("SansSerif", Font.PLAIN, 15));
		 appoinment.setForeground(Color.RED);
         appoinment.setBounds(110, 15, 120, 20);

        //level for records
        JLabel records = new JLabel();
        records.setText("Access patient Records");
        records.setForeground(new Color(000000));
        records.setFont(new Font("SansSerif", Font.PLAIN, 15));
        records.setBounds(275, 15, 165, 20);

         //level for prescripitions
         JLabel prescripitions = new JLabel();
         prescripitions.setText("Add prescripitions");
         prescripitions.setForeground(new Color(000000));
         prescripitions.setFont(new Font("SansSerif", Font.PLAIN, 15));
         prescripitions.setBounds(500, 15, 125, 20);
 
          //add level in middle_panel
		  middle_panel.add(home);
          middle_panel.add(appoinment);
          middle_panel.add(records);
          middle_panel.add(prescripitions);
		  
		  home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
				home.setForeground(Color.RED);
                home.setForeground(new Color(0x00FF00));
                home.setFont(new Font("SansSerif", Font.PLAIN, 17));
				home.setBounds(23, 10, 48, 30);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                home.setForeground(new Color(000000));
                home.setFont(new Font("SansSerif", Font.PLAIN, 15));
				home.setBounds(25, 15, 42, 20);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
               SwingUtilities.getWindowAncestor(home).dispose();
				new DoctorHomePage(username,true);
                
            }
        });
		  
		  
          


            appoinment.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                appoinment.setForeground(Color.RED);
                appoinment.setFont(new Font("SansSerif", Font.PLAIN, 17));
				appoinment.setBounds(105, 10, 130, 30);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                appoinment.setForeground(Color.RED);
                appoinment.setFont(new Font("SansSerif", Font.PLAIN, 15));
				appoinment.setBounds(110, 15, 120, 20);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
               // SwingUtilities.getWindowAncestor(appoinment).dispose();
                
            }
        });

        records.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                records.setForeground(new Color(0x00FF00));
                records.setFont(new Font("SansSerif", Font.PLAIN, 17));
				records.setBounds(270, 10, 180, 30);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                records.setForeground(new Color(0, 0, 0));
                records.setFont(new Font("SansSerif", Font.PLAIN, 15));
				records.setBounds(275, 15, 165, 20);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
				 SwingUtilities.getWindowAncestor(records).dispose();
                new DoctorPatientRecordsPage(username);
            }
        });
        


        prescripitions.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                prescripitions .setForeground(new Color(0x00FF00));
                prescripitions.setFont(new Font("SansSerif", Font.PLAIN, 17));
				prescripitions.setBounds(495, 10, 170, 30);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                prescripitions.setForeground(new Color(0, 0, 0));
                prescripitions.setFont(new Font("SansSerif", Font.PLAIN, 15));
		        prescripitions.setBounds(500, 15, 125, 20);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
				 SwingUtilities.getWindowAncestor(prescripitions).dispose();
                new DoctorAddPrescripitionsPage(username);
            }
        });


        return middle_panel;
    }






    private JPanel createLowerpanel()
    {

        JButton Addprescripitions = new JButton("Add Prescripitions");
        Addprescripitions.setBounds(445, 310, 120, 40);
        Addprescripitions.setFont(new Font("SansSerif", Font.PLAIN, 15));
        Addprescripitions.setBorder(BorderFactory.createLineBorder(new Color(0x1A75FF), 2, true));
        Addprescripitions.setFocusable(false);

        JButton AccesspatientRecords = new JButton("Access patient Records");
        AccesspatientRecords.setBounds(305, 310, 120, 40);
        AccesspatientRecords.setFont(new Font("SansSerif", Font.PLAIN, 15));
        AccesspatientRecords.setBorder(BorderFactory.createLineBorder(new Color(0x1A75FF), 2, true));
        AccesspatientRecords.setFocusable(false);

        AccesspatientRecords.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedUsername = getSelectedPatientUsername();
                if (selectedUsername != null) {
                    new DoctorPatientRecordsPage(selectedUsername);
                }
                else {
                    JOptionPane.showMessageDialog(null, "No doctor selected.");
                }
            }
        });

       

        tableModel = new DefaultTableModel(new String[]
             { "Full Name", "email" , "Specialization", "Days", "Time", "Fee"}, 0) 
        {
            @Override
            public boolean isCellEditable(int row, int column)
             {
                return false;
             }
        };

            viewappoinmentTable = new JTable(tableModel);
           
      
        

        loadDoctorData();

        viewappoinmentTable = new JTable(tableModel);
        viewappoinmentTable.getTableHeader().setReorderingAllowed(false);
        viewappoinmentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        viewappoinmentTable.setRowHeight(30);
        viewappoinmentTable.setFont(new Font("SansSerif", Font.PLAIN, 12));
        viewappoinmentTable.setShowGrid(true);
        viewappoinmentTable.setGridColor(new Color(230, 230, 230));

         //! Style Of The Header
        JTableHeader header = viewappoinmentTable.getTableHeader();
        header.setBackground(new Color(51, 102, 204));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("SansSerif", Font.BOLD, 12));

         viewappoinmentTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

        JScrollPane scrollPane = new JScrollPane(viewappoinmentTable);
        scrollPane.setBounds(0, 0, 900,300);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JPanel lower_panel = new JPanel();                                  
        lower_panel.setLayout(null);
        lower_panel.setBounds(0,180,900,385);
        lower_panel.setBackground(Color.white);
        lower_panel.add(Addprescripitions);
        lower_panel.add(AccesspatientRecords);
        lower_panel.add(scrollPane);
        return lower_panel;
    }



    private void loadDoctorData()
    {

        ArrayList<HashMap<String, String>> allDoctors = GetDoctorData.getAllDoctorsDetails();

        for (HashMap<String, String> doctor : allDoctors)
        {
            tableModel.addRow(new Object[] {
                doctor.get("fullName"),
                doctor.get("email"),
                doctor.get("specialization"),
                doctor.get("daysAvailable"),
                doctor.get("consultationHours"),
                doctor.get("consultationFee")
            });
        }



    }


    private String getSelectedPatientUsername() {
        int selectedRow = viewappoinmentTable.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }
        return FileUtils.getUsernameByEmail(tableModel.getValueAt(selectedRow, 1).toString(),"/data/doctors/");
    }





    /*private JPanel createLowerpanel()
    {
        JPanel lower_panel = new JPanel();                                  
        lower_panel.setLayout(null);
        lower_panel.setBounds(0,180,900,500);
        lower_panel.setBackground(new Color(0xECF8FD));
        




        return lower_panel;
    }*/






    @Override
    public void actionPerformed(ActionEvent e)
    {
        // code to handle the action event
    }

    public static void main(String[] args) {
        new DoctorViewAppoinmentsPage("emiko");
    }

}

