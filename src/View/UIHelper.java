package View;

import java.awt.Font;

import javax.swing.UIManager;
import WindowBuilder.helper_classes.*;

public class UIHelper
{
    public static void setup()
    {
        UIManager.getLookAndFeelDefaults().put("defaultFont", CustomFontLoader.loadContentFont(14));
    }
}
