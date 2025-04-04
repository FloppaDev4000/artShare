package View;

import javax.swing.UIManager;
import WindowBuilder.helper_classes.CustomFontLoader;

public class UIHelper
{
    public static void setup()
    {
        UIManager.getLookAndFeelDefaults().put("defaultFont", CustomFontLoader.loadContentFont(14));
    }
}
