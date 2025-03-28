package Model;

import java.sql.*;
import Objects.*;

public class UserOption
{
    // create new user
    public static int create(String name, String password, String email)
    {
        String sql = "INSERT INTO User (username, password, email, isVerified) VALUES (?, ?, ?, 0)";

        try
        {
            // communicate with SQL
            Connection c = Global.getCon();
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

        String sql = "SELECT username, password FROM User WHERE username = ? and password = ? ";

        try
        {
            // communicate with SQL
            Connection c = Global.getCon();

            PreparedStatement pst = c.prepareStatement(sql);
            
            
            pst.setString(1, name);
            pst.setString(2, password);
            
            System.out.println("Query executed successfully!");
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
            System.out.println("ERROR!");
            s.printStackTrace();
        }
        return 2;
    }

    public static int getId(String name)
    {
        // RESULTS:
        // 0:   valid login
        // 1:   invalid login
        // 2:   error

        String sql = "SELECT userId FROM User WHERE username = ? ";

        System.out.println("getting ID...");

        try
        {
            // communicate with SQL
            Connection c = Global.getCon();

            System.out.println("CONNECTED");

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, name);
            
            ResultSet rs = pst.executeQuery();

            if (!rs.next()) {
                
                // invalid login
                System.out.println("ResultSet is empty");
                return 1;
            }
            else
            {
                // valid login, return UserId
                return rs.getInt(1);
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

        String sql = "SELECT * FROM User WHERE username = ?";

        try
        {
            // communicate with SQL
            Connection c = Global.getCon();
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
    public static User readUser(int userId)
    {
        String sql = "SELECT * FROM User WHERE userId = ?";
        User u = new User();

        try
        {
            // communicate with SQL
            Connection c = Global.getCon();
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, userId);
            
            ResultSet rs = pst.executeQuery();

            u.userId = userId;
            u.username = rs.getString("username");
            u.isVerified = rs.getBoolean("isVerified");
            u.bio = rs.getString("bio");
        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }
        return u;
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
            Connection c = Global.getCon();
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
            Connection c = Global.getCon();
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