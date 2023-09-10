
package travel.tourism.system;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author yogendra singh
 */
public class SplashMain extends JFrame implements Runnable 
{
    ImageIcon i1;
    public SplashMain()
    {
        
        setDefaultCloseOperation(3);
        //setLayout(null);
       
       
        i1= new ImageIcon(ClassLoader.getSystemResource("icones//GreenArorra.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        Thread t1 = new Thread(this);
        t1.start();
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        SplashMain frame = new SplashMain();
        int x = 570;
        for(int i = 0;i<=600;x-=2,i+=4)
        {
        frame.setSize(2*i, i);
        frame.setLocation(x, x);
        try
        {
            Thread.sleep(10);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            }
        } 
    }

    @Override
    public void run() 
    {
        try
        {
            Thread.sleep(4000);
            setVisible(false);
            new LoginPage().setVisible(true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}