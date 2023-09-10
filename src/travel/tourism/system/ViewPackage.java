
package travel.tourism.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author 91740
 */
public class ViewPackage extends JFrame implements ActionListener
{
    JTextField jt1,jt2,jt3,jt4,jt5,choice1,choice2;
    String username,pckg;
    JButton back;
    int total_price;
    public ViewPackage(String username)
    {
        this.username = username;
        setBounds(400, 250, 1000, 600);
        setDefaultCloseOperation(3);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        //------------------------------label----------------------------
        JLabel l1 = new JLabel("Book Package");
        l1.setBounds(100, 0, 300, 40);
        l1.setFont(new Font("system",Font.BOLD,30));
        add(l1);
        JLabel l2 = new JLabel("Username");
        l2.setBounds(30, 50, 200, 30);
        l2.setFont(new Font("system",Font.PLAIN,22));
        add(l2);
        jt1 = new JTextField();
        jt1.setBounds(250, 50, 300, 30);
        jt1.setFont(new Font("system",Font.PLAIN,18));
        jt1.setText(username);
        jt1.setEditable(false);
        add(jt1);
        

        JLabel l3 = new JLabel("ID");
        l3.setBounds(30, 100, 200, 30);
        l3.setFont(new Font("system",Font.PLAIN,22));
        add(l3);
        jt2 = new JTextField();
        jt2.setBounds(250, 100, 300, 30);
        jt2.setFont(new Font("system",Font.PLAIN,18));     
        jt2.setEditable(false);
        add(jt2);
        
        JLabel l4 = new JLabel("ID NUMBER");
        l4.setBounds(30, 150, 200, 30);
        l4.setFont(new Font("system",Font.PLAIN,22));
        add(l4);
        jt3 = new JTextField();
        jt3.setBounds(250, 150, 300, 30);
        jt3.setFont(new Font("system",Font.PLAIN,18));     
        jt3.setEditable(false);
        add(jt3);
        
        JLabel l5 = new JLabel("PHONE");
        l5.setBounds(30, 200, 200, 30);
        l5.setFont(new Font("system",Font.PLAIN,22));
        add(l5);
        jt4 = new JTextField();
        jt4.setBounds(250, 200, 300, 30);
        jt4.setFont(new Font("system",Font.PLAIN,18));     
        jt4.setEditable(false);
        add(jt4);
        
        JLabel l6 = new JLabel("SELECT PACKAGE");
        l6.setBounds(30, 250, 200, 30);
        l6.setFont(new Font("system",Font.PLAIN,20));
        add(l6);
        
        choice1 = new JTextField();
        choice1.setBounds(250, 250, 300, 30);
        choice1.setFont(new Font("system",Font.PLAIN,18)); 
        choice1.setEditable(false);
        add(choice1);
        
        JLabel l7 = new JLabel("SELECT PERSON");
        l7.setBounds(30, 300, 200, 30);
        l7.setFont(new Font("system",Font.PLAIN,20));
        add(l7);
        choice2 =new JTextField();
        choice2.setBounds(250, 300, 300, 30);
        choice2.setFont(new Font("system",Font.PLAIN,18)); 
        choice2.setEditable(false);
        add(choice2);
        
        JLabel l8 = new JLabel("TOTAL AMOUNT");
        l8.setBounds(30, 350, 200, 30);
        l8.setFont(new Font("system",Font.PLAIN,22));
        add(l8);
        jt5 = new JTextField();
        jt5.setBounds(250, 350, 300, 30);
        jt5.setFont(new Font("system",Font.PLAIN,18));
        jt5.setText(2500+"");
        jt5.setEditable(false);
        add(jt5);
        insertValue();
        //--------------------------------------button---------------------------
        

        back = new JButton("Back");
        back.setBounds(30, 420, 200, 40);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        back.setFont(new Font("system",Font.BOLD,25));
        add(back);
        
        setVisible(true);
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
    public void insertValue()
    {
       try
       {
            CachedRowSet rs = dbopration.DBOpration.getPackageDetails(username);
            if(rs.next())
            {
                jt2.setText(rs.getString(2));
                jt3.setText(rs.getString(3));
                jt4.setText(rs.getString(4));
                choice1.setText(rs.getString(5));
                choice2.setText(rs.getString(6));
                jt5.setText(rs.getInt(7)+"");
                   
            }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }
}
