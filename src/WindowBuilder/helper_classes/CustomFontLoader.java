package WindowBuilder.helper_classes;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.*;

public class CustomFontLoader
{
    final static String TITLE_FONT_PATH = "res/fonts/Jost/TrueType/Jost-400-Book.tff";
    final static String CONTENT_FONT_PATH = "res/fonts/roboto/Roboto-Medium.tff";

    public static Font loadFont(String path, float size)
    {
        try
        {
            InputStream is = CustomFontLoader.class.getResourceAsStream(path);
            System.out.println("Font loaded.");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            font = font.deriveFont(size);
            return font;
        }
        catch(FileNotFoundException f)
        {
            f.printStackTrace();
            System.out.println("COULD NOT FIND " + path + "; DEFAULTING...");
            return new Font("Arial", Font.PLAIN, (int) size);
        }
        catch (FontFormatException | IOException e)
        {
            e.printStackTrace();
            System.out.println(("OH NO! fontformat/IOexception!"));
            return new Font("Arial", Font.PLAIN, (int) size);
        }
        
    }

    public static Font loadTitleFont(float size)
    {
        return loadFont(TITLE_FONT_PATH, size);
    }

    public static Font loadContentFont(float size)
    {
        return loadFont(CONTENT_FONT_PATH, size);
    }
}