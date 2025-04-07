package controller;

import javax.swing.JPanel;

public class Control
{
    private JPanel view;
    private ControlManager manager;

    Control(){}
    Control(ControlManager manager)
    {
        this.manager = manager;
    }

    public JPanel switchView(JPanel newView)
    {
        return newView;
    }

    //SETGET

    public JPanel getView() {
        return this.view;
    }

    public void setView(JPanel view) {
        this.view = view;
    }

    public ControlManager getManager() {
        return this.manager;
    }

    public void setManager(ControlManager manager) {
        this.manager = manager;
    }

}
