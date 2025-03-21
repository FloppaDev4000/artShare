package Model;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

import Objects.Post;

public class FileOption
{
    public File[] loadFiles(int postId)
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
                File f = new File(rs.getString("link"));
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

    public int saveFile(int postId, int userId, String link)
    {
        return 0;
    }
}
