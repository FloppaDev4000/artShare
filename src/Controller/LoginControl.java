package Controller;

import View.*;
import Model.*;

public class LoginControl extends Control
{
    LoginView view;
    MainControl parent;

    public LoginControl(Control parent)
    {
        super(parent);
        switchView(new LoginView());
        view.addLoginListener(e -> login(view.username, view.password));
        parent = (MainControl) parent;
    }
    
    // log into existing account
    public void login(String username, String password)
    {
        int loginValid = UserOption.findUser(username, password);

        if(loginValid == 0)
        {
            // success path; login and move to main view, logged in
            int uid = UserOption.getId(username);

            // here, we want to tell MainControl to move to home
            parent.goToHome();
            
        }
        else if(loginValid == 1)
        {
            // fail path
            System.out.println("Invalid login.");
        }
    }

    // create new account, auto log in
    public void signUp(String username, String password, String email)
    {
        // 3 possible results
        int nameAvailable = UserOption.checkUsernameAvailable(username);

        if(nameAvailable == 0)
        {
            // success path
            if(UserOption.create(username, password, email) == 0)
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
