package Controller;

import javax.swing.*;

public class Control
{
    public JPanel view;
    public Control parent;

    Control(){}
    Control(Control parent)
    {
        this.parent = parent;
    }

    public JPanel switchView(JPanel newView)
    {
        return newView;
    }

    public void setUpView()
    {
        view.revalidate();
        view.repaint();
    }
    

    public Control createControl(Control newControl)
    {
        return newControl;
    }
}
