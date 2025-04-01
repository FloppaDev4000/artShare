package Controller;

import View.*;
import Model.*;

public class LoginControl extends Control
{
    LoginView view;
    MainControl parent;

    public LoginControl(ControlManager m)
    {
        super(m);

        view = new LoginView(m);

        view.addLoginListener(e -> login(view.usernameField.getText(), view.passwordField.getPassword()));
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
            
            manager.login(uid);
            manager.makeActiveHome();
            
        }
        else if(loginValid == 1)
        {
            // fail path
            view.message.setText("Invalid login.");
        }
    }

    // create new account, auto log in
    public void signUp(String username, char[] password, String email)
    {
        String p = new String(password);

        // 3 possible results
        int nameAvailable = UserOption.checkUsernameAvailable(username);

        if(nameAvailable == 0)
        {
            // success path
            if(UserOption.create(username, p, email) == 0)
            {
                login(username, password);
            }
        }
        else if(nameAvailable == 1)
        {
            // fail path
        }
    }
}
