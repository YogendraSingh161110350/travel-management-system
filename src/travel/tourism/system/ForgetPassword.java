
package travel.tourism.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
/**
 *
 * @author yogendra singh
 */
public class ForgetPassword extends JFrame implements ActionListener,KeyListener
{
    JTextField username_field,name_field,security_field,answer_field,password_field;
    JButton search,get_password,back;
    String username=null;
    String password = null;
    String answer= null;
    public ForgetPassword()
    {
        setBounds(400, 250, 1000, 500);
        setDefaultCloseOperation(3);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        //-------------------------------------panel 1 start-------------------------
        JPanel p1 = new JPanel(null);
        p1.setBounds(0, 0, 600, 500);
        
        JLabel jl1 = new JLabel("Username:");
        jl1.setBounds(20, 40, 150, 30);
        jl1.setFont(new Font("relway",Font.BOLD,20));
        p1.add(jl1);
        
        username_field = new JTextField();
        username_field.setBounds(180, 42, 250, 30);
        username_field.addKeyListener(this);
        p1.add(username_field);
        
        JLabel jl2 = new JLabel("Name:");
        jl2.setBounds(20, 90, 150, 30);
        jl2.setFont(new Font("relway",Font.BOLD,20));
        p1.add(jl2);
        
        name_field = new JTextField();
        name_field.setBounds(180, 92, 250, 30);
        name_field.setEditable(false);
        p1.add(name_field);
        
        
        JLabel jl3 = new JLabel("Security Q. :");
        jl3.setBounds(20, 140, 150, 30);
        jl3.setFont(new Font("relway",Font.BOLD,20));
        p1.add(jl3);
        
        security_field = new JTextField();
        security_field.setBounds(180, 142, 250, 30);
        security_field.setEditable(false);
        p1.add(security_field);
        
         JLabel jl4 = new JLabel("Answer :");
        jl4.setBounds(20, 190, 150, 30);
        jl4.setFont(new Font("relway",Font.BOLD,20));
        p1.add(jl4);
        
        answer_field = new JTextField();
        answer_field.setBounds(180, 192, 250, 30);
        p1.add(answer_field);
        add(p1);
         JLabel jl5 = new JLabel("Password: ");
        jl5.setBounds(20, 240, 150, 30);
        jl5.setFont(new Font("relway",Font.BOLD,20));
        p1.add(jl5);
        
        password_field = new JTextField();
        password_field.setBounds(180, 240, 250, 30);
        password_field.setEditable(false);
        p1.add(password_field);
        
        search = new JButton("Search");
        search.setBounds(460,42 , 120, 30);
        search.addActionListener(this);
        p1.add(search);
        
        get_password = new JButton("Get Password");
        get_password.setBounds(460,192 , 120, 30);
        get_password.setEnabled(false);
        get_password.addActionListener(this);
        p1.add(get_password);
        
        back = new JButton("Back");
        back.setBounds(200, 290, 100,30);
        back.addActionListener(this);
        p1.add(back);
        add(p1);
        //-------------------------------------panel 1 end---------------------------
        
        setVisible(true);
    }
  
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==search)
        {
            username  = username_field.getText();
            String name[] = dbopration.DBOpration.getName(username);
            if(!(name[1]==null))
            {
                name_field.setText(name[0]);
                security_field.setText(name[2]);
                password = name[1];
                answer = name[3];
                
                get_password.setEnabled(true);
            }
            else
            {
               JOptionPane.showMessageDialog(rootPane, "record not found", "invalid username", JOptionPane.ERROR_MESSAGE);
            }
            
        } 
        else if(e.getSource()==get_password)
        {
           if(answer_field.getText().trim().equals(answer))
           {
               password_field.setText(password);
               get_password.setEnabled(false);
           }
           else
           {
               JOptionPane.showMessageDialog(rootPane, "wrong answer", "try agine", JOptionPane.ERROR_MESSAGE);
           }
        }  
        else if(e.getSource()==back)
        {
            new LoginPage().setVisible(true);
            setVisible(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {

    }
}
