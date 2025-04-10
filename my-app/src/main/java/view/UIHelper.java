package view;

import javax.swing.UIManager;

public class UIHelper
{
    public static void setup()
    {
        UIManager.getLookAndFeelDefaults().put("defaultFont", CustomFontLoader.loadContentFont(14));
    }
}
