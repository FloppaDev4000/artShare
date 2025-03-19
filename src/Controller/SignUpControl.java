package Controller;

import View.*;
import Model.*;

public class SignUpControl extends Control
{
    SignUpView view;
    MainControl parent;

    public SignUpControl(ControlManager m)
    {
        super(m);

        view = new SignUpView(m);

        view.addSignUpListener(e -> login(view.usernameField.getText(), view.passwordField.getPassword()));
        view.addBackListener(e -> m.makeActiveSplash());
    }
    
    // log into existing account
    public void login(String username, char[] password)
    {
        int loginValid = UserOption.findUser(username, new String(password));

        if(loginValid == 0)
        {
            // success path; login and move to main view, logged in
            int uid = UserOption.getId(username);

            manager.makeActiveHome();
            
        }
        else if(loginValid == 1)
        {
            // fail path
            System.out.println("Invalid login.");
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
