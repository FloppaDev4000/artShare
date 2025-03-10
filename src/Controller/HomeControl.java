package Controller;

import View.*;

public class HomeControl extends Control
{
    HomeView view;
    Control middleControl;

    public HomeControl(Control parent)
    {
        super(parent);
        switchView(new HomeView());
        view.addLogoutListener(e -> logout());
        parent = (MainControl) parent;

        // set basic middleControl
        middleControl = new ArrayPostControl(this);
    }

    // move to single post
    public void goToPost(int postId)
    {
        middleControl = new PostControl(this);
    }

    // return to base post scroll
    public goToArrayPost()
    {
        middleControl = new ArrayPostControl(this);
    }

    public void logout()
    {

    }
}
