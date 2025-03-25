package Model;

import java.sql.*;

import javax.naming.spi.DirStateFactory.Result;

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
    public static void checkTypeValid(int type, int max, int min) throws InteractionTypeException
    {
        if(type > max || type < min)
        {
            throw new InteractionTypeException("Interaction type invalid.");
        }
    }

    public static int checkInteraction(int postId, int userId, int type)
    {
        // CHECK IF IDENTICAL INTERACTION EXISTS. IF SO, REMOVE. IF NOT, CREATE

        String sql = "SELECT interactionId FROM Interaction WHERE postId = ? AND userId = ? AND type = ?";

        try
        {
            checkTypeValid(type, 1, 0);

            Connection c = Global.getCon();
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postId);
            pst.setInt(2, userId);
            pst.setInt(3, type);

            ResultSet rs = pst.executeQuery();

            if(rs.next())
            {
                System.out.println("REMOVING...");
                removeInteraction(postId, userId, type);
            }
            else
            {
                System.out.println("ADDING TO POST: " + postId);
                createInteraction(postId, userId, type);
            }
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

    // create non-comment interaction
    private static int createInteraction(int postId, int userId, int type)
    {
        String sql = "INSERT INTO Interaction (postId, userId, type) VALUES (?, ?, ?)";

        try
        {
            checkTypeValid(type, 1, 0);

            Connection c = Global.getCon();
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postId);
            pst.setInt(2, userId);
            pst.setInt(3, type);

            pst.executeUpdate();
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

    // create non-comment interaction
    private static int removeInteraction(int postId, int userId, int type)
    {
        String sql = "DELETE FROM Interaction WHERE postId = ? AND userId = ? AND type = ?";

        try
        {
            checkTypeValid(type, 1, 0);

            Connection c = Global.getCon();
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postId);
            pst.setInt(2, userId);
            pst.setInt(3, type);

            pst.executeUpdate();
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
        // auto set type to 2
        String sql = "INSERT INTO Interaction (postId, userId, type, comment) VALUES (?, ?, 2, ?)";

        try
        {
            Connection c = Global.getCon();
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

    public static int deleteInteraction(int interactionId)
    {
        String sql = "DELETE FROM Interaction WHERE InteractionId = ?";

        try
        {

            Connection c = Global.getCon();
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, interactionId);

            pst.executeUpdate();
        }
        catch(SQLException s)
        {
            s.printStackTrace();
            return 1;
        }

        return 0;
    }

    public static int[] getInteraction(int postId)
    {
        int[] interactionArr = {0, 0, 0};

        String sql = "SELECT * FROM Interaction WHERE postId = ?";
        ResultSet rs;
        try
        {
            // communicate with SQL
            Connection c = Global.getCon();
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postId);
            rs = pst.executeQuery();

            while(rs.next())
            {
                int type = rs.getInt("type");
                interactionArr[type]++;
            }

        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }
    
        return interactionArr;
    }
}
