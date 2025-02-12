package Model;

import java.sql.*;

public class PostOptions
{
    public static int create(String name, String description, int userID)
    {
        // create SQL insert statement
        String sql = "INSERT INTO posts VALUES (?, ?, ?)";
        
        try
        {
            // communicate with SQL
            Connection c = DriverManager.getConnection(Global.URL, Global.USER , Global.PASSWORD);
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, description);
            pst.setInt(3, userID);
            pst.executeUpdate();
        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }
        
        return 0;
    }

    public int readPost(int postID)
    {
        String sql = "SELECT * FROM posts WHERE postID = ?";

        try
        {
            // communicate with SQL
            Connection c = DriverManager.getConnection(Global.URL, Global.USER , Global.PASSWORD);
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postID);
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

    public int deletePost(int postID)
    {
        String sql = "DELETE FROM posts WHERE postID = ?";

        try
        {
            // communicate with SQL
            Connection c = DriverManager.getConnection(Global.URL, Global.USER , Global.PASSWORD);
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postID);
            pst.executeUpdate();
        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }
        return 0;
    }
}