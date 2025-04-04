package Controller;

import View.MainView;

public class MainControl extends Control
{
    public MainView view;

    public Control currentControl;

    public MainControl(ControlManager m)
    {
        super(m);
    }

}
