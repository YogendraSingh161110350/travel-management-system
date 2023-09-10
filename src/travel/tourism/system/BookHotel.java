
package travel.tourism.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author 91740
 */
public class BookHotel extends JFrame implements ActionListener
{
    String username;
    JTextField name,totalPersons,id,id_number,phone,total_price;
    Choice hotel_name,ac,food,no_days;
    JButton jb1,jb2,jb3;
    String price ;
    public BookHotel(String username)
    {
        this.username = username;
        setBounds(400, 250, 1000, 600);
        setDefaultCloseOperation(3);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        //-------------------------------------label---------------------
        JLabel l1 = new JLabel("Username");
        l1.setBounds(50, 80, 150, 30);
        l1.setFont(new Font("system",Font.PLAIN,20));
        add(l1);
        
        name = new JTextField();
        name.setEditable(false);
        name.setBounds(210, 80, 300, 30);
        add(name);
        
        JLabel l2 = new JLabel("Total person");
        l2.setBounds(50, 120, 150, 30);
        l2.setFont(new Font("system",Font.PLAIN,20));
        add(l2);
        
        totalPersons = new JTextField();
        totalPersons.setEditable(false);
        totalPersons.setBounds(210, 120, 300, 30);
        add(totalPersons);
        
        JLabel l3 = new JLabel("No. of days");
        l3.setBounds(50, 160, 150, 30);
        l3.setFont(new Font("system",Font.PLAIN,20));
        add(l3);
        
        no_days = new Choice();
        //no_days.setEditable(false);
        no_days.add("1");
        no_days.add("2");
        no_days.add("3");
        no_days.add("4");
        no_days.add("5");
        no_days.add("6");
        no_days.add("7");
        no_days.add("8");
        no_days.add("9");
        no_days.add("10");
        no_days.add("11");
        no_days.add("12");
        no_days.add("13");
        no_days.add("14");
        no_days.add("15");
        no_days.add("16");
        no_days.add("17");
        no_days.add("18");
        no_days.add("19");
        no_days.add("20");
        no_days.add("21");
        no_days.setBounds(210, 160, 300, 30);
        add(no_days);
        
        JLabel l4 = new JLabel("Id");
        l4.setBounds(50, 200, 150, 30);
        l4.setFont(new Font("system",Font.PLAIN,20));
        add(l4);
        
        id = new JTextField();
        id.setEditable(false);
        id.setBounds(210, 200, 300, 30);
        add(id);
        JLabel l5 = new JLabel("Number");
        l5.setBounds(50, 240, 150, 30);
        l5.setFont(new Font("system",Font.PLAIN,20));
        add(l5);
        
        id_number = new JTextField();
        id_number.setEditable(false);
        id_number.setBounds(210, 240, 300, 30);
        add(id_number);
        
        JLabel l6 = new JLabel("Select hotel");
        l6.setBounds(50, 280, 150, 30);
        l6.setFont(new Font("system",Font.PLAIN,20));
        add(l6);
        
        hotel_name = new Choice();
        hotel_name.add("TAJ HOTEL");
        hotel_name.add("OBEROI DELHI");
        hotel_name.add("TAJ MAHAL PALACE");
        hotel_name.add("HIMALAYA PALACE");
        hotel_name.add("KEDRANATH BABA");
        hotel_name.setBounds(210, 280, 300, 30);
        add(hotel_name);
        
        JLabel l7 = new JLabel("Ac Room");
        l7.setBounds(50, 320, 150, 30);
        l7.setFont(new Font("system",Font.PLAIN,20));
        add(l7);
        ac = new Choice();
        ac.add("No");
        ac.add("Yes");
        ac.setBounds(210, 320, 300, 30);
        add(ac);
        
        JLabel l8 = new JLabel("Food Included");
        l8.setBounds(50, 360, 150, 30);
        l8.setFont(new Font("system",Font.PLAIN,20));
        add(l8);
        food = new Choice();
        food.add("No");
        food.add("Yes");
        food.setBounds(210, 360, 300, 30);
        add(food);
        
        total_price = new JTextField();
        total_price.setBounds(210, 400, 300, 30);
        total_price.setEditable(false);
        add(total_price);
        JLabel l9 = new JLabel("Total Price");
        l9.setBounds(50, 400, 150, 30);
        l9.setFont(new Font("system",Font.PLAIN,20));
        add(l9);
        jb1 = new JButton("Check Price");
        jb1.setBounds(50, 480, 160, 40);
        jb1.setBackground(Color.black);
        jb1.setForeground(Color.white);
        jb1.addActionListener(this);
        jb1.setFont(new Font("system",Font.BOLD,22));
        add(jb1);
        jb2 = new JButton("Book");
        jb2.setBounds(240, 480, 160, 40);
        jb2.setBackground(Color.black);
        jb2.setForeground(Color.white);
        jb2.addActionListener(this);
        jb2.setFont(new Font("system",Font.BOLD,22));
        jb2.setEnabled(false);
        add(jb2);
        jb3 = new JButton("Back");
        jb3.setBounds(430, 480, 160, 40);
        jb3.setBackground(Color.black);
        jb3.setForeground(Color.white);
        jb3.addActionListener(this);
        jb3.setFont(new Font("system",Font.BOLD,22));
        add(jb3);
        preDetails(username);
        setVisible(true);
    }
   

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==jb1)
        {
            calculatePrice(hotel_name.getSelectedItem());
            jb2.setEnabled(true);
        }
        else if(e.getSource()==jb2)
        {
            calculatePrice(hotel_name.getSelectedItem());
            int a= dbopration.DBOpration.bookHotel(username,totalPersons.getText(),no_days.getSelectedItem(),id.getText(),id_number.getText(),hotel_name.getSelectedItem(),ac.getSelectedItem(),food.getSelectedItem(),total_price.getText());
            if(a>0)
            {
                JOptionPane.showMessageDialog(rootPane, "your ticket has successfully submited");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "your ticket has not successfully submited","some error occure",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource()==jb3)
        {
            new DashBoard(username).setVisible(true);
            setVisible(false);
        }
        
    }
    public void preDetails(String username)
    {
        try
        {
            JoinRowSet rs = dbopration.DBOpration.getDetails(username);
            CachedRowSet rs1 = dbopration.DBOpration.getPackageDetails(username);
            if(rs.next())
            {
                System.out.println(rs.getString(6));
                id.setText(rs.getString(7));
                id_number.setText(rs.getString(8));
                name.setText(username);  
            }
            if(rs1.next())
            {
                totalPersons.setText(rs1.getString(6));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void calculatePrice(String hotel_name)
    {
     try
     {
         ResultSet rs = dbopration.DBOpration.hotelDetails(hotel_name);
         while(rs.next())
         {
             int ammount = 0;
             int days = Integer.parseInt(no_days.getSelectedItem());
             if(ac.getSelectedItem().equals("Yes"))
             {
                 ammount+=rs.getInt(3);
             }
             if(food.getSelectedItem().equals("Yes"))
             {
                 ammount+=rs.getInt(4);
             }
             ammount +=rs.getInt(2);
             ammount*=days;
             total_price.setText(ammount+"");
         }
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
    }
}
