package View;

import javax.swing.JPanel;
import Controller.*;

public class View extends JPanel
{
    public ControlManager manager;

    public View(ControlManager m)
    {
        manager = m;
    }

    public void setUpView()
    {
        revalidate();
        repaint();
    }
}
