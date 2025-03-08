package Model;

import java.sql.*;

public class UserOption
{
    // create new user
    public static int create(String name, String password, String email)
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

    // check if username and password match
    public static int findUser(String name, String password)
    {
        // RESULTS:
        // 0:   valid login
        // 1:   invalid login
        // 2:   error

        String sql = "SELECT * FROM User WHERE name = ?, password = ?";

        try
        {
            // communicate with SQL
            Connection c = DriverManager.getConnection(Global.URL, Global.USER , Global.PASSWORD);
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(1, password);
            
            ResultSet rs = pst.executeQuery();

            if (!rs.next()) {
                
                // invalid login
                System.out.println("ResultSet is empty");
                return 1;
            }
            else
            {
                // valid login
                return 0;
            }
        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }
        return 2;
    }

    // check if username is already taken or not
    public static int checkUsernameAvailable(String username)
    {
        // RESULTS:
        // 0:   valid login
        // 1:   invalid login
        // 2:   error

        String sql = "SELECT * FROM User WHERE name = ?";

        try
        {
            // communicate with SQL
            Connection c = DriverManager.getConnection(Global.URL, Global.USER , Global.PASSWORD);
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, username);
            
            ResultSet rs = pst.executeQuery();

            if (!rs.next())
            {    
                // name is free
                return 0;
            }
            else
            {
                // name is taken already
                return 1;
            }
        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }
        return 2;
    }

    // read one user data
    public static int readUser(int userId)
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

    public static int update()
    {
        return 0;
    }

    // delete user
    public static int delete(int userId)
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

    // change user verification
    public static int verifyUser(int userId, boolean verifying)
    {
        String sql = "UPDATE User SET verified = ? WHERE userId = ?";
        
        try
        {
            // communicate with SQL
            Connection c = DriverManager.getConnection(Global.URL);
            PreparedStatement pst = c.prepareStatement(sql);

            // bool to int
            int verifyingInt = 0;
            if(verifying)
            {
                verifyingInt = 1;
            }

            pst.setInt(1, verifyingInt);
            pst.setInt(2, userId);
            pst.executeUpdate();
        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }
        return 0;
    }
}