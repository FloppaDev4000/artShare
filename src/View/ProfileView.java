package View;

import Objects.*;
import Controller.ControlManager;

public class ProfileView extends View
{
    public ProfileView(ControlManager m)
    {
        super(m);
    }

    int userId;
    String username;

    public void getUserValues(User u)
    {
        userId = u.userId;
        username = u.username;
    }
}
