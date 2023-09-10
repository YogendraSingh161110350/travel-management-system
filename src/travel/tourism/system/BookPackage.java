
package travel.tourism.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author yogendra singh
 */
public class BookPackage extends JFrame implements ActionListener
{
    JTextField jt1,jt2,jt3,jt4,jt5;
    String username,pckg;
    Choice choice1,choice2;
    JButton check_price,book_package,back;
    int total_price=2500;
    public BookPackage(String username)
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
        choice1 = new Choice();
        choice1.add("BRONZE PACKAGE");
        choice1.add("SILVER PACKAGE");
        choice1.add("GOLDEN PACKAGE");
        choice1.setBounds(250, 250, 300, 30);
        choice1.setFont(new Font("system",Font.PLAIN,18)); 
        add(choice1);
        
        JLabel l7 = new JLabel("SELECT PERSON");
        l7.setBounds(30, 300, 200, 30);
        l7.setFont(new Font("system",Font.PLAIN,20));
        add(l7);
        choice2 = new Choice();
        choice2.add("1");
        choice2.add("2");
        choice2.add("3");
        choice2.add("4");
        choice2.add("5");
        choice2.add("6");
        choice2.add("7");
        choice2.add("8");
        choice2.add("9");
        choice2.add("10");
        choice2.setBounds(250, 300, 300, 30);
        choice2.setFont(new Font("system",Font.PLAIN,18)); 
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
        
        //--------------------------------------button---------------------------
        
        check_price = new JButton("Check Price");
        check_price.setBounds(30, 420, 200, 40);
        check_price.setForeground(Color.white);
        check_price.setBackground(Color.black);
        check_price.addActionListener(this);
        check_price.setFont(new Font("system",Font.BOLD,25));
        add(check_price);
        
        book_package = new JButton("Book Package");
        book_package.setBounds(270, 420, 230, 40);
        book_package.setForeground(Color.white);
        book_package.setBackground(Color.black);
        book_package.addActionListener(this);
        book_package.setEnabled(false);
        book_package.setFont(new Font("system",Font.BOLD,25));
        add(book_package);
        setFields();
        back = new JButton("Back");
        back.setBounds(550, 420, 200, 40);
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
        if(e.getSource()==book_package)
        {
           int a = dbopration.DBOpration.bookPackage(total_price, username,jt2.getText(),jt3.getText(),jt4.getText(),choice1.getSelectedItem(),choice2.getSelectedItem());
           if(a>0)
           {
               JOptionPane.showMessageDialog(rootPane, "your trip has booked.");
           }
           else
           {
               JOptionPane.showMessageDialog(rootPane, "some error occure","please check your account agine",JOptionPane.ERROR_MESSAGE);
           }
        }
        else if(e.getSource()==check_price)
        {
            book_package.setEnabled(true);
            int person = Integer.parseInt(choice2.getSelectedItem());
            pckg = choice1.getSelectedItem();
            int ammount = 2_500;
            if(pckg.equals("BRONZE PACKAGE"))
            {
                ammount = 2_500;
            }
            else if(pckg.equalsIgnoreCase("silver package"))
            {
               ammount = 5_000;
            }
            
            else if(pckg.equalsIgnoreCase("golden package"))
            {
                ammount =10_000;
            }
            total_price = ammount*person;
            jt5.setText(total_price+"");
            System.out.println(total_price);
        }
        else if(e.getSource()==back)
        {
            setVisible(false);
            new DashBoard(username).setVisible(true);
        }
    }
    public void setFields()
    {
        try
        {
            JoinRowSet rs =dbopration.DBOpration.getDetails(username);
            if(rs.next())
            {
                jt2.setText(rs.getString(7));
                jt3.setText(rs.getString(8));
                jt4.setText(rs.getString(13));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
