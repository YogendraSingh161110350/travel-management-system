
package dbopration;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JOptionPane;

/**
 *
 * @author yogendra singh
 */
public class DBOpration 
{
    public static int insertSignUpValue(String... details)
    {
        int a = 0;
        try
        {
            Connection con = dbconnection.DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into account values(?,?,?,?,?)");
            ps.setString(1, details[0]);
            ps.setString(2, details[1]);
            ps.setString(3, details[2]);
            ps.setString(4, details[3]);
            ps.setString(5, details[4]);
            a = ps.executeUpdate();
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, "username may be exist or may be very long","username error",JOptionPane.ERROR_MESSAGE);
        }
        return a;
    }
    public static String[] getName(String username)
    {
        String[] name = new String[4];
        try
        {
            Connection con = dbconnection.DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from account where username=?");
            ps.setString(1, username);
            ResultSet rs =ps.executeQuery();
            if(rs.next())
            {
                name[0] = rs.getString(2);
                name[1] = rs.getString(3);
                name[2] = rs.getString(4);
                name[3] = rs.getString(5);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return name;
    }
    public static int insertPersonalDetails(FileInputStream fis,String... details)
    {
        int a= 0;
       try
       {
            Connection con = dbconnection.DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into personal_details values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, details[0]);
            ps.setString(2, details[1]);
            ps.setString(3, details[2]);
            ps.setString(4, details[3]);
            ps.setString(5, details[4]);
            ps.setString(6, details[5]);
            ps.setString(7, details[6]);
            ps.setString(8, details[7]);
            ps.setString(9, details[8]);
            ps.setBinaryStream(10, fis);
            a = ps.executeUpdate();
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
       
       return a;
    }
    public static ResultSet login(String username,String password)
    {
         ResultSet rs= null;
        try
        {
            Connection con = dbconnection.DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from account where username= ? and password= ?");
            ps.setString(1, username);
            ps.setString(2,password);
            rs =ps.executeQuery();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    public static JoinRowSet getDetails(String username)
    {   
        JoinRowSet rs=null;
        try
        {
            Connection con = dbconnection.DBConnection.getConnection();
            CachedRowSet rs1 = RowSetProvider.newFactory().createCachedRowSet();
            rs1.setCommand("select * from  account where username='"+username+"'");
            rs1.execute(con);
            CachedRowSet rs2 = RowSetProvider.newFactory().createCachedRowSet();
            rs2.setCommand("select * from  personal_details where username='"+username+"'");
            rs2.execute(con);
            rs = RowSetProvider.newFactory().createJoinRowSet();
            rs.addRowSet(rs1, "username");
            rs.addRowSet(rs2, "username");
           
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return rs;
    }
    public static boolean deleteAccount(String username)
    {
        boolean flag = false;
        Connection con=null;
        try
        {
            con = dbconnection.DBConnection.getConnection();
            con.setAutoCommit(false);
            PreparedStatement ps1 = con.prepareStatement("delete from account where username= ?");
            PreparedStatement ps2 = con.prepareStatement("delete from personal_details where username= ?");
            ps1.setString(1, username);
            ps2.setString(1, username);
            int a = ps1.executeUpdate();
            int b = ps2.executeUpdate();
            if(a>0&&b>0)
            {
                flag= true;
                con.commit();
            }
            else
            {
                 try
                 {
                    con.rollback();
                 }
                 catch(Exception ex)
                {
                    ex.printStackTrace();
                }        
            }
        }
        catch(Exception e)
        {
           e.printStackTrace();
           try
           {
                con.rollback();
           }
           catch(Exception ex)
           {
               ex.printStackTrace();
           }
        }
        return flag;
    } 
    public static int updateDetails(FileInputStream fis,String... details)
    {   int c = 0;
        try
        {
            Connection con = dbconnection.DBConnection.getConnection();
            PreparedStatement ps1 = con.prepareStatement("update account set name= ? where username = ?");
            ps1.setString(1, details[1]);
            ps1.setString(2, details[0]);
            int a = ps1.executeUpdate();
            PreparedStatement ps2 = con.prepareStatement("update personal_details set name= ?,address= ?,email=?,phone= ?,image=? where username = ?");
            ps2.setString(1, details[1]);
            ps2.setString(2, details[2]);
            ps2.setString(3, details[3]);
            ps2.setString(4, details[4]);
            ps2.setBinaryStream(5, fis);
            ps2.setString(6, details[0]);
            int b = ps2.executeUpdate();
            if(a>0 &&b>0)
            {
                c=1;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return c;
    } 
    public static int updateDetails(String... details)
    {   int c = 0;
        try
        {
            Connection con = dbconnection.DBConnection.getConnection();
            PreparedStatement ps1 = con.prepareStatement("update account set name= ? where username = ?");
            ps1.setString(1, details[1]);
            ps1.setString(2, details[0]);
            int a = ps1.executeUpdate();
            PreparedStatement ps2 = con.prepareStatement("update personal_details set name= ?,address= ?,email=?,phone= ? where username = ?");
            ps2.setString(1, details[1]);
            ps2.setString(2, details[2]);
            ps2.setString(3, details[3]);
            ps2.setString(4, details[4]);
            ps2.setString(5, details[0]);
            int b = ps2.executeUpdate();
            if(a>0 &&b>0)
            {
                c=1;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return c;
    } 
    public static int bookPackage(int ammount,String... details)
    {
        int a = 0;
        try
        {
            Connection con = dbconnection.DBConnection.getConnection();
            PreparedStatement ps =  con.prepareStatement("insert into book_package values(?,?,?,?,?,?,?)");
            ps.setString(1, details[0]);
            ps.setString(2, details[1]);
            ps.setString(3, details[2]);
            ps.setString(4, details[3]);
            ps.setString(5, details[4]);
            ps.setString(6, details[5]);
            ps.setInt(7, ammount);
            a = ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
                    
        }
        return a;
    }
    public static CachedRowSet getPackageDetails(String username)
    {
         CachedRowSet rs=null;
       try
       {
           Connection con = dbconnection.DBConnection.getConnection();
           rs =RowSetProvider.newFactory().createCachedRowSet();
           rs.setCommand("select * from book_package where username =?");
           rs.setString(1, username);
           rs.execute(con);
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       return rs;
    }
    public static ResultSet hotelDetails(String hotel_name)
    {
        ResultSet rs = null;
        try
        {
            Connection con = dbconnection.DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from hotel where name= ?");
            ps.setString(1, hotel_name);
            rs = ps.executeQuery();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    public static int bookHotel(String... details)
    {
        int a= 0;
        try
        {
            Connection con = dbconnection.DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into book_hotel values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, details[0]);
            ps.setString(2, details[1]);
            ps.setString(3, details[2]);
            ps.setString(4, details[3]);
            ps.setString(5, details[4]);
            ps.setString(6, details[5]);
            ps.setString(7, details[6]);
            ps.setString(8, details[7]);
            ps.setString(9, details[8]);
            a =ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return a;
    }
    public static ResultSet getBookHotelDetails(String username)
    {
        ResultSet rs=null;
        try
        {
            Connection con = dbconnection.DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from book_hotel where username= ?");
            ps.setString(1, username);
            rs = ps.executeQuery();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
}
