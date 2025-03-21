package Controller;

import View.*;
import Model.UserOption;
import Objects.*;

public class ProfileControl extends Control
{
    ProfileView view;

    User user;

    ArrayPostControl postArray;

    public ProfileControl(ControlManager m, int userId)
    {
        super(m);

        System.out.println("USERID: " + userId);

        user = UserOption.readUser(userId);

        postArray = new ArrayPostControl(m, userId);

        view = new ProfileView(m, user);

        view.add(postArray.getView());
    }
}
