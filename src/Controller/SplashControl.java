package controller;

import view.SplashView;

public class SplashControl extends Control
{
    private SplashView view;
    private MainControl parent;

    public SplashControl(ControlManager m)
    {
        super(m);

        view = new SplashView(m);

        // add listeners
        view.addLoginListener(e -> m.makeActiveLogin());
        view.addSignUpListener(e -> m.makeActiveSignUp());
    }
    
    // SETGET

    public SplashView getView() {
        return this.view;
    }

    public void setView(SplashView view) {
        this.view = view;
    }

    public MainControl getParent() {
        return this.parent;
    }

    public void setParent(MainControl parent) {
        this.parent = parent;
    }

}
