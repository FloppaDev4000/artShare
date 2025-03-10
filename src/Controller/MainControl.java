package Controller;

import javax.swing.*;
import View.*;

public class MainControl extends Control
{
    Control currentControl;

    public MainControl(Control parent)
    {
        super(parent);
        switchView(new MainView());
        Control loginControl = createControl(new LoginControl(this));

    }

    public void assignHomeControl()
    {

    }

    public Control assignLoginControl()
    {
        currentControl = new LoginControl(this);

        return currentControl;
    }

    public void goToHome()
    {
        currentControl = new HomeControl(this);
    }
}
