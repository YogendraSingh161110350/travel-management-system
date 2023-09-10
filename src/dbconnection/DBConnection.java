
package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author yogendra singh
 */
public class DBConnection
{
   
    public static Connection getConnection()
    {
        Connection con=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_managment_system", "root", "root");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  con;
    }
}
