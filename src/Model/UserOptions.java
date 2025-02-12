package Model;

import java.sql.*;

public class UserOptions
{
    // create new user
    public int create(String name, String password, String email)
    {
        String sql = "INSERT INTO User (username, password, email) VALUES (?, ?, ?)";

        try
        {
            // communicate with SQL
            Connection c = DriverManager.getConnection(Global.URL, Global.USER , Global.PASSWORD);
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, password);
            pst.setString(3, email);
            
            pst.executeUpdate();
        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }

        return 0;
    }

    // read one user data
    public int readUser(int userId)
    {
        String sql = "SELECT * FROM User WHERE userId = ?";

        try
        {
            // communicate with SQL
            Connection c = DriverManager.getConnection(Global.URL, Global.USER , Global.PASSWORD);
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, userId);
            
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

    // delete user
    public int delete(int userId)
    {
        String sql = "DELETE FROM User WHERE userId = ?";

        try
        {
            // communicate with SQL
            Connection c = DriverManager.getConnection(Global.URL, Global.USER , Global.PASSWORD);
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, userId);
            pst.executeUpdate();
        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }
        return 0;
    }
}