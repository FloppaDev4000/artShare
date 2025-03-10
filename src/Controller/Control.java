package Controller;

import javax.swing.*;

public class Control
{
    JPanel view;
    Control parent;

    Control(Control parent)
    {
        this.parent = parent;
    }

    public void switchView(JPanel newView)
    {
        view.removeAll();
        view.add(newView);
        System.out.println("Switching view to " + newView + "!");
        view.revalidate();
        view.repaint();
    }

    public Control createControl(Control newControl)
    {
        return newControl;
    }
}
