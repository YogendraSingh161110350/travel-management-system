
package travel.tourism.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sql.rowset.JoinRowSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author yogendra singh
 */
public class ViewProfile extends JFrame implements ActionListener
{
    String username,name,id,idn,cntry,adres,mail,phn,gndr;
    JTextField username1,name1,id_type,id_number,country,email,phone,gender;
    JTextArea address;
    JLabel add_image;
    JRadioButton male,female,others;
    JButton back;
    byte[] image;
    public ViewProfile(String username)
    {
        this.username = username;
        
        try
        {
            JoinRowSet rs = dbopration.DBOpration.getDetails(username);
            if(rs.next())
            {
                name = rs.getString(6);
                id = rs.getString(7);
                idn = rs.getString(8);
                gndr= rs.getString(9);
                cntry = rs.getString(10);
                adres = rs.getString(11);
                mail = rs.getString(12);
                phn = rs.getString(13);
                image = rs.getBytes(14);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        setBounds(400,200, 1000, 700);
        setDefaultCloseOperation(3);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        //----------------------------fields and labales-------------------------------
        JLabel jl1 = new JLabel("Username:");
        jl1.setBounds(60, 60, 150, 30);
        jl1.setFont(new Font("system",Font.PLAIN,20));
        add(jl1);
        username1 = new JTextField();
        username1.setEditable(false);
        username1.setBounds(240, 60, 300, 30);
        username1.setText(username);
        add(username1);
        
        JLabel jl2 = new JLabel("Name:");
        jl2.setBounds(60, 110, 150, 30);
        jl2.setFont(new Font("system",Font.PLAIN,20));
        add(jl2);
        name1 = new JTextField();
        name1.setEditable(false);
        name1.setBounds(240, 110, 300, 30);
        name1.setText(name);
        add(name1);
        
        JLabel jl3 = new JLabel("ID Type:");
        jl3.setBounds(60, 160, 150, 30);
        jl3.setFont(new Font("system",Font.PLAIN,20));
        add(jl3);
        id_type = new JTextField(id);
        id_type.setEditable(false);
        id_type.setBounds(240, 160, 300, 30);
        add(id_type);
        
        JLabel jl4 = new JLabel("ID Number:");
        jl4.setBounds(60, 210, 150, 30);
        jl4.setFont(new Font("system",Font.PLAIN,20));
        add(jl4);
        id_number = new JTextField(idn.substring(0, 2)+"XXXXX"+idn.substring(4));
        id_number.setEditable(false);
        id_number.setBounds(240, 210, 300, 30);
        add(id_number);
        
        JLabel jl5 = new JLabel("Gender:");
        jl5.setBounds(60,260, 150, 30);
        jl5.setFont(new Font("system",Font.PLAIN,20));
        add(jl5)
                ;
        gender = new JTextField(gndr);
        gender.setEditable(false);
        gender.setBounds(240,260 , 150, 30);
        add(gender);
        
        JLabel jl6 = new JLabel("Country:");
        jl6.setBounds(60, 310, 150, 30);
        jl6.setFont(new Font("system",Font.PLAIN,20));
        add(jl6);
        country = new JTextField(cntry);
        country.setEditable(false);
        country.setBounds(240, 310, 300, 30);
        add(country);
        
        JLabel jl7 = new JLabel("Address:");
        jl7.setBounds(60, 360, 150, 30);
        jl7.setFont(new Font("system",Font.PLAIN,20));
        add(jl7);
        address = new JTextArea(adres);
        address.setEditable(false);
        address.setBounds(240, 360, 400, 30);
        add(address);
        
        JLabel jl8 = new JLabel("Email:");
        jl8.setBounds(60, 410, 150, 30);
        jl8.setFont(new Font("system",Font.PLAIN,20));
        add(jl8);
        email = new JTextField(mail);
        email.setEditable(false);
        email.setBounds(240, 410, 300, 30);
        add(email);
        
        JLabel jl9 = new JLabel("Phone:");
        jl9.setBounds(60, 460, 150, 30);
        jl9.setFont(new Font("system",Font.PLAIN,20));
        add(jl9);
        phone = new JTextField(phn);
        
        phone.setEditable(false);
        phone.setBounds(240, 460, 300, 30);
        add(phone);
        
        ImageIcon i1 = new ImageIcon(image);
        Image i2 = i1.getImage().getScaledInstance(150, 150,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        add_image = new JLabel(i3);
        add_image.setBounds(700, 20, 150, 150);
        add(add_image);
        //------------------------------------end of fields and lables------------------------
        //------------------------------------start of BUttons--------------------------------
       
        back =new JButton("Back");
        back.setBounds(350, 530, 160, 50);
        back.setBackground(new Color(255,0,0));
        back.setFont(new Font("relway",Font.BOLD,23));
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        setVisible(true);
    }
  
    @Override
    public void actionPerformed(ActionEvent e)
    {
          new DashBoard(username).setVisible(true);
          setVisible(false);
    
    }
}
