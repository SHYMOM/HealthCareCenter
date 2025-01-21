package com.healthcarecenter.frames;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class adminLogout extends JFrame implements ActionListener
{

    public adminLogout()
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
        
        ImageIcon appIcon = new ImageIcon("resources/Icons/appIcon.png");
        this.setIconImage(appIcon.getImage());

        this.setTitle("Health Care Center");      
        this.setLayout(null);
        this.setSize(900, 600);                        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setResizable(false); 
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
		 
         //level for log out
         JLabel log_out = new JLabel();
         log_out.setText("Log out");
         log_out.setForeground(new Color(000000));
		 log_out.setForeground(Color.RED );
         log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
         log_out.setBounds(450, 15, 130, 20);
 
          //add level in middle_panel
          middle_panel.add(home);
          middle_panel.add(Mang_Doc);
          middle_panel.add(upd_bloo);
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
				new adminHomePage();
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
				new adminManageDoctor();
                
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
				new adminUpdateBloodStock();
                
            }
        });
		
	
         log_out.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
            log_out.setForeground(new Color(0x00FF00));
			log_out.setForeground(Color.RED );
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 18));
			log_out.setBounds(443, 10, 100, 30);
			
          }
          @Override
         public void mouseExited(MouseEvent e) {
            log_out.setForeground(new Color(0, 0, 0));
			log_out.setForeground(Color.RED );
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
			log_out.setBounds(450, 15, 130, 20);
			
          }
         @Override
          public void mouseClicked(MouseEvent e)  
          {
            int result = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION)
             {
                System.out.println("Yes selected");
                SwingUtilities.getWindowAncestor(log_out).dispose();
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
        JPanel lower_panel = new JPanel();                                  
        lower_panel.setLayout(null);
        lower_panel.setBounds(0,130,900,500);
        lower_panel.setBackground(new Color(0xECF8FD));
       
        return lower_panel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // code to handle the action event
    }

    public static void main(String[] args) {
        new adminLogout();
    }

}