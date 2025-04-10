package controller;

import java.awt.Dimension;

import view.MainView;
import view.View;
import model.UserOption;
import objects.User;

public class ControlManager
{
    
    // frame
    private MainFrame f = new MainFrame();

    private User currentUser;

    //-----------------------------main
    private MainControl main;
    private MainView mainV;

    //-----------------------------children of main
    private SplashControl mainSplash;

    private LoginControl mainLogin;

    private SignUpControl mainSignUp;

    private HomeControl mainHome;

    // VIEW
    private MainView mainView = new MainView(this);

    public void run()
    {
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
        mainV.replaceContainer(mainLogin.getView());
    }

    void makeActiveSignUp()
    {
        mainSignUp = new SignUpControl(this);
        mainV.replaceContainer(mainSignUp.getView());
    }

    void makeActiveSplash()
    {
        mainSplash = new SplashControl(this);
        mainV.replaceContainer(mainSplash.getView());
    }

    void makeActiveHome()
    {
        // place mainHome's view inside main's view
        mainHome = new HomeControl(this);
        mainV.replaceContainer(mainHome.getView());
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
            return currentUser.getUserId();
        }

        System.out.println("NULL USER!");
        return -1;
    }

    //---------------------------------------------
    // SETGET

    public HomeControl getMainHome(){return mainHome;}

    public MainFrame getFrame() {
        return this.f;
    }

    public void setFrame(MainFrame f) {
        this.f = f;
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public MainControl getMain() {
        return this.main;
    }

    public void setMain(MainControl main) {
        this.main = main;
    }

    public MainView getMainV() {
        return this.mainV;
    }

    public void setMainV(MainView mainV) {
        this.mainV = mainV;
    }

    public SplashControl getMainSplash() {
        return this.mainSplash;
    }

    public void setMainSplash(SplashControl mainSplash) {
        this.mainSplash = mainSplash;
    }

    public LoginControl getMainLogin() {
        return this.mainLogin;
    }

    public void setMainLogin(LoginControl mainLogin) {
        this.mainLogin = mainLogin;
    }

    public SignUpControl getMainSignUp() {
        return this.mainSignUp;
    }

    public void setMainSignUp(SignUpControl mainSignUp) {
        this.mainSignUp = mainSignUp;
    }
    public void setMainHome(HomeControl mainHome) {
        this.mainHome = mainHome;
    }

    public MainView getMainView() {
        return this.mainView;
    }

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }
}
