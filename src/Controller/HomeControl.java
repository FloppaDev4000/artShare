package Controller;

import View.*;

public class HomeControl extends Control
{
    HomeView view;
    Control middleControl;

    public HomeControl(ControlManager m)
    {
        super(m);

        // set basic middleControl
        middleControl = new ArrayPostControl(manager);
    }

    // move to single post
    public void goToPost(int postId)
    {
        middleControl = new PostControl(manager);
    }

    // return to base post scroll
    public void goToArrayPost()
    {
        middleControl = new ArrayPostControl(manager);
    }

    public void logout()
    {

    }
}
