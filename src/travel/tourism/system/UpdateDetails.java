
package travel.tourism.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import javax.sql.rowset.JoinRowSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author yogendra singh
 */
public class UpdateDetails extends JFrame implements ActionListener
{
    String username,name,id,idn,cntry,adres,mail,phn,gndr;
    JTextField username1,name1,id_type,id_number,country,address,email,phone,gender;
    JLabel add_image;
    JRadioButton male,female,others;
    JButton back,select,update;
    byte[] image;
    File filee;
    public UpdateDetails(String username)
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
        //name1.setEditable(false);
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
        address = new JTextField(adres);
        //address.setEditable(false);
        address.setBounds(240, 360, 300, 30);
        add(address);
        
        JLabel jl8 = new JLabel("Email:");
        jl8.setBounds(60, 410, 150, 30);
        jl8.setFont(new Font("system",Font.PLAIN,20));
        add(jl8);
        email = new JTextField(mail);
        //email.setEditable(false);
        email.setBounds(240, 410, 300, 30);
        add(email);
        
        JLabel jl9 = new JLabel("Phone:");
        jl9.setBounds(60, 460, 150, 30);
        jl9.setFont(new Font("system",Font.PLAIN,20));
        add(jl9);
        phone = new JTextField(phn); 
        //phone.setEditable(false);
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
        select =new JButton("Select");
        select.setBounds(700, 200, 160, 50);
        select.setBackground(new Color(0,0,101));
        select.setFont(new Font("relway",Font.BOLD,23));
        select.setForeground(Color.white);
        select.addActionListener(this);
        add(select);
        update =new JButton("Save");
        update.setBounds(100, 530, 160, 50);
        update.setBackground(new Color(59,177,67));
        update.setFont(new Font("relway",Font.BOLD,23));
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        setVisible(true);   
    }
   
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==back)
        {
            new DashBoard(username).setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==select)
        {
            JFileChooser jf = new JFileChooser();
            int a = jf.showSaveDialog(this);
            if(a==0)
            {
                filee = jf.getSelectedFile();
                ImageIcon i1 = new ImageIcon(filee.getAbsolutePath());
                Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                ImageIcon i3 = new ImageIcon(i2);
                add_image.setIcon(i3);
            }
        }
        else if(ae.getSource()==update)
        {
            if(name.length()<0)
            {
                JOptionPane.showMessageDialog(rootPane, "inavlid name", "check name", JOptionPane.ERROR_MESSAGE);
            }
            else if(adres.length()<10)
            {
                JOptionPane.showMessageDialog(rootPane, "inavlid address", "check address", JOptionPane.ERROR_MESSAGE);
            }
            else if(mail.length()<13)
            {
                JOptionPane.showMessageDialog(rootPane, "inavlid email", "check email", JOptionPane.ERROR_MESSAGE);
            }
            else if(!(phn.length()==10))
            {
                JOptionPane.showMessageDialog(rootPane, "inavlid mobile number", "check mobile number.", JOptionPane.ERROR_MESSAGE);
            }
            else if(filee==null)
            {
                try
                {
                     int a = dbopration.DBOpration.updateDetails(username,name1.getText().toUpperCase(),address.getText().toUpperCase(),email.getText(),phone.getText());
                     if(a==1)
                     {
                        JOptionPane.showMessageDialog(rootPane, "Inforamtion has updated.");
                     }
                }
                catch(Exception e)
                {
                     e.printStackTrace();
                }
            }
            else 
            {
                 try
                {
                     FileInputStream fis = new FileInputStream(filee);
                     int a = dbopration.DBOpration.updateDetails(fis, username,name1.getText().toUpperCase(),address.getText().toUpperCase(),email.getText(),phone.getText());
                     if(a==1)
                    {
                        JOptionPane.showMessageDialog(rootPane, "Inforamtion has updated.");
                    }
             }
             catch(Exception e)
                {
                 e.printStackTrace();
                }
            }
        }
    }
}
