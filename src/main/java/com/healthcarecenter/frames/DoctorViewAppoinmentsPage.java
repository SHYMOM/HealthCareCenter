package com.healthcarecenter.frames;
import com.healthcarecenter.utils.FileUtils;
import com.healthcarecenter.utils.FrameUtils;
import com.healthcarecenter.utils.GetDoctorData;
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
            this.name = GetDoctorData.getName(username);
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
        label.setForeground(new Color(000000));
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
        middle_panel.setBounds(0,130,900,50);
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
		 appoinment.setForeground(Color.white);
         appoinment.setBounds(110, 15, 120, 20);

        //level for records
        JLabel records = new JLabel();
        records.setText("Access patient Records");
        records.setForeground(new Color(000000));
        records.setFont(new Font("SansSerif", Font.PLAIN, 15));
        records.setBounds(275, 15, 165, 20);

         //level for prescription
         JLabel prescription = new JLabel();
         prescription.setText("Add Prescription");
         prescription.setForeground(new Color(000000));
         prescription.setFont(new Font("SansSerif", Font.PLAIN, 15));
         prescription.setBounds(500, 15, 125, 20);

         //level for log out
         JLabel log_out = new JLabel();
         log_out.setText("Log out");
         log_out.setForeground(new Color(000000));
         log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
         log_out.setBounds(650, 15, 60, 20);
 
 
          //add level in middle_panel
		  middle_panel.add(home);
          middle_panel.add(appoinment);
          middle_panel.add(records);
          middle_panel.add(prescription);
		  middle_panel.add(log_out);


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
                String selectedUsername = getSelectedPatientUsername();
				if (selectedUsername != null) {
                    new DoctorPatientRecordsPage(username , selectedUsername);
                    SwingUtilities.getWindowAncestor(records).dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No patient selected.");
                }
            }
        });
        


        prescription.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                prescription .setForeground(new Color(0x00FF00));
                prescription.setFont(new Font("SansSerif", Font.PLAIN, 17));
				prescription.setBounds(495, 10, 170, 30);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                prescription.setForeground(new Color(0, 0, 0));
                prescription.setFont(new Font("SansSerif", Font.PLAIN, 15));
		        prescription.setBounds(500, 15, 125, 20);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                String selectedUsername = getSelectedPatientUsername();
				if (selectedUsername != null) {
                    new DoctorAddPrescripitionsPage(username, selectedUsername);
                    SwingUtilities.getWindowAncestor(prescription).dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No patient selected.");
                }
            }
        });

         log_out.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
            log_out.setForeground(new Color(0x00FF00));
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 17));
			log_out.setBounds(648, 12, 66, 25);
			
          }
          @Override
        public void mouseExited(MouseEvent e) {
            log_out.setForeground(new Color(0, 0, 0));
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
			log_out.setBounds(650, 15, 60, 20);
			
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

        JButton Addprescription = new JButton("Add prescription");
        Addprescription.setBounds(455, 320, 135, 30);
        Addprescription.setFont(new Font("SansSerif", Font.PLAIN, 15));
        Addprescription.setBorder(BorderFactory.createLineBorder(new Color(0x1A75FF), 2, true));
        Addprescription.setFocusable(false);

        Addprescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedUsername = getSelectedPatientUsername();
                if (selectedUsername != null) {
                    new DoctorAddPrescripitionsPage(username, selectedUsername);
                    SwingUtilities.getWindowAncestor(Addprescription).dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No patient selected.");
                }
            }
        });
        JButton AccesspatientRecords = new JButton("Access patient");
        AccesspatientRecords.setBounds(305, 320, 135, 30);
        AccesspatientRecords.setFont(new Font("SansSerif", Font.PLAIN, 15));
        AccesspatientRecords.setBorder(BorderFactory.createLineBorder(new Color(0x1A75FF), 2, true));
        AccesspatientRecords.setFocusable(false);

        AccesspatientRecords.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedUsername = getSelectedPatientUsername();
                if (selectedUsername != null) {
                    new DoctorPatientRecordsPage(username , selectedUsername);
                    SwingUtilities.getWindowAncestor(AccesspatientRecords).dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No patient selected.");
                }
            }
        });


        tableModel = new DefaultTableModel(new String[]
            { "Patient Name", "Patient Email" , "Appointment Date", "Status"}, 0) 
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
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
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
        lower_panel.add(Addprescription);
        lower_panel.add(AccesspatientRecords);
        lower_panel.add(scrollPane);
        return lower_panel;
    }



    private void loadDoctorData()
    {

        ArrayList<HashMap<String, String>> appointments = GetDoctorData.getAppointments(username);

        for (HashMap<String, String> appointment : appointments)
        {
            tableModel.addRow(new Object[] {
                appointment.get("patientName"),
                appointment.get("patientEmail"),
                appointment.get("date"),
                appointment.get("status")
            });
        }



    }


    private String getSelectedPatientUsername() {
        int selectedRow = viewappoinmentTable.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }
        return FileUtils.getUsernameByEmail(tableModel.getValueAt(selectedRow, 1).toString(),"/data/users/");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // code to handle the action event
    }

    public static void main(String[] args) {
        new DoctorViewAppoinmentsPage("Doctor2");
    }

}

