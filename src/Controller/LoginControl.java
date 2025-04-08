package controller;

import model.UserOption;
import model.Global;

import view.LoginView;

public class LoginControl extends Control
{
    private LoginView view;
    private MainControl parent;

    public LoginControl(ControlManager m)
    {
        super(m);

        view = new LoginView(m);

        view.addLoginListener(e -> login(view.getUsernameField().getText(), view.getPasswordField().getPassword()));
        view.addBackListener(e -> m.makeActiveSplash());
    }
    
    // log into existing account
    public void login(String username, char[] password)
    {
        String p = new String(password);
        if(Global.SECRET_DEBUG_MODE)
        {
            username = "adamN";
            p = "password";
        }
    
        int loginValid = UserOption.findUser(username, p);

        if(loginValid == 0)
        {
            // success path; login and move to main view, logged in
            int uid = UserOption.getId(username);
            
            getManager().login(uid);
            getManager().makeActiveHome();
            
        }
        else if(loginValid == 1)
        {
            // fail path
            view.getMessage().setText("Invalid login.");
        }
    }

    // SETGET

    public LoginView getView() {
        return this.view;
    }

    public void setView(LoginView view) {
        this.view = view;
    }

    public MainControl getParent() {
        return this.parent;
    }

    public void setParent(MainControl parent) {
        this.parent = parent;
    }

}
