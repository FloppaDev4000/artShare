package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JOptionPane;

public class FileSaver
{
    public final static String userFilePath = "res/userFiles/images";

    public static void saveImgToDir(File selectedFile)
    {
        // Create a directory for saving the file
        File targetDirectory = new File(userFilePath);

        if (!targetDirectory.exists())
        {
            targetDirectory.mkdir();
        }

        // Determine the target file path
        File targetFile = new File(targetDirectory, selectedFile.getName());

        if(targetFile.exists())
        {
            return;
        }

        // Copy file to the new location
        try (InputStream inStream = new FileInputStream(selectedFile);OutputStream outStream = new FileOutputStream(targetFile))
        {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }

            JOptionPane.showMessageDialog(null, "File saved to: " + targetFile.getAbsolutePath());

        }
        catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving the file: " + e.getMessage());
        }
    }
}
