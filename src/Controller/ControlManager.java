package Controller;

import java.awt.*;

import Model.UserOption;
import View.*;
import View.UIHelper;
import Objects.*;

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
    SplashView mainSplashV;

    LoginControl mainLogin;
    LoginView mainLoginV;

    SignUpControl mainSignUp;
    SignUpView mainSignUpV;

    HomeControl mainHome;
    HomeView mainHomeV;

    //-----------------------------children of home
    ArrayPostControl homeArray;
    ArrayPostView homeArrayV;

    ProfileControl homeProfile;
    ProfileView homeProfileV;

    // VIEW
    MainView mainView = new MainView(this);

    public void run()
    {
        UIHelper.setup();

        main = new MainControl(this);
        mainV = new MainView(this);
        mainV.setPreferredSize(new Dimension(840, 480));

        mainLogin = new LoginControl(this);
        mainHome = new HomeControl(this);

        homeArray = new ArrayPostControl(this, -1);
        homeProfile = new ProfileControl(this, getCurrentUserId());

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

    void makeActiveProfile(int userId)
    {
        // place inside Home View
        homeProfileV = new ProfileView(this);
        mainV.container = homeProfileV;
    }

    void viewReset(View v)
    {
        v.repaint();
        v.revalidate();
    }

    //---------------------------------------------USER STUFF

    void login(int userId)
    {
        currentUser = UserOption.readUser(userId);
    }

    void logout()
    {
        if(currentUser != null)
        {
            currentUser = null;
        }
    }

    int getCurrentUserId()
    {
        if(currentUser != null)
        {
            return currentUser.userId;
        }

        return -1;
    }

    //---------------------------------------------
    // SETGET
    public MainFrame getFrame(){return f;}
}
