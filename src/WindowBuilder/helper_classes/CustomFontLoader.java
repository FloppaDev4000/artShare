package WindowBuilder.helper_classes;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class CustomFontLoader
{
    final static String TITLE_FONT_PATH = "res/fonts/Jost/TrueType/Jost-400-Book.tff";
    final static String CONTENT_FONT_PATH = "res/fonts/roboto/Roboto-Medium.tff";

    public static Font loadFont(String path, float size)
    {
        try
        {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
            font = font.deriveFont(size);
            return font;
        }
        catch (FontFormatException | IOException e)
        {
            System.out.println("COULD NOT FIND " + path + "; DEFAULTING...");
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