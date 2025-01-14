import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class userHistoryPage extends JFrame implements ActionListener
{

    public userHistoryPage()
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
        
        ImageIcon appIcon = new ImageIcon("HealthCareCenter/src/main/resources/Icons/appIcon.png");
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
        upper_panel.setBackground(Color.white);

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
        middle_panel.setBackground(new Color(25, 25, 105));


        //level for home
        JLabel home = new JLabel();
        home.setText("Home");
        home.setForeground(new Color(200, 120, 150));
        home.setFont(new Font("SansSerif", Font.PLAIN, 15));
        home.setBounds(25, 15, 100, 20);



         //level for appoinment
         JLabel appoinment= new JLabel();
         appoinment.setText("Book Appoinment");
         appoinment.setForeground(new Color(200, 120, 150));
         appoinment.setFont(new Font("SansSerif", Font.PLAIN, 15));
         appoinment.setBounds(110, 15, 165, 20);

          //level for history
        JLabel History = new JLabel();
        History.setText("View Medicle History");
        History.setForeground(Color.red);
        History.setFont(new Font("SansSerif", Font.PLAIN, 15));
        History.setBounds(275, 15, 200, 20);

         //level for blood
         JLabel blood = new JLabel();
         blood.setText("Blood Bank");
         blood.setForeground(new Color(200, 120, 150));
         blood.setFont(new Font("SansSerif", Font.PLAIN, 15));
         blood.setBounds(475, 15, 100, 20);

          //level for bill
        JLabel bill = new JLabel();
        bill.setText("Pay Bill");
        bill.setForeground(new Color(200, 120, 150));
        bill.setFont(new Font("SansSerif", Font.PLAIN, 15));
        bill.setBounds(625, 15, 100, 20);

         //level for log out
         JLabel log_out = new JLabel();
         log_out.setText("log_out");
         log_out.setForeground(new Color(200, 120, 150));
         log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
         log_out.setBounds(750, 15, 250, 20);
 
          //add level in middle_panel
          middle_panel.add(home);
          middle_panel.add(appoinment);
          middle_panel.add(History);
          middle_panel.add(blood);
          middle_panel.add(bill);
          middle_panel.add(log_out);


        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               home.setForeground(new Color(0x00FF00));
               home.setBounds(23, 10, 110, 30);
               home.setFont(new Font("SansSerif", Font.PLAIN, 17));
    
            }
            @Override
          public void mouseExited(MouseEvent e) {
                home.setForeground(new Color(200, 120, 150)); 
                home.setBounds(25, 15, 100, 20);
                home.setFont(new Font("SansSerif", Font.PLAIN, 15));
                 
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(History).dispose();
                new userHomePage();
            }
        });



        appoinment.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                appoinment.setForeground(new Color(0x00FF00));
                appoinment.setBounds(100, 10, 205, 30);
                appoinment.setFont(new Font("SansSerif", Font.PLAIN, 17));

            }
            @Override
            public void mouseExited(MouseEvent e) {
                appoinment.setForeground(new Color(200, 120, 150));
                appoinment.setBounds(110, 15, 165, 20);
                appoinment.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(History).dispose();
                new userAppointPage();
            }
        });

        History.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                History.setForeground(Color.red);
                History.setBounds(275, 15, 200, 20);
                History.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                History.setForeground(Color.red);
                History.setBounds(275, 15, 200, 20);
                History.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
               // SwingUtilities.getWindowAncestor(History).dispose();  
            }
        });
        


        blood .addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                blood .setForeground(new Color(0x00FF00));
                blood.setBounds(470, 10, 120, 30);
                blood.setFont(new Font("SansSerif", Font.PLAIN, 17));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                blood .setForeground(new Color(200, 120, 150));
                blood.setBounds(475, 15, 100, 20);
                blood.setFont(new Font("SansSerif", Font.PLAIN, 15));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.getWindowAncestor(History).dispose();
                new userBloodPage(); 
            }
        });



        bill.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
            bill.setForeground(new Color(0x00FF00));
            bill.setBounds(620, 5, 120, 40);
            bill.setFont(new Font("SansSerif", Font.PLAIN, 17));
          }
          @Override
          public void mouseExited(MouseEvent e) {
            bill.setForeground(new Color(200, 120, 150));
            bill.setBounds(625, 15, 100, 20);
            bill.setFont(new Font("SansSerif", Font.PLAIN, 15));
          }
          @Override
          public void mouseClicked(MouseEvent e) {
            SwingUtilities.getWindowAncestor(History).dispose();  
            new userBillPage();
          }
      });


      log_out.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
            log_out.setForeground(new Color(0x00FF00));
            log_out.setBounds(747, 10, 280, 30);
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 17));
          }
          @Override
        public void mouseExited(MouseEvent e) {
            log_out.setForeground(new Color(200, 120, 150));
            log_out.setBounds(750, 15, 250, 20);
            log_out.setFont(new Font("SansSerif", Font.PLAIN, 15));
          }
          @Override
          public void mouseClicked(MouseEvent e) {
            SwingUtilities.getWindowAncestor(History).dispose();
            new userLogOutPage();
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
        
        /*ImagePanel image_panel = new ImagePanel("HealthCareCenter/src/main/resources/Images/signUpBG1.jpg");
        image_panel.setBounds(0,0,900,300);
        image_panel.setLayout(null);
        image_panel.setOpaque(false);
        lower_panel.add(image_panel);*/

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


}
