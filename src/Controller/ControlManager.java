package controller;

import java.awt.Dimension;

import view.MainView;
import view.View;
import model.UserOption;
import objects.User;
import view.UIHelper;

public class ControlManager
{
    
    // frame
    MainFrame f = new MainFrame();

    User currentUser;

    //-----------------------------main
    MainControl main;
    MainView mainV;

    //-----------------------------children of main
    SplashControl mainSplash;

    LoginControl mainLogin;

    SignUpControl mainSignUp;

    HomeControl mainHome;

    // VIEW
    MainView mainView = new MainView(this);

    public void run()
    {
        //UIHelper.setup();

        main = new MainControl(this);
        mainV = new MainView(this);
        mainV.setPreferredSize(new Dimension(840, 480));

        f.add(mainV);
        f.frameReset();
        
        makeActiveSplash();
    }

    //-------------------------------------------------

    void makeActiveLogin()
    {
        // place mainLogin's view inside main's view
        mainLogin = new LoginControl(this);
        mainV.replaceContainer(mainLogin.view);
    }

    void makeActiveSignUp()
    {
        mainSignUp = new SignUpControl(this);
        mainV.replaceContainer(mainSignUp.view);
    }

    void makeActiveSplash()
    {
        mainSplash = new SplashControl(this);
        mainV.replaceContainer(mainSplash.view);
    }

    void makeActiveHome()
    {
        // place mainHome's view inside main's view
        mainHome = new HomeControl(this);
        mainV.replaceContainer(mainHome.view);
    }

    //-------------------------------------------------

    void viewReset(View v)
    {
        v.repaint();
        v.revalidate();
    }

    //---------------------------------------------USER STUFF

    public void login(int userId)
    {
        currentUser = UserOption.readUser(userId);
    }

    public void logout()
    {
        if(currentUser != null)
        {
            currentUser = null;
        }
    }

    public int getCurrentUserId()
    {
        if(currentUser != null)
        {
            return currentUser.userId;
        }

        System.out.println("NULL USER!");
        return -1;
    }

    //---------------------------------------------
    // SETGET
    public MainFrame getFrame(){return f;}

    public HomeControl getMainHome(){return mainHome;}
}
