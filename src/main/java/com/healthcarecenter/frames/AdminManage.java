import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AdminManage extends JFrame implements ActionListener
{
    JLabel label,title,icon;
    JButton Add_Admin,Remove_Admin,Modify_Admin;

    public AdminManage()
    {
        
	   //!Labels
        label = new JLabel("Health Care Center");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0, 10, 400, 50);
        label.setForeground(new Color(0x00FF00));
        label.setFont(new Font("MV Boli", Font.BOLD, 20));

        //?Title
        title = new JLabel("Manage Admin");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0, 70, 400, 100);
        title.setForeground(new Color(0x00FF00));
        title.setFont(new Font("SansSerif", Font.ITALIC, 15));
		
		icon = new JLabel("Back");
        icon.setHorizontalAlignment(JLabel.LEFT);
        icon.setBounds(10, 0, 400, 60);
        icon.setForeground(new Color(0x00FF00));
        icon.setFont(new Font("SansSerif", Font.ITALIC, 15));

        
        //!Buttons
        //?Add_Doctor
        Add_Admin = new JButton("Add Admin");
        Add_Admin.setBounds(100, 150, 200, 50);
        Add_Admin.setFocusable(false);
        Add_Admin.addActionListener(this);
        
        //?Remove_Doctor
        Remove_Admin = new JButton("Remove Admin");
        Remove_Admin.setBounds(100, 250, 200,50);
        Remove_Admin.setFocusable(false);
        Remove_Admin.addActionListener(this);

        //?Modify_Doctor
        Modify_Admin = new JButton("Modify Admin");
        Modify_Admin.setBounds(100, 350, 200, 50);
        Modify_Admin.setFocusable(false);
        Modify_Admin.addActionListener(this);


        //!! main frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 550);
        this.setVisible(true);
        this.setTitle("Health Care Center");
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x123456));
        
        //? Adding components
        this.add(label);
        this.add(title);
		this.add(icon);
        this.add(Add_Admin);
        this.add(Remove_Admin);
        this.add(Modify_Admin);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == Add_Admin)
        {
            this.dispose();
            
        }
        else if(e.getSource() == Remove_Admin)
        {
            this.dispose();
        }
        else if(e.getSource() == Modify_Admin)
        {
            this.dispose();
        }
    }


  public static void main(String[] args) {
        new AdminManage();
    }
}