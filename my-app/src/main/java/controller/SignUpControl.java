package controller;

import java.util.Arrays;

import javax.swing.JOptionPane;

import model.Global;
import model.UserOption;
import view.SignUpView;

public class SignUpControl extends Control
{
    private SignUpView view;
    private MainControl parent;

    public SignUpControl(ControlManager m)
    {
        super(m);

        view = new SignUpView(m);

        view.addSignUpListener(e -> signUp(view.getUsernameField().getText(), view.getPasswordField().getPassword(), view.getConfirmField().getPassword(), view.getEmailField().getText()));
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
            
            System.out.println("FOUND UID: " + uid);
            getManager().login(uid);
            getManager().makeActiveHome();
            
        }
        else if(loginValid == 1)
        {
            // fail path
            JOptionPane.showMessageDialog(null, "Invalid login. Please try again.");
        }
    }

    // create new account, auto log in
    public void signUp(String username, char[] password, char[] confirm, String email)
    {
        String p = new String(password);

        // VALIDATE
        if(!Arrays.equals(password, confirm))
        {
            JOptionPane.showMessageDialog(null, "Passwords must match!");
            return;
        }
        else if(!p.matches(".{5,}"))
        {
            JOptionPane.showMessageDialog(null, "Password must be at least 5 characters long!");
            return;
        }
        else if(!email.matches(".*@.*"))
        {
            JOptionPane.showMessageDialog(null, "Email is invalid!");
            return;
        }

        // 3 possible results
        int nameAvailable = UserOption.checkUsernameAvailable(username);

        if(nameAvailable == 1)
        {
            // fail path
            System.out.println("Username not available.");
        }

        // success path
        if(UserOption.create(username, p, email) == 0)
        {
            login(username, password);
        }
        else
        {
            System.out.println("SIGN UP FAILED!");
        }
    }

    // SETGET

    public SignUpView getView() {
        return this.view;
    }

    public void setView(SignUpView view) {
        this.view = view;
    }

    public MainControl getParent() {
        return this.parent;
    }

    public void setParent(MainControl parent) {
        this.parent = parent;
    }

}
