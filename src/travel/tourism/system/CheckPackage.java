
package travel.tourism.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author yogendra singh
 */
public class CheckPackage extends JFrame implements ActionListener
{
    String username;
    JButton back;
    public CheckPackage(String username)
    {
        this.username = username;
        setBounds(500, 250, 800, 600);
        setDefaultCloseOperation(3);
        
        JTabbedPane t1 = new JTabbedPane();
        JPanel p1 = getPannel("1.) 6 days and 7 nights","2.) Airport assistance","3.) half day city tour","4.) daily buffet","5.) free soft drinks","6.) full day 3 island cruise","7.)  english speaking guide","Price:  10,000");
        JPanel p2 = getPannel("1.) 4 days and 5 nights","2.) Airport assistance","3.) half day city tour","4.) daily buffet","5.) 3 free soft drinks","6.) full day 2 island cruise","7.)  english speaking guide","Price:  5,000");
        JPanel p3 = getPannel("1.) 2 days and 3 nights","2.) BUS ASSISTANCE","3.) FULL day city tour","4.) daily buffet","5.) 1 free soft drinks","6.) full day 1 island cruise","7.)  hindi speaking guide","Price:  2,500");
        back  =new JButton("BACK");
        back.setBounds(40, 450, 200, 50);
        back.setForeground(Color.white);
        back.setBackground(Color.red);
        back.addActionListener(this);
        back.setFont(new Font("relway",Font.BOLD,30));
        p3.add(back);
        
        t1.addTab("GOLDEN PACKAGE", null, p1);
        t1.addTab("SILVER PACKAGE", null, p2);
        t1.addTab("BRONZE PACKAGE", null, p3);
        add(t1);
        
        setVisible(true);
    }
   
    public JPanel getPannel(String... details)
    {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 800, 600);
        p1.setBackground(Color.white);
        //---------------------------package information-------------------------------------------
        JLabel l1  =new JLabel(details[0].toUpperCase());
        l1.setBounds(40, 30, 300, 30);
        l1.setForeground(Color.black);
        l1.setFont(new Font("relway",Font.BOLD,22));
        p1.add(l1);
        
        JLabel l2  =new JLabel(details[1].toUpperCase());
        l2.setBounds(40, 70, 300, 30);
        l2.setForeground(Color.black);
        l2.setFont(new Font("relway",Font.BOLD,22));
        p1.add(l2);
        JLabel l3  =new JLabel(details[2].toUpperCase());
        l3.setBounds(40, 120, 300, 30);
        l3.setForeground(Color.black);
        l3.setFont(new Font("relway",Font.BOLD,22));
        p1.add(l3);
        JLabel l4  =new JLabel(details[3].toUpperCase());
        l4.setBounds(40, 170, 300, 30);
        l4.setForeground(Color.black);
        l4.setFont(new Font("relway",Font.BOLD,22));
        p1.add(l4);
        JLabel l5  =new JLabel(details[4].toUpperCase());
        l5.setBounds(40, 210, 300, 30);
        l5.setForeground(Color.black);
        l5.setFont(new Font("relway",Font.BOLD,22));
        p1.add(l5);
        JLabel l6  =new JLabel(details[5].toUpperCase());
        l6.setBounds(40, 260, 350, 30);
        l6.setForeground(Color.black);
        l6.setFont(new Font("relway",Font.BOLD,22));
        p1.add(l6);
        
        JLabel l7  =new JLabel(details[6].toUpperCase());
        l7.setBounds(40, 310, 350, 30);
        l7.setForeground(Color.black);
        l7.setFont(new Font("relway",Font.BOLD,22));
        p1.add(l7);
        
        JLabel l8  =new JLabel(details[7].toUpperCase());
        l8.setBounds(40, 390, 350, 30);
        l8.setForeground(new Color(0,0,101));
        l8.setFont(new Font("relway",Font.BOLD,30));
        p1.add(l8);
        

        return p1;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==back)
        {
            setVisible(false);
            new DashBoard(username).setVisible(true);
        }
    }
}
