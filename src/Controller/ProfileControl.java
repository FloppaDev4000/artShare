package Controller;

import View.*;

public class ProfileControl extends Control
{
    ProfileView view;

    ArrayPostControl postArray;

    public ProfileControl(ControlManager m, int userId)
    {
        super(m);

        postArray = new ArrayPostControl(m, userId);

        view = new ProfileView(m);
    }
}
