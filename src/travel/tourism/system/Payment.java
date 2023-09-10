
package travel.tourism.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author yogebdra singh
 */
public class Payment extends JFrame implements ActionListener
{
    JButton next ,back;
    String username;
    public Payment(String username)
    {
        this.username = username;
        setBounds(400, 300, 1000, 550);
        setDefaultCloseOperation(3);
        getContentPane().setBackground(Color.white);
        JLabel l2 = new JLabel("Payment Portal");
        l2.setBounds(300, 20, 300, 70);
        l2.setForeground(new Color(0, 0, 101));
        l2.setFont(new Font("Arial",Font.BOLD,40));
        add(l2);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icones//upi.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 300, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1= new JLabel(i3);
        l1.setBounds(0, 0, 1000, 500);
        add(l1);
        
        next = new JButton("Next");
        next.setBounds(250, 430, 200, 50);
        next.setFont(new Font("System",Font.BOLD,25));
        next.setBackground(Color.green);
        next.setForeground(Color.white);
        l1.add(next);
        
        back = new JButton("Back");
        back.setBounds(520, 430, 200, 50);
        back.setFont(new Font("System",Font.BOLD,25));
        back.setBackground(Color.red);
        back.setForeground(Color.white);
        back.addActionListener(this);
        l1.add(back);
        setVisible(true);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==next)
        {
        }
        else if(e.getSource()==back)
        {
            setVisible(false);
            new DashBoard(username).setVisible(true);
        }
     }
}
