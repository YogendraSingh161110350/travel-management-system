
package travel.tourism.system;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author yogendra singh
 */
public class ViewHotel extends JFrame implements Runnable
{
    ImageIcon[] i1 = new ImageIcon[10];
    Image[] i2= new Image[10];
    ImageIcon[] i3 = new ImageIcon[10];
    JLabel[] l1 = new JLabel[10];
    Thread t1;
    String username;
    public ViewHotel(String username)
    {
        this.username = username;
        setBounds(480, 280, 900, 550);
        setDefaultCloseOperation(3);
       
        for(int i = 0;i<10;i++)
        {
         i1[i] = new ImageIcon(ClassLoader.getSystemResource("icones//hotel"+(i+1)+".jpg"));  
         i2[i] = i1[i].getImage().getScaledInstance(900, 550, Image.SCALE_SMOOTH);
         i3[i] = new ImageIcon(i2[i]);
         l1[i] = new JLabel(i3[i]);
         l1[i].setBounds(0, 0, 900, 550);
         
         }
        t1=new Thread(this);
        t1.start();
        setVisible(true);
    }
    

    @Override
    public void run() 
    {
         try
         {
             for(int i = 0;i<10;i++)
             {
                 add(l1[i]);
                 System.out.println(i);
                 l1[i].setVisible(true);
                 Thread.sleep(1500);
                 if(i<8)
                 l1[i].setVisible(false);
                 
             }
                     new DashBoard(username).setVisible(true);
                     setVisible(false);
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
    }
}
