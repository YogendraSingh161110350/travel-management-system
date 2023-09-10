
package travel.tourism.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author yogendra singh
 */
public class AddPersonalDetails extends JFrame implements ActionListener
{
    JTextField username1,id_number,name1,address,email,phone,country;
    JComboBox id_type;
    JRadioButton male,female,others;
    JButton add,back,select_image;
    JLabel add_image ;
    File file;
    String username,name;
    public AddPersonalDetails(String username)
    {
        this.username = username;
        name = dbopration.DBOpration.getName(username)[0]; 
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
        id_type = new JComboBox(new String[]{"Select ID","Passport","Aadhar card","Pan card","Licence","Voter ID","Domecile"} );
        id_type.setBounds(240, 160, 300, 30);
        add(id_type);
        
        JLabel jl4 = new JLabel("ID Number:");
        jl4.setBounds(60, 210, 150, 30);
        jl4.setFont(new Font("system",Font.PLAIN,20));
        add(jl4);
        id_number = new JTextField();
        id_number.setBounds(240, 210, 300, 30);
        add(id_number);
        
        JLabel jl5 = new JLabel("Gender:");
        jl5.setBounds(60,260, 150, 30);
        jl5.setFont(new Font("system",Font.PLAIN,20));
        add(jl5);
        male = new JRadioButton("Male");
        male.setBounds(240, 260, 100, 30);
        male.setBackground(Color.white);
        male.setFont(new Font("system",Font.PLAIN,20));
        female = new JRadioButton("Female");
        female.setBounds(340, 260, 100, 30);
        female.setBackground(Color.white);
        female.setFont(new Font("system",Font.PLAIN,20));
        others = new JRadioButton("Others");
        others.setBounds(460, 260, 100, 30);
        others.setBackground(Color.white);
        others.setFont(new Font("system",Font.PLAIN,20));
        ButtonGroup b1 = new ButtonGroup();
        b1.add(male);
        b1.add(female);
        b1.add(others);
        add(female);
        add(others);
        add(male);
        
        JLabel jl6 = new JLabel("Country:");
        jl6.setBounds(60, 310, 150, 30);
        jl6.setFont(new Font("system",Font.PLAIN,20));
        add(jl6);
        country = new JTextField();
        country.setBounds(240, 310, 300, 30);
        add(country);
        
        JLabel jl7 = new JLabel("Address:");
        jl7.setBounds(60, 360, 150, 30);
        jl7.setFont(new Font("system",Font.PLAIN,20));
        add(jl7);
        address = new JTextField();
        address.setBounds(240, 360, 300, 30);
        add(address);
        
        JLabel jl8 = new JLabel("Email:");
        jl8.setBounds(60, 410, 150, 30);
        jl8.setFont(new Font("system",Font.PLAIN,20));
        add(jl8);
        email = new JTextField();
        email.setBounds(240, 410, 300, 30);
        add(email);
        
        JLabel jl9 = new JLabel("Phone:");
        jl9.setBounds(60, 460, 150, 30);
        jl9.setFont(new Font("system",Font.PLAIN,20));
        add(jl9);
        phone = new JTextField();
        phone.setBounds(240, 460, 300, 30);
        add(phone);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icones//AdminImage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 150,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        add_image = new JLabel(i3);
        add_image.setBounds(700, 20, 150, 150);
        add(add_image);
        //------------------------------------end of fields and lables------------------------
        //------------------------------------start of BUttons--------------------------------
        select_image =new JButton("Select Image");
        select_image.setBounds(700, 190, 190, 50);
        select_image.setBackground(new Color(59,177,67));
        select_image.setFont(new Font("relway",Font.BOLD,23));
        select_image.setForeground(Color.white);
        select_image.addActionListener(this);
        add(select_image);
        
        add =new JButton("ADD");
        add.setBounds(100, 530, 160, 50);
        add.setBackground(new Color(59,177,67));
        add.setFont(new Font("relway",Font.BOLD,23));
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);
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
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==select_image)
        {
            JFileChooser jfc = new JFileChooser();
           
            int a = jfc.showOpenDialog(this);
            if(a==0)
            {
                 file = jfc.getSelectedFile();
                 ImageIcon i1 = new ImageIcon(file.toString());
                 Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                 ImageIcon i3 = new ImageIcon(i2);
                 add_image.setIcon(i3);
            }
            else 
            {
            
            }
        }
        else if(ae.getSource()==add)
        {
           
            String id_type1 = (String) id_type.getSelectedItem();
            String id_number1 = id_number.getText();
            String gender = "";
            if (male.isSelected()) 
            {
                gender = "Male";
            } else if (female.isSelected()) 
            {
                gender = "Female";
            } else if (others.isSelected())
            {
                gender = "Others";
            }
            String country1 = country.getText();
            String address1 = address.getText();
            String email1 = email.getText();
            String phone1 = phone.getText();
            if(id_type1.equalsIgnoreCase("Select Id"))
            {
                JOptionPane.showMessageDialog(rootPane, "select id type", "choose id ", JOptionPane.ERROR_MESSAGE);
            }
            else if(id_type1.trim().length()<5)
            {
                JOptionPane.showMessageDialog(rootPane, "id number more than 5 character", "invalid id ", JOptionPane.ERROR_MESSAGE);
            }
            else if(gender.equals(""))
            {
                JOptionPane.showMessageDialog(rootPane, "choose the gender", "select gender ", JOptionPane.ERROR_MESSAGE);
            }
            else if(country1.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(rootPane, "enter county name", "invalid contry ", JOptionPane.ERROR_MESSAGE);
            }
            else if(address1.trim().length()<5)
            {
                JOptionPane.showMessageDialog(rootPane, "wrong address", "invalid address ", JOptionPane.ERROR_MESSAGE);
            }
            else if(email1.trim().length()<11)
            {
                JOptionPane.showMessageDialog(rootPane, "invalid email id", "invalid email ", JOptionPane.ERROR_MESSAGE);
            }
            else if(phone1.trim().length()!=10)
            {
                JOptionPane.showMessageDialog(rootPane, "invalid phone number", "invalid phone number ", JOptionPane.ERROR_MESSAGE);
            }
            else if(file==null)
            {
               JOptionPane.showMessageDialog(rootPane, "select photo", "choose photo ", JOptionPane.ERROR_MESSAGE);
            } 
           
           else 
           { 
               try
               {
                   //add_image.setIcon(new ImageIcon(file.toString()));
                   FileInputStream fis = new FileInputStream(file);
                   int b = dbopration.DBOpration.insertPersonalDetails(fis,username,name,id_type1,id_number1,gender.toUpperCase(),country1.toUpperCase(),address1.toUpperCase(),email1,phone1);
                   if(b>0)
                   {
                       System.out.println("value inserted successfully.");
                       JOptionPane.showMessageDialog(rootPane, "record has saved.");
                       setVisible(false);
                       new LoginPage().setVisible(true);
                   }
               }
               catch(Exception e)
               {
                   e.printStackTrace();
               }
           }
        }
        else if(ae.getSource()==back)
        {
            
        }
    }
}
