package Controller;

import javax.swing.*;

public class Control
{
    public JPanel view;
    public ControlManager manager;

    Control(){}
    Control(ControlManager manager)
    {
        this.manager = manager;
    }

    public JPanel switchView(JPanel newView)
    {
        return newView;
    }
}
