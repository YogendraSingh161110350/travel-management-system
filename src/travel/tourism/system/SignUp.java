
package travel.tourism.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author yogendra singh
 */
public class SignUp extends JFrame implements ActionListener
{
    JTextField username,name,password,answer;
    Choice security ;
    JButton submit,back;
    public SignUp()
    {
        setBounds(400, 250, 800, 500);
        setDefaultCloseOperation(3);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        //----------------------------------text fields creation starts------------------------------------
        JPanel p1 = new JPanel(null);
        p1.setBounds(0, 0, 500, 500);
        p1.setBackground(new Color(131, 193, 233));
        
        JLabel jl1 = new JLabel("USERNAME:");
        jl1.setBounds(20, 20, 130, 50);
        jl1.setFont(new Font("relway",Font.PLAIN,20));
        
        username = new JTextField();
        username.setBounds(180, 27, 250, 30);
        p1.add(username);
        p1.add(jl1);
        
        JLabel jl2 = new JLabel("NAME:");
        jl2.setBounds(20, 80, 130, 50);
        jl2.setFont(new Font("relway",Font.PLAIN,20));
        p1.add(jl2);
        name = new JTextField();
        name.setBounds(180, 87, 250, 30);
        p1.add(name);
        
        JLabel jl3 = new JLabel("PASSWORD:");
        jl3.setBounds(20, 140, 130, 50);
        jl3.setFont(new Font("relway",Font.PLAIN,20));
        p1.add(jl3);
        password = new JTextField();
        password.setBounds(180, 147, 250, 30);
        p1.add(password);
        
        JLabel jl4 = new JLabel("SECURITY Q.:");
        jl4.setBounds(20, 200, 150, 50);
        jl4.setFont(new Font("relway",Font.PLAIN,20));
        p1.add(jl4);
        security = new Choice();
        security.add("what your childhood name?");
        security.add("what your favroite movie?");
        security.add("what your best friend name?");
        security.add("what is your lucky number?");
        security.setBounds(180, 217, 250, 40);
        p1.add(security);
        
        JLabel jl5 = new JLabel("ANSWER:");
        jl5.setBounds(20, 260, 150, 50);
        jl5.setFont(new Font("relway",Font.PLAIN,20));
        p1.add(jl5);
        
        answer = new JTextField();
        answer.setBounds(180, 267, 250, 30);
        p1.add(answer);
       //----------------------------------text fields creation ends------------------------------------ 
       
       
        //-----------------------------button-----------------------
        submit = new JButton("NEXT");
        submit.setBounds(20, 330, 150, 50);
        submit.setBackground(Color.white);
        submit.setFont(new Font("Arial",Font.BOLD,22));
        submit.setForeground(new Color(131, 193, 233));
        submit.addActionListener(this);
        p1.add(submit);
        back = new JButton("BACK");
        back.setBounds(230, 330, 150, 50);
        back.setBackground(Color.white);
        back.setFont(new Font("Arial",Font.BOLD,22));
        back.setForeground(new Color(131, 193, 233));
        back.addActionListener(this);
        p1.add(back);
        
        add(p1);
        
        setVisible(true);
    }
   

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==submit)
        {
            String username1 = username.getText();
            String name1 = name.getText();
            String password1 = password.getText();
            String security_q = security.getSelectedItem();
            String answer1 = answer.getText();
            if(username1.trim().length()<1)
            {
                JOptionPane.showMessageDialog(rootPane, "please enter valid username", "invalid username", JOptionPane.ERROR_MESSAGE);
            }
            else if(name1.trim().length()<1)
            {
                JOptionPane.showMessageDialog(rootPane, "please enter valid name", "invalid name", JOptionPane.ERROR_MESSAGE);
            }
            else if(password1.trim().length()<1)
            {
                JOptionPane.showMessageDialog(rootPane, "please enter valid password", "invalid password", JOptionPane.ERROR_MESSAGE);
            }
            else if(answer1.trim().length()<1)
            {
                JOptionPane.showMessageDialog(rootPane, "please enter valid answer Q.", "invalid answer", JOptionPane.ERROR_MESSAGE);
            }
            else 
            {
                int a = dbopration.DBOpration.insertSignUpValue(username1,name1.toUpperCase(),password1,security_q,answer1);
                if(a>0)
                {
                    JOptionPane.showMessageDialog(rootPane, "details submmited.");
                    setVisible(false);
                    new AddPersonalDetails(username1).setVisible(true);
                }
            }
        }
        
        else if(e.getSource()==back)
        {
            new LoginPage().setVisible(true);
            setVisible(false);
        }
       
     }
}
