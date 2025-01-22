package com.healthcarecenter.frames;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class SuperAdminOtherSystemManagement extends JFrame implements ActionListener
{

    public SuperAdminOtherSystemManagement()
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
        upper_panel.setBounds(0,0,900,200);
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
        user_panel.setBackground(Color.yellow);
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
        middle_panel.setBackground(new Color(10, 10, 10));


        //level for home
        JLabel home = new JLabel();
        home.setText("Home");
        home.setForeground(new Color(0x00FF00));
        home.setFont(new Font("SansSerif", Font.PLAIN, 15));
        home.setBounds(20, 15, 60, 20);



         //level for Manage Doctors
         JLabel Mang_Doc= new JLabel();
         Mang_Doc.setText("Manage Doctors");
         Mang_Doc.setForeground(new Color(0x00FF00));
         Mang_Doc.setFont(new Font("SansSerif", Font.PLAIN, 15));
         Mang_Doc.setBounds(80, 15, 140, 20);

          //level forupd_bloo
         JLabel upd_bloo = new JLabel();
         upd_bloo.setText("Update Blood Stock");
         upd_bloo.setForeground(new Color(0x00FF00));
         upd_bloo.setFont(new Font("SansSerif", Font.PLAIN, 15));
         upd_bloo.setBounds(200, 15, 160, 20);
		 
		 //level for manage admin
         JLabel Mang_Admin = new JLabel();
         Mang_Admin.setText("Manage Admin");
         Mang_Admin.setForeground(new Color(0x00FF00));
         Mang_Admin.setFont(new Font("SansSerif", Font.PLAIN, 15));
         Mang_Admin.setBounds(380, 15, 120, 20);

         //level for oth_sys_manag 
         JLabel oth_sys_manag = new JLabel();
         oth_sys_manag .setText("Other System Management");
         oth_sys_manag.setForeground(Color.RED );
         oth_sys_manag .setFont(new Font("SansSerif", Font.PLAIN, 15));
         oth_sys_manag .setBounds(510, 15, 225, 20);

         //level for log out
         JLabel log_out = new JLabel();
         log_out.setText("Log out");
         log_out.setForeground(new Color(0x00FF00));
         log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
         log_out.setBounds(750, 15, 250, 20);
 
          //add level in middle_panel
          middle_panel.add(home);
          middle_panel.add(Mang_Doc);
          middle_panel.add(upd_bloo);
          middle_panel.add(oth_sys_manag );
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
                home.setForeground(new Color(200, 120, 150)); 
                home.setBounds(20, 15, 60, 20);
                home.setFont(new Font("SansSerif", Font.PLAIN, 15));
                 
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(home).dispose();
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
                Mang_Doc.setForeground(new Color(200, 120, 150));
                Mang_Doc.setFont(new Font("SansSerif", Font.PLAIN, 15));
				Mang_Doc.setBounds(80, 15, 140, 20);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(home).dispose();
                
            }
        });

       upd_bloo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               upd_bloo.setForeground(new Color(0x00FF00));
               upd_bloo.setFont(new Font("SansSerif", Font.PLAIN, 18));
			   upd_bloo.setBounds(210, 10, 170, 30);
			  
            }
            @Override
            public void mouseExited(MouseEvent e) {
               upd_bloo.setForeground(new Color(200, 120, 150));
               upd_bloo.setFont(new Font("SansSerif", Font.PLAIN, 15));
			   upd_bloo.setBounds(220, 15, 160, 20);
			  
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
        });
		
		Mang_Admin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               Mang_Admin.setForeground(new Color(0x00FF00));
               Mang_Admin.setFont(new Font("SansSerif", Font.PLAIN, 18));
			   Mang_Admin.setBounds(370, 10, 130, 30);
			  
            }
            @Override
            public void mouseExited(MouseEvent e) {
               Mang_Admin.setForeground(new Color(200, 120, 150));
               Mang_Admin.setFont(new Font("SansSerif", Font.PLAIN, 15));
			   Mang_Admin.setBounds(380, 15, 120, 20);
			  
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
        });
        


        oth_sys_manag  .addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                oth_sys_manag.setForeground(Color.RED );
                oth_sys_manag .setFont(new Font("SansSerif", Font.PLAIN, 18));
				oth_sys_manag .setBounds(520, 10, 230, 30);
				
            }
            @Override
            public void mouseExited(MouseEvent e) {
                oth_sys_manag.setForeground(Color.RED );
                oth_sys_manag .setFont(new Font("SansSerif", Font.PLAIN, 15));
				oth_sys_manag .setBounds(510, 15, 225, 20);
				
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
            log_out.setForeground(new Color(200, 120, 150));
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
			log_out.setBounds(750, 15, 250, 20);
			
          }
          @Override
          public void mouseClicked(MouseEvent e) {
              
          }
      });


        return middle_panel;
    }

    private JPanel createLowerpanel()
    {
        JPanel lower_panel = new JPanel();                                  
        lower_panel.setLayout(null);
        lower_panel.setBounds(0,200,900,500);
        lower_panel.setBackground(Color.white);
        
        //ImagePanel image_panel = new ImagePanel("HealthCareCenter/src/main/resources/Images/signUpBG1.jpg");
        //image_panel.setBounds(0,0,900,300);
        //image_panel.setLayout(null);
        //image_panel.setOpaque(false);
        //lower_panel.add(image_panel);

        JLabel welcome= new JLabel("Welcome User");
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setBounds(300,330,300,30);
        welcome.setFont(new Font("SensSerif", Font.PLAIN, 20));

        JLabel health_tips= new JLabel("Random Health Tips");
        health_tips.setHorizontalAlignment(JLabel.CENTER);
        health_tips.setBounds(350,300,200,30);
        health_tips.setFont(new Font("SensSerif", Font.PLAIN, 15));


        lower_panel.add(welcome);
        lower_panel.add(health_tips);

        return lower_panel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // code to handle the action event
    }

    public static void main(String[] args) {
        new SuperAdminOtherSystemManagement();
    }

}