package controller;

import view.MainView;

public class MainControl extends Control
{
    public MainView view;

    public Control currentControl;

    public MainControl(ControlManager m)
    {
        super(m);
    }

}
