package View;

import Objects.*;
import Controller.ControlManager;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.GridBagConstraints;

public class ProfileView extends View
{
    JLabel usernameLabel;
    JLabel bioLabel;
    JLabel verifiedLabel;
    

    public ProfileView(ControlManager m, User u)
    {
        super(m);
        System.out.println("MY USERNAME: " + u.username);
        usernameLabel = new JLabel(u.username);
        bioLabel = new JLabel(u.bio);
        verifiedLabel = new JLabel("[Verified]");

        add(usernameLabel);
        add(bioLabel);

        if(u.isVerified)
        {
            add(verifiedLabel);
        }
    }

    public void addOptions(JButton option)
    {
        GridBagConstraints b = new GridBagConstraints();
        add(option, b);
    }
}
