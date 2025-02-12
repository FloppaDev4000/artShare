package Model;

import java.sql.*;

//      Post:
// postId
// title
// description
// userId

public class PostOptions
{
    public static int create(String name, String description, int userId)
    {
        // create SQL insert statement
        String sql = "INSERT INTO Post (title, description, userId) VALUES (?, ?, ?)";
        
        try
        {
            // communicate with SQL
            Connection c = DriverManager.getConnection(Global.URL, Global.USER , Global.PASSWORD);
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, description);
            pst.setInt(3, userId);

            pst.executeUpdate();
        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }
        
        return 0;
    }

    // read one post data
    public int readPost(int postId)
    {
        String sql = "SELECT * FROM Post WHERE postId = ?";

        try
        {
            // communicate with SQL
            Connection c = DriverManager.getConnection(Global.URL, Global.USER , Global.PASSWORD);
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postId);
            ResultSet rs = pst.executeQuery();
        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }

        return 0;
    }

    // read many posts' data
    public int readManyPost()
    {
        return 0;
    }

    public int update()
    {
        return 0;
    }

    public int deletePost(int postId)
    {
        String sql = "DELETE FROM Post WHERE postId = ?";

        try
        {
            // communicate with SQL
            Connection c = DriverManager.getConnection(Global.URL, Global.USER , Global.PASSWORD);
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postId);
            pst.executeUpdate();
        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }
        return 0;
    }
}