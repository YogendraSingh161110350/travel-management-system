
package travel.tourism.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author yogendra singh
 */
public class LoginPage extends JFrame implements ActionListener
{
    JTextField username;
    JPasswordField password;
    JButton login,signup,forget;
    String username1,password1;
    public LoginPage()
    {
        setSize(900,500);
        setDefaultCloseOperation(3);
        setLayout(null);
        setLocation(400, 250);
        getContentPane().setBackground(Color.white);
        //---------------------------------start pannel one
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 400, 500);
        p1.setLayout(null);
        p1.setBackground(new Color(131, 193, 233));
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icones//AdminImage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 20, 300, 300);
        p1.add(image);
        add(p1);
        //----------------------------------end panel 1------------------------------------
        //----------------------------------------start panel 2----------------------------
        JPanel p2 = new JPanel(null);
        p2.setBounds(400,0 , 500, 500);
        p2.setBackground(Color.white);
        
        JLabel jl1 = new JLabel("USERNAME:");
        jl1.setBounds(30, 30, 200, 30);
        jl1.setFont(new Font("Arial",Font.PLAIN,20));
        p2.add(jl1);
        username= new JTextField();
        username.setBounds(30, 65, 350, 35);
        p2.add(username);
        //username.setBorder(BorderFactory.createEmptyBorder());
        
        JLabel jl2 = new JLabel("PASSWORD:");
        jl2.setBounds(30, 120, 200, 30);
        jl2.setFont(new Font("Arial",Font.PLAIN,20));
        p2.add(jl2);
        password= new JPasswordField();
        password.setBounds(30, 155, 350, 35);
        p2.add(password);
        
        login = new JButton("Login");
        login.setBounds(30, 230, 150,50);
        login.setBackground(new Color(131, 193, 233));
        login.setFont(new Font("Arial",Font.PLAIN,20));
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("SignUp");
        signup.setBounds(210, 230, 150,50);
        signup.setBackground(new Color(131, 193, 233));
        signup.setFont(new Font("Arial",Font.PLAIN,20));
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.addActionListener(this);
        p2.add(signup);
        
        forget = new JButton("Forget Password");
        forget.setBounds(30, 300, 200,50);
        forget.setBackground(new Color(131, 193, 233));
        forget.setFont(new Font("Arial",Font.PLAIN,20));
        forget.addActionListener(this);
        p2.add(forget);

        add(p2);
        
        setVisible(true);
    }
   
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==login)
        {
            username1 = username.getText().trim();
            password1 = password.getText().trim();
            try
            {
                ResultSet rs = dbopration.DBOpration.login(username1, password1);
                if(rs.next())
                {
                    setVisible(false);
                    new LoadingPage(username1).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "username or password did not match", "check username and password", HEIGHT);
                }
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        else if(e.getSource()==signup)
        {
            new SignUp().setVisible(true);
            setVisible(false);
        }
        else if(e.getSource()==forget)
        {
            new ForgetPassword().setVisible(true);
            setVisible(false);
        }
    }
}
