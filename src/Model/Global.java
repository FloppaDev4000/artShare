package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Global
{
    public static final boolean SECRET_DEBUG_MODE = true;

    public static final String USER_FILE_PATH = "res/userFiles/";
    
    private static Connection c;
    
    public static final String URL = "jdbc:sqlite:res/data.sqlite";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    //public static final String FULL_URL = "jdbc:mysql://c00299231.candept.com:3306/artShare?user=user1&password=pr4ssw0ld4!";

    //public static String getFullUrl(){return FULL_URL;}

    public static void connect()
    {
        try
        {
            c = DriverManager.getConnection(Global.URL);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Connection getCon(){return c;}
}
