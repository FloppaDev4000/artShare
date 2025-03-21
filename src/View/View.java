package View;

import javax.swing.JPanel;
import Controller.*;

public class View extends JPanel
{
    private ControlManager manager;

    public View(ControlManager m)
    {
        manager = m;
    }

    public void setUpView()
    {
        revalidate();
        repaint();
    }

    // SETGET

    public ControlManager getManager() {
        return this.manager;
    }

    public void setManager(ControlManager manager) {
        this.manager = manager;
    }

}
