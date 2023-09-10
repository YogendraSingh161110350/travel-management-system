
package travel.tourism.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import javax.sql.rowset.JoinRowSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author yogendra singh
 */
public class DashBoard extends JFrame implements ActionListener
{
    JButton about,update_details,view_details,delete_account,cheak_package,book_package,view_package,view_hotel,book_hotel,view_book_hotel,destinations,payment,calculator,exit,logout;
    String username ;
    public DashBoard(String username)
    {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(3);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        //--------------------image-------------------------
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icones//hotel2.jpg"));
        
        Image i5 =i4.getImage().getScaledInstance(1580, 850, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l1 = new JLabel(i6);
        l1.setBounds(350, 150, 1580, 850);
        add(l1);
        //-----------------------p1 panel-----------------------------------
        
        
        JPanel p1 = new JPanel(null);
        p1.setBounds(0, 0, 2000, 150);
        p1.setBackground(new Color(0,0,101));
        JLabel l2 = new JLabel("SHIVA TRAVEL AGENCY");
        l2.setForeground(Color.white);
        l2.setFont(new Font("relway",Font.BOLD,50));
        l2.setBounds(700, 50, 600, 50);
        //-----------------------insert image at top of pannel--------------------------------------
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icones//travel.png"));
        Image ii2 = ii1.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel l3 = new JLabel(ii3);
        l3.setBounds(50, 0,200, 150);
        
        p1.add(l2);
        p1.add(l3);
        try
        {
            JoinRowSet rs = dbopration.DBOpration.getDetails(username);
            if(rs.next())
            {
            JLabel jl1 = new JLabel("WELCOME: "+rs.getString(2).toUpperCase());
            jl1.setBounds(1400, 50, 500, 50);
            jl1.setFont(new Font("Arial",Font.BOLD,20));
            jl1.setForeground(Color.white);
            p1.add(jl1);
            InputStream fis = rs.getBinaryStream(14);
            ImageIcon i1 = new ImageIcon(rs.getBytes(14));
            Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel jl = new JLabel(i3);
            jl.setBounds(1800, 20, 100, 100);
            p1.add(jl);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
        
        p1.setLayout(null);
        add(p1);
        //--------------------------------p2 panel---------------------------------
        
        JPanel p2 = new JPanel(null);
        p2.setBounds(0, 150, 350, 1000);
        p2.setBackground(new Color(0,0,101));
        //--------------------------------------------------------button-------------------------------
        
        
        about = new JButton("About");
        about.setFont(new Font("relway",Font.BOLD,20));
        about.setForeground(Color.white);
        about.setBackground(new Color(0,0,101));
        about.addActionListener(this);
        about.setMargin(new Insets(0,0,0,185));
        about.setBounds(0, 10, 400, 50);
        p2.add(about);
        
        update_details = new JButton("Updates Profile");
        update_details.setFont(new Font("relway",Font.BOLD,20));
        update_details.setForeground(Color.white);
        update_details.setBackground(new Color(0,0,101));
        update_details.addActionListener(this);
        update_details.setMargin(new Insets(0,0,0,185));
        update_details.setBounds(0, 70, 400, 50);
        p2.add(update_details);
        
        
        view_details = new JButton("View Profile");
        view_details.setFont(new Font("relway",Font.BOLD,20));
        view_details.setForeground(Color.white);
        view_details.setBackground(new Color(0,0,101));
        view_details.addActionListener(this);
        view_details.setMargin(new Insets(0,0,0,210));
        view_details.setBounds(0, 130, 400, 50);
        p2.add(view_details);
        
        delete_account = new JButton("Delete Account");
        delete_account.setFont(new Font("relway",Font.BOLD,20));
        delete_account.setForeground(Color.white);
        delete_account.setBackground(new Color(0,0,101));
        delete_account.addActionListener(this);
        delete_account.setMargin(new Insets(0,0,0,185));
        delete_account.setBounds(0, 190, 400, 50);
        p2.add(delete_account);
        
        cheak_package = new JButton("Cheak Package");
        cheak_package.setFont(new Font("relway",Font.BOLD,20));
        cheak_package.setForeground(Color.white);
        cheak_package.setBackground(new Color(0,0,101));
        cheak_package.addActionListener(this);
        cheak_package.setMargin(new Insets(0,0,0,185));
        cheak_package.setBounds(0, 250, 400, 50);
        p2.add(cheak_package);
        
        
        book_package= new JButton("Book Package");
         book_package.setFont(new Font("relway",Font.BOLD,20));
         book_package.setForeground(Color.white);
         book_package.setBackground(new Color(0,0,101));
         book_package.addActionListener(this);
         book_package.setMargin(new Insets(0,0,0,185));
         book_package.setBounds(0, 310, 400, 50);
        p2.add( book_package);
        
        
        view_package = new JButton("View Package");
        view_package.setFont(new Font("relway",Font.BOLD,20));
        view_package.setForeground(Color.white);
        view_package.setBackground(new Color(0,0,101));
        view_package.addActionListener(this);
        view_package.setMargin(new Insets(0,0,0,190));
        view_package.setBounds(0, 370, 400, 50);
        p2.add(view_package);
        
        
        view_hotel = new JButton("View Hotels");
        view_hotel.setFont(new Font("relway",Font.BOLD,20));
        view_hotel.setForeground(Color.white);
        view_hotel.setBackground(new Color(0,0,101));
        view_hotel.addActionListener(this);
        view_hotel.setMargin(new Insets(0,0,0,195));
        view_hotel.setBounds(0, 430, 400, 50);
        p2.add(view_hotel);
        
        
        book_hotel = new JButton("Book Hotel");
        book_hotel.setFont(new Font("relway",Font.BOLD,20));
        book_hotel.setForeground(Color.white);
        book_hotel.setBackground(new Color(0,0,101));
        book_hotel.addActionListener(this);
        book_hotel.setMargin(new Insets(0,0,0,195));
        book_hotel.setBounds(0, 490, 400, 50);
        p2.add(book_hotel);
        
        view_book_hotel = new JButton("View Book Hotel");
        view_book_hotel.setFont(new Font("relway",Font.BOLD,20));
        view_book_hotel.setForeground(Color.white);
        view_book_hotel.setBackground(new Color(0,0,101));
        view_book_hotel.addActionListener(this);
        view_book_hotel.setMargin(new Insets(0,0,0,150));
        view_book_hotel.setBounds(0, 560, 400, 50);
        p2.add(view_book_hotel);
        
        destinations = new JButton("Destinations");
        destinations.setFont(new Font("relway",Font.BOLD,20));
        destinations.setForeground(Color.white);
        destinations.setBackground(new Color(0,0,101));
        destinations.addActionListener(this);
        destinations.setMargin(new Insets(0,0,0,180));
        destinations.setBounds(0, 620, 400, 50);
        p2.add(destinations);
        
        
        payment = new JButton("Payment");
        payment.setFont(new Font("relway",Font.BOLD,20));
        payment.setForeground(Color.white);
        payment.setBackground(new Color(0,0,101));
        payment.addActionListener(this);
        payment.setMargin(new Insets(0,0,0,220));
        payment.setBounds(0, 680, 400, 50);
        p2.add(payment);
        
        calculator = new JButton("Calculator");
        calculator.setFont(new Font("relway",Font.BOLD,20));
        calculator.setForeground(Color.white);
        calculator.setBackground(new Color(0,0,101));
        calculator.addActionListener(this);
        calculator.setMargin(new Insets(0,0,0,205));
        calculator.setBounds(0, 740, 400, 50);
        p2.add(calculator);
        
        logout = new JButton("Logout");
        logout.setFont(new Font("relway",Font.BOLD,20));
        logout.setForeground(Color.red);
        logout.setBackground(new Color(0,0,101));
        logout.addActionListener(this);
        logout.setMargin(new Insets(0,0,0,215));
        logout.setBounds(0, 800, 400, 50);
        p2.add(logout);
        
        
         exit= new JButton("Logout");
         exit.setFont(new Font("relway",Font.BOLD,20));
         exit.setForeground(Color.white);
         exit.setBackground(new Color(0,0,101));
         exit.addActionListener(this);
         exit.setMargin(new Insets(0,0,0,225));
         exit.setBounds(0, 860, 400, 50);
        p2.add( exit);
        
        add(p2);
        
        setVisible(true);
    }
   

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
         if(ae.getSource()==exit)
        {
            //setVisible(false);
            new LoginPage().setVisible(true);
        }
        else if(ae.getSource()==view_details)
        {
            new ViewProfile(username).setVisible(true);
            //setVisible(false);
        } 
        else if(ae.getSource()==delete_account)
        {
           int a =  JOptionPane.showConfirmDialog(this,"do you really want to delete account?" );
          
           if(a==0)
            {
                boolean status = dbopration.DBOpration.deleteAccount(username);
                System.out.println(status);
                if(status)
                {
                     System.exit(0);
                }
               
            } 
        }
        else if(ae.getSource()==update_details)
        {
            //setVisible(false);
            new UpdateDetails(username).setVisible(true);
        }
        else if(ae.getSource()==cheak_package)
        {
            //setVisible(false);
            new CheckPackage(username).setVisible(true);
        }
        else if(ae.getSource()==book_package)
        {
            //setVisible(false);
            new BookPackage(username).setVisible(true);
        }
        else if(ae.getSource()==view_package)
        {
            //setVisible(false);
            new ViewPackage(username).setVisible(true);
        }
        else if(ae.getSource()==view_hotel)
        {
            //setVisible(false);
            new ViewHotel(username).setVisible(true);
        }
        else if(ae.getSource()==book_hotel)
        {
            new BookHotel(username).setVisible(true);
            //setVisible(false);
        }
        else if(ae.getSource()==calculator)
        {
           Runtime r = Runtime.getRuntime();
           try
           {
                Process p = r.exec("calc");
                
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }
          
        }
        else if(ae.getSource()==logout)
        {
            
            int a =  JOptionPane.showConfirmDialog(this,"do you want to logout?" );
          
           if(a==0)
            {
                boolean status = dbopration.DBOpration.deleteAccount(username);
                System.out.println(status);
                if(status)
                {
                     new LoginPage().setVisible(true);
                     setVisible(false);
                }
               
            } 
           // setVisible(false);
           
        }
    }
}
