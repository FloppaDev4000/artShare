package View;

import Objects.*;
import Controller.ControlManager;
import javax.swing.*;

public class ProfileView extends View
{
    JLabel usernameLabel;
    JLabel verifiedLabel;

    public ProfileView(ControlManager m, User u)
    {
        super(m);
        System.out.println("MY USERNAME: " + u.username);
        usernameLabel = new JLabel(u.username);
        verifiedLabel = new JLabel("[Verified]");

        add(usernameLabel);
        if(u.isVerified)
        {
            add(verifiedLabel);
        }
    }
}
