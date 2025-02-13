package Model;

import java.sql.*;

import Exceptions.InteractionTypeException;

//      Interaction:
// interactionId
// postId
// userId
// type         0: like, 1: share, 2: comment
// comment

public class InteractionOption
{
    // check if given interaction type is valid
    public static void checkTypeValid(int type, int max) throws InteractionTypeException
    {
        if(type > max || type < 0)
        {
            throw new InteractionTypeException("Interaction type invalid.");
        }
    }

    // create non-comment interaction
    public static int createInteraction(int postId, int userId, int type) throws InteractionTypeException
    {
        String sql = "INSERT INTO Interaction (postId, userId, type) VALUES (?, ?, ?)";

        try
        {
            checkTypeValid(type, 1);

            Connection c = DriverManager.getConnection(Global.FULLURL);
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postId);
        }
        catch(InteractionTypeException i)
        {
            return 1;
        }
        catch(SQLException s)
        {
            s.printStackTrace();
            return 1;
        }

        return 0;
    }

    // create comment interaction
    public static int createComment(int postId, int userId, String comment)
    {
        String sql = "INSERT INTO Interaction (postId, userId, type, comment) VALUES (?, ?, 2, ?)";

        try
        {

            Connection c = DriverManager.getConnection(Global.FULLURL);
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postId);
            pst.setInt(2, userId);
            pst.setString(3, comment);

            pst.executeUpdate();
        }
        catch(SQLException s)
        {
            s.printStackTrace();
            return 1;
        }

        return 0;
    }
}
