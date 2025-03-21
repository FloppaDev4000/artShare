package Controller;

import View.*;
import Model.*;

public class SplashControl extends Control
{
    SplashView view;
    MainControl parent;

    public SplashControl(ControlManager m)
    {
        super(m);

        view = new SplashView(m);

        view.addLoginListener(e -> m.makeActiveLogin());
        view.addSignUpListener(e -> m.makeActiveSignUp());
    }
    
}
