import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class DoctorManage extends JFrame implements ActionListener
{
    JLabel label,title,icon;
    JButton Add_Doctor,Remove_Doctor,Modify_Doctor;

    public DoctorManage()
    {
        
	   //!Labels
        label = new JLabel("Health Care Center");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0, 10, 400, 50);
        label.setForeground(new Color(0x00FF00));
        label.setFont(new Font("MV Boli", Font.BOLD, 20));

        //?Title
        title = new JLabel("Manage Doctor");
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
        Add_Doctor = new JButton("Add Doctor");
        Add_Doctor.setBounds(100, 150, 200, 50);
        Add_Doctor.setFocusable(false);
        Add_Doctor.addActionListener(this);
        
        //?Doctor
        Remove_Doctor = new JButton("Remove Doctor");
        Remove_Doctor.setBounds(100, 250, 200,50);
        Remove_Doctor.setFocusable(false);
        Remove_Doctor.addActionListener(this);

        //?Admin
        Modify_Doctor = new JButton("Modify Doctor");
        Modify_Doctor.setBounds(100, 350, 200, 50);
        Modify_Doctor.setFocusable(false);
        Modify_Doctor.addActionListener(this);


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
        this.add(Add_Doctor);
        this.add(Remove_Doctor);
        this.add(Modify_Doctor);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == Add_Doctor)
        {
            this.dispose();
            
        }
        else if(e.getSource() == Remove_Doctor)
        {
            this.dispose();
        }
        else if(e.getSource() == Modify_Doctor)
        {
            this.dispose();
        }
    }


  public static void main(String[] args) {
        new DoctorManage();
    }
}