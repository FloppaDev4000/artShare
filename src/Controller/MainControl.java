package controller;

import view.MainView;

public class MainControl extends Control
{
    private MainView view;

    private Control currentControl;

    public MainControl(ControlManager m)
    {
        super(m);
    }

    // SETGET

    public MainView getView() {
        return this.view;
    }

    public void setView(MainView view) {
        this.view = view;
    }

    public Control getCurrentControl() {
        return this.currentControl;
    }

    public void setCurrentControl(Control currentControl) {
        this.currentControl = currentControl;
    }

}
