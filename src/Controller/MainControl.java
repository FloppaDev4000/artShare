package Controller;

import javax.swing.*;
import View.*;

public class MainControl extends Control
{
    public Control currentControl;

    public MainControl()
    {
        switchView(new MainView());
        assignLoginControl();
    }
    public MainControl(Control parent)
    {
        super(parent);
        switchView(new MainView());
        assignLoginControl();
    }

    public void assignHomeControl()
    {
        currentControl = new HomeControl(this);
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
