package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class Global
{
    public static final boolean SECRET_DEBUG_MODE = false;
    
    private static Connection c;
    
    public static final String URL = "jdbc:sqlite:res/data.sqlite";

    // get connection at start of program
    public static void connect()
    {
        try
        {
            c = DriverManager.getConnection(URL);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    // get connection
    public static Connection getCon(){return c;}
}
