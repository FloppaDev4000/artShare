package Controller;

import View.LoginView;

public class LoginControl
{
    
    // log into existing account
    public void login(String username, String password)
    {
        int loginValid = Model.UserOption.findUser(username, password);

        if(loginValid == 0)
        {
            // success path; login and move to main view, logged in

        }
        else if(loginValid == 1)
        {
            // fail path
        }
    }

    // create new account, auto log in
    public void signUp(String username, String password, String email)
    {
        // 3 possible results
        int nameAvailable = Model.UserOption.checkUsernameAvailable(username);

        if(nameAvailable == 0)
        {
            // success path
            if(Model.UserOption.create(username, password, email) == 0)
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
