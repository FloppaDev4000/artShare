package Controller;

import javax.swing.JFrame;

import View.*;

public class ControlManager
{
    // frame
    MainFrame f = new MainFrame();

    //-----------------------------main
    MainControl main;
    MainView mainV;

    //-----------------------------children of main
    LoginControl mainLogin;
    LoginView mainLoginV;

    HomeControl mainHome;
    HomeView mainHomeV;

    //-----------------------------children of home
    ArrayPostControl homeArray;
    ArrayPostView homeArrayV;

    PostControl homePost;
    PostView homePostV;

    ProfileControl homeProfile;
    ProfileView homeProfileV;

    // VIEW
    MainView mainView = new MainView(this);

    public void run()
    {
        main = new MainControl(this);
        mainV = new MainView(this);

        mainLogin = new LoginControl(this);
        mainHome = new HomeControl(this);

        homeArray = new ArrayPostControl(this);
        homePost = new PostControl(this);
        homeProfile = new ProfileControl(this);


        f.add(mainV);
        f.frameReset();
        

        makeActiveLogin();
    }

    //-------------------------------------------------

    void makeActiveLogin()
    {
        // place mainLogin's view inside main's view
        mainLoginV = new LoginView(this);
        mainV.container = mainLoginV;
        mainV.add(mainV.container);

        mainLoginV.addLoginListener(e -> mainLogin.login("adamN", "password"));

        f.frameReset();
    }

    void makeActiveHome()
    {
        // place mainHome's view inside main's view
        mainHomeV = new HomeView(this);
        mainV.container = mainHomeV;
        makeActiveArrayPost();

        f.frameReset();
    }

    //-------------------------------------------------

    void makeActiveArrayPost()
    {
        // place homeArray's view inside home's view
        homeArrayV = new ArrayPostView(this);
        homeArray.populate(-1);
        mainV.container = homeArrayV;

        f.frameReset();
    }

    void makeActivePost(int postId)
    {
        // place homePost's view inside home's view
        // give post values to post
        homePostV = new PostView(this);
        homePost.populate(postId);

        f.frameReset();
    }

    void makeActiveProfile(int userId)
    {
        // place inside Home View
        homeProfileV = new ProfileView(this);
        mainV.container = homeProfileV;

        f.frameReset();
    }

    void viewReset(View v)
    {
        v.repaint();
        v.revalidate();
    }
}
