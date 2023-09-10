
package travel.tourism.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author yogendra singh
 */
public class ViewBookHotel extends JFrame implements ActionListener
{
    String username;
    JTextField name,totalPersons,id,id_number,total_price,hotel_name,ac,food,no_days;
    JButton jb1,jb2,jb3;
    String price ;
    public ViewBookHotel(String username)
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
        
        no_days = new JTextField();
        no_days.setEditable(false);
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
        
        JLabel l6 = new JLabel("Hotel");
        l6.setBounds(50, 280, 150, 30);
        l6.setFont(new Font("system",Font.PLAIN,20));
        add(l6);
        
        hotel_name = new JTextField();
        hotel_name.setEditable(false);
        hotel_name.setBounds(210, 280, 300, 30);
        add(hotel_name);
        
        JLabel l7 = new JLabel("Ac Room");
        l7.setBounds(50, 320, 150, 30);
        l7.setFont(new Font("system",Font.PLAIN,20));
        add(l7);
        ac = new JTextField();
        ac.setEditable(false);
        ac.setBounds(210, 320, 300, 30);
        add(ac);
        
        JLabel l8 = new JLabel("Food Included");
        l8.setBounds(50, 360, 150, 30);
        l8.setFont(new Font("system",Font.PLAIN,20));
        add(l8);
        food = new JTextField();
        food.setBounds(210, 360, 300, 30);
        food.setEditable(false);
        add(food);
        
        total_price = new JTextField();
        total_price.setBounds(210, 400, 300, 30);
        total_price.setEditable(false);
        add(total_price);
        JLabel l9 = new JLabel("Total Price");
        l9.setBounds(50, 400, 150, 30);
        l9.setFont(new Font("system",Font.PLAIN,20));
        add(l9);
        
       
        jb3 = new JButton("Back");
        jb3.setBounds(230, 480, 190, 50);
        jb3.setBackground(Color.black);
        jb3.setForeground(Color.white);
        jb3.addActionListener(this);
        jb3.setFont(new Font("system",Font.BOLD,22));
        add(jb3);
        // fill values inside the fields
        setFields();
        //preDetails(username);
        setVisible(true);
    
    }
   
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==jb3)
        {
            new DashBoard(username).setVisible(true);
            setVisible(false);
        }
    }
    public void setFields()
    {
        try
        {
            ResultSet rs = dbopration.DBOpration.getBookHotelDetails(username);
            if(rs.next())
            {
                name.setText(rs.getString(1));
                totalPersons.setText(rs.getString(2));
                no_days.setText(rs.getString(3));
                id.setText(rs.getString(4));
                id_number.setText(rs.getString(5));
                hotel_name.setText(rs.getString(6));
                ac.setText(rs.getString(7));
                food.setText(rs.getString(8));
                total_price.setText(rs.getString(9));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    
    }
}
