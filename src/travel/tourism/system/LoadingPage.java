
package travel.tourism.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author yogendra singh
 */
public class LoadingPage extends JFrame implements Runnable
{
     JLabel jl1 ;
    JProgressBar progress;
    String username;
    public LoadingPage(String username)
    {
        this.username = username;
        setBounds(450, 300, 800, 450);
        setDefaultCloseOperation(3);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        jl1 = new JLabel("Loading...");
        jl1.setBounds(100, 180, 300, 30);
        jl1.setFont(new Font("system",Font.BOLD,20));
        jl1.setForeground(Color.red);
        add(jl1);
        JLabel jl2 = new JLabel("TRAVEL MANAGEMENT SYSTEM");
        jl2.setBounds(120, 40, 600, 30);
        jl2.setFont(new Font("system",Font.BOLD,35));
        jl2.setForeground(Color.green);
        add(jl2);
        
        JLabel jl3 = new JLabel("WELCOME : "+"xxx");
        jl3.setBounds(100, 300, 300, 30);
        jl3.setFont(new Font("system",Font.BOLD,20));
        jl3.setForeground(Color.BLUE);
        add(jl3);
        
        progress = new JProgressBar();
        progress.setBounds(100, 150, 600, 20);
        progress.setStringPainted(true);
        Thread t1 = new Thread(this);
        t1.start();
        add(progress);
        setVisible(true);
    }
   

    @Override
    public void run() 
    {
         for(int i = 1;i<=101;i++)
        {
            if(i==30)
            {
                jl1.setText("resource checking...");
            }
            if(i==60)
            {
               jl1.setText("data loading...");
            }
            progress.setValue(progress.getValue()+1);
            try
            {
                Thread.sleep(100);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
         setVisible(false);
         new DashBoard(username).setVisible(true);
    }
}
