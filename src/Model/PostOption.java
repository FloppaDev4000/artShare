package Model;

import java.sql.*;
import Objects.*;

//      Post:
// postId
// title
// description
// userId

public class PostOption
{
    public static int create(String name, String description, int userId)
    {
        // create SQL insert statement
        String sql = "INSERT INTO Post (title, description, userId) VALUES (?, ?, ?)";
        
        try
        {
            // communicate with SQL
            Connection c = Global.getCon();

            System.out.println("CONNECTED");

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
    public static Post readPost(int postId)
    {
        String sql = "SELECT * FROM Post WHERE postId = ?";
        ResultSet rs;
        Post p = null;
        try
        {
            // communicate with SQL
            Connection c = Global.getCon();
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postId);
            rs = pst.executeQuery();

            p = new Post();
            p.setPostId(postId);
            p.setTitle(rs.getString("title"));
            p.setDescription(rs.getString("description"));
            p.setUserId(rs.getInt("userId"));

            // AFTER THIS, GET INTERACTIONS
        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }

        return p;
    }

    // read array of posts, by userId or all
    public static Post[] readPosts(int userId, int maxLength)
    {
        Post[] posts = new Post[maxLength];

        String sql = "SELECT " +
        "* " +
        "FROM Post";

        if(userId != -1){sql += " WHERE userId = ?";}

        ResultSet rs;
        try
        {
            // communicate with SQL
            Connection c = Global.getCon();
            PreparedStatement pst = c.prepareStatement(sql);

            if(userId != -1){pst.setInt(1, userId);}

            rs = pst.executeQuery();

            int index = 0;

            while(rs.next() && index < maxLength)
            {
                Post p = new Post();
                p.setPostId(rs.getInt("postId"));
                p.setTitle(rs.getString("title"));
                p.setDescription(rs.getString("description"));
                p.setUserId(rs.getInt("userId"));
                
                // use other table options to get other stuff
                p.setFilePath("file path");
                int[] interactions = {0, 0, 0};
                interactions = InteractionOption.getInteraction(rs.getInt("postId"));
                p.setInteractions(interactions);
                
                posts[index] = p;
                index++;
            }

        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }

        return posts;   
    }

    // update
    public int update()
    {
        return 0;
    }

    // delete post by postId
    public int deletePost(int postId)
    {
        String sql = "DELETE FROM Post WHERE postId = ?";

        try
        {
            // communicate with SQL
            Connection c = Global.getCon();
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