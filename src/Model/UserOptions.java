package Model;

import java.sql.*;

public class UserOptions
{
    public int create()
    {
        return 0;
    }

    public int readUser(int userID)
    {
        String sql = "SELECT * FROM user WHERE userID = ?";

        try
        {
            // communicate with SQL
            Connection c = DriverManager.getConnection(Global.URL, Global.USER , Global.PASSWORD);
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, userID);
            
            ResultSet rs = pst.executeQuery();
        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }
        return 0;
    }

    public int update()
    {
        return 0;
    }

    public int delete(int postID)
    {
        return 0;
    }
}