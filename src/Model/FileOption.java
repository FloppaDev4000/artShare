package Model;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class FileOption
{
    public static File[] loadFiles(int postId)
    {
        File[] files = null;
        String sql = "SELECT path FROM File WHERE postId = ?";

        try
        {
            Connection c = Global.getCon();
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postId);

            ResultSet rs = pst.executeQuery();

            ArrayList<File> list = new ArrayList<File>();
            while(rs.next())
            {
                File f = new File(rs.getString("path"));
                list.add(f);
            }

            files = list.toArray(files);
        }
        catch(SQLException s)
        {
            s.printStackTrace();
            return null;
        }
        return files;
    }

    public static String getFilePath(int postId)
    {
        String path = null;

        String sql = "SELECT path FROM File WHERE postId = ?";

        try
        {
            Connection c = Global.getCon();
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postId);

            ResultSet rs = pst.executeQuery();

            if(!rs.next())
            {
                return null;
            }

            path = rs.getString("path");
        }
        catch(SQLException s)
        {
            s.printStackTrace();
            return null;
        }
        

        return path;
    }

    public static int saveFile(int postId, int userId, String link)
    {
        // create SQL insert statement
        String sql = "INSERT INTO File (postId, userId, path) VALUES (?, ?, ?)";
        
        try
        {
            // communicate with SQL
            Connection c = Global.getCon();


            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postId);
            pst.setInt(2, userId);
            pst.setString(3, link);

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
